package com.groupe10.projet_fin_detude_L3.dao;

import com.groupe10.projet_fin_detude_L3.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findByEmail(String email);


}
