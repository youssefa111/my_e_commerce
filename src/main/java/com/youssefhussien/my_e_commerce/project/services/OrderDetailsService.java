package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.project.dto.OrderDetailsDTO;
import com.youssefhussien.my_e_commerce.project.entites.OrderDetails;
import com.youssefhussien.my_e_commerce.project.repository.OrderDetailRepository;
import com.youssefhussien.my_e_commerce.project.vo.OrderDetailsQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderDetailsUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderDetailsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Slf4j
@Transactional(readOnly = true)
public class OrderDetailsService {

    @Autowired
    private OrderDetailRepository orderDetailsRepository;

    public Integer save(OrderDetailsVO vO) {
        OrderDetails bean = new OrderDetails();
        BeanUtils.copyProperties(vO, bean);
        bean = orderDetailsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        orderDetailsRepository.deleteById(id);
    }

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

    private OrderDetails requireOne(Integer id) {
        return orderDetailsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
