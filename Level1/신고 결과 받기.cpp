#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <algorithm>
#include <unordered_map>

using namespace std;

vector<string> split(string str, char Delimiter) {
    istringstream iss(str);
    string buffer;
    
    vector<string> result;
    
    while (getline(iss, buffer, Delimiter)) {
        result.push_back(buffer);
    }
    
    return result;
}

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    unordered_map<string, vector<string>> um;
    unordered_map<string, int> count;
    
    for (int i = 0; i < id_list.size(); i++) {
        count[id_list[i]] = 0;
    }
        
    for (int i = 0; i < report.size(); i++) {
        vector<string> names = split(report[i], ' ');
        
        auto it = find(um[names[1]].begin(), um[names[1]].end(), names[0]);
        if (it == um[names[1]].end()) {
            um[names[1]].push_back(names[0]);
        }
    }
    
    for (int i = 0; i < id_list.size(); i++) {
        if (um[id_list[i]].size() >= k) {
            for (int j = 0; j < um[id_list[i]].size(); j++) {
                count[um[id_list[i]][j]]++;
            }
        }
    }
    
    for (int i = 0; i < id_list.size(); i++) {
        answer.push_back(count[id_list[i]]);
    }
    
    return answer;
}
