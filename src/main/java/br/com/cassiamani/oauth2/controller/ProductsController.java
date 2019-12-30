package br.com.cassiamani.oauth2.controller;

import br.com.cassiamani.oauth2.domain.Products;
import br.com.cassiamani.oauth2.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity<List<Products>> findAll() {
        List<Products> products = productsService.findAll();

        return ResponseEntity.ok().body(products);
    }
}
