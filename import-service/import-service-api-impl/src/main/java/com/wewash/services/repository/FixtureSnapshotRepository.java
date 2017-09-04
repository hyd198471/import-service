package com.wewash.services.repository;

import com.wewash.services.model.FixtureSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FixtureSnapshotRepository extends JpaRepository<FixtureSnapshot, Long> {


}
