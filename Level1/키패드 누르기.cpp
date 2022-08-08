#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    int left = 10, right = 12;
    for (int i = 0; i < numbers.size(); i++) {
        
        switch(numbers[i]) {
            case 1:
            case 4:
            case 7:
                left = numbers[i];
                answer = answer + "L";
                break;
            case 3:
            case 6:
            case 9:
                right = numbers[i];
                answer = answer + "R";
                break;
            case 2:
            case 5:
            case 8:
            case 0:
                if (numbers[i] == 0) numbers[i] = 11;
                
                int l_count = 0;
                int r_count = 0;
                int left_temp = left;
                int right_temp = right;
                
                if (left_temp < numbers[i]) {
                    while (left_temp + 3 <= numbers[i]) {
                        left_temp += 3;
                        l_count++;
                    }
                    l_count += numbers[i] - left_temp;
                }
                else {
                    while (left_temp > numbers[i]) {
                        left_temp -= 3;
                        l_count++;
                    }
                    l_count += numbers[i] - left_temp;
                }
                
                if (right_temp < numbers[i]) {
                    while (right_temp < numbers[i]) {
                        right_temp += 3;
                        r_count++;
                    }
                    r_count += right_temp - numbers[i];
                }
                else {
                    while (right_temp - 3 >= numbers[i]) {
                        right_temp -= 3;
                        r_count++;
                    }
                    r_count += right_temp - numbers[i];
                }
                
                if (l_count > r_count) {
                    right = numbers[i];
                    answer = answer + "R";
                }
                else if (l_count < r_count) {
                    left = numbers[i];                
                    answer = answer + "L";
                }
                else {
                    if (hand == "left") {
                        left = numbers[i];            
                        answer = answer + "L";
                    }
                    else {
                        right = numbers[i];            
                        answer = answer + "R";
                    }
                }
                break;
        }
    }
    
    return answer;
}
