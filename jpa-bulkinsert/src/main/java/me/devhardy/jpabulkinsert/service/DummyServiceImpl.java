package me.devhardy.jpabulkinsert.service;

import lombok.RequiredArgsConstructor;
import me.devhardy.jpabulkinsert.domain.Dummy;
import me.devhardy.jpabulkinsert.repository.BulkRepository;
import me.devhardy.jpabulkinsert.repository.DummyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DummyServiceImpl implements DummyService{

    private final DummyRepository dummyRepository;

    private final BulkRepository bulkRepository;

    @Transactional
    @Override
    public void createDummies() {
        Long maxPk = dummyRepository.findMaxPk();
        if (maxPk == null) {
            maxPk = 0L;
        }
        List<Dummy> dummies = Dummy.createDummies(maxPk);
        bulkRepository.saveAll(dummies);
    }
}
