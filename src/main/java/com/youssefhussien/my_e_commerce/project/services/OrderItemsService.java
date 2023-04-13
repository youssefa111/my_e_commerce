package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.core.exception_handling.exception.InvalidDataEntryException;
import com.youssefhussien.my_e_commerce.project.dto.OrderItemsDTO;
import com.youssefhussien.my_e_commerce.project.entites.OrderDetails;
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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@Transactional(readOnly = true)
public class OrderItemsService {

    @Autowired
    private OrderItemRepository orderItemsRepository;
    @Autowired
    private ProductService productService;
    @Transactional
    public Integer save(OrderItemsVO vO) {
        OrderItems bean = new OrderItems();
        BeanUtils.copyProperties(vO, bean);
        bean = orderItemsRepository.save(bean);
        return bean.getId();
    }

    @Transactional
    public List<Integer> saveAll(List<OrderItemsVO> vO, OrderDetails result) {
        List<OrderItems> orderItemsBeanList = new ArrayList<>();
        for (OrderItemsVO object : vO) {
            var product = productService.requireOne(object.getProductId());
            var productInventory = product.getInventory();
            var productInventoryQuantity = productInventory.getQuantity();

            // Check first the entry quantity is Valid or not.
            if (productInventoryQuantity == 0)
                throw new InvalidDataEntryException("The Product with id : {" + object.getProductId() + "} is not currently available");
            else if(productInventoryQuantity < object.getQuantity())
                throw new InvalidDataEntryException("The Quantity of that item with id : {" + object.getProductId() + "} is invalid, please check it again.");
            else {
                // Convert VO to Entity.
                OrderItems orderItems = new OrderItems();
                BeanUtils.copyProperties(object,orderItems);
                orderItems.setOrderDetails(result);

                // Decrement Quantity of product Then add it to Order item.
                productInventory.setQuantity(productInventoryQuantity - object.getQuantity());
                orderItems.setProduct(product);

                // ADD ENTITY TO LIST OF ENTITIES.
                orderItemsBeanList.add(orderItems);
            }

        }
        orderItemsBeanList = orderItemsRepository.saveAll(orderItemsBeanList);
        return orderItemsBeanList.stream().map(OrderItems::getId).toList();
    }

    @Transactional
    public void delete(Integer id) {
        orderItemsRepository.deleteById(id);
    }
    @Transactional
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
