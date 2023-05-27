package com.base.repository;

import com.base.domain.HelloRequest;
import com.base.dto.HelloDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class MyDatabaseRepository {

    static final String TABLE_NAME = "my_table";
    private static class Columns {
        private static final String NAME = "name";
    }

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public MyDatabaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(TABLE_NAME)
                .usingColumns(Columns.NAME);
    }

    public void save(HelloRequest helloRequest) {
        simpleJdbcInsert.execute(toSqlParametersForInsert(helloRequest));
    }

    private MapSqlParameterSource toSqlParametersForInsert(HelloRequest helloRequest) {
        return new MapSqlParameterSource()
                .addValue(Columns.NAME, helloRequest.getName());
    }
}
