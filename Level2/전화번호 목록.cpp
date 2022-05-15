#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

bool solution(vector<string> phone_book) {
    map<string, int> m;
    
    for (int i = 0; i < phone_book.size(); i++) {
        m[phone_book[i]] = 1;
    }
    
    for (int i = 0; i < phone_book.size(); i++) {
        string phone_number = "";
        for (int j = 0; j < phone_book[i].size(); j++) {
            phone_number += phone_book[i][j];
            if (m[phone_number] && phone_number != phone_book[i]) return false;
        }
    }
    return true;
}
