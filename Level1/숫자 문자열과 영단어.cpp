#include <string>
#include <vector>
#include <stack>
#include <math.h>

using namespace std;

int convertStringToNum(string temp) {
    if(temp.compare("zero") == 0) {
        return 0;
    }
    else if (temp.compare("one") == 0) {
        return 1;
    }
    else if (temp.compare("two") == 0) {
        return 2;
    }
    else if (temp.compare("three") == 0) {
        return 3;
    }
    else if (temp.compare("four") == 0) {
        return 4;
    }
    else if (temp.compare("five") == 0) {
        return 5;
    }
    else if (temp.compare("six") == 0) {
        return 6;
    }
    else if (temp.compare("seven") == 0) {
        return 7;
    }
    else if (temp.compare("eight") == 0) {
        return 8;
    }
    else if (temp.compare("nine") == 0) {
        return 9;
    }
    else {
        return -1;
    }
}

int solution(string s) {
    int answer = 0;
    stack<int> num;
    string temp = "";
    for (int i = 0; i < s.length(); i++) {
        if (s.at(i) >= '0' && s.at(i) <= '9') {
            num.push(s.at(i) - '0');
        } else {
            temp = temp + s.at(i);
        }
        
        int value = convertStringToNum(temp);
        if (value != -1) {
            num.push(value);
            temp = "";
        }
    }
    
    if (temp.length() > 0) num.push(convertStringToNum(temp));
    
    int cnt = 0;
    while (num.size() > 0) {
        answer += num.top() * pow(10, cnt);
        num.pop();
        cnt++;
    }
    
    return answer;
}
