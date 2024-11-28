package com.api.contactos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.contactos.entities.ContactoEliminado;

@Repository
public interface ContactoEliminadoRepository extends JpaRepository<ContactoEliminado, Long> {

  @Query(value = "SELECT * FROM contactos_eliminados", nativeQuery = true)
  List<ContactoEliminado> listarContactosEliminados();
}
