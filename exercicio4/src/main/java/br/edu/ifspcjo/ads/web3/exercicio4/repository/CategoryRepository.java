package br.edu.ifspcjo.ads.web3.exercicio4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  br.edu.ifspcjo.ads.web3.exercicio4.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
