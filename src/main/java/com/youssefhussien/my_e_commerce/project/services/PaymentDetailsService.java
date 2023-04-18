package com.youssefhussien.my_e_commerce.project.services;

import com.youssefhussien.my_e_commerce.project.dto.PaymentDetailsDTO;
import com.youssefhussien.my_e_commerce.project.entites.PaymentDetail;
import com.youssefhussien.my_e_commerce.project.repository.PaymentDetailsRepository;
import com.youssefhussien.my_e_commerce.project.vo.PaymentDetailsQueryVO;
import com.youssefhussien.my_e_commerce.project.vo.PaymentDetailsUpdateVO;
import com.youssefhussien.my_e_commerce.project.vo.PaymentDetailsVO;
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
public class PaymentDetailsService {

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    public Integer save(PaymentDetailsVO vO) {
        PaymentDetail bean = new PaymentDetail();
        BeanUtils.copyProperties(vO, bean);
        bean = paymentDetailsRepository.save(bean);
        return bean.getId();
    }
    public PaymentDetail save(PaymentDetail paymentDetail){
        return paymentDetailsRepository.save(paymentDetail);
    }

    public void delete(Integer id) {
        paymentDetailsRepository.deleteById(id);
    }

    public void update(Integer id, PaymentDetailsUpdateVO vO) {
        PaymentDetail bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paymentDetailsRepository.save(bean);
    }

    public PaymentDetailsDTO getById(Integer id) {
        PaymentDetail original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaymentDetailsDTO> query(PaymentDetailsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaymentDetailsDTO toDTO(PaymentDetail original) {
        PaymentDetailsDTO bean = new PaymentDetailsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaymentDetail requireOne(Integer id) {
        return paymentDetailsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
