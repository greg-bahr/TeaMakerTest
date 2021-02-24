import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    private Account anAccount;

    @BeforeEach
    void setUp() throws ParseException {
        anAccount = new Account();
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        anAccount._entries = new Hashtable<>();

        String str_d1 = "16-Jan-03";
        String str_d2 = "20-Jan-03";
        String str_d3 = "25-Jan-03";

        Date d1 = formatter.parse(str_d1);
        anAccount._entries.put(d1, 100);
        Date d2 = formatter.parse(str_d2);
        anAccount._entries.put(d2, 120);
        Date d3 = formatter.parse(str_d3);
        anAccount._entries.put(d3, 110);
    }

    @Test
    void getSalesBetween() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");

        String str_start = "17-Jan-03";
        String str_end = "30-Jan-03";
        Date start = formatter.parse(str_start);
        Date end = formatter.parse(str_end);

        assertEquals(230, anAccount.getSalesBetween(start, end));
    }

    @Test
    public void testGetSalesBetween2() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        String str_start = "1-Jan-03";
        String str_end   = "16-Jan-03";

        Date start = formatter.parse(str_start);
        Date end   = formatter.parse(str_end);

        assertEquals(100, anAccount.getSalesBetween(start, end));
    }

    @Test
    public void testInvalidRangeInclusive() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        String str_start = "1-Jan-03";
        String str_end   = "16-Jan-03";

        Date start = formatter.parse(str_start);
        Date end   = formatter.parse(str_end);

        assertEquals(100, anAccount.getSalesBetween(end, start));
    }

    @Test
    public void testInvalidRangeExclusive() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        String str_start = "1-Jan-03";
        String str_end   = "17-Jan-03";

        Date start = formatter.parse(str_start);
        Date end   = formatter.parse(str_end);

        assertEquals(0, anAccount.getSalesBetween(end, start));
    }
}