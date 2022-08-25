#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    // 0: RT, 1: CF, 2: JM, 3: AN
    vector<int> score = {0, 0, 0, 0};
    
    for (int i = 0; i < choices.size(); i++) {
        bool isReversed = false;
        int position = 0;
        
        if (survey[i].compare("RT") == 0) {
            position = 0;
        }
        else if (survey[i].compare("TR") == 0) {
            isReversed = true;
            position = 0;
        }
        if (survey[i].compare("CF") == 0) {
            position = 1;
        }
        else if (survey[i].compare("FC") == 0) {
            isReversed = true;
            position = 1;
        }
        if (survey[i].compare("JM") == 0) {
            position = 2;
        }
        else if (survey[i].compare("MJ") == 0) {
            isReversed = true;
            position = 2;
        }
        if (survey[i].compare("AN") == 0) {
            position = 3;
        }
        else if (survey[i].compare("NA") == 0) {
            isReversed = true;
            position = 3;
        }
        
        int temp = choices[i] - 4;
        if (isReversed) temp = -temp;
        score[position] += temp;
    }
    
    if (score[0] > 0) {
        answer = answer + "T";
    }
    else {
        answer = answer + "R";
    }
    
    if (score[1] > 0) {
        answer = answer + "F";
    }
    else {
        answer = answer + "C";
    }
    
    if (score[2] > 0) {
        answer = answer + "M";
    }
    else {
        answer = answer + "J";
    }
    
    if (score[3] > 0) {
        answer = answer + "N";
    }
    else {
        answer = answer + "A";
    }
    
    return answer;
}
