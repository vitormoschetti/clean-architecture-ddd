package br.com.cleanarch.domain.checkout.entity;//package br.com.ddd.domain.checkout.entity;
//
//import br.com.ddd.domain.shared.entity.IAggregateRoot;
//import br.com.ddd.domain.shared.entity.exception.DomainException;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Objects;
//
//public class Order implements IAggregateRoot {
//
//    private String id;
//    private final String customerId;
//    private final List<OrderItem> items;
//
//    public Order(final String id, final String customerId, final List<OrderItem> items) {
//        this.id = id;
//        this.customerId = customerId;
//        this.items = items;
//        this.validate();
//    }
//
//    private void validate() {
//        if (Objects.isNull(this.id) || this.id.isEmpty())
//            throw new DomainException("Id is required");
//        if (Objects.isNull(this.customerId) || this.customerId.isEmpty())
//            throw new DomainException("CustomerId is required");
//        if (Objects.isNull(this.items) || this.items.isEmpty())
//            throw new DomainException("Order must have at least one item");
//    }
//
//    public BigDecimal total() {
//
//        return this.items.stream().map(OrderItem::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
//
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public List<OrderItem> getItems() {
//        return items;
//    }
//}
