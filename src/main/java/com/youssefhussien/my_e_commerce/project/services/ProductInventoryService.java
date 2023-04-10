package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.project.dto.ProductInventoryDTO;
import com.youssefhussien.my_e_commerce.project.entites.ProductInventory;
import com.youssefhussien.my_e_commerce.project.repository.ProductInventoryRepository;
import com.youssefhussien.my_e_commerce.project.vo.ProductInventoryQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductInventoryUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductInventoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductInventoryService {

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    public Integer save(ProductInventoryVO vO) {
        ProductInventory bean = new ProductInventory();
        BeanUtils.copyProperties(vO, bean);
        bean = productInventoryRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        productInventoryRepository.deleteById(id);
    }

    public void update(Integer id, ProductInventoryUpdateVO vO) {
        ProductInventory bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productInventoryRepository.save(bean);
    }

    public ProductInventoryDTO getById(Integer id) {
        ProductInventory original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProductInventoryDTO> query(ProductInventoryQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ProductInventoryDTO toDTO(ProductInventory original) {
        ProductInventoryDTO bean = new ProductInventoryDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ProductInventory requireOne(Integer id) {
        return productInventoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
