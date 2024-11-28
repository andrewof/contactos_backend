package com.api.contactos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.contactos.entities.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

  @Query(value = "SELECT * FROM contactos WHERE id = :id", nativeQuery = true)
  Optional<Contacto> buscarPorId(@Param("id") Long id);

  @Query(value = "SELECT * FROM contactos WHERE nombre = :nombre", nativeQuery = true)
  Contacto buscarPorNombre(@Param("nombre") String nombre);

  @Query(value = "SELECT buscar_contacto(:nombre)")
  Optional<Contacto> obtenerNumeroContacto(@Param("nombre") String nombre);

  @Modifying
  @Query(value = "INSERT INTO contactos (nombre, numero, correo) VALUES (:nombre, :numero, :correo)", nativeQuery = true)
  void registrarContacto(@Param("nombre") String nombre, @Param("numero") String numero,
      @Param("correo") String correo);

  @Modifying
  @Procedure(procedureName = "actualizar_contacto")
  void actualizarContacto(@Param("id") Long id, @Param("numero") String numero, @Param("correo") String correo);

  @Modifying
  @Query(value = "DELETE FROM contactos WHERE id = :id", nativeQuery = true)
  void eliminarContacto(@Param("id") Long id);
}
