#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.length();
    
    // 압축할 문자열 크기 i
    for (int i = 1; i < s.length() / 2 + 1; i++) {
        // 반복 횟수 cnt
        int cnt = 1;
      
        // 압축 결과 temp
        string temp = "";
        string zip = s.substr(0, i);
        
        for (int j = i; j < s.size(); j += i) {
            if (zip == s.substr(j, i)) cnt++;
            else {
                if (cnt > 1) temp += to_string(cnt);
                temp += zip;
                zip = s.substr(j, i);
                cnt = 1;
            }
        }  
        if (cnt > 1) temp += to_string(cnt);
        temp += zip;
      
        if (answer > temp.length()) answer = temp.length();
    }
    
    return answer;
}
