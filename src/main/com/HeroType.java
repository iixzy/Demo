package main.com;

/**
 * LOL英雄职业
 */
public enum HeroType {
    TANK,WIZARD,ASSASSIN,ASSIST,WARRIOR,
    RANGED,PUSH,FARMING;

    public static void main(String[] args) {
        for (HeroType e : HeroType.values()) {
            System.out.println(e);
        }

    }

}
