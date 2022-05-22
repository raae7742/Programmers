#include <string>
#include <vector>

using namespace std;

int answer = 0;

// DFS(깊이 우선 탐색)을 재귀로 구현
void dfs(vector<int> numbers, int target, int sum, int index) {
    // 재귀 종료 조건
    if (index == numbers.size()) {
        if (sum == target) answer++;
        return;
    }
    
    // 현재 값을 더하고, 다음 노드 탐색
    dfs(numbers, target, sum + numbers[index], index+1);
    // 현재 값을 빼고, 다음 노드 탐색
    dfs(numbers, target, sum - numbers[index], index+1);
}

int solution(vector<int> numbers, int target) {
    // 재귀 호출
    dfs(numbers, target, 0, 0);
    
    return answer;
}
