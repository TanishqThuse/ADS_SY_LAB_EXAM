/*Q7) 2) Write a Program to create a Binary Tree and perform following
nonrecursive operations on it. a. Levelwise display b. Mirror image c.
Display height of a tree.*/

#include <iostream>
#include <stack>
#include <queue>

using namespace std;

// Define the structure of a binary tree node
struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int value) {
        data = value;
        left = right = nullptr;
    }
};

//preorder traversal (non - recusive)
//NLR ( left -> root -> right)
void inorder(Node* root) {
    if (!root) return;

    stack<Node*> s;
    Node* curr = root;

    cout << "Inorder Traversal: ";
    
    while (curr != nullptr || !s.empty()) {
        while (curr != nullptr) {
            s.push(curr);
            curr = curr->left;
        }
        
        curr = s.top();
        s.pop();

        cout << curr->data << " ";
        
        curr = curr->right;
    }

    cout << endl;
}

//A) Level wise Display --> AKA BFS
void levelWiseDisplay(Node* root){
    if(!root){
        return;
    }

    queue<Node*> q;
    q.push(root);

    cout<<"Level Wise Display : "<<endl;
    while(!q.empty()){
        int size = q.size();

        while(size-->0){
            Node* curr = q.front();
            q.pop();

            cout<<curr->data<<" ";

            if(curr->left){
                q.push(curr->left);
            }
            if(curr->right){
                q.push(curr->right);
            }
        }
        cout<<"\n";
    }
}


//B Mirror
void mirror(Node* root){
    if(!root){
        return;
    }

    queue<Node*> q;
    q.push(root);

    while(!q.empty()){
        Node* curr = q.front();
        q.pop();

        swap(curr->left, curr->right);

        if(curr->left){
            q.push(curr->left);
        }
        if(curr->right){
            q.push(curr->right);
        }
    }
}


//C) Display the height of the binary tree
int treeHeight(Node* root){
    if(!root){
        return 0;
    }

    int height = 0;
    queue<Node*> q;
    q.push(root);

    while(!q.empty()){
        int size = q.size();
        height++;

        while(size--){
            Node* curr = q.front();
            q.pop();

            if(curr->left){
                q.push(curr->left);
            }
            if(curr->right){
                q.push(curr->right);
            }
        }
    }
    return height;
}

// Main function to test the binary tree
int main() {
    // Create the binary tree
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->left = new Node(6);
    root->right->right = new Node(7);

    // Perform operations

    cout<<"A) LevelWise display : "<<endl;
    // inorder(root);
    levelWiseDisplay(root);
    cout<<"B) Mirror (printing in inorder fashion): "<<endl;
    mirror(root);
    inorder(root);
    cout<<"C)Display height : "<<treeHeight(root)<<endl;

    return 0;
}