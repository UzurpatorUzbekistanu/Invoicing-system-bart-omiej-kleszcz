package pl.futurecollars.invoicing.db.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Data;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;

@Data
public class InMemoryDatabase implements Database {

  private final Map<Integer, Invoice> invoices = new HashMap<>();
  private int nextId = 1;

  @Override
  public int save(Invoice invoice) {
    invoice.setId(nextId);
    invoices.put(nextId, invoice);
    return nextId++;
  }

  @Override
  public Optional<Invoice> getById(int id) {
    return Optional.ofNullable(invoices.get(id));
  }

  @Override
  public List<Invoice> getAll() {
    return invoices.values().stream().collect(Collectors.toList());
  }

  @Override
  public void update(int id, Invoice updatedInvoice) {
    if(invoices.containsKey(id)){
      invoices.replace(id, updatedInvoice);
    }
  }

  @Override
  public void delete(int id) {
    if(invoices.containsKey(id)){
      invoices.remove(id);
    }
  }
}
