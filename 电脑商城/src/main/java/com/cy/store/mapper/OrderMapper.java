package com.cy.store.mapper;


import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

/*订单持久层接口*/
public interface OrderMapper {
    Integer insertOrder(Order order);

    Integer insertOrderItem(OrderItem orderItem);

}
