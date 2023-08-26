package com.cqrs.demo.service.implementation;

import com.cqrs.demo.DAO.ProductQueryRepository;
import com.cqrs.demo.DTO.ProductEvent;
import com.cqrs.demo.entity.Product;
import com.cqrs.demo.service.apstraction.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductQueryRepository productQueryRepository;



    @Autowired
   public ProductServiceImpl( ProductQueryRepository productQueryRepository){
        this.productQueryRepository = productQueryRepository;
    }

    @Override
    public Product getProductById(long productId) throws Exception {
        return productQueryRepository.findById(productId).orElseThrow();
    }

    @Override
    public List<Product> getProducts() {
        return productQueryRepository.findAll();
    }


    @KafkaListener(topics = "PRODUCT_EVENT_TOPIC" ,groupId = "PRODUCT_EVENT_GROUP")

    public void processProductEvent(ProductEvent productEvent){
        if(productEvent.getEventType().equals("CREATE_PRODUCT")){

            productQueryRepository.save(productEvent.getProduct());

        }

        if(productEvent.getEventType().equals("UPDATE_PRODUCT")){

            productQueryRepository.save(productEvent.getProduct());

        }

    }
}
