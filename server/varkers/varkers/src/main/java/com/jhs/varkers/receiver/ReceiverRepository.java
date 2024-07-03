package com.jhs.varkers.receiver;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiverRepository extends JpaRepository<ReceiverEntity,Long> {
    List<ReceiverEntity> findByVarkId(Long varkId);
}
