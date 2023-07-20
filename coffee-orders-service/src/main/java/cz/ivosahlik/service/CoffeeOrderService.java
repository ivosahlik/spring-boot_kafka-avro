package cz.ivosahlik.service;

import cz.ivosahlik.domain.generated.*;
import cz.ivosahlik.dto.CoffeeOrderDTO;
import cz.ivosahlik.dto.CoffeeOrderUpdateDTO;
import cz.ivosahlik.dto.OrderLineItemDTO;
import cz.ivosahlik.producer.CoffeeOrderProducer;
import cz.ivosahlik.producer.CoffeeOrderUpdateProducer;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CoffeeOrderService {

    private CoffeeOrderProducer  coffeeOrderProducer;

    private CoffeeOrderUpdateProducer coffeeOrderUpdateProducer;

    public CoffeeOrderService(CoffeeOrderProducer coffeeOrderProducer) {
        this.coffeeOrderProducer = coffeeOrderProducer;
        this.coffeeOrderUpdateProducer = coffeeOrderUpdateProducer;
    }

    public CoffeeOrderDTO newOrder(CoffeeOrderDTO coffeeOrderDTO) {
        var coffeeOrderAvro = mapToCoffeeOrder(coffeeOrderDTO);
         coffeeOrderDTO.setId(coffeeOrderAvro.getId().toString());
        coffeeOrderProducer.sendMessage(coffeeOrderAvro);
        return coffeeOrderDTO;
    }

    private CoffeeOrder mapToCoffeeOrder(CoffeeOrderDTO coffeeOrderDTO) {

        var store  = getStore(coffeeOrderDTO);
        var orderLineItems = buildOrderLineItems(coffeeOrderDTO.getOrderLineItems());

        return CoffeeOrder
                .newBuilder()
                .setId(UUID.randomUUID())
                .setName(coffeeOrderDTO.getName())
                .setStore(store)
                .setOrderLineItems(orderLineItems)
                //.setOrderedTime(Instant.now())
                .setOrderedTime(coffeeOrderDTO.getOrderedTime().toInstant(ZoneOffset.UTC))
                .setPickUp(coffeeOrderDTO.getPickUp())
                .setStatus(coffeeOrderDTO.getStatus())
                .build();
    }

    private List<OrderLineItem> buildOrderLineItems(List<OrderLineItemDTO> orderLineItems) {

        return orderLineItems
                .stream()
                .map(orderLineItemDTO -> new OrderLineItem(orderLineItemDTO.getName(),
                        orderLineItemDTO.getSize(),
                        orderLineItemDTO.getQuantity(),
                        orderLineItemDTO.getCost())
                )
                .toList();
    }


    private Store getStore(CoffeeOrderDTO coffeeOrderDTO) {
        var store = coffeeOrderDTO.getStore();
        return Store
                .newBuilder()
                .setId(store.getStoreId())
                .setAddress(
                          new Address(store.getAddress().getAddressLine1(),
                        store.getAddress().getCity(),
                        store.getAddress().getState(),
                        store.getAddress().getCountry(),
                        store.getAddress().getZip())
                )
                .build();
    }

    public CoffeeOrderUpdateDTO updateOrder(String orderId, CoffeeOrderUpdateDTO coffeeOrderUpdateDTO) {
        var coffeeUpdateEvent = mapToCoffeeOrderUpdate(orderId, coffeeOrderUpdateDTO);
        coffeeOrderUpdateProducer.sendMessage(coffeeUpdateEvent);
        return coffeeOrderUpdateDTO;
    }

    private CoffeeUpdateEvent mapToCoffeeOrderUpdate(String orderId, CoffeeOrderUpdateDTO coffeeOrderUpdateDTO) {

        return CoffeeUpdateEvent
                .newBuilder()
                .setId(UUID.fromString(orderId))
                .setStatus(coffeeOrderUpdateDTO.getOrderStatus())
                .build();

    }
}
