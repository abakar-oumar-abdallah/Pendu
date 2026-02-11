package com.oumar.game;

import java.util.ArrayList;
import java.util.List;

public class GuessGame {

    private final List<Character> secretWord = new ArrayList<>();
    private int lifePoints;
    private final List<Character> guessWord = new ArrayList<>();

    public GuessGame(String wordToGuess, int lifePoints) {
        for (char c : wordToGuess.toCharArray()) {
            this.secretWord.add(c);
        }
        this.lifePoints = lifePoints;
        for (int index = 0; index < this.secretWord.size(); index++) {
            this.guessWord.add('_');
        }
    }

    public void guessLetter(char letter) {
        var isGoodLetter = secretWord.contains(letter) && !guessWord.contains(letter);

        if (isGoodLetter) {
            var index = 0;
            for (char c : secretWord) {
                if (c == letter) {
                    guessWord.set(index, c);
                }
                index ++;
            }
        } else {
            lifePoints -= 1;
        }
    }

    public boolean isLost() {
        return lifePoints <= 0;
    }

    public boolean isWon() {
        return !guessWord.contains('_');
    }

    @Override
    public String toString() {
        return "mot à deviner : " + guessWord +
                " | points de vie : " + lifePoints;
    }
}
