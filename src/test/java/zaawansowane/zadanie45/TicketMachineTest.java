package zaawansowane.zadanie45;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TicketMachineTest {
    @Test
    public void przetestujDzialanieMaszyny(){
        //given, when
        TicketMachine ticketMachine = new TicketMachine("A", 1.5,10);

        //then
        assertEquals("A", ticketMachine.getCecha());
        assertEquals(1.5, ticketMachine.getCena());
        assertEquals(10, ticketMachine.getPapier());

    }
    @Test
    public void przetestujStrefeB(){
        TicketMachine ticketMachine2 = new TicketMachine(1.5,10);

        //then
        assertEquals("C", ticketMachine2.getCecha());
        assertEquals(1.5, ticketMachine2.getCena());
        assertEquals(10, ticketMachine2.getPapier());
    }
    @Test
    public void przetestujbilety(){
        TicketMachine ticketMachine3 = new TicketMachine(1.5,12);

        //then
        assertEquals(3, ticketMachine3.howManyTickets());

    }
    @Test
    public void przetestujpapier(){
        TicketMachine ticketMachine4 = new TicketMachine(1.5,12);
        ticketMachine4.changePaper(15);
        //then
        assertEquals(15,ticketMachine4.getPapier() );

    }
//    @Test
//    public void przetestujZmianeStrefy(){
//        TicketMachine ticketMachine6 = new TicketMachine(1.5,12);
//        ticketMachine6.changeArea("E");
//        //then
//        assertEquals("B",ticketMachine6.getCecha());
//        ticketMachine6.changeArea("A");
//        //then
//        assertEquals("A",ticketMachine6.getCecha());
//
//    }
    @Test
    public void przetestujGodzine(){

        LocalDateTime localDateTime1 = LocalDateTime.parse("2015-05-28T18:54:23");
        LocalDateTime localDateTime2 = LocalDateTime.parse("2015-05-28T22:54:23");

        TicketMachine ticketMachine7 = new TicketMachine(1.5,12);

        //then
        assertTrue(ticketMachine7.isActive(localDateTime1));
        assertFalse(ticketMachine7.isActive(localDateTime2));

    }




}