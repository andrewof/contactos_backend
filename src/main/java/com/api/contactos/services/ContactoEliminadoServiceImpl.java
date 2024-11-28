package com.api.contactos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.contactos.entities.ContactoEliminado;
import com.api.contactos.repositories.ContactoEliminadoRepository;

@Service
public class ContactoEliminadoServiceImpl implements ContactoEliminadoService {

  @Autowired
  private ContactoEliminadoRepository contactoEliminadoRepository;

  @Override
  public List<ContactoEliminado> listarContactosEliminados() {
    return contactoEliminadoRepository.listarContactosEliminados();
  }

}
