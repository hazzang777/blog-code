package me.devhardy.jpabulkinsert.repository;

import me.devhardy.jpabulkinsert.domain.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DummyRepository extends JpaRepository<Dummy, Long> {
    @Query("select max(d.id) from Dummy d")
    Long findMaxPk();
}
