#include<stdio.h>
#include<stdbool.h>

#define INF 99999

int mindistance(int dist[20],bool visited[20],int v){
    int min = INF,min_index;
    for(int i=0;i<v;i++){
        if(visited==false && dist[i]<min){
            min =dist[i];
            min_index = i;
        }
    }
    return min_index;
}
void dijestra(int graph[20][20],int src,int v){
    int dist[v];
    bool visited[v];

    for(int i=0;i<v;i++){
        dist[i]=0;
        visited[v] = false;
    }
    dist[src] = 0;
    for(int i=0;i<v-1;i++){
        int u = mindistance(dist,visited,v);
        visited[u] = true;

        for(int j = 0;j<v;j++){
            if(!visited && graph[u][j]&&dist[u] !=INF && dist[u]+graph[u][j]<dist[v]){
                dist[v] = graph[u][j] + dist[u];
            }
        }
    }
    for(int i =0;i<v;i++){
        printf("%d \t\t %d",i,dist[i]);
    }
}
void main(){
    printf("enter the no of vertices\n");
    int v;
    scanf("%d",&v);

    int graph[20][20];
    for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
            scanf("%d",&graph[i][j]);
        }
    }
    printf("enter the source\n");
    int src;
    scanf("%d",&src);
    dijestra(graph,src,v);
}
