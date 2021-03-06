package br.com.cassiamani.oauth2.repository;

import br.com.cassiamani.oauth2.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
