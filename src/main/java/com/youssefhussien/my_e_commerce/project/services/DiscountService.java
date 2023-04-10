package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.project.dto.DiscountDTO;
import com.youssefhussien.my_e_commerce.project.entites.Discount;
import com.youssefhussien.my_e_commerce.project.entites.Product;
import com.youssefhussien.my_e_commerce.project.repository.DiscountRepository;
import com.youssefhussien.my_e_commerce.project.vo.DiscountQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.DiscountUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.DiscountVO;
import com.youssefhussien.my_e_commerce.project.vo.ProductUpdateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private ProductService productService;

    @Transactional
    public Integer save(DiscountVO vO) {
        Discount bean = new Discount();
        Product product = productService.requireOne(vO.getProductID());
        if(product.getDiscount() != null){
            product.getDiscount().setActive(0);
        }
        BeanUtils.copyProperties(vO, bean);
        bean = discountRepository.save(bean);
        product.setDiscount(bean);
        return bean.getId();
    }
    @Transactional
    public void delete(Integer id) {
        discountRepository.deleteById(id);
    }
    @Transactional
    public void update(Integer id, DiscountUpdateVO vO) {
        Discount bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        discountRepository.save(bean);
    }

    public DiscountDTO getById(Integer id) {
        Discount original = requireOne(id);
        return toDTO(original);
    }

    public Page<DiscountDTO> query(DiscountQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DiscountDTO toDTO(Discount original) {
        DiscountDTO bean = new DiscountDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Discount requireOne(Integer id) {
        return discountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
