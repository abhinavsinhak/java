#include <stdio.h>
#include <stdbool.h>

#define MAX_EDGES 100

struct Edge {
    int src;
    int dest;
    int weight;
};

void sortEdges(struct Edge edges[], int m) {
    for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < m - i - 1; j++) {
            if (edges[j].weight > edges[j + 1].weight) {
                struct Edge temp = edges[j];
                edges[j] = edges[j + 1];
                edges[j + 1] = temp;
            }
        }
    }
}

int findParent(int parent[], int node) {
    if (parent[node] != node) {
        parent[node] = findParent(parent, parent[node]);
    }
    return parent[node];
}

void unionSets(int parent[], int x, int y) {
    int xParent = findParent(parent, x);
    int yParent = findParent(parent, y);
    parent[xParent] = yParent;
}

void kruskalMST(struct Edge edges[], int n, int m) {
    sortEdges(edges, m);

    int parent[n];
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }

    struct Edge mst[MAX_EDGES];
    int mstSize = 0;

    for (int i = 0; i < m; i++) {
        int srcParent = findParent(parent, edges[i].src);
        int destParent = findParent(parent, edges[i].dest);

        if (srcParent != destParent) {
            mst[mstSize++] = edges[i];
            unionSets(parent, srcParent, destParent);
        }
    }

    printf("Minimum Spanning Tree:\n");
    for (int i = 0; i < mstSize; i++) {
        printf("(%d, %d) weight: %d\n", mst[i].src, mst[i].dest, mst[i].weight);
    }
}

int main() {
    int n, m;
    printf("Enter the number of nodes and edges in the graph: ");
    scanf("%d %d", &n, &m);

    struct Edge edges[MAX_EDGES];
    printf("Enter the source, destination, and weight of each edge:\n");
    for (int i = 0; i < m; i++) {
        scanf("%d %d %d", &edges[i].src, &edges[i].dest, &edges[i].weight);
    }

    kruskalMST(edges, n, m);

    return 0;
}
