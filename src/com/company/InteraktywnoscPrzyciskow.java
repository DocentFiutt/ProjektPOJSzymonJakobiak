package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class InteraktywnoscPrzyciskow extends Gra implements ActionListener  { // tworzymy interakcje po kliknieciu przycisku
    public void actionPerformed(ActionEvent event){

        try {
            stworzObrazGry1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

