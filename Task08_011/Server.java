package classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Server {
    final int PORT = 3456;
    private boolean ready;
    public ArrayList<String> players;
    private ArrayList<Connection> connections;
    public ArrayList<Card> deck;
    public int chestCount;
    public String currentLog;
    public int turnId;
    public ArrayList<PlayerGUI> pg;
    static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");


    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public Server() throws IOException {
    }

    public void go() throws IOException {
        pg = new ArrayList<>();
        turnId=0;
        chestCount = 0;
        currentLog = "";
        deck = fillDeck();
        players = new ArrayList<>();
        connections = new ArrayList<>();
        ServerSocket s1 = (ServerSocket) ac.getBean("serverSocket");//Spring
        System.out.println("classes.Server activated!");
        int i = 0;
        ready = false;
        while (i <= 2) {
                Socket client = s1.accept();
                System.out.println("Connected");
                connections.add(new Connection(this, client, i));
                i++;
        }

    }

    public Card getCard(){
        System.out.println("give card");
        Random r = new Random();
        int i = r.nextInt(deck.size());
        Card lcard = deck.get(i);
        Card ncard = new Card(lcard.getDeg(),lcard.getSuit());
        deck.remove(i);
        return ncard;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Connection> connections) {
        this.connections = connections;
    }

    public static void main(String[] args) throws IOException {
        Server server = (Server) ac.getBean("server");//Spring
        server.go();

        server.getCard();
    }

    private ArrayList<Card> fillDeck(){
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<String> degs = new ArrayList<>();
        ArrayList<String> suits = new ArrayList<>();

        for (int i = 6; i <= 10;i++){
            degs.add(String.valueOf(i));
        }
        degs.add("V");
        degs.add("D");
        degs.add("K");
        degs.add("T");

        suits.add("byb");
        suits.add("ch");
        suits.add("pik");
        suits.add("kr");

        for (String deg : degs){
            for (String suit : suits){
                deck.add(new Card(deg,suit));
            }
        }

        return deck;
    }

    public void addChest(){
        chestCount++;
    }

    public void nextTurn(){
        if (turnId < connections.size()-1){
            turnId++;
        }else{
            turnId=0;
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
