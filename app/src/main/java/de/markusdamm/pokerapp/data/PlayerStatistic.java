package de.markusdamm.pokerapp.data;

import java.util.ArrayList;

import de.markusdamm.pokerapp.utils.Utils;

/**
 * Created by Markus Damm on 30.03.2015.
 */
public class PlayerStatistic implements Comparable<PlayerStatistic> {

    private int bestPlace;
    private int wins;
    private int participations;
    private int minuits;
    private int beatenPlayers;
    private int participators;
    private int sumOfPlaces;
    private Player player;
    private ArrayList<String> strings;

    private String value1, value2, value3;

    public final static String stBestPlace = "Beste Platzierung";
    public final static String stWins = "Siege";
    public final static String stParticipations = "Anzahl an Teilnahmen";
    public final static String stMinuits = "Gespielte Zeit";
    public final static String stBeatenPlayers = "Anzahl rausgeworfener Spieler";
    public final static String stNumberOfOponents = "Anzahl Gegner";
    public final static String stSumOfPlaces = "Summe der Plätze";
    public final static String stWorsePlayer = "Anzahl schlechtere Spieler bei Teilnahme";
    public final static String stAveragePlace = "Durchschnittliche Platzierung";


    public PlayerStatistic(Player player){
        this.player = player;
        strings = new ArrayList<>();
        fillStrings();
    }

    public int getSumOfPlaces(){
        return sumOfPlaces;
    }

    public int getBestPlace() {
        return bestPlace;
    }

    public int getWins() {
        return wins;
    }

    public int getParticipations() {
        return participations;
    }

    public int getMinuits() {
        return minuits;
    }

    public int getBeatenPlayers() {
        return beatenPlayers;
    }

    public int getParticipators() {
        return participators;
    }

    public Player getPlayer() {
        return player;
    }


    public void setSumOfPlaces(int sumOfPlaces){
        this.sumOfPlaces = sumOfPlaces;
    }

    public void setBestPlace(int bestPlace) {
        this.bestPlace = bestPlace;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setParticipations(int participations) {
        this.participations = participations;
    }

    public void setMinuits(int minuits) {
        this.minuits = minuits;
    }

    public void setBeatenPlayers(int beatenPlayers) {
        this.beatenPlayers = beatenPlayers;
    }

    public void setParticipators(int participators) {
        this.participators = participators;
    }



    public void setValues(String value1, String value2, String value3){
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }



    public ArrayList<String> getStatisticList(){
        ArrayList<String> statisticList = new ArrayList<>();
        statisticList.add(stBestPlace + ": " + bestPlace);
        statisticList.add(stWins + ": " + wins);
        statisticList.add(stParticipations + ": " + participations);
        statisticList.add(stMinuits + ": " + minuits + " Minuten bzw. " + Utils.formatTimeToString(minuits));
        statisticList.add(stBeatenPlayers + ": " + beatenPlayers);
        statisticList.add(stNumberOfOponents + ": " + participators);
        statisticList.add(stSumOfPlaces + ": " + sumOfPlaces);
        statisticList.add(stWorsePlayer + ": " + Integer.toString(participators - sumOfPlaces));
        statisticList.add(stAveragePlace + ": " + ((double)sumOfPlaces) / participations);



        return statisticList;
    }


    public int getValue(String value){
        switch (value){
            case stBestPlace:
                return getBestPlace();
            case stWins:
                return getWins();
            case stMinuits:
                return getMinuits();
            case stBeatenPlayers:
                return getBeatenPlayers();
            case stNumberOfOponents:
                return getParticipators();
            case stSumOfPlaces:
                return getSumOfPlaces();
            case stWorsePlayer:
                return getParticipators() - getSumOfPlaces();
            case stParticipations:
                return getParticipations();
            case stAveragePlace:
                return sumOfPlaces / participations;
            default:
                return -1;
        }
    }


    public void fillStrings(){
        strings.clear();
        strings.add(stBestPlace);
        strings.add(stWins);
        strings.add(stParticipations);
        strings.add(stMinuits);
        strings.add(stBeatenPlayers);
        strings.add(stNumberOfOponents);
        strings.add(stSumOfPlaces);
        strings.add(stWorsePlayer);
        strings.add(stAveragePlace);
    }

    public ArrayList<String> getStrings(){
        return strings;
    }

    @Override
    public int compareTo(PlayerStatistic another) {
        if (value1.equals(stAveragePlace)){
            Double a = ((double)this.getSumOfPlaces())/this.getParticipations();
            Double b = ((double)another.getSumOfPlaces())/another.getParticipations();
            if (a.floatValue() != b.floatValue()){
                return a.compareTo(b);
            }
        }
        else {
            Integer a = this.getValue(value1);
            Integer b = another.getValue(value1);
            if (a.intValue() != b.intValue()) {
                if (value1.equals(stBestPlace) || value1.equals(stSumOfPlaces)) {
                    return a.compareTo(b);
                } else {
                    return b.compareTo(a);
                }
            }
        }

        if (value2.equals(stAveragePlace)){
            Double a = ((double)this.getSumOfPlaces())/this.getParticipations();
            Double b = ((double)another.getSumOfPlaces())/another.getParticipations();
            if (a.floatValue() != b.floatValue()){
                return a.compareTo(b);
            }
        }
        else {
            Integer a = this.getValue(value2);
            Integer b = another.getValue(value2);
            if (a.intValue() != b.intValue()) {
                if (value2.equals(stBestPlace) || value2.equals(stSumOfPlaces)) {
                    return a.compareTo(b);
                } else {
                    return b.compareTo(a);
                }
            }
        }


        if (value3.equals(stAveragePlace)){
            Double a = ((double)this.getSumOfPlaces())/this.getParticipations();
            Double b = ((double)another.getSumOfPlaces())/another.getParticipations();
            if (a.floatValue() != b.floatValue()){
                return a.compareTo(b);
            }
        }
        else {
            Integer a = this.getValue(value3);
            Integer b = another.getValue(value3);
            if (value3.equals(stBestPlace) || value3.equals(stSumOfPlaces)) {
                return a.compareTo(b);
            } else {
                return b.compareTo(a);
            }
        }
        return 0;
    }
}
