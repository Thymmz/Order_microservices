package com.walmart.order;

import com.walmart.order.dao.OrderDao;
import com.walmart.order.service.OrderLoaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootApplication
public class OrderLoaderServiceApplication {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		SpringApplication.run(OrderLoaderServiceApplication.class, args);

	}


}
