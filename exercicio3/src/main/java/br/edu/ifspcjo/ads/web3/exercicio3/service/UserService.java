package br.edu.ifspcjo.ads.web3.exercicio3.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.edu.ifspcjo.ads.web3.exercicio3.domain.model.User;
import br.edu.ifspcjo.ads.web3.exercicio3.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User update(Long id, User user) {
        User userSaved = findUserById(id);
        BeanUtils.copyProperties(user, userSaved, "id");
        return userRepository.save(userSaved);
    }

    public void updateActiveProperty(Long id, Boolean active) {
        User userSaved = findUserById(id);
        userSaved.setActive(active);
        userRepository.save(userSaved);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
