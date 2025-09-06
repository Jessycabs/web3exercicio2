package br.edu.ifspcjo.ads.web3.exercicio2.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletResponse;

import br.edu.ifspcjo.ads.web3.exercicio2.domain.model.Category;
import br.edu.ifspcjo.ads.web3.exercicio2.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@Valid @RequestBody Category category, HttpServletResponse response) {
        return categoryRepository.save(category);
    }
}
