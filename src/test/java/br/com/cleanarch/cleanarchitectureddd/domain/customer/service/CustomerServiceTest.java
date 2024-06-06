package br.com.cleanarch.cleanarchitectureddd.domain.customer.service;//package br.com.ddd.domain.customer.service;
//
//import br.com.ddd.BaseTeste;
//import br.com.ddd.domain.customer.entity.Customer;
//import br.com.ddd.domain.customer.event.dispatcher.CustomerEventDispatcher;
//import br.com.ddd.domain.customer.event.event.changedaddress.CustomerChangedAddressEvent;
//import br.com.ddd.domain.customer.event.event.created.CustomerCreatedEvent;
//import br.com.ddd.domain.customer.event.handler.PrintLog2WhenCustomerCreatedEventHandler;
//import br.com.ddd.domain.customer.event.handler.PrintLogWhenCustomerCreatedEventHandler;
//import br.com.ddd.domain.customer.event.handler.SendMessageWhenCustomerChangedAddressEventHandler;
//import br.com.ddd.domain.customer.repository.ICustomerRepository;
//import br.com.ddd.domain.customer.valueobject.AddressVO;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.UUID;
//
//import static org.mockito.Mockito.*;
//
//public class CustomerServiceTest extends BaseTeste {
//
//    CustomerEventDispatcher dispatcher;
//    ICustomerRepository repository;
//
//    @BeforeEach
//    public void init() {
//        this.dispatcher = new CustomerEventDispatcher();
//        this.repository = new ICustomerRepository() {
//
//            @Override
//            public Customer findByTenantId(UUID tenantId) {
//                return buildValidCustomer();
//            }
//
//            @Override
//            public void create(final Customer entity) {
//
//            }
//
//            @Override
//            public void update(final Customer entity) {
//
//            }
//
//            @Override
//            public Customer findById(final String id) {
//                return buildValidCustomer();
//            }
//
//            @Override
//            public List<Customer> findAll() {
//                return List.of(buildValidCustomer());
//            }
//        };
//    }
//
//    @Test
//    @DisplayName("should notify handlers after created customer")
//    public void shouldNotifyHandlersAfterCreatedCustomer() {
//
//
//        final var printHandler = spy(new PrintLogWhenCustomerCreatedEventHandler());
//
//        final var print2Handler = spy(new PrintLog2WhenCustomerCreatedEventHandler());
//
//        dispatcher.register("CustomerCreatedEvent", printHandler);
//        dispatcher.register("CustomerCreatedEvent", print2Handler);
//
//        final var customerService = new CustomerService(dispatcher, repository);
//
//        final var customer = customerService.notifyCreated("handlers-test", "street", "city", "state", "zipcode");
//
//        Assertions.assertNotNull(customer.getId());
//        Assertions.assertEquals("handlers-test", customer.getName());
//        Assertions.assertEquals(new AddressVO("street", "city", "state", "zipcode"), customer.getAddress());
//        Assertions.assertEquals(0L, customer.getRewardPoints());
//        Assertions.assertEquals(Boolean.TRUE, customer.isActive());
//
//        verify(printHandler, times(1)).handle(any(CustomerCreatedEvent.class));
//        verify(print2Handler, times(1)).handle(any(CustomerCreatedEvent.class));
//
//
//    }
//
//    @Test
//    @DisplayName("should notify handlers after changed address")
//    public void shouldNotifyHandlersAfterChangedAddress() {
//
//        final var dispatcher = new CustomerEventDispatcher();
//
//        final var handler = spy(new SendMessageWhenCustomerChangedAddressEventHandler());
//
//        dispatcher.register("CustomerChangedAddressEvent", handler);
//
//        final var customerService = new CustomerService(dispatcher, repository);
//
//        final var customer = this.buildValidCustomer();
//
//        final var result = customerService.notifyChangeAddress(
//                customer,
//                this.buildAddressVOWith(
//                        UUID.randomUUID().toString(),
//                        UUID.randomUUID().toString(),
//                        UUID.randomUUID().toString(),
//                        UUID.randomUUID().toString()));
//
//        Assertions.assertEquals(customer.getId(), result.getId());
//        Assertions.assertEquals(customer.getName(), result.getName());
//        Assertions.assertEquals(customer.getAddress(), result.getAddress());
//        Assertions.assertEquals(customer.getRewardPoints(), result.getRewardPoints());
//        Assertions.assertEquals(customer.isActive(), result.isActive());
//
//        verify(handler, times(1)).handle(any(CustomerChangedAddressEvent.class));
//
//    }
//
//}
