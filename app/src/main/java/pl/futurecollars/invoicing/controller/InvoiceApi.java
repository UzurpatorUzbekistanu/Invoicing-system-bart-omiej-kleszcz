package pl.futurecollars.invoicing.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.futurecollars.invoicing.model.Invoice;

@RequestMapping("invoices")
@Tag(name = "invoice-controller", description = "Controller used to list / add / update / delete invoices (CRUD)")
public interface InvoiceApi {

  @Operation(summary = "Get list of all invoices")
  @GetMapping(produces = {"application/json;charset=UTF-8"})
  List<Invoice> getAll();

  @Operation(summary = "Add new invoice to system")
  @PostMapping
  int add(@RequestBody Invoice invoice);

  @Operation(summary = "Get invoice with given id")
  @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
  ResponseEntity<Invoice> getById(@PathVariable int id);

  @Operation(summary = "Delete invoice with given id")
  @DeleteMapping("/{id}")
  ResponseEntity<?> deleteById(@PathVariable int id);

  @Operation(summary = "Update invoice with given id")
  @PutMapping("/{id}")
  ResponseEntity<?> update(@PathVariable int id, @RequestBody Invoice invoice);
}
