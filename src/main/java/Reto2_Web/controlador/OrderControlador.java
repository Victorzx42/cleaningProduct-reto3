package Reto2_Web.controlador;

import Reto2_Web.modelo.Order;
import Reto2_Web.servicio.OrderServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderControlador {

    @Autowired
    private OrderServicio orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderService.findByZone(zona);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> findBySalesMan(@PathVariable("id")int idSales){
        return orderService.findBySalesMan(idSales);
    }

    @GetMapping("/state/{status}/{id}")
    public List<Order> findByStatus(@PathVariable("status")String status, @PathVariable("id")int idSales){
        return orderService.findByStatus(status,idSales);
    }

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> findByRegisterDay(@PathVariable("registerDay")String registerDay,@PathVariable("id")int idSales){
        return  orderService.findByRegisterDay(registerDay,idSales);
    }
}
