import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles edit menu actions within Date212GUI.
 */
public class EditMenuHandler implements ActionListener {
    private final Date212GUI date212GUI;

    /**
     * Initializes EditMenuHandler with a reference to the parent Date212GUI.
     *
     * @param date212GUI The owning Date212GUI instance.
     */
    public EditMenuHandler(Date212GUI date212GUI) {
        this.date212GUI = date212GUI;
    }

    /**
     * Invoked when an action occurs, prompting user input for filtering dates by
     * year.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String inputYear = JOptionPane.showInputDialog(date212GUI, "Enter a year:");
        System.out.println("Input Year: " + inputYear); // Debugging line

        if (inputYear != null && !inputYear.trim().isEmpty()) {
            filterAndDisplayDatesByYear(inputYear);
        }
    }

    /**
     * Filters and displays dates by a specific year.
     *
     * @param year The year used for filtering the dates.
     */
    private void filterAndDisplayDatesByYear(String year) {
        System.out.println("Filtering for year: " + year); // Debugging line

        // Filter dates in sorted list by year
        SortedDate212List filteredSortedDatesList = date212GUI.sortedList.filterByYear(year);
        String filteredSortedDates = filteredSortedDatesList.getSortedDatesAsString();
        System.out.println("Filtered Sorted Dates: \n" + filteredSortedDates); // Debugging line

        // Filter dates in unsorted list by year
        UnsortedDate212List filteredUnsortedDatesList = date212GUI.unsortedList.filterByYear(year);
        String filteredUnsortedDates = filteredUnsortedDatesList.getUnsortedDatesAsString();
        System.out.println("Filtered Unsorted Dates: \n" + filteredUnsortedDates); // Debugging line

        // Update GUI with filtered dates
        date212GUI.updateSortedTextArea(filteredSortedDates);
        date212GUI.updateUnsortedTextArea(filteredUnsortedDates);
    }
}
