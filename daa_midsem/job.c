
#include <stdio.h>
#include <stdbool.h>

#define MAX_JOBS 100

// Function to sort jobs based on their deadlines in ascending order
void sortByDeadline(char names[], int durations[], int deadlines[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (deadlines[j] > deadlines[j + 1]) {
                // Swap the jobs' details
                char tempName = names[j];
                int tempDuration = durations[j];
                int tempDeadline = deadlines[j];

                names[j] = names[j + 1];
                durations[j] = durations[j + 1];
                deadlines[j] = deadlines[j + 1];

                names[j + 1] = tempName;
                durations[j + 1] = tempDuration;
                deadlines[j + 1] = tempDeadline;
            }
        }
    }
}

// Function to schedule jobs using the Earliest Deadline First (EDF) algorithm
void scheduleJobs(char names[], int durations[], int deadlines[], int n) {
    sortByDeadline(names, durations, deadlines, n);

    int currentTime = 0;

    printf("Job arrangement:\n");
    printf("Job Name\tExecution Time\n");

    for (int i = 0; i < n; i++) {
        if (currentTime < deadlines[i]) {
            printf("%c\t\t%d\n", names[i], durations[i]);
            currentTime += durations[i];
        }
    }
}

int main() {
    int n; // Number of jobs
    printf("Enter the number of jobs: ");
    scanf("%d", &n);

    char names[MAX_JOBS];
    int durations[MAX_JOBS];
    int deadlines[MAX_JOBS];

    // Input job details from the user
    for (int i = 0; i < n; i++) {
        printf("Enter the name, duration, and deadline for job %d: ", i + 1);
        scanf(" %c%d%d", &names[i], &durations[i], &deadlines[i]);
    }

    scheduleJobs(names, durations, deadlines, n);

    return 0;
}
