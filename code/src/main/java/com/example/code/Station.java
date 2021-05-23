package com.example.code;


import java.util.*;

public enum Station {
    LINE_ONE("1호선", Arrays.asList("신림", "서울대입구", "홍익대", "왕십리")),
    LINE_TWO("2호선", Arrays.asList("대림")),
    EMPTY("없음", Collections.emptyList());

    private final String line;
    private final List<String> stations;

    Station(String line, List<String> stations) {
        this.line = line;
        this.stations = stations;
    }

    public boolean hasStation(String station) {
        return stations.stream().anyMatch(x -> x.equals(station));
    }

    public static Station getLine(String station) {
        Arrays.stream(Station.values()).forEach(System.out::println);
        return Arrays.stream(Station.values())
                .filter(Station -> Station.hasStation(station))
                .findFirst()
                .orElse(EMPTY);
    }

    static List<String> arr = new ArrayList<>();

    public static void main(String args[]) {
        String station = "서울대입구";
        Station subway = Station.getLine(station);
        System.out.println(subway);
        List<String> arr = new ArrayList<>();

        arr.add("d");
        arr.add("a");
        arr.add("c");

        System.out.println(arr.stream().filter(x -> x.equals("a")).findAny());
    }
}
