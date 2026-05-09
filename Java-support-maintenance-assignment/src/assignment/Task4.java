package assignment;

// class ReportDAO = Task4

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class Task4 {

    private DataSource dataSource;

    public List<ReportEntry> fetchMonthlyReport(
            String accountId,
            int month,
            int year)
            throws SQLException {

        List<ReportEntry> entries = new ArrayList<>();

        // FIX: Use try-with-resources so Connection and
        // PreparedStatement are closed automatically and we dont't need to close resoucres in finally block
        try (
                Connection conn = dataSource.getConnection();

                PreparedStatement ps = conn.prepareStatement(
                        "SELECT * FROM report_entries " +
                                "WHERE account_id = ? AND MONTH(entry_date) = ? " +
                                "AND YEAR(entry_date) = ?"
                )
        ) {

            ps.setString(1, accountId);
            ps.setInt(2, month);
            ps.setInt(3, year);

            // FIX: ResultSet is also closed automatically
            // after query execution completes.
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    entries.add(mapRow(rs));
                }
            }
        }

        return entries;
    }

    private ReportEntry mapRow(ResultSet rs) {

        // Existing mapping logic
        return new ReportEntry();
    }
}
