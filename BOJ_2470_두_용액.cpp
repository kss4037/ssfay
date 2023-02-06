#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	
	int size = 0;
	cin >> size;
	string result;
	
	vector<int> vec;
	for(int i=0;i<size;i++){
		int num;
		cin >> num;
		vec.push_back(num);
	}
	
	sort(vec.begin(), vec.end());
	
	pair<int,int> best;
	int best_value = 2000000005;
	
	int left = 0 , right = vec.size()-1;
	while(left < right) {
		int temp_value = vec[left] + vec[right];
		if( abs(temp_value) < best_value){
			best.first = vec[left];
			best.second = vec[right];
			best_value = abs(temp_value);
		}
		
		if(temp_value > 0) {
			right--;
		} else if(temp_value < 0) {
			left++;
		} else {
			break;
		}
	}
	cout << best.first  << " " << best.second << '\n'; 
	return 0;
}
