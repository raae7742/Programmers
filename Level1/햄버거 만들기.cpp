#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    vector<int> v;
    
    for (int i = 0; i < ingredient.size(); i++) {
        v.push_back(ingredient[i]);
        int back = v.size() - 1;
        if (v.size() >= 4 && v[back] == 1) {
            if (v[back - 1] == 3 && v[back - 2] == 2 && v[ back - 3] == 1) {
                answer++;
                v.erase(v.begin() + back);
                v.erase(v.begin() + back - 1);
                v.erase(v.begin() + back - 2);
                v.erase(v.begin() + back - 3);
            }
        }
    }
    
    return answer;
}
