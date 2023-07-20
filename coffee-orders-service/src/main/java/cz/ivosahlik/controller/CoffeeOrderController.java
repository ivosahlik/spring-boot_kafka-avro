package cz.ivosahlik.controller;

import cz.ivosahlik.dto.CoffeeOrderDTO;
import cz.ivosahlik.dto.CoffeeOrderUpdateDTO;
import cz.ivosahlik.service.CoffeeOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/coffee_orders")
@Slf4j
public class CoffeeOrderController {

    private CoffeeOrderService coffeeOrderService;

    public CoffeeOrderController(CoffeeOrderService coffeeOrderService) {
        this.coffeeOrderService = coffeeOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrderDTO newOrder(@RequestBody CoffeeOrderDTO coffeeOrderDTO) {
        log.info("Received the request for an order : {}", coffeeOrderDTO);
        return coffeeOrderService.newOrder(coffeeOrderDTO);
    }

    @PutMapping("/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public CoffeeOrderUpdateDTO updateCoffeeOrder(@PathVariable("order_id") String orderId,
                                                  @RequestBody CoffeeOrderUpdateDTO coffeeOrderUpdateDTO) {
        return coffeeOrderService.updateOrder(orderId, coffeeOrderUpdateDTO);

    }
}
