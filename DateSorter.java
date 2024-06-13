package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        List<LocalDate> datesWithR = unsortedDates.stream()
                .filter(unsortedDate -> unsortedDate.getMonth().name().contains("R"))
                .sorted()
                .toList();
        List<LocalDate> datesWithoutR = unsortedDates.stream()
                .filter(date -> !date.getMonth().name().contains("R"))
                .sorted(Collections.reverseOrder())
                .toList();

        List<LocalDate> sortedDates = new ArrayList<>(datesWithR);
        sortedDates.addAll(datesWithoutR);

        return sortedDates;
    }
}