package me.devhardy.jpabulkinsert.repository;

import lombok.RequiredArgsConstructor;
import me.devhardy.jpabulkinsert.domain.Dummy;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BulkRepository {

    private final JdbcTemplate jdbcTemplate;

    public void saveAll(List<Dummy> dummies) {
        jdbcTemplate.batchUpdate("insert into dummy(id, title) " +
                        "values (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, dummies.get(i).getId());
                        ps.setString(2, dummies.get(i).getTitle());
                    }

                    @Override
                    public int getBatchSize() {
                        return dummies.size();
                    }
                });
    }
}
