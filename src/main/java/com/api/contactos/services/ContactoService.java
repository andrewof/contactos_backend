package com.api.contactos.services;

import java.util.List;
import java.util.Optional;

import com.api.contactos.entities.Contacto;
import com.api.contactos.entities.VistaContactos;
import com.api.contactos.entities.dto.ContactoDto;

public interface ContactoService {

  List<VistaContactos> listarContactos();

  Optional<Contacto> buscarPorIdOp(Long id);

  Contacto buscarPorId(Long id);

  ContactoDto obtenerNumerContacto(String nombre);

  Contacto registrarContacto(Contacto contacto);

  Contacto actualizarContacto(Long id, String numero, String correo);

  void eliminarContacto(Long id);

}
