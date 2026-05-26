package com.dex.monsterdex.repository;

import com.dex.monsterdex.pojo.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Integer> {
    Monster findByName(String name);
}
