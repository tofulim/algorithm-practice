#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main() {
	vector <char> v;
	string equation;
	getline(cin, equation);
	int length = equation.length();
	for (int i = 0; i < length; i++) {
		v.push_back(equation[i]);
		if (v.back() == '('||v.back() == '+' || v.back() == '-' || v.back() == '*' || v.back() == '/') continue;
		else if (v.back() == ')') {
			v.pop_back();
			while (v.back() != '(') {
				printf("%c", v.back());
				v.pop_back();
			}
			v.pop_back();
		}
		else {
			printf("%c", v.back());
			v.pop_back();
		}
	}
	while (!v.empty()) {
		printf("%c", v.back());
		v.pop_back();
	}

	return 0;
}
