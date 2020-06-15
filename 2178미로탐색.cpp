#include <iostream>
#include <queue>
using namespace std;
int arr[100][100];
int check[100][100];
char num[101];
queue <pair <int,int>> q;

int main() {
	int n, m;
	scanf("%d", &n); scanf("%d", &m);
	for (int i = 0; i < n; i++) {
			scanf("%s", &num);
			for (int j = 0; j < m; j++) {
				arr[i][j] = num[j]-48;
				check[i][j] = 0;
			}
	}
	check[0][0] = 1;
	q.push(make_pair(0, 0));
	int nx2[4] = { 1,-1,0,0 };
	int ny2[4] = { 0,0,-1,1 }; 
	while (!q.empty()) {
		int f=q.front().first;
		int s = q.front().second;
		
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx =f + nx2[i];
			int ny = s + ny2[i];
			if (nx < 0 || ny < 0) continue;
			if (arr[nx][ny] != 0&& check[nx][ny] == 0) {
				check[nx][ny] = check[f][s]+1;
				q.push(make_pair(nx, ny));
			}
		}
	}
	printf("%d", check[n-1][m-1]);
	return 0;
}