package assignment;

public class Task2 {

    /*
     * 1. What is the exact cause of ConcurrentModificationException in Java?
     *
     * This exception happens when a collection is modified
     * while looping through it.
     *
     * For example, removing or adding elements to an ArrayList
     * inside a for-each loop can cause this issue.
     */


    /*
     * 2. What code pattern at line 142 most likely triggered this error?
     *
     * Most likely scenario:
     *
     * for (Transaction transaction : transactions) {
     *
     *     if (condition) {
     *         transactions.remove(transaction);
     *     }
     * }
     *
     * Here the list is being modified during iteration even if it is single threaded operation this will give conCurrentModification exception as we are iterating and at same time removing element .
     */


    /*
     * 3. Provide the minimal code change that resolves this safely.
     *
     * Use Iterator.remove() instead of list.remove().
     *
     * Example:
     *
     * Iterator<Transaction> iterator = transactions.iterator();
     *
     * while (iterator.hasNext()) {
     *
     *     Transaction transaction = iterator.next();
     *
     *     if (condition) {
     *         iterator.remove();
     *     }
     * }
     *
     * Iterator.remove() safely removes elements while iterating.
     */
}