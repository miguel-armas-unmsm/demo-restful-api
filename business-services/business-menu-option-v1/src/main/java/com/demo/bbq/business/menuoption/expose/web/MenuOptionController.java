package com.demo.bbq.business.menuoption.expose.web;

import com.demo.bbq.business.menuoption.service.MenuOptionService;
import com.demo.bbq.business.menuoption.util.model.dto.request.MenuOptionRequest;
import com.demo.bbq.business.menuoption.util.model.dto.response.MenuOptionResponse;
import com.demo.bbq.support.logstash.Markers;
import java.net.URI;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
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

  @GetMapping(produces = MediaType.APPLICATION_JSON, value = "/{id}")
  public ResponseEntity<MenuOptionResponse> findById(HttpServletRequest servletRequest,
                                                     @PathVariable(name = "id") Long id) {
    logRequest.accept(servletRequest);
    return ResponseEntity.ok(service.findById(id));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON)
  public ResponseEntity<List<MenuOptionResponse>> findByCategory(HttpServletRequest servletRequest,
      @RequestParam(value = "category", required = false) String categoryCode) {
    logRequest.accept(servletRequest);
    List<MenuOptionResponse> menuOptionResponseList = service.findByCategory(categoryCode);
    return (menuOptionResponseList == null || menuOptionResponseList.isEmpty())
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(service.findByCategory(categoryCode));
  }

  @PostMapping
  public ResponseEntity<Void> save(HttpServletRequest servletRequest,
                                   @Valid @RequestBody MenuOptionRequest menuOption) {
    logRequest.accept(servletRequest);
    Long id = service.save(menuOption);
    return ResponseEntity.created(buildPostUriLocation.apply(id)).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> update(HttpServletRequest servletRequest,
                                     @Valid @RequestBody MenuOptionRequest menuOption, @PathVariable("id") Long id) {
    logRequest.accept(servletRequest);
    Long updatedMenuOptionId = service.update(id, menuOption);
    return ResponseEntity.created(buildPutUriLocation.apply(updatedMenuOptionId)).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(HttpServletRequest servletRequest, @PathVariable("id") Long id) {
    logRequest.accept(servletRequest);
    System.out.println(servletRequest.getRequestURI());
    return ResponseEntity.noContent().build();
  }

  private final static Consumer<HttpServletRequest> logRequest = servletRequest->
      log.info(Markers.SENSITIVE_JSON, "{}", servletRequest.getMethod() + ": " + servletRequest.getRequestURI());

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
