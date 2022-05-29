#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int first = 0, end = people.size() - 1;
    
    sort(people.begin(), people.end());
    
    while (first <= end) {
        // 가장 가벼운 사람 + 가장 무거운 사람이 함꼐 탈 수 있다면
        // 가장 가벼운 사람 한 명, 가장 무거운 사람 한 명 제외
        if (people[first] + people[end] <= limit) first++;
        // 그렇지 않다면 가장 무거운 사람 한 명만 제외
        end--;
        
        // 구명보트 개수 증가
        answer++;
    }
    
    return answer;
}
