package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.project.dto.DiscountDTO;
import com.youssefhussien.my_e_commerce.project.dto.ProductCategoryDTO;
import com.youssefhussien.my_e_commerce.project.dto.ProductDTO;
import com.youssefhussien.my_e_commerce.project.dto.ProductInventoryDTO;
import com.youssefhussien.my_e_commerce.project.entites.Product;
import com.youssefhussien.my_e_commerce.project.entites.ProductInventory;
import com.youssefhussien.my_e_commerce.project.repository.ProductRepository;
import com.youssefhussien.my_e_commerce.project.vo.ProductQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductVO;
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
@Transactional(readOnly = true)
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryService productCategoryService;

    @Transactional
    public Integer save(ProductVO vO) {
        Product bean = new Product();
        ProductInventory productInventory = new ProductInventory();
        BeanUtils.copyProperties(vO, bean);
        BeanUtils.copyProperties(vO.getInventory(), productInventory);
        bean.setCategory(productCategoryService.requireOne(vO.getCategory()));
        bean.setInventory(productInventory);
        bean = productRepository.save(bean);
        return bean.getId();
    }

    @Transactional
    public List<Integer> saveAll(List<ProductVO> vO) {
        List<Product> beans = new ArrayList<>();

        vO.forEach(element -> {
            Product bean = new Product();
            ProductInventory productInventory = new ProductInventory();
            BeanUtils.copyProperties(element, bean);
            BeanUtils.copyProperties(element.getInventory(), productInventory);
            bean.setCategory(productCategoryService.requireOne(element.getCategory()));
            bean.setInventory(productInventory);
            beans.add(bean);
        });

        var result = productRepository.saveAll(beans);
        return result.stream().map(Product::getId).toList();
    }

    @Transactional
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void update(Integer id, ProductUpdateVO vO) {
        Product bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productRepository.save(bean);
    }


    public ProductDTO getById(Integer id) {
        Product original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProductDTO> query(ProductQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ProductDTO toDTO(Product original) {
        original.calcPriceAfterDiscount();
        ProductDTO bean = new ProductDTO();
        BeanUtils.copyProperties(original, bean);

        if (original.getInventory() != null) {
            ProductInventoryDTO productInventoryDTO = new ProductInventoryDTO();
            BeanUtils.copyProperties(original.getInventory(), productInventoryDTO);
            bean.setInventory(productInventoryDTO);
        }

        if (original.getCategory() != null) {
            ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
            BeanUtils.copyProperties(original.getCategory(), productCategoryDTO);
            bean.setCategory(productCategoryDTO);
        }

        if (original.getDiscount() != null && original.getDiscount().getActive() != 0) {
            DiscountDTO discountDTO = new DiscountDTO();
            BeanUtils.copyProperties(original.getDiscount(), discountDTO);
            bean.setDiscount(discountDTO);
        }

        return bean;
    }

    public Product requireOne(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<ProductDTO> findAll() {
        List<Product> result = productRepository.findAll();
        return result.stream().map(this::toDTO).toList();
    }

    public List<ProductDTO> findByCategory(Integer id) {
        List<Product> result = productRepository.findByCategory(id);
        return result.stream().map(this::toDTO).toList();
    }
}
