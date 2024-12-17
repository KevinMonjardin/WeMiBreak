package com.taskify.wemibreak.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskify.wemibreak.persistence.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Modifying
    @Query(value = "UPDATE TASK SET STATUS=1 WHERE ID=:id", nativeQuery = true)
    public void updateTask(@Param("id") Long id);
}
