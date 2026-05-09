package assignment;

//BankStatementBatchProcessor =Task3
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    // FIX: processedCount was getting updated by multiple threads
    // at the same time. Because increment operation is not atomic,
    // some updates were getting lost and final count became incorrect.
    // AtomicInteger provides thread-safe increment operation
    private AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<StatementRecord> records)
            throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {

            executor.submit(() -> {

                processRecord(record);

                // FIX: Thread-safe increment
                processedCount.incrementAndGet();
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {

        return processedCount.get();
    }

    private void processRecord(StatementRecord record) {

        // Existing processing logic
    }
}
