#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int arr[27][27];
bool check[27][27];
int num;
queue <pair <int, int>> q;
vector <int> v;
int count1; //단지 수
int count2;//단지 내 아파트 수
int nx[4] = { 0,1,0,-1 };
int ny[4] = { 1,0,-1,0 };

void bfs(int n,int m) {
	q.push(make_pair(n, m)); 
	check[n][m]=true;
	count2++; count1++;
	while (!q.empty()) {
		int f = q.front().first;
		int s = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int x = f + nx[i];
			int y = s + ny[i];
			if (arr[x][y] != 0 && check[x][y] == 0) {
				check[x][y] = true;
				q.push(make_pair(x, y));
				count2++;
			}
		}
	}
	v.push_back(count2);
	count2 = 0;
}


int main() {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%1d", &arr[i][j]);
			
		}
	}
	for (int k = 1; k <= n; k++) {
		for (int k2 = 1; k2 <= n; k2++) {
			if (arr[k][k2] != 0 && check[k][k2] != true) {
				bfs(k, k2);
			}
		}
	}
	int s = v.size();
	for (int i = 0; i < s; i++) {
		
	}
	printf("%d\n%d\n%d",count1,)
	return 0;
}
