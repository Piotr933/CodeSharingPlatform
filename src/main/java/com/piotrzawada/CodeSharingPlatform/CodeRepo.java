package com.piotrzawada.CodeSharingPlatform;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepo extends CrudRepository<Code, String> {

    @Query(value = "SELECT * FROM CODE WHERE RESTRICTED_BY_TIME = FALSE AND  RESTRICTED_BY_VIEWS = " +
            "FALSE ORDER BY LOCAL_DATE_TIME DESC LIMIT 10", nativeQuery = true)
    List<Code> findCode();
}