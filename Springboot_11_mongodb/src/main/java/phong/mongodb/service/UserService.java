package phong.mongodb.service;

import phong.mongodb.dto.UserAggregationAverageAge;
import phong.mongodb.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();

    UserEntity getUser(String id);

    UserEntity createUser(UserEntity userEntity);

    List<UserEntity> createMultipleUsers(List<UserEntity> userEntities) throws Exception;

    List<UserEntity> createMultipleUsersUsingTransactionTemplate(List<UserEntity> userEntities);

    List<UserEntity> createMultipleUsersUsingClientSession(List<UserEntity> userEntities);

    List<UserEntity> createMultipleUsersUsingClientSessionAndMongoTemplate(List<UserEntity> userEntities);

    UserEntity updateUser(String id, UserEntity userEntity);

    Boolean deleteUser(String id);

    List<UserEntity> getUserByEmail(String email);

    List<UserEntity> getUserByAge(Short age);

    List<UserAggregationAverageAge> getUserAverageAgeByGender(String gender);
}
