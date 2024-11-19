package com.app.cruduser.repository;

import com.app.cruduser.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE " +
            "(:nik IS NULL OR u.nik LIKE %:nik%) AND " +
            "(:name IS NULL OR u.name LIKE %:name%) AND " +
            "(:gender IS NULL OR u.gender LIKE %:gender%) AND " +
            "(:address IS NULL OR u.address LIKE %:address%) AND " +
            "(:nationality IS NULL OR u.nationality LIKE %:nationality%)")
    List<User> findByAllFields(
            @Param("nik") String nik,
            @Param("name") String name,
            @Param("gender") String gender,
            @Param("address") String address,
            @Param("nationality") String nationality
    );
}
