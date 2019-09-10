package test_9_10;

import java.util.*;

class Card{
    //值
    public int value;      //rank
    public String color;  //suit
    public Card(int value,String color){
        this.value = value;
        this.color = color;
    }
    @Override
    public String toString() {
        return String.format("[%s %d]",color,value);
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Card)){
            return false;
        }
        //需要向下转型
        Card o = (Card)obj;
        if(o.value == this.value && o.color == this.color){
            return true;
        }
        return false;
    }
}
public class Main {
    /**
     * 实现有一个简单的扑克牌
     * 1.买一副扑克牌
     * 2.洗牌
     * 3.三个玩家，每个玩家抓5张牌（每个人抓一张）
     * 4.问黑桃A在谁手里谁就赢了
     *
     */
    private static final String[] COLORS = {"♥","♠","♣","♦"};
    //买牌
    static List<Card> buyDeck(){
        List<Card> deck = new ArrayList<>(52);
        for (int i = 0; i < 4; i++) {
            String color = COLORS[i];
            for (int j = 1; j <= 13; j++) {
                int value = j;
                Card card = new Card(value,color);
                deck.add(card);
            }
        }
        return deck;
    }


    //换牌
    private static void swap(List<Card> deck,int i,int r){
        Card temp = null;
        temp = deck.get(i);
        deck.set(i,deck.get(r));
        deck.set(r,temp);
    }
    //洗牌
    private static void shuffle(List<Card> deck){
        Random random = new Random();
        for(int i = deck.size() - 1;i > 0;i--){
            int r = random.nextInt(i);
            swap(deck,i,r);
        }
    }

    //抓牌
    private static void send(List<List<Card>> hands,List<Card> deck,int numCard,int numPerson){
        //因为有三个人，所以添加3个元素，相当于3个人，每个人手中有一个链表，这个链表就是牌
        //这里先添加空的链表，后面需要调用(有几个人就添加几个)
        for (int i = 0; i < numPerson; i++) {
            hands.add(new ArrayList<>());
        }
        for (int i = 0; i < numCard; i++) {
            for (int j = 0; j < numPerson; j++) {
                //抓牌
                Card card = deck.remove(0);
                hands.get(i).add(card);
            }
        }
    }
    public static void main(String[] args) {
        List<Card> deck = Main.buyDeck();
        System.out.println("一副新牌：");
        System.out.println(deck);
        System.out.println("洗牌后：");
        shuffle(deck);
        System.out.println(deck);
        System.out.println("抓牌（3个人抓，每人5张）");
        List<List<Card>> hands = new ArrayList<>(3);
        send(hands,deck,3,5);
        System.out.println("第一个人手中的牌"+hands.get(0));
        System.out.println("第二个人手中的牌"+hands.get(1));
        System.out.println("第三个人手中的牌"+hands.get(2));
        play(hands);
    }


    private static void play(List<List<Card>> hands) {
        Card card = new Card(1,"♠");
        for (int i = 0; i < hands.size(); i++) {
            for (int j = 0; j < hands.get(i).size(); j++) {
                //引用比较相等时不能直接用等于号
                if(card.equals(hands.get(i).get(j))){
                    System.out.println("%d号选手输了"+i);
                    return;
                }
            }
        }
    }
}
