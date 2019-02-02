package com.orrz.shopping_cart.Order;import com.orrz.shopping_cart.Order.model.OrderDao;import com.orrz.shopping_cart.Order.model.OrderMockDao;import com.orrz.shopping_cart.Order.view.GetOrderResponse;import com.orrz.shopping_cart.Order.view.ListOrderResponse;import com.orrz.shopping_cart.Order.view.UpdateOrderResponse;import com.orrz.shopping_cart.Order.view.UpdateOrderResquest;import com.orrz.shopping_cart.Order.view.create.CreateOrderRequest;import com.orrz.shopping_cart.Order.view.create.CreateOrderResponse;import com.orrz.shopping_cart.Order.view.create.CreateOrderValidator;import com.orrz.shopping_cart.Product.model.ProductDao;import com.orrz.shopping_cart.Product.model.ProductMockDao;import com.orrz.shopping_cart.User.model.UserDao;import com.orrz.shopping_cart.User.model.UserMockDao;import org.junit.Before;import org.junit.Test;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import static org.junit.Assert.assertEquals;/** * @Author: Lin_Ya * @Date: 2019-02-02-10:21 * @Version: 1.0 * @Description: 订单控制器 */public class OrderControllerTest {    private final long EXIST_ID = 1L;    private final long NOT_FOUND_ID = 999L;    private OrderDao orderDao;    private UserDao userDao;    private ProductDao productDao;    private CreateOrderValidator createOrderValidator;    private OrderController orderController;    private CreateOrderRequest createOrderRequest;    private UpdateOrderResquest updateOrderResquest;    @Before    public void setUp() {        createOrderValidator = new CreateOrderValidator();        userDao = new UserMockDao();        productDao = new ProductMockDao();        orderDao = new OrderMockDao();        orderController = new OrderController(orderDao, userDao, productDao, createOrderValidator);        createOrderRequest = new CreateOrderRequest();        updateOrderResquest = new UpdateOrderResquest();    }    /**     * 测试获取 订单 成功     */    @Test    public void shouldGetOrderSuccess() {        ResponseEntity<GetOrderResponse> response = orderController.getOrder(EXIST_ID);        assertEquals(HttpStatus.OK, response.getStatusCode());    }    /**     * 测试获取 订单 失败     */    @Test    public void shouldGetOrderFail() {        ResponseEntity<GetOrderResponse> response = orderController.getOrder(NOT_FOUND_ID);        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());    }    /**     * 获取所有订单 成功     */    @Test    public void shouldGetAllOrder() {        ResponseEntity<ListOrderResponse> response = orderController.getAllOrder();        assertEquals(HttpStatus.OK, response.getStatusCode());    }    /**     * 测试 创建订单     */    @Test    public void shouldCreaeteOrderSuccess() {        createOrderRequest.setAddress("Test");        createOrderRequest.setProductId(EXIST_ID);        createOrderRequest.setUserId(EXIST_ID);        createOrderRequest.setQuantity(1L);        createOrderRequest.setStatus("Test");        ResponseEntity<CreateOrderResponse> response = orderController.createOrder(createOrderRequest);        assertEquals(HttpStatus.CREATED, response.getStatusCode());        assertEquals(1L, response.getBody().getOrder().getQuantity());    }    /**     * 测试 更新订单成功     */    @Test    public void shouldUpdateOrderSuccess() {        updateOrderResquest.setAddress("UPDATE");        updateOrderResquest.setQuantity(10L);        updateOrderResquest.setStatus("UPDATE");        ResponseEntity<UpdateOrderResponse> response = orderController.updateOrder(EXIST_ID, updateOrderResquest);        assertEquals(HttpStatus.OK, response.getStatusCode());        assertEquals(10L, response.getBody().getOrder().getQuantity());        assertEquals("UPDATE", response.getBody().getOrder().getStatus());    }    /**     * 测试 删除订单成功     */    @Test    public void shouldDeleteOrderSuccess() {        ResponseEntity response = orderController.deleteOrder(EXIST_ID);        assertEquals(HttpStatus.OK, response.getStatusCode());    }    /**     * 测试 删除订单 失败     */    @Test    public void shouldDeleteOrderFail() {        ResponseEntity response = orderController.deleteOrder(EXIST_ID);        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());    }}