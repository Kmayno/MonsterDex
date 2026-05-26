package com.dex.monsterdex.repository;

import com.dex.monsterdex.pojo.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    //trova ID monster preferita utente x
    @Query(value = "SELECT monster_id FROM ratings WHERE user_id = :userId ORDER BY rating DESC, created_at DESC LIMIT 1", nativeQuery = true)
    Optional<Long> findFavoriteMonsterIdByUserId(@Param("userId") Long userId);
}
