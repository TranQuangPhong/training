package com.repo;

import com.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDataRepository extends JpaRepository<DataModel, Long> {

    //    @Query(value = "SELECT MAX(id) FROM tbl_data", nativeQuery = true)
    @Query(value = "select coalesce(max(tb.id), 0) from tbl_data tb", nativeQuery = true)
    Long getMaxId();
}
