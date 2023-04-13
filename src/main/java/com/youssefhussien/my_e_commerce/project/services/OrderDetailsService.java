package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.auth.user.service.UserService;
import com.youssefhussien.my_e_commerce.project.dto.OrderDetailsDTO;
import com.youssefhussien.my_e_commerce.project.entites.OrderDetails;
import com.youssefhussien.my_e_commerce.project.entites.OrderItems;
import com.youssefhussien.my_e_commerce.project.repository.OrderDetailRepository;
import com.youssefhussien.my_e_commerce.project.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@Transactional(readOnly = true)
public class OrderDetailsService {

    @Autowired
    private OrderDetailRepository orderDetailsRepository;
    @Autowired
    private OrderItemsService orderItemsService;
    @Autowired
    private UserService userService;

    @Transactional
    public Integer save(CreateOrderVO vO) {

        OrderDetails orderDetailsBean = new OrderDetails();
        vO.getOrderDetailsVO().setPaymentId(null);
        BeanUtils.copyProperties(vO.getOrderDetailsVO(), orderDetailsBean);
        orderDetailsBean.setUser(userService.getById(vO.getOrderDetailsVO().getUserId()));
       var result = orderDetailsRepository.save(orderDetailsBean);
       var orderItemsResultList = orderItemsService.saveAll(vO.getOrderItemsVOList(),result);
        return result.getId();
    }

    @Transactional
    public void delete(Integer id) {
        orderDetailsRepository.deleteById(id);
    }

    @Transactional
    public void update(Integer id, OrderDetailsUpdateVO vO) {
        OrderDetails bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        orderDetailsRepository.save(bean);
    }

    public OrderDetailsDTO getById(Integer id) {
        OrderDetails original = requireOne(id);
        return toDTO(original);
    }

    public Page<OrderDetailsDTO> query(OrderDetailsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private OrderDetailsDTO toDTO(OrderDetails original) {
        OrderDetailsDTO bean = new OrderDetailsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public OrderDetails requireOne(Integer id) {
        return orderDetailsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
