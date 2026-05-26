package com.dex.monsterdex.service;

import com.dex.monsterdex.pojo.Monster;
import com.dex.monsterdex.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {

    private final MonsterRepository monsterRepository;

    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    public Optional<Monster> getMonsterById(int id) {
        return monsterRepository.findById(id);
    }

    public Monster createMonster(Monster monster) {
        return monsterRepository.save(monster);
    }

    public Monster updateMonster(String name, Monster monsterDetails) {
        Monster find = monsterRepository.findByName(name);
        if (find != null) {
            find.setName(monsterDetails.getName());
            find.setDescription(monsterDetails.getDescription());
            find.setReleaseDate(monsterDetails.getReleaseDate());
            find.setCategory(monsterDetails.getCategory());
            find.setImageUrl(monsterDetails.getImageUrl());
            monsterRepository.save(find);
            return find;
        } else {
            throw new RuntimeException("Monster not found");
        }
    }

    public void deleteMonster(int id) {
        if (!monsterRepository.existsById(id)) {
             throw new RuntimeException("Monster non trovata con id: " + id);
        }
        monsterRepository.deleteById(id);
    }
}
