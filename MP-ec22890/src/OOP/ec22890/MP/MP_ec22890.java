package OOP.ec22890.MP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MP_ec22890 implements Visitor {
    enum Semaphore{WAITING, PRESSED}
    JFrame frame = new JFrame();
    static JTextArea Main_Text = new JTextArea("Hello!\n");
    JPanel gold_item = new JPanel();
    JTextArea gold = new JTextArea();
    JTextArea current_items = new JTextArea();
    Semaphore acceptSemaphore = Semaphore.WAITING;
    private int purse;
    private Item[] items;
    private int next;
    static Visitable house = new House_ec22890();
    ArrayList<String> questions = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();

    public MP_ec22890() {
        items = new Item[1000];
        frame.add(Main_Text, BorderLayout.CENTER);
        Main_Text.setEditable(true);
        JScrollPane scroll = new JScrollPane(Main_Text);
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        frame.add(scroll);
        Font font = new Font("Segoe Script", Font.BOLD, 10);
        Main_Text.setFont(font);

        frame.add(gold_item, BorderLayout.WEST);
        gold_item.add(gold);
        gold_item.add(current_items);
        gold.setText("Gold: " + purse + "\n");
        current_items.setText("Items: " + "\n");

        frame.setTitle("GUI by ec22890");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        house = what_house();
    }

    public void tell(String m) {
        Main_Text.append(m+"\n");
    }

    public char getChoice(String d, char[] a) {
        final char[] return_variable = {'x'};

        tell(d);

        JPanel panel = new JPanel(new GridLayout(1, a.length));
        panel.setBackground(Color.cyan);
        frame.add(panel, BorderLayout.SOUTH);

        JButton[] all_buttons = new JButton[a.length];
        for(int i = 0; i < all_buttons.length; i++){
            all_buttons[i] = new JButton();
            all_buttons[i].setText(String.valueOf(a[i]));
            all_buttons[i].setBackground(Color.cyan);
            panel.add(all_buttons[i]);
            JButton current = all_buttons[i];
            all_buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    acceptSemaphore = Semaphore.PRESSED;
                    for(int j = 0; j < all_buttons.length; j++){
                        if (current == all_buttons[j]){
                            return_variable[0] = a[j];
                        }
                    }
                }
            });
        }

        frame.revalidate();
        while(acceptSemaphore == Semaphore.WAITING){
            frame.repaint();
        }

        questions.add(d);
        answers.add(String.valueOf(return_variable[0]));

        acceptSemaphore = Semaphore.WAITING;
        frame.getContentPane().remove(panel);
        Main_Text.setText("");

        return return_variable[0];
    }

    public boolean giveItem(Item x) {
        tell("You are being offered: "+x.name);

        if (next >= items.length) {
            tell("But you have no space and must decline.");
            return false;
        }

        if (getChoice("Do you accept (Yes/No)?", new char[]{'y', 'n'}) == 'y') {
            items[next] = x;
            next++;
            current_items.setText("Items: " + "\n");
            for (int i=0;i<next;i++) current_items.append(items[i].name+"\n");
            return true;

        } else return false;
    }

    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++)
            if (x == items[i])
                return true;
        return false;
    }


    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++)
            if (x.equals(items[i]))
                return true;
        return false;
    }


    public void giveGold(int n) {
        tell("You are given "+n+" gold pieces.");
        purse += n;
        tell("You now have "+purse+" pieces of gold.");
        gold.setText("Gold: " + purse + "\n");
    }


    public int takeGold(int n) {
        if (n<0) {
            tell("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            tell("but you didn't fall for it and returned the 'loan'.");
            gold.setText("Gold: " + purse + "\n");
            return 0;
        }

        int t = 0;
        if (n > purse) t = purse;
        else t = n;

        tell(t+" pieces of gold are taken from you.");
        purse -= t;
        tell("You now have "+purse+" pieces of gold.");

        gold.setText("Gold: " + purse + "\n");
        return t;
    }

    public void past_questions(){
        char asked = getChoice("You have finished the mystery house" + "\n" +"Do you which to see your all you answers again?",new char[] {'y', 'n'});
        if (asked == 'y'){
            for(int i = 0; i < answers.size(); i++){
                tell(questions.get(i));
                tell("You answered " + answers.get(i) + "\n" );
            }
        }
    }

    public Visitable what_house(){
        char[] a = {'a', 'b', 'c', 'd', 'e'};
        char choice;
        choice = getChoice("Which house do you wish to enter? \n a) House_ec22890 b) House_ec22621 c) House_ec22626 d) House_ec22837 e) House_ec22473 ", a);
        if (choice == 'a'){
            house = new House_ec22890();
        }
        else if (choice == 'b'){
            house = new House_ec22621();
        }
        else if (choice == 'c'){
            house = new House_ec22626();
        }
        else if (choice == 'd'){
            house = new House_ec22837();
        }
        else if (choice == 'e'){
            house = new House_ec22473();
        }
        return house;
    }

    public static void main(String[] args){
        Visitor v = new MP_ec22890();
        Visitable r = house;
        r.visit(v, Direction.TO_WEST);
        v.past_questions();
        Main_Text.append("You have Successfully escaped the house. \n You can see the gold and items you own. \n You can now exit the window ");
    }
}
