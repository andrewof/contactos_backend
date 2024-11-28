package com.api.contactos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.contactos.entities.Contacto;
import com.api.contactos.entities.ContactoRequest;
import com.api.contactos.services.ContactoService;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "*")
public class ContactoController {

  @Autowired
  private ContactoService contactoService;

  @GetMapping
  public ResponseEntity<?> listarContactos() {
    return ResponseEntity.ok(contactoService.listarContactos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> listarContacto(@PathVariable Long id) {
    Optional<Contacto> optionalContacto = contactoService.buscarPorIdOp(id);
    if (optionalContacto.isPresent()) {
      return ResponseEntity.ok(optionalContacto.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<?> registrarContacto(@RequestBody Contacto contacto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(contactoService.registrarContacto(contacto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> actualizarContacto(@RequestBody ContactoRequest contactoRequest, @PathVariable Long id) {
    Optional<Contacto> optionalContacto = contactoService.buscarPorIdOp(id);
    if (optionalContacto.isPresent()) {
      return ResponseEntity
          .ok(contactoService.actualizarContacto(id, contactoRequest.getNumero(), contactoRequest.getCorreo()));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> eliminarContacto(@PathVariable Long id) {
    Optional<Contacto> optionalContacto = contactoService.buscarPorIdOp(id);
    if (optionalContacto.isPresent()) {
      contactoService.eliminarContacto(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}
