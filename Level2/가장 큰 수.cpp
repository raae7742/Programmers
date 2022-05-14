#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(const string &a, const string &b) {
    if (a + b > b + a)
        return true;
    else
        return false;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> numbers_s;
    
    for (int i = 0; i < numbers.size(); i++) {
        numbers_s.push_back(to_string(numbers[i]));
    }
    
    sort(numbers_s.begin(), numbers_s.end(), compare);
    
    for (int i = 0; i < numbers_s.size(); i++) {
        answer += numbers_s[i];
    }
    if (answer[0] == '0') return "0";
    return answer;
}
