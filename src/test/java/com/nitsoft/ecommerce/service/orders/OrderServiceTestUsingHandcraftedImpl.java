package com.nitsoft.ecommerce.service.orders;

import com.nitsoft.ecommerce.database.model.Orders;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class OrderServiceTestUsingHandcraftedImpl {

    private final Date  orderPlacedAt = new Date(Instant.now().getEpochSecond());

    private final Orders order1 = Orders.builder().id(1L).userId("U001").adressId(1L).paymentId(1L).companyId(1L).createdAt(orderPlacedAt).build();
    private final Orders order2 = Orders.builder().id(2L).userId("U002").adressId(1L).paymentId(1L).companyId(1L).createdAt(orderPlacedAt).build();
    private final Orders order3 = Orders.builder().id(3L).userId("U003").adressId(1L).paymentId(1L).companyId(2L).createdAt(orderPlacedAt).build();

    public OrderService orderService = new SimulatedOrderServiceHandcraftedImpl(List.of(order1,order2,order3));


    @Test
    public void orderUpdateTest() {

        Orders current = orderService.getOrderByOrderIdAndCompanyID(order3.getId(),order3.getCompanyId());

        Assert.assertEquals(0,current.getStatus());
        Assert.assertNull(current.getItemsCount());

        Orders freshOrder = Orders.builder()
                             .id(order3.getId())
                             .userId(order3.getUserId())
                             .adressId(order3.getAdressId())
                             .paymentId(order3.getPaymentId())
                             .companyId(order3.getCompanyId())
                             .createdAt(order3.getCreatedAt())
                             .build();
        freshOrder.setItemsCount(20);
        freshOrder.setStatus(2);

        orderService.updateStatusOrder(freshOrder);

        Orders updated = orderService.getOrderByOrderIdAndCompanyID(order3.getId(),order3.getCompanyId());

        Assert.assertNotNull(updated);
        Assert.assertEquals(2, updated.getStatus());
        Assert.assertEquals(Integer.valueOf(20), updated.getItemsCount());

    }

}
