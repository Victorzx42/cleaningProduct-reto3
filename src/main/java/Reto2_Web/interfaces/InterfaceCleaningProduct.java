/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_Web.interfaces;


import Reto2_Web.modelo.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, String> {
    @Query("{'price': {$lte:?0}}")
    List<CleaningProduct> findByPrice(double price);

    @Query("{'description': {$regex:?0,$options:'i'}}")
    List<CleaningProduct> findByDescription(String description);
    
}
