/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        ListNode*  current = head;
        int index = 0, first = -1, previous = -1, last = -1, minDist = INT_MAX;
        while(current->next != NULL && current->next->next != NULL){
            if((current->val > current->next->val && current->next->val < current->next->next->val) || (current->val < current->next->val && current->next->val > current->next->next->val)){
                if(first == -1) first = index+1;
                else minDist = min(minDist, (index+1)-previous);
                previous = index+1;
                last = index+1;
            }
            current = current->next;
            index++;
        }
        
        if(first == last) return {-1,-1};
        return {minDist, last-first};
    }
};