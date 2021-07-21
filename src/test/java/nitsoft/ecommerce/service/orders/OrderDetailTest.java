package nitsoft.ecommerce.service.orders;

import com.nitsoft.ecommerce.database.model.OrderAddress;
import com.nitsoft.ecommerce.database.model.OrderDetail;
import com.nitsoft.ecommerce.service.AbstractBaseService;
import com.nitsoft.ecommerce.service.orders.OrderAddressService;
import com.nitsoft.ecommerce.service.orders.OrderDetailService;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDetailTest {

    public OrderDetail orderDetail1 = new OrderDetail();
    public OrderDetail orderDetail2 = new OrderDetail();
    public Map<Long,OrderDetail> testDB = new HashMap<>();

    @Before
    public void setup() {

        orderDetail1.setOrderId(1001L);
        orderDetail1.setName("Yesterday");
        orderDetail1.setBasePrice(new BigDecimal(100.00));

        orderDetail2.setOrderId(2001L);
        orderDetail2.setName("Today");
        orderDetail2.setBasePrice(new BigDecimal(200.00));

        testDB.put(orderDetail1.getOrderId(),orderDetail1);
        testDB.put(orderDetail2.getOrderId(),orderDetail2);

    }

    @Test
    public void orderDetailRetrievalTest() {

        StubbedOrderDetailImpl stubbedOrderDetail =  new StubbedOrderDetailImpl(this.testDB);

        List<OrderDetail> orderDetailRetrieved = stubbedOrderDetail.getListOrderDetail(orderDetail1.getOrderId());

        Assert.assertArrayEquals(List.of(orderDetail1).toArray(),orderDetailRetrieved.toArray());

    }

    @Test
    public void orderDetailSaveTest() {

        StubbedOrderDetailImpl stubbedOrderDetail =  new StubbedOrderDetailImpl(this.testDB);

        OrderDetail orderDetail3 = new OrderDetail();
        orderDetail3.setOrderId(3000L);
        orderDetail3.setName("DayBeforeYesterday");
        orderDetail3.setBasePrice(new BigDecimal(400.00));

        stubbedOrderDetail.saveOrUpdate(orderDetail3);


        List<OrderDetail> orderDetailRetrieved1 = stubbedOrderDetail.getListOrderDetail(orderDetail1.getOrderId());
        List<OrderDetail> orderDetailRetrieved2 = stubbedOrderDetail.getListOrderDetail(orderDetail2.getOrderId());
        List<OrderDetail> orderDetailRetrieved3 = stubbedOrderDetail.getListOrderDetail(orderDetail3.getOrderId());

        Assert.assertTrue(
                !orderDetailRetrieved1.isEmpty() &&
                         !orderDetailRetrieved2.isEmpty() &&
                         !orderDetailRetrieved3.isEmpty() &&
                        (orderDetailRetrieved3.size() == 1)
                );

        Assert.assertEquals(new BigDecimal(400.00),orderDetailRetrieved3.get(0).getBasePrice());
    }



    public class StubbedOrderDetailImpl extends AbstractBaseService implements OrderDetailService {

        private Map<Long,OrderDetail>  localDB;


        public StubbedOrderDetailImpl(Map<Long, OrderDetail> localDB) {
            this.localDB = localDB;
        }


        @Override
        public OrderDetail saveOrUpdate(OrderDetail orderDetail) {

            this.localDB.put(orderDetail.getOrderId(),orderDetail);
            return orderDetail;
        }

        @Override
        public List<OrderDetail> getListOrderDetail(Long orderId) {
            return List.of((this.localDB.get(orderId)));
        }
    }
}
