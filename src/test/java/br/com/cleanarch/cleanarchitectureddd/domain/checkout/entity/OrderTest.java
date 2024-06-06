package br.com.cleanarch.cleanarchitectureddd.domain.checkout.entity;//package br.com.ddd.domain.checkout.entity;
//
//import br.com.ddd.BaseTeste;
//import br.com.ddd.domain.shared.entity.exception.DomainException;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//public class OrderTest extends BaseTeste {
//
//    @Test
//    @DisplayName("should throw domain exception when id is empty")
//    public void shouldThrowDomainExceptionWhenIdEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new Order("", UUID.randomUUID().toString(), this.buildListOrderItem(1L)));
//
//        Assertions.assertEquals("Id is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when customer id is empty")
//    public void shouldThrowDomainExceptionWhenCustomerIdEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new Order(UUID.randomUUID().toString(), "", this.buildListOrderItem(1L)));
//
//        Assertions.assertEquals("CustomerId is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when order items is empty")
//    public void shouldThrowDomainExceptionWhenCustomerOrderItemsEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new Order(UUID.randomUUID().toString(), UUID.randomUUID().toString(), List.of()));
//
//        Assertions.assertEquals("Order must have at least one item", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should return the total order price")
//    public void shouldReturnTotalOrderPrice() {
//
//        final var quantity = 100L;
//
//        final var expectedTotal = new BigDecimal(((quantity + 1) * quantity) / 2);
//
//        final var order = this.buildOrderWithOrderItems(quantity);
//
//        final var total = order.total();
//
//        Assertions.assertEquals(expectedTotal, total);
//
//    }
//
//}
