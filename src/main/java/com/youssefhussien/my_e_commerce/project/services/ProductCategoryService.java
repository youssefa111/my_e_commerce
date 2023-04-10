package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.project.dto.ProductCategoryDTO;
import com.youssefhussien.my_e_commerce.project.entites.ProductCategory;
import com.youssefhussien.my_e_commerce.project.repository.ProductCategoryRepository;
import com.youssefhussien.my_e_commerce.project.vo.ProductCategoryQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductCategoryUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@Transactional(readOnly = true)
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Transactional
    public Integer save(ProductCategoryVO vO) {
        log.info("here is entity of ProductCategoryVO ===>" + vO.toString());
        ProductCategory bean = new ProductCategory();
        BeanUtils.copyProperties(vO, bean);
        log.info("here is entity of Product Category ===>" + bean.toString());
        bean = productCategoryRepository.save(bean);
        return bean.getId();
    }

    @Transactional
    public void delete(Integer id) {
        productCategoryRepository.deleteById(id);
    }

    @Transactional
    public void update(Integer id, ProductCategoryUpdateVO vO) {
        ProductCategory bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productCategoryRepository.save(bean);
    }

    public ProductCategoryDTO getById(Integer id) {
        ProductCategory original = requireOne(id);
        return toDTO(original);
    }

    public List<ProductCategoryDTO> findAll() {
      List<ProductCategory> result = productCategoryRepository.findAll();
        return result.stream().map(this::toDTO).toList();
    }

    public Page<ProductCategoryDTO> query(ProductCategoryQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    public ProductCategoryDTO toDTO(ProductCategory original) {
        ProductCategoryDTO bean = new ProductCategoryDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public ProductCategory requireOne(Integer id) {
        return productCategoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }


}
