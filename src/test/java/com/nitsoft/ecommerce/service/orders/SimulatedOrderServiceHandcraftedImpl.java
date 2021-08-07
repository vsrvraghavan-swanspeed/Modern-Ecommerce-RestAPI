package com.nitsoft.ecommerce.service.orders;

import com.nitsoft.ecommerce.api.request.model.OrdersRequestModel;
import com.nitsoft.ecommerce.database.model.Orders;
import org.springframework.data.domain.Page;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulatedOrderServiceHandcraftedImpl extends AbstractMethodError implements OrderService {

    private Map<Long,Orders>  db = new HashMap<>();

    public SimulatedOrderServiceHandcraftedImpl(List<Orders> sampleOrders) {

        sampleOrders.stream().forEach(nextOrder -> this.db.put(nextOrder.getId(),nextOrder));
    }

    private Date someDate = new Date(Instant.now().getEpochSecond());

    @Override
    public Page<Orders> doPagingOrders(OrdersRequestModel ordersRequestModel, Long companyId) {
        return null;
    }

    @Override
    public Orders getOrderByOrderIdAndCompanyID(Long orderId, Long companyId) {

        Orders mayBeAnOrder = this.db.get(orderId);

        return (
          mayBeAnOrder == null ? null
          : (mayBeAnOrder.getCompanyId() == companyId ? mayBeAnOrder
                  : null)
        );
    }

    @Override
    public void updateStatusOrder(Orders order) {

        this.db.put(order.getId(),order);

    }
}
