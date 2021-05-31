package jpql.item;

public class BadCode {
    public static void main(String args[]) {
    }

    public String findSubwayLine(String station) {
        if (station.equals("신림")) {
            return "3호선";
        } else if (station.equals("대방")) {
            return "4호선";
        }
        return "";
    }
}
