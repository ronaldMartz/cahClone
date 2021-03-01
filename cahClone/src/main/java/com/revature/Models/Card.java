package com.revature.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="available_in_play")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @Column(name="card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardID;

    @Column(name = "black_white")
    private Boolean blackWhite;

    @Column(name = "pick_num")
    private int pickNum;

    @Column(name = "card_text")
    private String cardText;

    @Column(name = "card_pack")
    private int cardPack;

    @Column(name = "been_played")
    private Boolean beenPlayed;
}
