package br.edu.ifspcjo.ads.web3.exercicio3.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import br.edu.ifspcjo.ads.web3.exercicio3.domain.model.User;
import br.edu.ifspcjo.ads.web3.exercicio3.repository.UserRepository;
import br.edu.ifspcjo.ads.web3.exercicio3.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list() { return userRepository.findAll(); }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User saved = userRepository.save(user);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
        User updated = userService.update(id, user);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/{id}/active")
    public ResponseEntity<Void> updateActive(@PathVariable Long id, @RequestBody Boolean active) {
        userService.updateActiveProperty(id, active);
        return ResponseEntity.noContent().build();
    }
}
