package com.anish.screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import javax.swing.JFrame;

import com.anish.calabashbros.BubbleSorter;
import com.anish.calabashbros.Calabash;
import com.anish.calabashbros.World;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

public class Main extends JFrame implements KeyListener {

    private AsciiPanel terminal;
    private Screen screen;

    Calabash[] bros ;
    World w;
    String[] sortSteps;

    public Main() {
        super();
        terminal = new AsciiPanel(World.WIDTH, World.HEIGHT, AsciiFont.TALRYTH_15_15);
        add(terminal);
        pack();
        w = new World();

        bros = new Calabash[7];

        bros[3] = new Calabash(new Color(204, 0, 0), 1, w);
        bros[5] = new Calabash(new Color(255, 165, 0), 2, w);
        bros[1] = new Calabash(new Color(252, 233, 79), 3, w);
        bros[0] = new Calabash(new Color(78, 154, 6), 4, w);
        bros[4] = new Calabash(new Color(50, 175, 255), 5, w);
        bros[6] = new Calabash(new Color(114, 159, 207), 6, w);
        bros[2] = new Calabash(new Color(173, 127, 168), 7, w);

        w.put(bros[0], 10, 10);
        w.put(bros[1], 12, 10);
        w.put(bros[2], 14, 10);
        w.put(bros[3], 16, 10);
        w.put(bros[4], 18, 10);
        w.put(bros[5], 20, 10);
        w.put(bros[6], 22, 10);

        screen = new WorldScreen(w);
        addKeyListener(this);
        repaint();

        BubbleSorter<Calabash> b = new BubbleSorter<>();
        b.load(bros);
        b.sort();

        sortSteps = this.parsePlan(b.getPlan());

        
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(Calabash[] bros, String step) {
        String[] couple = step.split("<->");
        getBroByRank(bros, Integer.parseInt(couple[0])).swap(getBroByRank(bros, Integer.parseInt(couple[1])));
    }

    private Calabash getBroByRank(Calabash[] bros, int rank) {
        for (Calabash bro : bros) {
            if (bro.getRank() == rank) {
                return bro;
            }
        }
        return null;
    }

    @Override
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    int i =0;

    @Override
    public void keyPressed(KeyEvent e) {

       
            this.execute(bros, sortSteps[i]);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            this.repaint();

        


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}
