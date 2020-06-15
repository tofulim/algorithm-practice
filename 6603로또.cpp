#include <iostream>
#include <vector>
using namespace std;
vector <bool> v2;
vector <int> v;
int arr[6] = { 0,1,2,3,4,5 };
int n;
void dfs(int num) {
	int k = num; //k는 전체 함수에 관여하여 dfs에 --로 계속 들어갈 놈, num은 인덱스르 위함
	if (k == 5) {
		int m = arr[5];
		while (m < n) {
			v2[m++] = false;
			arr[5] = m;
			v2[m] = true;
			printf("%d %d %d %d %d %d\n", v[arr[0]], v[arr[1]], v[arr[2]], v[arr[3]], v[arr[4]], v[arr[5]]);
			dfs(--k);
		}
	}
	else if (k < 5) {
		int m = arr[k];
		while (m < n - 5 + k) {
			v2[m++] = false; v2[arr[k + 1]] = false;
			arr[k] = m; arr[k + 1] = m + 1;
			v2[m] = true; v2[m + 1] = true;
			dfs(k + 1);
		}
		if (k == 0) return;
		dfs(k - 1);
	}
}



int main() {
	while (true) {
		n = 0;
		int num = 0;
		scanf("%d", &n);
		if (n == 0) return 0;
		for (int i = 0; i < n; i++) {
			v2.push_back(false);
			cin >> num;
			v.push_back(num);
		}v.push_back(50);

		printf("%d %d %d %d %d %d\n", v[arr[0]], v[arr[1]], v[arr[2]], v[arr[3]], v[arr[4]], v[arr[5]]);
		v2[arr[0]], v2[arr[1]], v2[arr[2]], v2[arr[3]], v2[arr[4]], v2[arr[5]] = true;
		dfs(5);
		printf("\n");

	}

}