package phong.mongodb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import phong.mongodb.dto.UserAggregationAverageAge;
import phong.mongodb.entity.UserEntity;
import phong.mongodb.repository.CustomUserRepository;

import java.util.List;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<UserAggregationAverageAge> findAverageAgeByGender(String gender) {

        Criteria genderMatchCriteria = Criteria.where("gender").is(gender);
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(genderMatchCriteria),
                Aggregation.group("gender").avg("age").as("avgAge"),
                Aggregation.project("avgAge")
                        .and(ArithmeticOperators.Round.roundValueOf("avgAge").place(2)).as("avgAge")
                        .and("_id").as("gender")
        );

        AggregationResults<UserAggregationAverageAge> results = mongoTemplate.aggregate(
                aggregation,
                mongoTemplate.getCollectionName(UserEntity.class),
                UserAggregationAverageAge.class
        );

        return results.getMappedResults();
    }
}
