package br.edu.ifspcjo.ads.web3.exercicio3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.edu.ifspcjo.ads.web3.exercicio3.domain.model.Category;
import br.edu.ifspcjo.ads.web3.exercicio3.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category update(Long id, Category category) {
        Category saved = findById(id);
        saved.setName(category.getName());
        return categoryRepository.save(saved);
    }

    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw ex;
        }
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
