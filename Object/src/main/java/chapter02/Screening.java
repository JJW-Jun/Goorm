//package chapter02;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//public class Screening {
//    private Movie movie;
//    private int sequence;
//    private LocalDateTime whenScreened;
//
//    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
//        this.movie = movie;
//        this.sequence = sequence;
//        this.whenScreened = whenScreened;
//    }
//
//    public LocalDate getStartTime() {
//        return whenScreened;
//    }
//
//    public boolean isSequence(int sequence) {
//        return this.sequence == sequence;
//    }
//
//    public Money getMovieFee() {
//        return movie.getFee();
//    }
//
//    public Reservation reservce(Customer customer, int audienceCount) {
//        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
//    }
//
//    public boolean isSeqeunce(int sequence) {
//        return false;
//    }
//}
