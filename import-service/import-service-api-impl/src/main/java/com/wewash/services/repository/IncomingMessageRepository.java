package com.wewash.services.repository;

import com.wewash.services.model.IncomingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface IncomingMessageRepository extends JpaRepository<IncomingMessage, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<IncomingMessage> findByFixtureIdAndProcessedOrderByHeaderTimestamp(Long fixtureId, boolean processed);


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<IncomingMessage> findByFixtureIdAndHeaderTimestampGreaterThanEqualOrderByHeaderTimestamp(
            long fixtureId, Date headerTimestamp);

}
