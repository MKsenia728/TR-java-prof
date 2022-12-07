package hw221128Game;

import hw221128Game.GeneratorParticipant.Generator;
import hw221128Game.comparators.ScoreAllComparator;
import hw221128Game.createListParticipant.ListParticipant;
import hw221128Game.enums.LeagueType;
import hw221128Game.enums.TournamentType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.*;

@Getter
public class OrganisationTournament {
    private final List<Tournament> listTournament = new ArrayList<>();
    private final Set<Participant> leadersTournament = new TreeSet<>();
    private final Set<Participant> losersTournament = new TreeSet<>();

    public void makeTournaments() throws Exception {
        createTournaments();
        playStageTournament();
        printPlayerChangeLeague();
        determineBestResults(LeagueType.CHILDREN);
        determineBestResults(LeagueType.YOUTH);
        determineBestResults(LeagueType.ADULT);
        makeParticipantMap();
        makeLeaderMap(80);
    }

    private void createTournaments() {
        Generator generator = new Generator();
        generator.generator();

        listTournament.add(new Tournament(1, TournamentType.QUALIFICATION, LocalDate.of(2020, 1, 10), LeagueType.CHILDREN));
        listTournament.add(new Tournament(2, TournamentType.QUALIFICATION, LocalDate.of(2020, 1, 12), LeagueType.YOUTH));
        listTournament.add(new Tournament(3, TournamentType.QUALIFICATION, LocalDate.of(2020, 1, 15), LeagueType.ADULT));

        listTournament.add(new Tournament(4, TournamentType.BASE, LocalDate.of(2020, 2, 5), LeagueType.CHILDREN));
        listTournament.add(new Tournament(5, TournamentType.BASE, LocalDate.of(2020, 2, 8), LeagueType.YOUTH));
        listTournament.add(new Tournament(6, TournamentType.BASE, LocalDate.of(2020, 2, 12), LeagueType.ADULT));

        listTournament.add(new Tournament(7, TournamentType.BASE, LocalDate.of(2020, 3, 4), LeagueType.CHILDREN));
        listTournament.add(new Tournament(8, TournamentType.BASE, LocalDate.of(2020, 3, 6), LeagueType.YOUTH));
        listTournament.add(new Tournament(9, TournamentType.BASE, LocalDate.of(2020, 3, 11), LeagueType.ADULT));

        listTournament.add(new Tournament(10, TournamentType.BASE, LocalDate.of(2020, 4, 10), LeagueType.CHILDREN));
        listTournament.add(new Tournament(11, TournamentType.BASE, LocalDate.of(2020, 4, 14), LeagueType.YOUTH));
        listTournament.add(new Tournament(12, TournamentType.BASE, LocalDate.of(2020, 4, 16), LeagueType.ADULT));

        listTournament.add(new Tournament(13, TournamentType.BASE, LocalDate.of(2020, 5, 12), LeagueType.CHILDREN));
        listTournament.add(new Tournament(14, TournamentType.BASE, LocalDate.of(2020, 5, 15), LeagueType.YOUTH));
        listTournament.add(new Tournament(15, TournamentType.BASE, LocalDate.of(2020, 5, 18), LeagueType.ADULT));

        listTournament.add(new Tournament(16, TournamentType.BASE, LocalDate.of(2020, 6, 6), LeagueType.CHILDREN));
        listTournament.add(new Tournament(17, TournamentType.BASE, LocalDate.of(2020, 6, 11), LeagueType.YOUTH));
        listTournament.add(new Tournament(18, TournamentType.BASE, LocalDate.of(2020, 6, 15), LeagueType.ADULT));
    }

    private void playStageTournament() throws Exception {
        List<Participant> listCh = ListParticipant.getInstance().getLeagueType(LeagueType.CHILDREN);
        List<Participant> listYo = ListParticipant.getInstance().getLeagueType(LeagueType.YOUTH);
        List<Participant> listAd = ListParticipant.getInstance().getLeagueType(LeagueType.ADULT);

        String leagueType;
        for (Tournament t : listTournament) {
            leagueType = t.getLeagueType().toString();
            switch (leagueType) {
                case "CHILDREN" -> t.tournament(listCh);
                case "YOUTH" -> t.tournament(listYo);
                case "ADULT" -> t.tournament(listAd);
            }
        }
    }

    private void makeSetBestPlayer() {
        for (Tournament t : listTournament) {
            leadersTournament.addAll(t.getListLeader());
        }
    }

    private void makeSetWorstPlayer() {
        for (Tournament t : listTournament) {
            losersTournament.addAll(t.getListLoser());
        }
    }

    private void printParticipant(Participant p) {
        System.out.printf("League: %-8s - %-10s name: %-15s age: %-7d score: %-5d total number of game: %-5d%n", p.getLeagueType(), p.getLeagueLevel(), p.getName(), p.getAge(), p.getAllScore(), p.getAllGame());
    }

    private void printPlayerChangeLeague() {
        makeSetBestPlayer();
        System.out.println("These players had a league level increase");
        for (Participant participant : leadersTournament) {
            printParticipant(participant);
        }
        System.out.println("*************************************************************************************************");
        makeSetWorstPlayer();
        System.out.println("These players had a league level decrease");
        for (Participant participant : losersTournament) {
            printParticipant(participant);
        }
    }

    private void determineBestResults(LeagueType leagueType) {
        List<Participant> list = ListParticipant.getInstance().getLeagueType(leagueType);
        list.sort(new ScoreAllComparator());
        System.out.println("The best player in league " + leagueType + " has " + list.get(0).getAllScore() + " ");
        printParticipant(list.get(0));
        System.out.println("_____________________________________________________________");
    }

    private void makeParticipantMap(){
        List<Participant> list = ListParticipant.getInstance().listParticipants;
        Map<LeagueType, List<Participant>> listMap= new HashMap<>();
        for (LeagueType l: LeagueType.values()) {
            listMap.put(l, new ArrayList<>());
        }
        for (Participant p: list) {
            if (listMap.containsKey(p.getLeagueType())) listMap.get(p.getLeagueType()).add(p);
        }
        printMap(listMap, "All participants in MAP");

    }

    private void makeLeaderMap(int minScore) {
        List<Participant> list = ListParticipant.getInstance().listParticipants;
        list.sort(new ScoreAllComparator());
        Map<Integer, List<Participant>> listMap= new HashMap<>();
        for (Participant p: list) {
            if (p.getAllScore() >= minScore) {
                listMap.putIfAbsent(p.getAllScore(), new ArrayList<>());
                listMap.get(p.getAllScore()).add(p);
            }
        }
        printMap(listMap, "Participants whom score is more than " + minScore + " in MAP");
    }
    private <K> void printMap(Map<K, List<Participant>> map, String s) {
        System.out.println(s);
        int i = 0;
        for (Map.Entry<K, List<Participant>> entry: map.entrySet()) {
            for (Participant p: entry.getValue()) {
                System.out.printf("%-5s", ++i);
                printParticipant(p);
            }
        }
    }

}
