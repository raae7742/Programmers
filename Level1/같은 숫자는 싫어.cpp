#include <vector>
#include <iostream>
#include <stack>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    stack<int> s;
    vector<int> answer;
    
    for (int i = 0; i < arr.size(); i++) {
        if (s.empty() == true) {
            s.push(arr[i]);
            answer.push_back(arr[i]);
        }
        else {
            if (s.top() == arr[i]) {
                continue;
            } else {
                s.push(arr[i]);
                answer.push_back(arr[i]);
            }
        }
    }

    return answer;
}
