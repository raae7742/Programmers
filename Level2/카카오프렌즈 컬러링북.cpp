#include <vector>
#include <stack>
#include <iostream>
#include <utility>

using namespace std;

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    stack<pair<int, int>> s;
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    bool visited[100][100] = { false };
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (visited[i][j] == false && picture[i][j] != 0) {
                s.push(make_pair(i, j));
                visited[i][j] = true;
                number_of_area++;
                int size_of_one_area = 0;
                
                while (s.size() != 0) {
                    pair<int, int> current = s.top();
                    int x = current.first;
                    int y = current.second;
                    s.pop();
                    size_of_one_area++;
                    
                    if (x > 0) {
                        if (picture[x-1][y] == picture[x][y] && visited[x-1][y] == false) {
                            s.push(make_pair(x-1, y));
                            visited[x-1][y] = true;
                        }
                    }
                    
                    if (x < m-1) {
                        if (picture[x+1][y] == picture[x][y] && visited[x+1][y] == false) {
                            s.push(make_pair(x+1, y));
                            visited[x+1][y] = true;
                        }
                    }
                    
                    if (y > 0) {
                        if (picture[x][y-1] == picture[x][y] && visited[x][y-1] == false) {
                            s.push(make_pair(x, y-1));
                            visited[x][y-1] = true;
                        }
                    }
                    
                    if (y < n-1) {
                        if (picture[x][y+1] == picture[x][y] && visited[x][y+1] == false) {
                            s.push(make_pair(x, y+1));
                            visited[x][y+1] = true;
                        }
                    } 
                }
                
                if (max_size_of_one_area < size_of_one_area) {
                    max_size_of_one_area = size_of_one_area;
                }
            }
        }
    }
    
    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    
    return answer;
}
