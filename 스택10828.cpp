#include <stdio.h>
#include <stdlib.h>
int main() {
	int num;
	int n;
	int array[10000];
	array[0] = -1;
	int now = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		char line[6];
		scanf("%s", &line);
		if (strcmp(line,"push")==1) {
			scanf("%d", &num);
			now++;
			array[now] = num;
		}
		else if (line == "pop ") {
			if (now == 0) { printf("-1"); continue; }
			else {
				printf("%d", array[now]);
				array[now] = NULL;
				now--;
			}
		}
		else if (line == "size") {
			printf("%d", now);
		}
		else if (line == "empty") {
			if (now == 0) printf("1");
			else printf("0");
		}
		else if (line == "top") {
			if (now == 0) { printf("-1"); continue; }
			else {
				printf("%d", array[now]);
			}
		}
	}
	return 0;
}