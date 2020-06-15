#include <iostream>
using namespace std;
int arr[100][100]; bool visit[100][100];
int num;
void dfs(int x,int y,int z) {
	visit[y][z] = true;
	for (int m = 0; m < num; m++) {
		if (arr[z][m] && !visit[x][m]) {
			dfs(x, z, m);    // 메인문에서 1을 찾아 타고 간 것이기에 도착점을 시작행으로 훑는다 
		}
	}
	
}

int main() {
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		for (int j = 0; j < num; j++) {
			cin >> arr[i][j];
		}printf("\n");
	}
	for (int k = 0; k < num; k++) {
		for (int n = 0; num; n++) {
			if (arr[k][n] && !visit[k][n]) dfs(k, k, n);
		}
	}

	return 0;
}