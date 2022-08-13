#include <string>
#include <vector>
#include <sstream>
#include <unordered_map>

using namespace std;

vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
 
    return answer;
}

vector<string> solution(vector<string> record) {
    vector<string> answer;
    unordered_map<string, string> m;
    
    for (int i = 0; i < record.size(); i++) {
        vector<string> words = split(record[i], ' ');
        if (words.size() == 3) {
            m[words[1]]= words[2];
        }
    }
             
    for (int i = 0; i < record.size(); i++) {
        vector<string> words = split(record[i], ' ');
                
        string chat = m[words[1]];
        
        if (words[0].compare("Enter") == 0) {
            chat += "님이 들어왔습니다.";
            answer.push_back(chat);
        }
        else if (words[0].compare("Leave") == 0) {
            chat += "님이 나갔습니다.";
            answer.push_back(chat);
        }
        else {
            continue;
        }        
    }
    
    return answer;
}
