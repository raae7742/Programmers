#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int max_x = 0, max_h = 0;
    
    if (sizes[0][0] >= sizes[0][1]) {
        max_x = sizes[0][0];
        max_h = sizes[0][1];
    }
    else {
        max_x = sizes[0][1];
        max_h = sizes[0][0];
    }
    
    for (int i = 0; i < sizes.size(); i++) {
        if (sizes[i][0] >= sizes[i][1]) {
            if (sizes[i][0] > max_x) max_x = sizes[i][0];
            if (sizes[i][1] > max_h) max_h = sizes[i][1];
        }
        else {
            if (sizes[i][1] > max_x) max_x = sizes[i][1];
            if (sizes[i][0] > max_h) max_h = sizes[i][0];
        }
    }
    
    answer = max_x * max_h;
    return answer;
}
