package com.api.contactos.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contactos_eliminados")
public class ContactoEliminado {

  @Id
  private Long id;
  private String nombre;
  private String numero;
  private String correo;
  @Column(name = "fecha_eliminacion")
  private LocalDateTime fechaEliminacion;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public LocalDateTime getFechaEliminacion() {
    return fechaEliminacion;
  }

  public void setFechaEliminacion(LocalDateTime fechaEliminacion) {
    this.fechaEliminacion = fechaEliminacion;
  }

}
