#include <stdio.h>
#include <stdbool.h>
#define MAX_VERTICES 100
#define INF 999999

// Function to find the minimum distance vertex not yet included in the shortest path
int minDistance(int dist[], bool visited[], int vertices) {
    int min = INF, min_index;
    for (int v = 0; v < vertices; v++) {
        if (!visited[v] && dist[v] < min) {
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}

// Function to print the shortest path from the source to the given vertex
void printPath(int parent[], int vertex) {
    if (parent[vertex] == -1)
        return;
    printPath(parent, parent[vertex]);
    printf(" -> %d", vertex);
}

// Function to implement Dijkstra's algorithm to find the shortest path
void dijkstraShortestPath(int graph[MAX_VERTICES][MAX_VERTICES], int vertices, int source) {
    int dist[MAX_VERTICES]; // To store the minimum distance from source to vertices
    bool visited[MAX_VERTICES]; // To keep track of visited vertices
    int parent[MAX_VERTICES]; // To store the shortest path

    // Initialize all distances as infinite and visited as false
    for (int i = 0; i < vertices; i++) {
        dist[i] = INF;
        visited[i] = false;
        parent[i] = -1;
    }

    // Distance of source vertex from itself is always 0
    dist[source] = 0;

    // Find the shortest path for all vertices
    for (int count = 0; count < vertices - 1; count++) {
        int u = minDistance(dist, visited, vertices);
        visited[u] = true;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && graph[u][v] && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
                parent[v] = u;
            }
        }
    }

    // Print the shortest paths
    printf("Shortest paths from vertex %d:\n", source);
    for (int i = 0; i < vertices; i++) {
        printf("Vertex %d - Distance: %d - Path: %d", i, dist[i], source);
        printPath(parent, i);
        printf("\n");
    }
}

int main() {
    int vertices, edges;
    int graph[MAX_VERTICES][MAX_VERTICES] = {0};

    printf("Enter the number of vertices: ");
    scanf("%d", &vertices);

    printf("Enter the number of edges: ");
    scanf("%d", &edges);

    printf("Enter the edges (start end weight):\n");
    int start, end, weight;
    for (int i = 0; i < edges; i++) {
        scanf("%d %d %d", &start, &end, &weight);
        graph[start][end] = weight;
    }

    int source;
    printf("Enter the source vertex: ");
    scanf("%d", &source);

    dijkstraShortestPath(graph, vertices, source);

    return 0;
}
