package br.com.cleanarch.cleanarchitectureddd.domain.checkout.entity;//package br.com.ddd.domain.checkout.entity;
//
//import br.com.ddd.domain.shared.entity.exception.DomainException;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//public class OrderItemTest {
//
//    @Test
//    @DisplayName("should throw domain exception when id is empty")
//    public void shouldThrowDomainExceptionWhenIdEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new OrderItem("", UUID.randomUUID().toString(), BigDecimal.ONE, UUID.randomUUID().toString(), 1L));
//
//        Assertions.assertEquals("Id is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when name is empty")
//    public void shouldThrowDomainExceptionWhenNameEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new OrderItem(UUID.randomUUID().toString(), "", BigDecimal.ONE, UUID.randomUUID().toString(), 1L));
//
//        Assertions.assertEquals("Name is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when price is less than 0")
//    public void shouldThrowDomainExceptionWhenPriceLessThanEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), new BigDecimal(-1000), UUID.randomUUID().toString(), 1L));
//
//        Assertions.assertEquals("Price is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when product id is empty")
//    public void shouldThrowDomainExceptionWhenProductIdEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.ONE, "", 1L));
//
//        Assertions.assertEquals("ProductId is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when quantity is empty")
//    public void shouldThrowDomainExceptionWhenQuantityEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.ONE, UUID.randomUUID().toString(),
//                0L));
//
//        Assertions.assertEquals("Quantity is required", exception.getMessage());
//
//    }
//
//}
