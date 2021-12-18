package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceOrder;
import Reto2_Web.modelo.Order;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author desarrolloextremo
 */
@Repository
public class OrderRepositorio {

    @Autowired
    private InterfaceOrder orderCrudRepository;

    public List<Order> getAll() {
        return  orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }

    public List<Order> findByStatus(String status, int idSales){
        return orderCrudRepository.findByStatus(status,idSales);
    }

    public List<Order> findByRegisterDate(Date date, int idSales){
        return orderCrudRepository.findByRegisterDay(date,idSales);
    }

    public List<Order> findBySalesMan(int idSales){
        return orderCrudRepository.findBySalesMan(idSales);
    }
}
