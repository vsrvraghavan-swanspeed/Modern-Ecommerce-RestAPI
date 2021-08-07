package com.nitsoft.ecommerce.service.orders;

import com.nitsoft.ecommerce.repository.OrdersRepository;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;


public class SimulatedOrderServiceMockedImpl {

    @Mock
    private OrdersRepository ordersRepository;

    OrderServiceImpl orderService;

    @Before
    void initUseCase() {
        orderService = new OrderServiceImpl(ordersRepository);
    }


}
