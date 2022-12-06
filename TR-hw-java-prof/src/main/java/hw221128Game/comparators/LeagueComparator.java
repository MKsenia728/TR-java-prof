package hw221128Game.comparators;

import hw221128Game.Participant;

import java.util.Comparator;
import java.util.Properties;

public class LeagueComparator implements Comparator<Participant> {

    @Override
    public int compare(Participant o1, Participant o2) {
        int res = o1.getLeagueType().toString().compareTo(o2.getLeagueType().toString());
        if (res == 0) {
            res = o1.getLeagueLevel().toString().compareTo(o2.getLeagueLevel().toString());
            if (res == 0) res = o1.getAllScore() - o2.getAllScore();
        }
        return res;
    }
}
