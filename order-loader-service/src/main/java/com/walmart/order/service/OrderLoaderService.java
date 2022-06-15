package com.walmart.order.service;


import com.walmart.order.dao.OrderDao;
import com.walmart.order.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@Service
public class OrderLoaderService {

    @Autowired
    private OrderDao orderDao;

    public OrderLoaderService(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public void parseAndSave(String fileName) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(fileName));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <staff>
            NodeList list = doc.getElementsByTagName("Order");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Integer orderId = Integer.valueOf(element.getElementsByTagName("orderId").item(0).getTextContent());
                    Integer itemId = Integer.valueOf(element.getElementsByTagName("itemId").item(0).getTextContent());
                    Integer quantity = Integer.valueOf(element.getElementsByTagName("quantity").item(0).getTextContent());
                    Integer amount = Integer.valueOf(element.getElementsByTagName("amount").item(0).getTextContent());
                    String confirmationStatus = element.getElementsByTagName("confirmationStatus").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();

                    Orders orders = new Orders(orderId, itemId, quantity, amount, confirmationStatus, address); //serealize your data into entity
                    orderDao.save(orders); //saving to database
                    // System.out.println(id + " " + lastName + " snType " + quantity + " programList " + programList);

                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}