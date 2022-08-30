#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

queue<char> q;

string printJadenCase(string answer, bool isBlanked) {
    if (!q.empty()) {
        if (q.front() >= 'a' && q.front() <= 'z') {
            answer += q.front() - 'a' + 'A';
        }
        else {
            answer += q.front();
        }
        q.pop();

        while (!q.empty()) {
            if (q.front() >= 'A' && q.front() <= 'Z') {
                answer += q.front() - 'A' + 'a';
            }
            else {
                answer += q.front();
            }
            q.pop();
        }
    }
    
    if (isBlanked) return answer + ' ';
    else return answer;
}


string solution(string s) {
    string answer = "";
    
    for (int i = 0; i < s.length(); i++) {
        if (s[i] != ' ') {
            q.push(s[i]);
        }
        else {
            answer = printJadenCase(answer, true);
        }
    }
    
    answer = printJadenCase(answer, false);
    return answer;
}
