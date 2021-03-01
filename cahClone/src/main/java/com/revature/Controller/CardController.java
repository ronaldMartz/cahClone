package com.revature.Controller;



import com.revature.Models.Card;
import com.revature.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(path="/play")
public class CardController {

    @Autowired
    private CardService cardService;

    public CardController(CardService cardService){this.cardService = cardService;}

    @GetMapping(path="/allBlack")
    public ResponseEntity<List<Card>> getAllBlackCards(){
        List<Card> returnedCards = cardService.getAllCardsOfOneColor(true);
        return new ResponseEntity<>(returnedCards, HttpStatus.OK);
    }

    @GetMapping(path="/allBlack/{pack}")
    public ResponseEntity<List<Card>> getAllBlackCardsFromPack(@PathVariable(name="pack") int i){
        List<Card> returnedCards = cardService.getAllCardsOfOneColorByPack(true,i);
        return new ResponseEntity<>(returnedCards, HttpStatus.OK);
    }

    @GetMapping(path="/allWhite")
    public ResponseEntity<List<Card>> getAllWhiteCards(){
        List<Card> returnedCards = cardService.getAllCardsOfOneColor(false);
        return new ResponseEntity<>(returnedCards, HttpStatus.OK);
    }

    @GetMapping(path="/allWhite/{pack}")
    public ResponseEntity<List<Card>> getAllWhiteCardsFromPack(@PathVariable(name="pack") int i){
        List<Card> returnedCards = cardService.getAllCardsOfOneColorByPack(false,i);
        return new ResponseEntity<>(returnedCards, HttpStatus.OK);
    }

    @GetMapping(path="/{pack}")
    public void buildDecks(@PathVariable(name="pack") int cardPack) {
        List<Stack<Card>> drawPiles = new ArrayList<>();
        drawPiles=cardService.prepCardStack(cardPack);

        for(int i = 0; i < drawPiles.size(); i++){
            System.out.print("Stack: " + (i+1));
            Stack<Card> drawStack = drawPiles.get(i);
            System.out.println(" Stack Size: " + drawStack.size());
            for(int j = 0; j < drawStack.size(); j++){
                System.out.println(drawStack.get(j));
            }
        }
    }

//    @GetMapping(path="/czar")
//    public ResponseEntity<Card> getOneForCzar(){
//        Random rand = new Random();
//        int upperbound = 2520;
//        int i = rand.nextInt(upperbound);
//        Card returnedCard = cardRepo.findByCardID(i);
//        return new ResponseEntity<>(returnedCard, HttpStatus.OK);
//    }
}
