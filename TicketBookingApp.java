import java.util.ArrayList;
import java.util.List;

class TicketBookingSystem {
    private final List<String> availableSeats;

    public TicketBookingSystem(int numberOfSeats) {
        availableSeats = new ArrayList<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            availableSeats.add("Seat" + i);
        }
    }

    public synchronized boolean bookSeat(String seat, String customerType) {
        if (availableSeats.contains(seat)) {
            System.out.println(customerType + " booked " + seat);
            availableSeats.remove(seat);
            return true;
        } else {
            System.out.println(seat + " is already booked.");
            return false;
        }
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final String seat;
    private final String customerType;

    public BookingThread(TicketBookingSystem bookingSystem, String seat, String customerType, int priority) {
        this.bookingSystem = bookingSystem;
        this.seat = seat;
        this.customerType = customerType;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(seat, customerType);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(10);

        BookingThread vip1 = new BookingThread(bookingSystem, "Seat1", "VIP", Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(bookingSystem, "Seat2", "VIP", Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(bookingSystem, "Seat1", "Regular", Thread.NORM_PRIORITY);
        BookingThread regular2 = new BookingThread(bookingSystem, "Seat3", "Regular", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }
}
