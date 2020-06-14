package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Gra {

    static JFrame okno;
    static Container con;
    static JPanel panelTytulowy, panelPrzyciskStart, panelGlownyTekst, przyciskWyboru, panelPostaci, panelStaty;
    static JLabel napisGlowny, postacimg1, postacimg2, postacimg3, postacimg4, hpLabel, hpLabelIle, kasaLabel, kasaLabelIle, przedmiotLabel, przedmiotLabelJaki;
    static Font czionkaGlownego = new Font("Times New Roman", Font.PLAIN, 50); // tworzymy customowa tytulowa czcionke
    static JButton przyciskStart, wybor1, wybor2, wybor3, wybor4; // tworzymy przycisk
    static Font czionkaPrzyciskow = new Font("Times New Roman", Font.PLAIN, 30);
    static JTextArea obszarGlownegoTekstu;
    static InteraktywnoscPrzyciskow itPk = new InteraktywnoscPrzyciskow(); // interaktywnosc przycisku nowa gra
    static InteraktywnoscPrzyciskow2 itPk2 = new InteraktywnoscPrzyciskow2(); // interaktywnosc przyciskow wyboru
    static String pozycja, przedmiot;
    static int hp, kasa, hpPsów=20, hpBoss =30;


    public static void main(String[] args) throws Exception {
        new Gra();
    }

    public Gra() {
        okno = new JFrame();
        okno.setSize(800, 600); // rozmiar okna
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // funkcja dzieki ktorej mozna zamknac okno
        okno.getContentPane().setBackground(Color.BLACK); // kolor tła
        okno.setLayout(null); // wylaczamy defaultowy layout zeby moc uzyc swoj
        okno.setVisible(true); // dzieki temu widac okno
        con = okno.getContentPane(); // tworzymy kontener w ktorym mozna umiescic panel

        panelTytulowy = new JPanel(); // tworzymy panel w tym przypadku do wpisania tytulu gry
        panelTytulowy.setBounds(100, 100, 600, 800); // ustawiamy wielkosc i polozenie panelu
        panelTytulowy.setBackground(Color.BLACK);

        napisGlowny = new JLabel("Łotr spod ciemnej gwiazdy");
        napisGlowny.setForeground(Color.white);
        napisGlowny.setFont(czionkaGlownego); // ustawiamy czionke

        panelPrzyciskStart = new JPanel();
        panelPrzyciskStart.setBounds(300, 400, 200, 100);
        panelPrzyciskStart.setBackground(Color.BLACK);

        przyciskStart = new JButton("NOWA GRA");
        przyciskStart.setBackground(Color.BLACK);
        przyciskStart.setForeground(Color.WHITE);
        przyciskStart.setFont(czionkaPrzyciskow);
        przyciskStart.addActionListener(itPk); // umozliwia interakcje przycisku
        przyciskStart.setFocusPainted(false); // znikniecie obwódki wokol tekstu

        panelTytulowy.add(napisGlowny); // umozliwia wyswietlanie tekstu w panelu
        panelPrzyciskStart.add(przyciskStart);
        con.add(panelTytulowy); // umozliwia wyswietlanie panelu w kontenerze
        con.add(panelPrzyciskStart);
    }

    public void stworzObrazGry1() throws IOException {
        pozycja = "wybor";
        panelTytulowy.setVisible(false); // wylaczenie panelow z ekranu glownego
        panelPrzyciskStart.setVisible(false);

        panelGlownyTekst = new JPanel();
        panelGlownyTekst.setBounds(100, 100, 600, 60);
        panelGlownyTekst.setBackground(Color.BLACK);
        con.add(panelGlownyTekst);

        obszarGlownegoTekstu = new JTextArea("WYBIERZ POSTAĆ");
        obszarGlownegoTekstu.setBounds(100, 100, 600, 200);
        obszarGlownegoTekstu.setBackground(Color.BLACK);
        obszarGlownegoTekstu.setForeground(Color.WHITE);
        obszarGlownegoTekstu.setFont(czionkaPrzyciskow);
        obszarGlownegoTekstu.setLineWrap(true); // wlaczanie zawijania wierszow
        panelGlownyTekst.add(obszarGlownegoTekstu);

        przyciskWyboru = new JPanel();
        przyciskWyboru.setBounds(100, 350,600,60);
        przyciskWyboru.setBackground(Color.BLACK);
        przyciskWyboru.setLayout(new GridLayout(1,4));
        con.add(przyciskWyboru);

        wybor1 = new JButton("Szymuś");
        wybor1.setBackground(Color.BLACK);
        wybor1.setForeground(Color.WHITE);
        wybor1.setFont(czionkaPrzyciskow);
        wybor1.addActionListener(itPk2);
        wybor1.setActionCommand("w1");
        wybor1.setFocusPainted(false);
        przyciskWyboru.add(wybor1);

        wybor2 = new JButton("Mati");
        wybor2.setBackground(Color.BLACK);
        wybor2.setForeground(Color.WHITE);
        wybor2.setFont(czionkaPrzyciskow);
        wybor2.addActionListener(itPk2);
        wybor2.setActionCommand("w2");
        wybor2.setFocusPainted(false);
        przyciskWyboru.add(wybor2);

        wybor3 = new JButton("Tomasz");
        wybor3.setBackground(Color.BLACK);
        wybor3.setForeground(Color.WHITE);
        wybor3.setFont(czionkaPrzyciskow);
        wybor3.addActionListener(itPk2);
        wybor3.setActionCommand("w3");
        wybor3.setFocusPainted(false);
        przyciskWyboru.add(wybor3);

        wybor4 = new JButton("Adek");
        wybor4.setBackground(Color.BLACK);
        wybor4.setForeground(Color.WHITE);
        wybor4.setFont(czionkaPrzyciskow);
        wybor4.addActionListener(itPk2);
        wybor4.setActionCommand("w4");
        wybor4.setFocusPainted(false);
        przyciskWyboru.add(wybor4);

        BufferedImage img = ImageIO.read(new File("D:\\Programowanie\\ProjektJAVA\\Zul2.png"));
        ImageIcon icon = new ImageIcon(img);
        panelPostaci = new JPanel();
        postacimg1 = new JLabel();
        postacimg1.setIcon(icon);
        panelPostaci.add(postacimg1);
        panelPostaci.setBackground(Color.BLACK);
        panelPostaci.setBounds(120,202,100,100);
        con.add(panelPostaci);

        BufferedImage img2 = ImageIO.read(new File("D:\\Programowanie\\ProjektJAVA\\Zul1.png"));
        ImageIcon icon2 = new ImageIcon(img2);
        panelPostaci = new JPanel();
        postacimg2 = new JLabel();
        postacimg2.setIcon(icon2);
        panelPostaci.add(postacimg2);
        panelPostaci.setBackground(Color.black);
        panelPostaci.setBounds(280,200,100,100);
        con.add(panelPostaci);

        BufferedImage img3 = ImageIO.read(new File("D:\\Programowanie\\ProjektJAVA\\Zul31.png"));
        ImageIcon icon3 = new ImageIcon(img3);
        panelPostaci = new JPanel();
        postacimg3 = new JLabel();
        postacimg3.setIcon(icon3);
        panelPostaci.add(postacimg3);
        panelPostaci.setBackground(Color.black);
        panelPostaci.setBounds(420,218,100,85);
        con.add(panelPostaci);

        BufferedImage img4 = ImageIO.read(new File("D:\\Programowanie\\ProjektJAVA\\Zul4.png"));
        ImageIcon icon4 = new ImageIcon(img4);
        panelPostaci = new JPanel();
        postacimg4 = new JLabel();
        postacimg4.setIcon(icon4);
        panelPostaci.add(postacimg4);
        panelPostaci.setBackground(Color.black);
        panelPostaci.setBounds(580,215,100,88);
        con.add(panelPostaci);

        panelStaty = new JPanel();
        panelStaty.setBounds(100,310,600,40);
        panelStaty.setBackground(Color.BLACK);
        panelStaty.setLayout(new GridLayout(1,6));
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(czionkaPrzyciskow);
        hpLabel.setForeground(Color.WHITE);
        panelStaty.add(hpLabel);
        hpLabelIle = new JLabel();
        hpLabelIle.setFont(czionkaPrzyciskow);
        hpLabelIle.setForeground(Color.WHITE);
        panelStaty.add(hpLabelIle);
        kasaLabel = new JLabel("Kasa: ");
        kasaLabel.setFont(czionkaPrzyciskow);
        kasaLabel.setForeground(Color.WHITE);
        panelStaty.add(kasaLabel);
        kasaLabelIle = new JLabel();
        kasaLabelIle.setFont(czionkaPrzyciskow);
        kasaLabelIle.setForeground(Color.WHITE);
        panelStaty.add(kasaLabelIle);
        przedmiotLabel = new JLabel("Ręka: ");
        przedmiotLabel.setFont(czionkaPrzyciskow);
        przedmiotLabel.setForeground(Color.WHITE);
        panelStaty.add(przedmiotLabel);
        przedmiotLabelJaki = new JLabel();
        przedmiotLabelJaki.setFont(czionkaPrzyciskow);
        przedmiotLabelJaki.setForeground(Color.WHITE);
        panelStaty.add(przedmiotLabelJaki);

    }
    public void setupPostaci(){
        hp = 50;
        hpLabelIle.setText(hp + "");
        przedmiot = "butelka";
        przedmiotLabelJaki.setText(przedmiot);
        kasa = 5;
        kasaLabelIle.setText(kasa + "zł");
    }
    public void wyborSzymus(){
        pozycja = "wyborSzymus"; // dajemy programowi wiedziec gdzie aktualnie sie znajdujemy
        con.add(panelStaty);
        setupPostaci();
        postacimg1.setVisible(false);
        postacimg2.setVisible(false);
        postacimg3.setVisible(false);
        postacimg4.setVisible(false);
        panelPostaci.setVisible(false);
        panelGlownyTekst.setBounds(100, 100, 600, 200);
        przyciskWyboru.setLayout(new GridLayout(4,1));
        przyciskWyboru.setBounds(100, 350,600,200);
        obszarGlownegoTekstu.setText("Wybrałeś SZYMUŚ. Twój przedmiot startowy \nto butelka po piwie. \nMożesz ją zwrócić do monopolowego.");
        wybor1.setText("Zwróć butelkę do monopolowego.");
        wybor2.setText("Wymień się nią z innym dykciarzem.");
        wybor3.setText("Ukryj butelke i idź szlajać się po mieście.");
        wybor4.setText(" ");
    }

    public void wyborMati(){
        pozycja = "wyborMati";
        con.add(panelStaty);
        setupPostaci();
        postacimg1.setVisible(false);
        postacimg2.setVisible(false);
        postacimg3.setVisible(false);
        postacimg4.setVisible(false);
        panelPostaci.setVisible(false);
        panelGlownyTekst.setBounds(100, 100, 600, 200);
        przyciskWyboru.setLayout(new GridLayout(4,1));
        przyciskWyboru.setBounds(100, 350,600,200);
        obszarGlownegoTekstu.setText("Wybrałeś MATI. Twój przedmiot startowy \nto butelka po piwie. \nMożesz ją zwrócić do monopolowego.");
        wybor1.setText("Zwróc butelkę do monopolowego.");
        wybor2.setText("Wymień się nią z innym dykciarzem.");
        wybor3.setText("Ukryj butelke i idź szlajać się po mieście.");
        wybor4.setText(" ");
    }

    public void wyborTomasz(){
        pozycja = "wyborTomasz";
        con.add(panelStaty);
        setupPostaci();
        postacimg1.setVisible(false);
        postacimg2.setVisible(false);
        postacimg3.setVisible(false);
        postacimg4.setVisible(false);
        panelPostaci.setVisible(false);
        panelGlownyTekst.setBounds(100, 100, 600, 200);
        przyciskWyboru.setLayout(new GridLayout(4,1));
        przyciskWyboru.setBounds(100, 350,600,200);
        obszarGlownegoTekstu.setText("Wybrałeś TOMASZ. Twój przedmiot startowy \nto butelka po piwie. \nMożesz ją zwrócić do monopolowego.");
        wybor1.setText("Zwróc butelkę do monopolowego.");
        wybor2.setText("Wymień się nią z innym dykciarzem.");
        wybor3.setText("Ukryj butelke i idź szlajać się po mieście.");
        wybor4.setText(" ");
    }

    public void wyborAdek(){
        pozycja = "wyborAdek";
        con.add(panelStaty);
        setupPostaci();
        postacimg1.setVisible(false);
        postacimg2.setVisible(false);
        postacimg3.setVisible(false);
        postacimg4.setVisible(false);
        panelPostaci.setVisible(false);
        panelGlownyTekst.setBounds(100, 100, 600, 200);
        przyciskWyboru.setLayout(new GridLayout(4,1));
        przyciskWyboru.setBounds(100, 350,600,200);
        obszarGlownegoTekstu.setText("Wybrałeś ADEK. Twój przedmiot startowy \nto butelka po piwie. \nMożesz ją zwrócić do monopolowego.");
        wybor1.setText("Zwróc butelkę do monopolowego.");
        wybor2.setText("Wymień się nią z innym dykciarzem.");
        wybor3.setText("Ukryj butelke i idź szlajać się po mieście.");
        wybor4.setText(" ");
    }

    public void zwrotButelki(){
        pozycja = "zwrotButelki";
        obszarGlownegoTekstu.setText("Sprzedawca: Panie złoty, \n1 zł za tą butelke to jedyne co mogę zaoferować!");
        wybor1.setText("Zaakceptuj ofertę.");
        wybor2.setText("Odrzuć ofertę.");
        wybor3.setText("Ukradnij butelkę i zabierz pieniądze.");
        wybor4.setText("Idź do króla żebraków.");

    }

    public void akceptacja(){
        pozycja = "akceptacja";
        obszarGlownegoTekstu.setText("Sprzedawca: Dziękuję, życzę miłego wieczorku! \nOtrzymałeś 1zł!");
        if(przedmiot != "łańcuch"){
            przedmiot = "-";
        }
        else if(przedmiot == "łańcuch"){
            przedmiot = "łańcuch";
        }
        przedmiotLabelJaki.setText(przedmiot);
        kasa = kasa + 1;
        kasaLabelIle.setText(kasa+"zł");
        wybor1.setText("Zakup alkohol od innego dykciarza.");
        wybor2.setText("Ukradnij alkohol ze sklepu.");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void odrzucenie(){
        pozycja = "odrzucenie";
        obszarGlownegoTekstu.setText("Sprzedawca: No takiej ceny \nnie znajdzie Pan nigdzie!");
        wybor1.setText("Zaakceptuj ofertę.");
        wybor2.setText("Zakup alkohol od dykciarzy.");
        wybor3.setText("Weź butelkę i zabierz pieniądze.");
        wybor4.setText("");
    }
    public void kradziez(){
        pozycja = "kradziez";
        int obrazeniaSprzedawcy;
        obrazeniaSprzedawcy = new java.util.Random().nextInt(5);
        obszarGlownegoTekstu.setText("Sprzedawca: Co Pan oszalał??!! Już nigdy więcej  tu mam Pana nie widzieć! \nZostałeś złapany podczas kradzieży" +
                "\nSprzedawca wypchnął cię za drzwi \ni zadał: "+ obrazeniaSprzedawcy + " obrażeń!");
        hp = hp - obrazeniaSprzedawcy;
        hpLabelIle.setText(hp+"");
        wybor1.setText("Zakup alkohol od innego dykciarza.");
        wybor2.setText("");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void wymianaButelki(){
        pozycja = "wymianaButelki";
        int obrazeniaLaczek;
        obrazeniaLaczek = new java.util.Random().nextInt(15);
        obszarGlownegoTekstu.setText("Inny żul: Cooo?? Myślisz że ja mam czym się \nwymienić?! Poszedł stąd! \nOtrzymałeś kopniaka z laczka: "+obrazeniaLaczek+"obrażeń");
        hp = hp - obrazeniaLaczek;
        hpLabelIle.setText(hp+"");
        wybor1.setText("Zwróć butelkę do monopolowego.");
        wybor2.setText("Idź szlajać się po mieście.");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void ukrycieButelki(){
        pozycja = "ukrycieButelki";
        przedmiotLabelJaki.setText("-");
        przedmiot = "-";
        if(hpPsów>1) {
            obszarGlownegoTekstu.setText("Robi się ciemno. \nNapada Cię zgraja psów. HP psów: " + hpPsów + "\nCo robisz?");
            wybor1.setText("Walcz.");
            wybor2.setText("Uciekaj.");
            wybor3.setText("");
            wybor4.setText("");
        }
        else{
            pozycja = "psyDrugiRaz";
            obszarGlownegoTekstu.setText("Pokonałeś już psy!");

            wybor1.setText("Wróć do monopolowego.");
            wybor2.setText("");
            wybor3.setText("");
            wybor4.setText("");
        }
    }
    public void ucieczka(){
        pozycja = "ucieczka";
        obszarGlownegoTekstu.setText("Uciekasz. \nWracasz pod most gdzie ukryłeś butelkę.");
        wybor1.setText("Zaatakuj psy jeszcze raz.");
        wybor2.setText("Idź do monopolowego.");
        wybor3.setText("");
        wybor4.setText("");

    }
    public void walkaPostaci(){
        pozycja = "walkaPostaci";
        int obrazeniaPostaci = 0;

        if(przedmiot.equals("butelka")){
            obrazeniaPostaci = new java.util.Random().nextInt(30); // randomowe obrazenia
        }
        else if(przedmiot.equals("-")){
            obrazeniaPostaci = new java.util.Random().nextInt(20);
        }
            hpPsów = hpPsów - obrazeniaPostaci;
            obszarGlownegoTekstu.setText("Zaatakowaleś zadając " + obrazeniaPostaci + " obrażeń! Hp psów: " + hpPsów);

            wybor1.setText(">");
            wybor2.setText("Uciekaj.");
            wybor3.setText("");
            wybor4.setText("");

    }
    public void walkaAI(){
        pozycja = "walkaAI";
        int obrazeniaAI;
        obrazeniaAI = new java.util.Random().nextInt(15);
        hp = hp - obrazeniaAI;
        obszarGlownegoTekstu.setText("Psy zaatakowały za " + obrazeniaAI + " obrażeń!");
        hpLabelIle.setText(hp+"");
        wybor1.setText("Walcz");
        wybor2.setText("Uciekaj.");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void walkaBoss(){
        pozycja = "walkaBoss";
        int obrazeniaBoss;
        obrazeniaBoss = new java.util.Random().nextInt(25);
        hp = hp - obrazeniaBoss;
        hpLabelIle.setText(hp+"");
        obszarGlownegoTekstu.setText("Król żebraków: haha! To ja jestem królem tego rewiru!\nUciekaj z mojej ziemii! \n" +
                "Król żebraków zaatakował za " + obrazeniaBoss + " obrażeń!");
        wybor1.setText("Walcz");
        wybor2.setText("");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void walkaPostaciBoss(){
        pozycja = "walkaPostaciBoss";
        int obrazeniaPostaci=0;

        if(przedmiot.equals("butelka")){
            obrazeniaPostaci = new java.util.Random().nextInt(20); // randomowe obrazenia
        }
        else if(przedmiot.equals("-")){
            obrazeniaPostaci = new java.util.Random().nextInt(15);
        }
        else if(przedmiot.equals("łańcuch")){
            obrazeniaPostaci = new java.util.Random().nextInt(30);
        }
        hpBoss = hpBoss - obrazeniaPostaci;
        obszarGlownegoTekstu.setText("Zaatakowaleś zadając " + obrazeniaPostaci + " obrażeń! Hp bossa: " +hpBoss);

        wybor1.setText(">");
        wybor2.setText("");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void porazka(){
        pozycja = "porazka";
        obszarGlownegoTekstu.setText("Zostałeś stracony.\n KONIEC GRY.");
        wybor1.setText("");
        wybor2.setText("");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void wygranaPsy(){
        pozycja = "wygranaPsy";
        obszarGlownegoTekstu.setText("Wygrałeś. \nPsy uciekły, zdobyłeś łańcuch po jednym z nich.");
        przedmiot = "łańcuch";
        przedmiotLabelJaki.setText("łańcuch");
        wybor1.setText("Wróć po butelkę i udaj się do monopolowego.");
        wybor2.setText("");
        wybor3.setText("");
        wybor4.setText("");
    }
    public void wygranaBoss(){
        pozycja = "wygranaBoss";
        obszarGlownegoTekstu.setText("WYGRAŁEŚ WALKĘ! ZOSTAŁEŚ NOWYM KRÓLEM REWIRU!\n Otrzymujesz kratę piwa!");
        przedmiot = "krata piwa";
        przedmiotLabelJaki.setText(przedmiot);
        wybor1.setText("THE END");
        wybor2.setText("");
        wybor3.setText("");
        wybor4.setText("");
    }
}

