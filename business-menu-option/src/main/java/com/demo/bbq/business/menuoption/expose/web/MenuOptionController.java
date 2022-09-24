package com.demo.bbq.business.menuoption.expose.web;

import com.demo.bbq.business.menuoption.service.MenuOptionService;
import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import java.net.URI;
import java.util.List;
import java.util.function.Function;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * <br/>Clase Controller que implementa los métodos necesarios para exponer mediante REST
 * los servicios del contexto Menu Option.<br/>
 *
 * @author Miguel Armas Abt <br/>
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bbq/business/v1/menu-options")
public class MenuOptionController {

  private final MenuOptionService service;

  @GetMapping(produces = "application/json", value = "/{id}")
  public ResponseEntity<MenuOptionResponse> findById(@PathVariable(name = "id") Long id) {
    return (service.findById(id) == null)
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(service.findById(id));
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<MenuOptionResponse>> findByCategory(
      @RequestParam(value = "category", required = false) String categoryCode) {
    List<MenuOptionResponse> menuOptionResponseList = service.findByCategory(categoryCode);
    return (menuOptionResponseList == null || menuOptionResponseList.isEmpty())
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(service.findByCategory(categoryCode));
  }

  @PostMapping
  public ResponseEntity<Void> save(@Valid @RequestBody MenuOptionRequest menuOption) {
    Long id = service.save(menuOption);
    return ResponseEntity.created(buildPostUriLocation.apply(id)).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(@Valid @RequestBody MenuOptionRequest menuOption, @PathVariable("id") Long id) {
    return (service.update(id, menuOption) == null)
        ? ResponseEntity.notFound().build()
        : ResponseEntity.created(buildPutUriLocation.apply(id)).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    return (service.deleteById(id) == null)
        ? ResponseEntity.notFound().build()
        : ResponseEntity.noContent().build();
  }

  private final static Function<Long, URI> buildPostUriLocation = id ->
      ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(id)
      .toUri();

  private final static Function<Long, URI> buildPutUriLocation = id ->
      ServletUriComponentsBuilder.fromCurrentRequest()
      .buildAndExpand()
      .toUri();
}
