package br.com.cleanarch.domain.portfolio.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {

    @Test
    @DisplayName("Should create a portfolio with customerId, audit and items empty")
    void shouldCreatePortfolioWithCustomerId() {

        //scenario && execution
        final var customerId = UUID.randomUUID();
        final var portfolio = new Portfolio(customerId);

        //validation

        assertEquals(customerId, portfolio.getCustomerId());
        assertNotNull(portfolio.getId());
        assertNotNull(portfolio.getCreatedAt());
        assertNull(portfolio.getUpdatedAt());
        assertEquals(0, portfolio.quantityItems());

    }

    @Test
    @DisplayName("Should buy a new item")
    void shouldBuyNewItem() {

        //scenario
        final var portfolio = new Portfolio(UUID.randomUUID());
        final long assetId = 1L;

        //execution
        portfolio.buy(assetId, BigDecimal.TEN, BigDecimal.TEN);

        //validation
        assertEquals(1, portfolio.quantityItems());
        assertNotNull(portfolio.getUpdatedAt());
        final var optItem = portfolio.getItem(assetId);
        assertTrue(optItem.isPresent());

    }

    @Test
    @DisplayName("Should buy more of an item")
    void shouldBuyMoreOfAnItem() {

        //scenario
        final var portfolio = new Portfolio(UUID.randomUUID());
        final long assetId = 1L;

        //execution
        portfolio.buy(assetId, BigDecimal.TEN, BigDecimal.TEN);
        portfolio.buy(assetId, BigDecimal.TEN, BigDecimal.TEN);

        //validation
        assertEquals(1, portfolio.quantityItems());
        assertNotNull(portfolio.getUpdatedAt());
        final var optItem = portfolio.getItem(assetId);
        assertTrue(optItem.isPresent());

        final var item = optItem.get();

        assertEquals(assetId, item.getAssetId());
        assertEquals(new BigDecimal(20), item.getQuantity());
        assertEquals(BigDecimal.TEN, item.getAveragePurchasePrice());
        assertEquals(new BigDecimal(200), item.totalInvested());

    }

    @Test
    @DisplayName("Should buy two new items")
    void shouldBuyTwoNewItems() {

        //scenario
        final var portfolio = new Portfolio(UUID.randomUUID());
        final long assetIdOne = 1L;
        final long assetIdTwo = 2L;

        //execution
        portfolio.buy(assetIdOne, BigDecimal.TEN, BigDecimal.TEN);
        portfolio.buy(assetIdTwo, BigDecimal.TEN, BigDecimal.TWO);

        //validation
        assertEquals(2, portfolio.quantityItems());
        assertNotNull(portfolio.getUpdatedAt());

        final var optItemOne = portfolio.getItem(assetIdOne);
        assertTrue(optItemOne.isPresent());

        final var itemOne = optItemOne.get();

        assertEquals(assetIdOne, itemOne.getAssetId());
        assertEquals(BigDecimal.TEN, itemOne.getQuantity());
        assertEquals(BigDecimal.TEN, itemOne.getAveragePurchasePrice());
        assertEquals(new BigDecimal(100), itemOne.totalInvested());

        final var optItemTwo = portfolio.getItem(assetIdTwo);
        assertTrue(optItemTwo.isPresent());

        final var itemTwo = optItemTwo.get();

        assertEquals(assetIdTwo, itemTwo.getAssetId());
        assertEquals(BigDecimal.TEN, itemTwo.getQuantity());
        assertEquals(BigDecimal.TWO, itemTwo.getAveragePurchasePrice());
        assertEquals(new BigDecimal(20), itemTwo.totalInvested());

    }

    @Test
    @DisplayName("Should sell a item")
    void shouldSellAnItem() {

        //scenario
        final var portfolio = new Portfolio(UUID.randomUUID());
        portfolio.buy(1L, BigDecimal.TEN, BigDecimal.TEN);

        //execution
        portfolio.sell(1L, new BigDecimal(5));

        //validation
        assertEquals(1, portfolio.quantityItems());
        assertNotNull(portfolio.getUpdatedAt());

        final var optItem = portfolio.getItem(1L);
        assertTrue(optItem.isPresent());

        final var item = optItem.get();
        assertEquals(1L, item.getAssetId());
        assertEquals(new BigDecimal(5), item.getQuantity());
        assertEquals(BigDecimal.TEN, item.getAveragePurchasePrice());
        assertEquals(new BigDecimal(50), item.totalInvested());

    }

    @Test
    @DisplayName("Should sell all position of a item")
    void shouldSellAllPositionOfAnItem() {

        //scenario
        final var portfolio = new Portfolio(UUID.randomUUID());
        portfolio.buy(1L, BigDecimal.TEN, BigDecimal.TEN);

        //execution
        portfolio.sell(1L, BigDecimal.TEN);

        //validation
        assertEquals(0, portfolio.quantityItems());
        assertNotNull(portfolio.getUpdatedAt());

    }

    @Test
    @DisplayName("Should try to sell an item that does not exist")
    void shouldSellAnItemThatDoesNotExist() {

        //scenario
        final var portfolio = new Portfolio(UUID.randomUUID());
        portfolio.buy(1L, BigDecimal.TEN, BigDecimal.TEN);

        //execution
        portfolio.sell(2L, BigDecimal.TEN);

        //validation
        assertEquals(1, portfolio.quantityItems());

    }

    @Test
    @DisplayName("Should list items asset id")
    void shouldListItemsAssetId() {

        //scenario
        final var portfolio = new Portfolio(UUID.randomUUID());

        //execution
        portfolio.buy(1L, BigDecimal.TEN, BigDecimal.TEN);
        portfolio.buy(2L, BigDecimal.TEN, BigDecimal.TEN);
        portfolio.buy(3L, BigDecimal.TEN, BigDecimal.TEN);
        portfolio.buy(4L, BigDecimal.TEN, BigDecimal.TEN);
        portfolio.buy(5L, BigDecimal.TEN, BigDecimal.TEN);

        //validation
        assertEquals(5, portfolio.quantityItems());
        assertArrayEquals(List.of(1L, 2L, 3L, 4L, 5L).toArray(),
                portfolio.listItemsAssetId().toArray());

    }

}