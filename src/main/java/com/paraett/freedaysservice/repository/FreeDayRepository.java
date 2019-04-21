package com.paraett.freedaysservice.repository;

import com.paraett.freedaysservice.model.entities.FreeDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FreeDayRepository  extends JpaRepository<FreeDay, Long> {
    @Transactional
    @Modifying
    void deleteAllByCompanyId(Long companyId);

    List<FreeDay> findAllByCompanyId(Long companyId);
}

