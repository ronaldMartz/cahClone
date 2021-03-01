package com.revature.DAO;

import com.revature.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepo extends JpaRepository<Card, Integer> {
    List<Card> findByBlackWhite(Boolean blackWhite);//find all cards (black or white).
    List<Card> findByBlackWhiteAndCardPack(Boolean blackWhite, int cardPack);//find all cards (black or white) in a pack.
    Card findByCardID(int cardID);
}
