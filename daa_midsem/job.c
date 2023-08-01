#include <stdio.h>
#include <stdlib.h>

struct Job {
    int id;
    int deadline;
    int profit;
};

void swapJobs(struct Job* a, struct Job* b) {
    struct Job temp = *a;
    *a = *b;
    *b = temp;
}

void bubbleSort(struct Job jobs[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (jobs[j].profit < jobs[j + 1].profit) {
                swapJobs(&jobs[j], &jobs[j + 1]);
            }
        }
    }
}

void scheduleJobs(struct Job jobs[], int n) {
    bubbleSort(jobs, n);

    int maxDeadline = 0;
    for (int i = 0; i < n; i++) {
        if (jobs[i].deadline > maxDeadline) {
            maxDeadline = jobs[i].deadline;
        }
    }

    int schedule[maxDeadline];
    for (int i = 0; i < maxDeadline; i++) {
        schedule[i] = -1;
    }

    int totalProfit = 0;
    for (int i = 0; i < n; i++) {
        for (int j = jobs[i].deadline - 1; j >= 0; j--) {
            if (schedule[j] == -1) {
                schedule[j] = jobs[i].id;
                totalProfit += jobs[i].profit;
                break;
            }
        }
    }

    printf("Job Sequence: ");
    for (int i = 0; i < maxDeadline; i++) {
        if (schedule[i] != -1) {
            printf("J%d ", schedule[i]);
        }
    }
    printf("\nTotal Profit: %d\n", totalProfit);
}

int main() {
    struct Job jobs[] = {
        {1, 4, 50},
        {2, 1, 30},
        {3, 1, 40},
        {4, 2, 60},
    };
    int n = sizeof(jobs) / sizeof(jobs[0]);

    scheduleJobs(jobs, n);

    return 0;
}
