package hw221128Game.comparators;

import hw221128Game.Participant;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant o1, Participant o2) {
        return o2.getScore() - o1.getScore();
    }
}
