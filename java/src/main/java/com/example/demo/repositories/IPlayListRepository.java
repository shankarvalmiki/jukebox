package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PlayList;

public interface IPlayListRepository {
    PlayList save(PlayList playlist);
    void delete(Integer id);
    List<PlayList> findAll();
    Optional<PlayList> findById(Integer id);
    Optional<PlayList> findByName(String name);
    
}
