#include <iostream>
#include <vector>
using namespace std;
vector <int> v;
int arr[6] = { 0,1,2,3,4,5 };
int n;
void dfs(int num) {
	int k = num; //k는 전체 함수에 관여하여 dfs에 --로 계속 들어갈 놈, num은 인덱스르 위함
	if (k == 5) {
		if (arr[4] == n - 1) {
			arr[k] = arr[4] + 1;
			printf("%d %d %d %d %d %d\n", v[arr[0]], v[arr[1]], v[arr[2]], v[arr[3]], v[arr[4]], v[arr[5]]);
		}
		else {
			arr[k] = arr[4] + 1;
			int m = arr[5];
			for (int i = 1; i <= n - m; i++) {
				arr[5] += i;

				printf("%d %d %d %d %d %d\n", v[arr[0]], v[arr[1]], v[arr[2]], v[arr[3]], v[arr[4]], v[arr[5]]);

			}
		}
		dfs(--k);
	}
	else if (k < 5) {
		int m = arr[k];
		while (m++ < n - 5 + k) {

			arr[k] = m; arr[k + 1] = m + 1;
			dfs(k + 1);
		}
		if (m == n - 5 + k) { //차수 올린 마지막 단계
			int k2 = k; //k 임시저장해서 뒷자리들 다 m+1로 맥여줌, 즉 정렬
			while (k2 <= 5) {
				arr[++k2] = m + 1;	
			}
			dfs(k + 1);
			dfs(k - 1);
		}
		if (k == 0) return;
	}
}



int main() {
	while (true) {
		n = 0;
		int num = 0;
		scanf("%d", &n);
		if (n == 0) return 0;
		for (int i = 0; i < n; i++) {
			cin >> num;
			v.push_back(num);
		}v.push_back(50);

		dfs(5);
		printf("\n");

	}

}