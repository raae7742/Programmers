#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <iostream>
#include <cmath>

using namespace std;

struct Line {
    string time;
    string car;
    string inout;
};

bool compare(Line a, Line b) {
    if (a.car == b.car) {
        return a.time < b.time;
    }
    return a.car < b.car;
}

vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
    
    while(getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
    
    return answer;
}

vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    vector<Line> lines;
    
    for (int i = 0; i < records.size(); i++) {
        vector<string> car_info = split(records[i], ' ');
        
        Line line;
        line.time = car_info[0];
        line.car = car_info[1];
        line.inout = car_info[2];
        
        lines.push_back(line);
    }
    
    sort(lines.begin(), lines.end(), compare);
    
    Line current = lines[0];
    int total_time = 0;
    int i = 0;
    
    for (i = 1; i < lines.size(); i++) {
        if (current.car == lines[i].car) {
            if (lines[i].inout == "OUT") {
                vector<string> in_list = split(current.time, ':');
                int in_hour = stoi(in_list[0]);
                int in_min = stoi(in_list[1]);
                
                vector<string> out_list = split(lines[i].time, ':');
                int out_hour = stoi(out_list[0]);
                int out_min = stoi(out_list[1]);

                if (in_min > out_min) {
                    total_time += (out_hour - in_hour - 1) * 60;
                    total_time += 60 - in_min + out_min;
                }
                else {
                    total_time += (out_hour - in_hour) * 60;
                    total_time += out_min - in_min;
                }  
            }
        }
        else {
            if (current.inout == "IN") {
                int in_hour = stoi(split(current.time, ':').at(0));
                int in_min = stoi(split(current.time, ':').at(1));
                int out_hour = 23;
                int out_min = 59;

                total_time += (out_hour - in_hour) * 60;
                total_time += out_min - in_min;              
            }
            
            int price = fees[1];
            if (total_time - fees[0] > 0) {
                price += ceil(((double)total_time - (double)fees[0]) / (double)fees[2]) * fees[3];
            }  
            answer.push_back(price);
            total_time = 0;
        }
        current = lines[i];
    }
    
    if (i == lines.size()) {
        if (current.inout == "IN") {
            int in_hour = stoi(split(current.time, ':').at(0));
            int in_min = stoi(split(current.time, ':').at(1));
            int out_hour = 23;
            int out_min = 59;

            total_time += (out_hour - in_hour) * 60;
            total_time += out_min - in_min;              
        }

        int price = fees[1];
        if (total_time - fees[0] > 0) {
            price += ceil(((double)total_time - (double)fees[0]) / (double)fees[2]) * fees[3];
        }  
        answer.push_back(price);
    }
    
    return answer;
}
