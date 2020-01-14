/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    
    ListNode* _addInternal(ListNode* l1, ListNode* l2, int carry) {
        ListNode *result = new ListNode(0);
        int value = 0;
        int next_carry = 0;
        ListNode *l1Next = NULL;
        ListNode *l2Next = NULL;
        
        if (l1 == NULL && l2 == NULL) {
            if(carry == 1) 
                value = 1;
            else
                return NULL; 
        }       
        else if (l1 == NULL) { 
            l2Next = l2->next;
            value = l2->val + carry;
        }
        else if (l2 == NULL) {
            l1Next = l1->next;
            value = l1->val + carry;
        }
        else {
            l1Next = l1->next;
            l2Next = l2->next;
            value = l1->val+l2->val + carry;
        }
        
        if (value >= 10) {
            value = value - 10;
            next_carry = 1;
        }
        
        result->val = value;
        result->next = _addInternal(l1Next, l2Next, next_carry);
        return result;
    }
         
    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        return _addInternal(l1, l2, 0);
    }
               
};
