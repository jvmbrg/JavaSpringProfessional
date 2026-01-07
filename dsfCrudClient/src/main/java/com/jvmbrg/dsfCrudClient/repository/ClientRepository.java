package com.jvmbrg.dsfCrudClient.repository;

import com.jvmbrg.dsfCrudClient.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
