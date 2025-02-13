public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        double n = Math.random();
        if (n < 0.5) {
            opponent.hitPoints -= 10;
        }
        else {
            hitPoints -= 10;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (hitPoints > 0 && opponent.getHitPoints() > 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        hitPoints = 100;
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int heroWins = 0;
        int oppWins = 0;
        for (int i = 0; i < n; i++) {
            hitPoints = 100;
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);
            if (hitPoints > 0) {
                heroWins++;
            }
            else {
                oppWins++;
            }
        }
        return new int[]{heroWins, oppWins};
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);
        String result = name + ": " + wins[0] + " wins \n" + opponent.getName() + ": " + wins[1] + " wins \n";

        if (wins[0] == wins[1]) {
            result += "OMG! It was actually a draw!";
        }
        else if (wins[0] > wins[1]) {
            result += name + " wins!";
        }
        else {
            result += opponent.getName() + " wins!";
        }

        return result;
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        hitPoints = 100;
        opponent.senzuBean();
        while (hitPoints > 0 && opponent.getHitPoints() > 0) {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
        }
    }
}
