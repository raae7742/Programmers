#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string new_id) {
    string answer = "";
    
    for (int i = 0; i < new_id.length(); i++) {
        char s = new_id.at(i);
        
        // 1
        if (s >= 'A' && s <= 'Z') s = s - 'A' + 'a';
        
        // 2
        if (!(s >= 'a' && s <= 'z') && 
            !(s >= '0' && s <= '9') &&
            s != '-' && s != '_' && s != '.') {
            continue;
        }
        
        // 3
        if (s == '.' && answer.length() > 0) {
            if (answer.at(answer.length() - 1) == '.') continue;
        }
        
        // 4
        if ((i == 0 || i == new_id.length() - 1) && s == '.') continue;
        
        answer = answer + s;
    }
    
    // 6
    if (answer.length() > 0 && answer.at(0) == '.') {
        answer.erase(0, 1);
    }
    
    if (answer.length() >= 16) answer = answer.substr(0, 15);
        
    if (answer.length() > 0 && answer.at(answer.length() - 1) == '.') {
        answer.pop_back();
    }
        
    // 5
    if (answer.length() == 0) answer = "a";
    
    // 7
    while (answer.length() <= 2) {
        answer = answer + answer.at(answer.length() - 1);
    }
    
    return answer;
}
