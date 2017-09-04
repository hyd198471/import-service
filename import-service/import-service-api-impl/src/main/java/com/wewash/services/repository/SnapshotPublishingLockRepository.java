package com.wewash.services.repository;

import com.wewash.services.model.SnapshotPublishingLock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnapshotPublishingLockRepository extends JpaRepository<SnapshotPublishingLock, Long> {
}
