#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	vector <char> v;
	int num;
	string line;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		cin >> line;
		for (int j = 0; j < line.length(); j++) {
			v.push_back(line[j]);
		}
		char first = v.back();
		for (int k = 0; k < line.length(); j++) {
			v.pop_back();
			char second = v.back();
			if(first==second) 
		}
	}



	return 0;
}