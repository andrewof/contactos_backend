package com.api.contactos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.contactos.entities.Contacto;
import com.api.contactos.entities.VistaContactos;
import com.api.contactos.entities.dto.ContactoDto;
import com.api.contactos.entities.mapper.DtoMapperContacto;
import com.api.contactos.repositories.ContactoRepository;
import com.api.contactos.repositories.VistaContactosRepository;

@Service
public class ContactoServiceImpl implements ContactoService {

  @Autowired
  private VistaContactosRepository vistaContactosRepository;

  @Autowired
  private ContactoRepository contactoRepository;

  @Override
  public List<VistaContactos> listarContactos() {
    return vistaContactosRepository.listarContactos();
  }

  @Override
  @Transactional(readOnly = true)
  public Contacto buscarPorId(Long id) {
    return contactoRepository.buscarPorId(id).orElseThrow();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Contacto> buscarPorIdOp(Long id) {
    return Optional.of(contactoRepository.buscarPorId(id).orElseThrow());
  }

  @Override
  @Transactional(readOnly = true)
  public ContactoDto obtenerNumerContacto(String nombre) {
    Optional<Contacto> optionalContacto = contactoRepository.obtenerNumeroContacto(nombre);
    return DtoMapperContacto.builder().setContacto(optionalContacto.get()).build();
  }

  @Override
  @Transactional
  public Contacto registrarContacto(Contacto contacto) {
    contactoRepository.registrarContacto(contacto.getNombre(), contacto.getNumero(), contacto.getCorreo());
    return contactoRepository.buscarPorNombre(contacto.getNombre());
  }

  @Override
  @Transactional
  public Contacto actualizarContacto(Long id, String numero, String correo) {
    Optional<Contacto> optionalContacto = contactoRepository.buscarPorId(id);
    if (optionalContacto.isPresent()) {
      contactoRepository.actualizarContacto(id, numero, correo);
      return contactoRepository.buscarPorId(id).orElseThrow();
    }
    return null;
  }

  @Override
  @Transactional
  public void eliminarContacto(Long id) {
    contactoRepository.eliminarContacto(id);
  }

}
