package com.social.SocialNetwork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.SocialNetwork.domain.User;
import com.social.SocialNetwork.dto.UserDTO;
import com.social.SocialNetwork.repository.UserRepository;
import com.social.SocialNetwork.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {//método para buscar todos os usuários
        return repo.findAll();
    }

    public User findById(String id) {//método para buscar um usuário por id
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj) {//método para inserir um novo usuário
        return repo.insert(obj);
    }

    public void delete(String id) {//método para deletar um usuário
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {//método para atualizar um usuário
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {//método para atualizar os dados de um usuário
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    public User fromDTO(UserDTO objDTO) {//método para converter um UserDTO em User
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}