package com.youssefhussien.my_e_commerce.core.base;

import com.youssefhussien.my_e_commerce.core.exception_handling.exception.RecordNotFoundException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>, ID extends  Number>{

    @Autowired
    private BaseRepository<T,ID> baseRepository;

//    @Autowired
//    private MessageSource messageSource;

    public T findById(ID id){

        Optional<T> entity =  baseRepository.findById(id);
        if (entity.isPresent()){
            return  entity.get();
        }
        else
        {
//            String [] msgParam = {id.toString()};
//        String msg = messageSource.getMessage("validation.recordNotFound.message",msgParam, LocaleContextHolder.getLocale());
            throw new RecordNotFoundException("This record with id:- {"+ id + "} not found");
        }
    }

    public List<T> findAll(){
        return baseRepository.findAll();
    }

    public T insert(T entity){

        if (entity.getId() != null) {

            throw new RuntimeException();
        }

        return baseRepository.save(entity);
    }

    public List<T> insert(List<T> entity){

        return baseRepository.saveAll(entity);
    }
    public T update(T entity){

        return baseRepository.save(entity);
    }

    public void deleteById(ID id){

        baseRepository.deleteById(id);
    }
}
