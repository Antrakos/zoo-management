package edu.softserve.zoo.persistence.repository.impl;

import edu.softserve.zoo.persistence.provider.JdbcPersistenceProvider;
import edu.softserve.zoo.persistence.repository.StatisticsRepository;
import edu.softserve.zoo.persistence.specification.impl.statistics.FedAnimalsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * @author Taras Zubrei
 */
@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository {
    @Autowired
    JdbcPersistenceProvider persistenceProvider;

    @Override
    public Long getFedAnimals() {
        return persistenceProvider.findOne(new FedAnimalsSpecification<>(), BigInteger::longValue);
    }
}
