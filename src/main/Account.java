import java.text.SimpleDateFormat;
import java.util.*;

class Account {
    Hashtable<Date, Integer> _entries;

    int getSalesBetween(DateRange range) {
        int result = 0;
        Set s = _entries.entrySet();
        Iterator i = s.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            Date date = (Date) m.getKey();
            Integer value = (Integer) m.getValue();
            if (range.includes(date)) {
                SimpleDateFormat dformat = new SimpleDateFormat("dd.MM.yyyy");
                String formattedDate = dformat.format(date);
                System.out.println("Date : " + formattedDate);
                result += value;
            }
        }
        return result;
    }
}