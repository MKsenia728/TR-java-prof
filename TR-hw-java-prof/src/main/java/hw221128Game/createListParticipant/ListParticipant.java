package hw221128Game.createListParticipant;

import hw221128Game.Participant;
import hw221128Game.enums.LeagueType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListParticipant {
    public List<Participant> listParticipants;

    static ListParticipant clp = null;

    public static ListParticipant getInstance() {
        if (clp == null)
            clp = new ListParticipant();
        return clp;
    }

    private ListParticipant() {
        listParticipants = new ArrayList<>();
    }

    public void addToList(Participant participant) {
        if (definitionLeague(participant)) listParticipants.add(participant);
    }

    private boolean definitionLeague(Participant participant) {
        boolean isInLeague = true;
        int age = participant.getAge();
        int fromForChildren = 13;
        int toForChildren = 18;
        int toForYouth = 25;
        int toForAdult = 100;
        if (age >= fromForChildren && age < toForChildren) participant.setLeagueType(LeagueType.CHILDREN);
        else if (age >= toForChildren && age < toForYouth) participant.setLeagueType(LeagueType.YOUTH);
        else if (age >= toForYouth && age < toForAdult) participant.setLeagueType(LeagueType.ADULT);
        else isInLeague = false;
        return isInLeague;
    }

    public void printList() {
        for (Participant p : listParticipants
        ) {
            System.out.println(p);
        }
    }

    public List<Participant> getLeagueType(LeagueType league) {
        List<Participant> list = new LinkedList<>();
        for (Participant p : listParticipants) {
            if (p.getLeagueType().equals(league)) list.add(p);
        }
        return list;
    }
}
