package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteraktywnoscPrzyciskow2 extends Gra implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        String twojWybor = event.getActionCommand(); // klikniety wybor zostanie wczytany do stringa
        switch (pozycja) {
            case "wybor":
                switch (twojWybor){
                    case "w1": wyborSzymus(); break;
                    case "w2": wyborMati(); break;
                    case "w3": wyborTomasz(); break;
                    case "w4": wyborAdek(); break;
                }
                break;
            case "wyborSzymus":
            case "wyborMati":
            case "wyborTomasz":
            case "wyborAdek":
                switch (twojWybor){
                    case "w1": zwrotButelki(); break;
                    case "w2": wymianaButelki(); break;
                    case "w3": ukrycieButelki(); break;
                }
                break;
            case "zwrotButelki":
                switch (twojWybor){
                    case "w1": akceptacja(); break;
                    case "w2": odrzucenie(); break;
                    case "w3": kradziez(); break;
                    case "w4": walkaBoss(); break;
                }
                break;
            case "akceptacja":
                switch (twojWybor){
                    case "w1": wymianaButelki(); break;
                    case "w2": kradziez(); break;
                }
                break;
            case "odrzucenie":
                switch (twojWybor){
                    case "w1": akceptacja(); break;
                    case "w2": wymianaButelki(); break;
                    case "w3": kradziez(); break;
                }
                break;
            case "kradziez":
                switch (twojWybor){
                    case "w1": wymianaButelki(); break;
                }
                break;
            case "wymianaButelki":
                switch (twojWybor){
                    case "w1": zwrotButelki(); break;
                    case "w2": ukrycieButelki(); break;
                }
                break;
            case "ukrycieButelki":
                switch (twojWybor){
                    case "w1": walkaPostaci(); break;
                    case "w2": ucieczka(); break;
                }
                break;
            case "ucieczka":
                switch (twojWybor){
                    case "w1": walkaAI(); break;
                    case "w2": zwrotButelki(); break;
                }
                break;
            case "walkaPostaci":
                switch (twojWybor){
                    case "w1":
                    if(hpPsów<1){
                        wygranaPsy();
                    }
                    else{
                        walkaAI();
                    }
                    break;
                    case "w2": ucieczka(); break;
                }
                break;
            case "walkaBoss":
                switch (twojWybor){
                    case "w1":
                        if(hp<1){
                            porazka();
                        }
                        else{
                            walkaPostaciBoss();
                        }
                        break;
                }
                break;
            case "walkaPostaciBoss":
                switch (twojWybor){
                    case "w1":
                        if(hpBoss<1){
                            wygranaBoss();
                        }
                        else{
                            walkaBoss();
                        }
                        break;
                }
                break;
            case "walkaAI":
                switch (twojWybor){
                    case "w1":
                    if(hp<1){
                        porazka();
                    }
                    else{
                        walkaPostaci();
                    }
                    break;
                    case "w2": ucieczka(); break;
                }
                break;
            case "wygranaPsy":
                switch (twojWybor){
                    case "w1": zwrotButelki(); break;
                }
                break;
            case "psyDrugiRaz":{
                switch (twojWybor){
                    case "w1": zwrotButelki(); break;
                }
                break;
            }
        }
    }
}
