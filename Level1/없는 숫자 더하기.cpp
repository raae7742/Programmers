#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    
    for (int i = 0; i < 10; i++) {
        int isExisted = false;
        for (int j = 0; j < numbers.size(); j++) {
            if (i == numbers[j]) isExisted = true;
        }
        
        if (isExisted == false) {
            answer += i;
        }
    }
    
    return answer;
}
