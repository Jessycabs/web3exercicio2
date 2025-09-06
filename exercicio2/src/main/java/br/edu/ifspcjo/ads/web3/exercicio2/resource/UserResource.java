package br.edu.ifspcjo.ads.web3.exercicio2.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletResponse;

import br.edu.ifspcjo.ads.web3.exercicio2.domain.model.User;
import br.edu.ifspcjo.ads.web3.exercicio2.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User user, HttpServletResponse response) {
        return userRepository.save(user);
    }
}
