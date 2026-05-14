package com.social.SocialNetwork.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.social.SocialNetwork.domain.Post;
import com.social.SocialNetwork.domain.User;
import com.social.SocialNetwork.dto.AuthorDTO;
import com.social.SocialNetwork.repository.PostRepository;
import com.social.SocialNetwork.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//formato de data para converter as datas dos posts
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));//configura o fuso horário para GMT

        userRepository.deleteAll();//deleta todos os usuários do banco de dados
        postRepository.deleteAll();//deleta todos os posts do banco de dados

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));//salva os usuários no banco de dados

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Mais um dia", "Estou trabalhando duro hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));//salva os posts no banco de dados
        maria.getPosts().addAll(Arrays.asList(post1, post2));//adiciona os posts aos usuários
        userRepository.save(maria);//atualiza os usuários no banco de dados
    }

}
