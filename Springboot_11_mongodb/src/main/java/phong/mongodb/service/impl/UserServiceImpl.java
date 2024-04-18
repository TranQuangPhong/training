package phong.mongodb.service.impl;

import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.TransactionBody;
import com.mongodb.client.result.InsertOneResult;
import jakarta.validation.ConstraintViolationException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import phong.mongodb.dto.UserAggregationAverageAge;
import phong.mongodb.entity.UserEntity;
import phong.mongodb.repository.CustomUserRepository;
import phong.mongodb.repository.UserRepository;
import phong.mongodb.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomUserRepository customUserRepository;

    @Autowired
    MongoTransactionManager mongoTransactionManager;

    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoTemplate mongoTemplate;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    /**
     * Test Transactional annotation
     *
     * @param userEntities
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public List<UserEntity> createMultipleUsers(List<UserEntity> userEntities) throws Exception {
        List<UserEntity> savedEntities = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            savedEntities.add(userRepository.save(userEntity));
            if (userEntity.getIpAddress().equals("000.000.000.000")) { //Test rollback case
                throw new Exception("Test rollback case");
            }
        }
        return savedEntities;
    }

    /**
     * Test TransactionTemplate
     *
     * @param userEntities
     * @return
     */
    @Override
    public List<UserEntity> createMultipleUsersUsingTransactionTemplate(List<UserEntity> userEntities) {
        List<UserEntity> savedEntities = new ArrayList<>();

        TransactionTemplate transactionTemplate = new TransactionTemplate(mongoTransactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                for (UserEntity userEntity : userEntities) {
                    savedEntities.add(mongoTemplate.insert(userEntity));
                    if (userEntity.getIpAddress().equals("000.000.000.000")) {//Test rollback case
                        throw new RuntimeException("Test rollback case");
                    }
                }
            }
        });
        return savedEntities;
    }

    /**
     * Test ClientSession
     *
     * @param userEntities
     * @return
     */
    @Override
    public List<UserEntity> createMultipleUsersUsingClientSession(List<UserEntity> userEntities) {

        List<UserEntity> savedEntities = new ArrayList<>();

        final ClientSession clientSession = mongoClient.startSession();
        TransactionBody<List<String>> txnBody = () -> {

            List<String> ackIds = new ArrayList<>();
            MongoCollection<Document> userCollection = mongoTemplate.getCollection("user");
            for (UserEntity userEntity : userEntities) {
                Document document = new Document();
                mongoTemplate.getConverter().write(userEntity, document);

                InsertOneResult insertOneResult = userCollection.insertOne(clientSession, document); //Must include clientSession to handle transaction
                System.out.println(insertOneResult);
                ackIds.add(Objects.requireNonNull(insertOneResult.getInsertedId()).asObjectId().getValue().toHexString());
                if (userEntity.getIpAddress().equals("000.000.000.000")) {//Test rollback case
                    throw new RuntimeException("Test rollback case");
                }
            }
            return ackIds;
        };

        try {
            List<String> savedEntityIds = clientSession.withTransaction(txnBody);
            for (String id : savedEntityIds) {
                savedEntities.add(userRepository.findById(id).orElse(new UserEntity()));
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            clientSession.close();
        }
        return savedEntities;
    }

    /**
     * Test ClientSession and MongoTemplate
     *
     * @param userEntities
     * @return
     */
    @Override
    public List<UserEntity> createMultipleUsersUsingClientSessionAndMongoTemplate(List<UserEntity> userEntities) {
        List<UserEntity> savedEntities = new ArrayList<>();
        final ClientSession clientSession = mongoClient.startSession();
        List<String> savedEntityIds = mongoTemplate.withSession(clientSession)
                .execute(UserEntity.class, userCollection -> {
                    List<String> ackIds = new ArrayList<>();
                    clientSession.startTransaction();
                    try {
                        for (UserEntity userEntity : userEntities) {
                            Document document = new Document();
                            mongoTemplate.getConverter().write(userEntity, document);

                            InsertOneResult insertOneResult = userCollection.insertOne(clientSession, document); //Must include clientSession to handle transaction
                            System.out.println(insertOneResult);
                            ackIds.add(Objects.requireNonNull(insertOneResult.getInsertedId()).asObjectId().getValue().toHexString());
                            if (userEntity.getIpAddress().equals("000.000.000.000")) {//Test rollback case
                                throw new RuntimeException("Test rollback case");
                            }
                        }
                        clientSession.commitTransaction();

                    } catch (RuntimeException e) {
                        System.out.println(e);
                        clientSession.abortTransaction();
                    }
                    return ackIds;
                });

        assert savedEntityIds != null;
        for (String id : savedEntityIds) {
            Optional<UserEntity> op = userRepository.findById(id);
            op.ifPresent(savedEntities::add);
        }
        return savedEntities;
    }

    @Override
    public UserEntity updateUser(String id, UserEntity userEntity) throws ConstraintViolationException {
        UserEntity currentEntity = getUser(id);
        if (currentEntity == null) {
            return null;
        }

        currentEntity.setFirstName(userEntity.getFirstName() == null ? currentEntity.getFirstName() : userEntity.getFirstName());
        currentEntity.setLastName(userEntity.getLastName() == null ? currentEntity.getLastName() : userEntity.getLastName());
        currentEntity.setEmail(userEntity.getEmail() == null ? currentEntity.getEmail() : userEntity.getEmail());
        currentEntity.setGender(userEntity.getGender() == null ? currentEntity.getGender() : userEntity.getGender());
        currentEntity.setIpAddress(userEntity.getIpAddress() == null ? currentEntity.getIpAddress() : userEntity.getIpAddress());
        currentEntity.setAge(userEntity.getAge() == null ? currentEntity.getAge() : userEntity.getAge());

        return userRepository.save(currentEntity);
    }

    @Override
    public Boolean deleteUser(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> getUserByAge(Short age) {
        return userRepository.findByAge(age);
    }

    @Override
    public List<UserAggregationAverageAge> getUserAverageAgeByGender(String gender) {
//        return userRepository.findAverageAgeByGender(gender); //User Aggregate annotation1
        return customUserRepository.findAverageAgeByGender(gender); //User Aggregate with MongoTemplate
    }
}
