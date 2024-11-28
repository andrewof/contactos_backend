package com.api.contactos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.contactos.services.ContactoEliminadoService;

@RestController
@RequestMapping("/eliminado")
@CrossOrigin(origins = "*")
public class ContactoEliminadoController {

  @Autowired
  private ContactoEliminadoService contactoEliminadoService;

  @GetMapping
  public ResponseEntity<?> listarContactosEliminados() {
    return ResponseEntity.ok(contactoEliminadoService.listarContactosEliminados());
  }
}
