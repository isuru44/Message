package com.ntt.serviceImpl;

import com.ntt.dto.ProductDto;
import com.ntt.service.ProductService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageListenerImpl {

    @Autowired
    ProductService productService;

    @RabbitListener(queues = "${app.queue.name}")
    public void receiveMessage(ProductDto productDto) {
        try {
            productService.saveProduct(productDto);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
