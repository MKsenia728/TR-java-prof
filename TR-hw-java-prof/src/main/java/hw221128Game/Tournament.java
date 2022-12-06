package hw221128Game;

import hw221128Game.comparators.LeagueComparator;
import hw221128Game.comparators.ScoreComparator;
import hw221128Game.enums.LeagueLevel;
import hw221128Game.enums.LeagueType;
import hw221128Game.enums.TournamentType;
import lombok.Getter;

import java.time.LocalDate;

import java.util.*;

@Getter
public class Tournament {

    private final int numberTournament;
    private final TournamentType tournamentType;
    private final LocalDate date;
    private final LeagueType leagueType;


    private final int countQualifyingGame = 25;
    private final int countBaseGame = 25;
    private final int numberParticipantInLeague = 26;

    private List<Participant> levelList = new LinkedList<>();

    private final List<Participant> listLeader = new LinkedList<>();
    private final List<Participant> listLoser = new LinkedList<>();

    public Tournament(int numberTournament, TournamentType tournamentType, LocalDate date, LeagueType leagueType) {
        this.numberTournament = numberTournament;
        this.tournamentType = tournamentType;
        this.date = date;
        this.leagueType = leagueType;
    }

    public void tournament(List<Participant> list) throws Exception {
        switch (tournamentType) {
            case QUALIFICATION -> {
                if (list.size() > numberParticipantInLeague * 3) {
                    gameLeague(list, countQualifyingGame);/* квалификационная игра */
                    definitionLeagueLevel(list);
                    System.out.println("Tournament " + numberTournament + " from " + date);
                    System.out.println("Table of results of the qualifying game in the league " + this.leagueType);
                    printResult(list);
                    clearAndSaveResults(list);
                }
            }
            case BASE -> {
                playInLevel(list, LeagueLevel.FIRST);
                playInLevel(list, LeagueLevel.HIGHER);
//                playInLevel(list, LeagueLevel.FIRST);
                playInLevel(list, LeagueLevel.SECOND);
                System.out.println("League " + leagueType + " leaders in each level");
                printResult(listLeader);
                System.out.println("League " + leagueType + " losers in each level");
                printResult(listLoser);
                moveToAnotherLeague(list);
                clearAndSaveResults(list);
            }
//            case PREMIUM -> {
////                gameLeague(list, list.size());
//                System.out.println("not implemented");
//            }
        }
    }

    /*
      На вход список по типу лиги (Дети, молодые, взрослые) делаем списки по уровням (высшая, 1,2)
     */
    private List<Participant> makeLevelList(List<Participant> list, LeagueLevel leagueLevel) {
        List<Participant> levelList = new LinkedList<>();
        for (Participant p : list) {
            if (p.getLeagueLevel().equals(leagueLevel)) levelList.add(p);
        }
        return levelList;
    }

    /*
    Все этапы турнира по каждому уровню лиги
     */

    private void playInLevel(List<Participant> list, LeagueLevel leagueLevel) throws Exception {
        levelList = makeLevelList(list, leagueLevel);
        gameLeague(levelList, countBaseGame);
        saveLeagueLeadersAndLosers(levelList);
        System.out.println("Table of results of the tournament №" + numberTournament + " in the league " + leagueType + "-" + leagueLevel);
        printResult(levelList);
        levelList.clear();
    }

    private void printResult(List<Participant> list) {
        Collections.sort(list);
        for (Participant p : list) {
            System.out.printf("League: %-8s - %-10s name: %-15s age: %-7d score: %-5d total number of game: %-5d%n", p.getLeagueType(), p.getLeagueLevel(), p.getName(), p.getAge(), p.getScore(), p.getAllGame());
        }
        System.out.println("******************************************************************************************************");
    }

