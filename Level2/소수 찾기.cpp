#include <string>
#include <vector>
#include <unordered_set>
#include <cmath>

using namespace std;

// 값 중복 방지를 위해 set 사용
unordered_set<int> s_num;

// 소수 찾기 - 에라토스테네스의 체
bool isPrime(int number) {
    if (number == 0 || number == 1) return false;
    
    int lim = sqrt(number);
    for (int i = 2; i <= lim; i++)
        if (number % i == 0) return false;
    
    return true;
}

// 재귀로 모든 경우의 수 만들기
void makeNumber(string s1, string s2) {
    if (s1 != "") s_num.insert(stoi(s1));
    
    for (int i = 0; i < s2.size(); i++)
        makeNumber(s1 + s2[i], s2.substr(0, i) + s2.substr(i + 1));
}

int solution(string numbers) {    
    makeNumber("", numbers);

    int answer = 0;
    for (int number: s_num)
        if (isPrime(number)) answer++;

    return answer;
}
