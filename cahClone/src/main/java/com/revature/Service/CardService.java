package com.revature.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.CardRepo;
import com.revature.Models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class CardService {
    private List<Stack<Card>> drawPiles = new ArrayList<>();

    @Autowired
    private CardRepo cardRepo;

    public CardService (CardRepo cardRepo) {this.cardRepo = cardRepo;}

    public List<Card> getAllCardsOfOneColor(Boolean blackWhite){
        List<Card> returnedCards = cardRepo.findByBlackWhite(blackWhite);
        return returnedCards;
    }

    public List<Card> getAllCardsOfOneColorByPack(Boolean blackWhite, int cardPack){
        List<Card> returnedCards = cardRepo.findByBlackWhiteAndCardPack(blackWhite,cardPack);
        return returnedCards;
    }

    public Stack<Card> makeDeck (List<Card> picked){
        Stack<Card> drawPile = new Stack<Card>();

        for(int i = 0; i < picked.size(); i++){
            drawPile.push(picked.get(i));
        }
        return drawPile;
    }

    public List<Stack<Card>> prepCardStack(int cardPack){
        List<Card> chosenBlackPacks = cardRepo.findByBlackWhiteAndCardPack(true, cardPack);
        Stack<Card> blackCards = makeDeck(chosenBlackPacks);

        List<Card> chosenWhitePacks = cardRepo.findByBlackWhiteAndCardPack(false, cardPack);
        Stack<Card> whiteCards = makeDeck(chosenWhitePacks);

        this.drawPiles.add(blackCards);
        this.drawPiles.add(whiteCards);

        return this.drawPiles;
    }
}
