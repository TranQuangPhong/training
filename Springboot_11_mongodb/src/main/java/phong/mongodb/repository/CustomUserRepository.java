package phong.mongodb.repository;

import phong.mongodb.dto.UserAggregationAverageAge;

import java.util.List;

public interface CustomUserRepository {
    List<UserAggregationAverageAge> findAverageAgeByGender(String gender);
}
