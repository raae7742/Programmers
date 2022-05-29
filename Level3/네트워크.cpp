#include <string>
#include <vector>

using namespace std;

// dfs 메소드: 배열 포인터(&) 변수로 받아야 함
bool dfs(vector<vector<int>>& computers, int num) {
    if (!computers[num][num]) return false;
    // 이미 방문한 컴퓨터는 0으로 처리
    computers[num][num] = 0;
    
    for (int i = 0; i < computers.size(); i++) {
        if (computers[num][i] == 1) dfs(computers, i);
    }
    
    return true;
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    for (int i = 0; i < n; i++) {
        if (computers[i][i] && dfs(computers,i)) answer++;
    }    
    return answer;
}
