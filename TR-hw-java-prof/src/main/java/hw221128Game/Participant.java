package hw221128Game;

import hw221128Game.enums.LeagueLevel;
import hw221128Game.enums.LeagueType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Participant implements Comparable<Participant> {
    private UUID id;
    private String name;
    private int age;
    private LeagueType leagueType;
    private LeagueLevel leagueLevel;
    private int score;
    private int allGame;
    private int allScore;

    public Participant(UUID id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        score = 0;
        allGame = 0;
        allScore = 0;
        leagueLevel = LeagueLevel.WAITING;
    }

    public void addScore(int d) {
        score = this.getScore() + d;
    }

    public void addAllScore(int d) {
        allScore = this.getAllScore() + d;
    }

    public void addAllGame(int d) {
        allGame = this.getAllGame() + d;
    }

    @Override
    public int compareTo(Participant p) {
//        int res = this.getLeagueType().toString().compareTo(p.getLeagueType().toString());
//        if (res == 0) {
//            res = this.leagueLevel.toString().compareTo(p.getLeagueLevel().toString());
//            if (res == 0) res = p.getScore() - this.getScore();
//        }

        int res = this.getName().compareTo(p.getName());
        return res;
    }
}
