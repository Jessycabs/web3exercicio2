package br.edu.ifspcjo.ads.web3.exercicio3.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import br.edu.ifspcjo.ads.web3.exercicio3.domain.model.Category;
import br.edu.ifspcjo.ads.web3.exercicio3.repository.CategoryRepository;
import br.edu.ifspcjo.ads.web3.exercicio3.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> list() { return categoryRepository.findAll(); }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category) {
        Category saved = categoryRepository.save(category);
        return ResponseEntity.status(201).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @Valid @RequestBody Category category) {
        Category updated = categoryService.update(id, category);
        return ResponseEntity.ok(updated);
    }
}
