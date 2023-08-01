#include <stdio.h>
#include <stdbool.h>

struct Item {
    int weight;
    int value;
};

void swap(struct Item* a, struct Item* b) {
    struct Item temp = *a;
    *a = *b;
    *b = temp;
}

void bubbleSort(struct Item items[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            double ratio1 = (double)items[j].value / items[j].weight;
            double ratio2 = (double)items[j + 1].value / items[j + 1].weight;
            if (ratio1 < ratio2) {
                swap(&items[j], &items[j + 1]);
            }
        }
    }
}

double fractionalKnapsack(int W, struct Item items[], int n) {
    bubbleSort(items, n);

    int currentWeight = 0;
    double finalValue = 0.0;

    for (int i = 0; i < n; i++) {
        if (currentWeight + items[i].weight <= W) {
            currentWeight += items[i].weight;
            finalValue += items[i].value;
        } else {
            int remainingWeight = W - currentWeight;
            finalValue += (double)remainingWeight * items[i].value / items[i].weight;
            break;
        }
    }

    return finalValue;
}

int main() {
    int W;
    printf("Enter the capacity of the knapsack: ");
    scanf("%d", &W);

    int n;
    printf("Enter the number of items: ");
    scanf("%d", &n);

    struct Item items[n];
    printf("Enter the weight and value of each item:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &items[i].weight, &items[i].value);
    }

    double maxValue = fractionalKnapsack(W, items, n);
    printf("Maximum value that can be obtained is: %.2lf\n", maxValue);

    return 0;
}
