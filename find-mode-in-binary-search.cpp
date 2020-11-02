/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{
public:
    std::map<int, int> modes;
    vector<int> findMode(TreeNode *root)
    {
        std::vector<int> highestModes;
        int highestCount = 0;

        // Create a map from the tree where the
        // keys are the node values and the values are
        // the number of times that node value appeared
        if (root != nullptr)
            getModes(root);

        // iterate through the map keys
        for (std::map<int, int>::iterator it = modes.begin(); it != modes.end(); it++)
        {
            int key = it->first;
            int val = it->second;

            // If the number of times a key appears is more than the number of times of
            // the current memoized key(s) (highestModes) appeared, replace the highestModes
            // and the highestCount with the new values
            if (val > highestCount)
            {
                highestCount = val;
                highestModes.clear();
                highestModes.push_back(key);
                // If the number of time key appears is equal, add the key to the
                // highestModes vector
            }
            else if (val == highestCount)
            {
                highestModes.push_back(key);
            }
        }

        return highestModes;
    }

    void getModes(TreeNode *root)
    {
        int tmpVal = root->val;

        modes[tmpVal] = modes[tmpVal] + 1;

        if (root->right != nullptr)
            getModes(root->right);

        if (root->left != nullptr)
            getModes(root->left);
    }
};

/*
Line 49: Char 20: error: invalid operands to binary expression ('int' and 'nullptr_t')
        if (tmpVal != nullptr) {
            ~~~~~~ ^  ~~~~~~~
1 error generated.
*/