/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.InterfaceCleaningProduct;
import Reto2_Web.modelo.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class CleaningProductRepositorio {
    @Autowired
    private InterfaceCleaningProduct repository;

    public List<CleaningProduct> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProduct> getProduct(String reference) {
        return repository.findById(reference);
    }
    public CleaningProduct create(CleaningProduct product) {
        return repository.save(product);
    }

    public void update(CleaningProduct Product) {
        repository.save(Product);
    }
    
    public void delete(CleaningProduct Product) {
        repository.delete(Product);
    }
}
