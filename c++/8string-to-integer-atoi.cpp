class Solution {
public:
    int myAtoi(string str) {
        str.erase(0, str.find_first_not_of(" "));
        long result = 0;
        int sign = 0;
        for(int i = 0; i < str.length(); i++){
            if(i == 0) {
                if(str[i] == '+')  
                    sign = 1;
                else if(str[i] == '-') 
                    sign = -1;
                else if(str[i] >= '0' &&  str[i] <= '9') 
                    result = str[i] - '0';
                else return 0;
                continue;
            }
            if(str[i] < '0' || str[i] > '9' )
                break;
            if(i == 1) {
                if(sign == 0) 
                    result = result *10 + str[i] - '0';
                else
                    result = sign * (str[i]- '0');
                continue;
            }
            
            if(sign == 0) sign = 1;
            if(str[i] >= '0' && str[i] <= '9' )
                result = result * 10 + sign * (str[i]- '0');   
            if(result >= INT_MAX) {
                result = INT_MAX;
                break;
            }
            if(result <= INT_MIN) {
                result = INT_MIN;
                break;
            } 
        }
        return int(result);
        }
};
