package com.leyou.order.web;

import com.leyou.order.dto.OrderDto;
import com.leyou.order.pojo.Order;
import com.leyou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param orderDto
     * @return
     */
    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody OrderDto orderDto) {
        //创建订单
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }

    /**
     * 根据id查询订单
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Order> queryOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.queryOrderById(id));
    }

    /**
     * 创建支付连接
     *
     * @param orderId
     * @return
     */
    @GetMapping("/url/{id}")
    public ResponseEntity<String> createPayUrl(@PathVariable("id") Long orderId) {
        return ResponseEntity.ok(orderService.createPayUrl(orderId));
    }

    /**
     * 查询支付状态
     *
     * @param orderId
     * @return
     */
    @GetMapping("/state/{id}")
    public ResponseEntity<Integer> queryOrderState(@PathVariable("id") Long orderId) {
        return ResponseEntity.ok(orderService.queryOrderState(orderId).getValue());//返回枚举，一般不要直接返回1  2  3
    }
}
