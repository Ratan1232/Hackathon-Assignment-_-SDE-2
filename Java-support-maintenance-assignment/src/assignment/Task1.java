package assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException as it was already assign as null in given code  and calling Date API method on null will give Null pointer exception
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null or empty input list
        if (accounts == null || accounts.isEmpty()) {
            return result;
        }

        Date currentDate = new Date();

        for (LoanAccount account : accounts) {

            // FIX: Skip null account objects
            if (account == null) {
                continue;
            }

            // FIX: dueDate can be null for restructured accounts
            if (account.getDueDate() != null
                    && account.getDueDate().before(currentDate)) {

                // FIX: Ignore accounts with zero outstanding balance
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
