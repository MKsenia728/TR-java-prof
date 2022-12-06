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

}
