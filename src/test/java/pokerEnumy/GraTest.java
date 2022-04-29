package pokerEnumy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraTest {

    @Test
    void strit() {
        Gra gra = new Gra();
        List<Karty> karties = new ArrayList<>();
        List<Karty> kartiesStrit = new ArrayList<>();

        Karty karty1 = new Karty(Suit.Trefl, Rank.Trzy);
        Karty karty2 = new Karty(Suit.Trefl, Rank.Trzy);
        Karty karty3 = new Karty(Suit.Trefl, Rank.Trzy);
        Karty karty4 = new Karty(Suit.Trefl, Rank.Trzy);
        Karty karty5 = new Karty(Suit.Trefl, Rank.Cztery);
        Karty karty6 = new Karty(Suit.Trefl, Rank.Piec);
        Karty karty7 = new Karty(Suit.Trefl, Rank.Szesc);
        Karty karty8 = new Karty(Suit.Trefl, Rank.Siedem);

        karties.add(karty4);
        karties.add(karty5);
        karties.add(karty6);
        karties.add(karty8);
        karties.add(karty8);

        kartiesStrit.add(karty4);
        kartiesStrit.add(karty5);
        kartiesStrit.add(karty6);
        kartiesStrit.add(karty7);
        kartiesStrit.add(karty8);

        //then
        assertEquals(false, gra.strit(karties));
        assertEquals(true, gra.strit(kartiesStrit));
    }

    @Test
    void kolor() {
    }

    @Test
    void poker() {
    }

    @Test
    void pokerKrolewski() {
    }

    @Test
    void kareta() {
    }

    @Test
    void para() {
    }

    @Test
    void trojka() {

    }

    @Test
    void dwiePary() {
    }

    @Test
    void full() {
    }
}