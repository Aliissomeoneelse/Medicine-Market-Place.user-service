package com.example.userservice.repository;

import com.example.userservice.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from users where deleted_at is null and id = :id", nativeQuery = true)
    Optional<User> findByIdAndDeletedAtIsNull(@Param(value = "id") Integer id);

    Set<User> findAllByOrdersIdAndDeletedAtIsNull(Integer ordersId);
}
