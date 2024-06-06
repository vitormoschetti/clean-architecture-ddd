package br.com.cleanarch.cleanarchitectureddd.domain.checkout.service;//package br.com.ddd.domain.checkout.service;
//
//import br.com.ddd.BaseTeste;
//import br.com.ddd.domain.checkout.service.OrderService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//public class OrderServiceTest extends BaseTeste {
//
//    @Test
//    @DisplayName("should get total of all orders")
//    public void shouldGetTotalAllOrders() {
//
//        final var orderItem1 = this.buildOrderItemWith("item 1", 1L, new BigDecimal(100));
//        final var orderItem2 = this.buildOrderItemWith("item 1", 2L, new BigDecimal(200));
//
//        final var total = OrderService.total(List.of(orderItem1, orderItem2));
//
//        Assertions.assertEquals(new BigDecimal(500), total);
//
//    }
//
//    @Test
//    @DisplayName("should place an order")
//    public void shouldPlaceAnOrder() {
//
//        final var customer = this.buildValidCustomer();
//
//        final var item1 = this.buildOrderItemWith("item 1", 1L, new BigDecimal(100));
//
//        final var order = OrderService.placeOrder(List.of(item1), customer);
//
//        Assertions.assertEquals(50, customer.getRewardPoints());
//        Assertions.assertEquals(new BigDecimal(100), order.total());
//
//
//    }
//
//}
