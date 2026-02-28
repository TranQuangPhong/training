package org.example.schedule;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Entry point: using spring schedule to trigger job
 */
@Component
public class OrderJobScheduler {

    private final JobLauncher jobLauncher;
    private final Job orderJob;

    public OrderJobScheduler(JobLauncher jobLauncher, Job orderJob) {
        this.jobLauncher = jobLauncher;
        this.orderJob = orderJob;
    }

    @Scheduled(cron = "${batch.job.order.schedule}")
    public void runOrderJob() {
        try {
            System.out.println("🚀 Starting orderJob at " + LocalDateTime.now());

            JobParameters params = new JobParametersBuilder()
                    .addLong("run.id", System.currentTimeMillis()) // ensure unique
                    .toJobParameters();

            jobLauncher.run(orderJob, params);

            //        JobParameters jobParameters = new JobParametersBuilder()
            //                .addString("inputFile", "your-s3-bucket/path/to/your.json")
            //                .addLong("time", System.currentTimeMillis())
            //                .toJobParameters();
            //        jobLauncher.run(importUserJob, jobParameters);

            System.out.println("✅ orderJob completed at " + LocalDateTime.now());
        } catch (Exception e) {
            System.err.println("❌ Error executing orderJob: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

