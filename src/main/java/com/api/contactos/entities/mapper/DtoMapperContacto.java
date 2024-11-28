package com.api.contactos.entities.mapper;

import com.api.contactos.entities.Contacto;
import com.api.contactos.entities.dto.ContactoDto;

public class DtoMapperContacto {
  private Contacto contacto;

  private DtoMapperContacto() {

  }

  public static DtoMapperContacto builder() {
    return new DtoMapperContacto();
  }

  public DtoMapperContacto setContacto(Contacto contacto) {
    this.contacto = contacto;
    return this;
  }

  public ContactoDto build() {
    if (contacto == null) {
      throw new RuntimeException("Debe proporcionar el entity contacto");
    }

    return new ContactoDto(contacto.getNumero());
  }
}
