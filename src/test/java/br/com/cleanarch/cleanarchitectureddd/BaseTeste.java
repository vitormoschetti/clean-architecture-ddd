package br.com.cleanarch.cleanarchitectureddd;

import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.customer.valueobject.AddressVO;

import java.util.List;

public class BaseTeste {

    protected AddressVO buildAddressVOWith(final String street, final String city, final String state, final String zipCode) {
        return new AddressVO(street, city, state, zipCode);
    }

    protected Customer buildValidCustomer() {
        final var customer = new Customer();
        customer.create("name", "street", "city", "state", "zipcode");
        return customer;
    }

//    protected List<OrderItem> buildListOrderItem(final Long quantity) {
//
//        final var orderItems = new ArrayList<OrderItem>();
//
//        for (long i = 0; i < quantity; i++) {
//            orderItems.add(this.buildOrderItemWith("product " + i, i + 1));
//        }
//
//        return orderItems;
//
//    }
//
//    private OrderItem buildOrderItemWith(final String name, final Long quantity) {
//        return new OrderItem(UUID.randomUUID().toString(), name, BigDecimal.ONE, UUID.randomUUID().toString(), quantity);
//    }
//
//    protected OrderItem buildOrderItemWith(final String name, final Long quantity, final BigDecimal price) {
//        return new OrderItem(UUID.randomUUID().toString(), name, price, UUID.randomUUID().toString(), quantity);
//    }
//
//    protected Order buildOrderWithOrderItems(final Long quantity) {
//
//        return new Order(UUID.randomUUID().toString(), UUID.randomUUID().toString(), this.buildListOrderItem(quantity));
//
//    }
//
//    protected Product buildValidProduct() {
//        return new Product(UUID.randomUUID().toString(), "product", BigDecimal.ONE);
//    }
//
//    protected Product buildProductWith(final String name, final BigDecimal price) {
//        return new Product(UUID.randomUUID().toString(), name, price);
//    }

}
