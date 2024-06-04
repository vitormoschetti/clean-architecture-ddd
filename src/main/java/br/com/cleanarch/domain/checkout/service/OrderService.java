package br.com.cleanarch.domain.checkout.service;


import br.com.cleanarch.domain.checkout.entity.Order;
import br.com.cleanarch.domain.checkout.entity.OrderItem;
import br.com.cleanarch.domain.customer.entity.Customer;
import br.com.cleanarch.domain.shared.service.IService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

public class OrderService implements IService {

    public static BigDecimal total(final List<OrderItem> items) {

        return items.stream().map(OrderItem::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public static Order placeOrder(final List<OrderItem> items, final Customer customer) {

        final var order = new Order(UUID.randomUUID().toString(), customer.getId(), items);

        final var rewardPoints = order.total().divide(new BigDecimal(2), RoundingMode.HALF_DOWN).longValue();

        customer.addRewardPoints(rewardPoints);

        return order;

    }

}