    /*
    Определение уровня лиги после квалификационной игры
     */
    private void definitionLeagueLevel(List<Participant> list) {
        list.sort(new ScoreComparator());
        ListIterator<Participant> listIterator = list.listIterator();
        while (listIterator.nextIndex() < numberParticipantInLeague) {
            listIterator.next().setLeagueLevel(LeagueLevel.HIGHER);
        }
        while ((listIterator.nextIndex()) < numberParticipantInLeague * 2) {
            listIterator.next().setLeagueLevel(LeagueLevel.FIRST);
        }
        while ((listIterator.nextIndex()) < numberParticipantInLeague * 3) {
            listIterator.next().setLeagueLevel(LeagueLevel.SECOND);
        }
    }

    private void saveLeagueLeadersAndLosers(List<Participant> list) {
        Collections.sort(list);
        list.sort(new LeagueComparator());
        for (int i = 0; i < 3; i++) {
            listLeader.add(levelList.get(i));
        }
        for (int i = list.size() - 1; i > list.size() - 4; i--) {
            listLoser.add(levelList.get(i));
        }
        listLeader.sort(new LeagueComparator());
        listLoser.sort(new LeagueComparator());
    }

    /*
    смена уровня лиги у 3 лидеров и 3 лузеров в каждой лиге, из высшей перервод в премиум - общая для всех типов,
    из низшей второй в лист ожидания, а новые из листа добавляются
     */
    private void moveToAnotherLeague(List<Participant> list) {
        for (Participant p : listLoser) {
            if (p.getLeagueLevel().equals(LeagueLevel.HIGHER)) p.setLeagueLevel(LeagueLevel.FIRST);
            else if (p.getLeagueLevel().equals(LeagueLevel.FIRST)) p.setLeagueLevel(LeagueLevel.SECOND);
            else if (p.getLeagueLevel().equals(LeagueLevel.SECOND)) p.setLeagueLevel(LeagueLevel.WAITING);
        }
        for (Participant p : listLeader) {
//            if (p.getLeagueLevel().equals(LeagueLevel.HIGHER)) p.setLeagueLevel(LeagueLevel.HIGHER);
            if (p.getLeagueLevel().equals(LeagueLevel.FIRST)) p.setLeagueLevel(LeagueLevel.HIGHER);
            else if (p.getLeagueLevel().equals(LeagueLevel.SECOND)) p.setLeagueLevel(LeagueLevel.FIRST);
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < 4 && j > 0) {
            if (list.get(j).getLeagueLevel().equals(LeagueLevel.WAITING)) {
                list.get(j).setLeagueLevel(LeagueLevel.SECOND);
                i++;
            }
            j--;
        }
    }

    /*
    Перенос счета из текущего в общий, обнуление текущего
     */
    private void clearAndSaveResults(List<Participant> list) {
        for (Participant p : list) {
            p.addAllScore(p.getScore());
            p.setScore(0);
        }
    }

    //    Функция для проведения игры в лиге, если в лиге играет более игроков,
//    чем нужно провести игр, для равномерного распределения игр берется количество,
//    кратное количеству игр (игр 25, игроков 80, берутся первые 75), остальные
//    остаются в листе ожидания (лига Waiting),
//    такое возможно при проведении квалификационной игры
    private void gameLeague(List<Participant> list, int countGame) throws Exception {
        int size;
        if (list.size() == numberParticipantInLeague || list.size() > countGame) size = numberParticipantInLeague;
        else throw new Exception("not enough players in the league");
        int countStage = 0;
        while (countStage < list.size() / numberParticipantInLeague) {
            for (int i = countStage * numberParticipantInLeague; i < (size) * (countStage + 1); i++) {
                for (int j = i + 1; j < size * (countStage + 1); j++) {
                    playGame(list.get(i), list.get(j));
                }
            }
            countStage++;
        }
    }

    private void playGame(Participant p1, Participant p2) {
        Random random = new Random();
        int i = random.nextInt(2);
        p1.addAllGame(1);
        p2.addAllGame(1);
        if (i == 0) p1.addScore(1);
        else p2.addScore(1);

    }

}
