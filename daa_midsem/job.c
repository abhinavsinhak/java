#include <stdio.h>
#include <stdbool.h>

// Structure to represent a job/task
struct Job {
    char name;      // Job name
    int duration;   // Time required to complete the job
    int deadline;   // Job deadline
};

// Function to sort jobs based on their deadlines in ascending order
void sortByDeadline(struct Job jobs[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (jobs[j].deadline > jobs[j + 1].deadline) {
                // Swap the jobs
                struct Job temp = jobs[j];
                jobs[j] = jobs[j + 1];
                jobs[j + 1] = temp;
            }
        }
    }
}

// Function to schedule jobs using the Earliest Deadline First (EDF) algorithm
void scheduleJobs(struct Job jobs[], int n) {
    sortByDeadline(jobs, n);

    int currentTime = 0;

    printf("Job arrangement:\n");
    printf("Job Name\tExecution Time\n");

    for (int i = 0; i < n; i++) {
        if (currentTime < jobs[i].deadline) {
            printf("%c\t\t%d\n", jobs[i].name, jobs[i].duration);
            currentTime += jobs[i].duration;
        }
    }
}

int main() {
    int n; // Number of jobs
    printf("Enter the number of jobs: ");
    scanf("%d", &n);

    struct Job jobs[n];

    // Input job details from the user
    for (int i = 0; i < n; i++) {
        printf("Enter the name, duration, and deadline for job %d: ", i + 1);
        scanf(" %c%d%d", &jobs[i].name, &jobs[i].duration, &jobs[i].deadline);
    }

    scheduleJobs(jobs, n);

    return 0;
}
