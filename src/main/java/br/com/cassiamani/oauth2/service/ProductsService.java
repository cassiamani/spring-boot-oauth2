package br.com.cassiamani.oauth2.service;

import br.com.cassiamani.oauth2.domain.Products;
import br.com.cassiamani.oauth2.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }
}
