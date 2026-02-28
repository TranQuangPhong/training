package phong.mongodb.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import phong.mongodb.dto.UserAggregationAverageAge;
import phong.mongodb.entity.UserEntity;

import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    List<UserEntity> findByEmail(String email);

    @Query("{'age': ?0}")
    List<UserEntity> findByAge(Short age);

    @Aggregation(pipeline = {
            "  {\n" +
            "    $match: {\n" +
            "      gender: ?#{#gender}\n" +
            "    }\n" +
            "  }", //The comma between 2 stages
            "  {\n" +
            "    $group: {\n" +
            "      _id: '$gender',\n" +
            "      avgAge: {$avg: '$age'}\n" +
            "    }\n" +
            "  }", //The comma between 2 stages
            "  {\n" +
            "    $project: {\n" +
            "      _id: 0,\n" +
            "      gender: '$_id',\n" +
            "      avgAge: {$round: ['$avgAge', 2]}\n" +
            "    }\n" +
            "  }"})
    List<UserAggregationAverageAge> findAverageAgeByGender(@Param("gender") String gender);
}
