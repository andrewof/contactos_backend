package com.api.contactos.entities.dto;

public class ContactoDto {
  String numero;

  public ContactoDto(String numero) {
    this.numero = numero;
  }

  public ContactoDto() {
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

}
