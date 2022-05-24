#include <string>
#include <vector>
#include <algorithm>
#define MAX 500

using namespace std;

int dp[MAX][MAX + 1] = { 0 };

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    
    for (int i = 0; i < triangle.size(); i++) {
        for (int j = 0; j < triangle[i].size(); j++) {
            if (i-1 < 0) {
                dp[i][j] = triangle[i][j];
            } else if (j-1 < 0) {
                dp[i][j] = dp[i-1][j] + triangle[i][j];
            } else if (j >= triangle[i-1].size()) {
                dp[i][j] = dp[i-1][j-1] + triangle[i][j];
            } else {
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
    }
    
    for (int i = 0; i < triangle.size() + 1; i++) {
        if (answer < dp[triangle.size()-1][i]) 
          answer = dp[triangle.size()-1][i];
    }
    
    return answer;
}
