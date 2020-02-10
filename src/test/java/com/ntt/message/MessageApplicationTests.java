package com.ntt.message;

import com.ntt.dto.ProductDto;
import com.ntt.entity.ProductEntity;
import com.ntt.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MessageApplicationTests {

	@Autowired
	ProductService productService;

	@Test
	void saveProductTest() {
		ProductDto dto = new ProductDto("Test1", 12, 105L);
		ResponseEntity<ProductEntity> savedEntity = productService.saveProduct(dto);
		assertThat(savedEntity).isNotNull();
	}

}
