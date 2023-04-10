package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.project.dto.OrderItemsDTO;
import com.youssefhussien.my_e_commerce.project.entites.OrderItems;
import com.youssefhussien.my_e_commerce.project.repository.OrderItemRepository;
import com.youssefhussien.my_e_commerce.project.vo.OrderItemsQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderItemsUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.OrderItemsVO;
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
public class OrderItemsService {

    @Autowired
    private OrderItemRepository orderItemsRepository;

    public Integer save(OrderItemsVO vO) {
        OrderItems bean = new OrderItems();
        BeanUtils.copyProperties(vO, bean);
        bean = orderItemsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        orderItemsRepository.deleteById(id);
    }

    public void update(Integer id, OrderItemsUpdateVO vO) {
        OrderItems bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        orderItemsRepository.save(bean);
    }

    public OrderItemsDTO getById(Integer id) {
        OrderItems original = requireOne(id);
        return toDTO(original);
    }

    public Page<OrderItemsDTO> query(OrderItemsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private OrderItemsDTO toDTO(OrderItems original) {
        OrderItemsDTO bean = new OrderItemsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private OrderItems requireOne(Integer id) {
        return orderItemsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
