package Reto2_Web.interfaces;

import Reto2_Web.modelo.Order;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author desarrolloextremo
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();

    @Query("{'salesMan.id': ?0}")
    List<Order> findBySalesMan(final Integer id);

    @Query("{registerDay: ?0, 'salesMan.id': ?1}")
    List<Order> findByRegisterDay(final Date registerDay, Integer id);


    @Query("{status: ?0, 'salesMan.id': ?1}")
    List<Order> findByStatus(final String status, Integer id);

}


