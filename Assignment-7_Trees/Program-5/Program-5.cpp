/*Q7) 5) Write a Program to create a Binary Tree and perform following
Nonrecursive operations on it. a. Inorder Traversal b. Preorder Traversal
c. Display Number of Leaf Nodes d. Mirror Im */

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

// A) Inorder traversal 
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


//B) Preorder Traversal
//Pre : root -> left -> right
void preorder(Node* root){
    if(!root){
        return;
    }

    stack<Node*> s;
    s.push(root);

    cout<<"Preorder Traversal : ";
    while(!s.empty()){
        Node* curr = s.top();

        s.pop();

        cout << curr->data << " ";

        if(curr->right){
            s.push(curr->right);
        }   
        if(curr->left){
            s.push(curr->left);
        }
    }
    cout<<endl;
}

//B) Post order traversal
//Post oder : Left -> Right -> Root
void postorder(Node* root){
    if(!root){
        return;
    }

    stack<Node*> s1, s2;
    s1.push(root);

    cout<<"Postorder Traversal : ";
    while(!s1.empty()){
        Node* curr = s1.top();
        s1.pop();
        s2.push(curr);

        if(curr->left){
            s1.push(curr->left);
        }
        if(curr->right){
            s1.push(curr->right);
        }
    }

    while(!s2.empty()){
        cout<<s2.top()->data<<" ";
        s2.pop();
    }


    cout<<endl;
}

//C) No. of nodes
//C) Display the number of leaf nodes
int countLeafNodes(Node* root){
    if(!root){
        return 0;
    }

    int count = 0;
    stack<Node*> s;
    s.push(root);

    while(!s.empty()){
        Node* curr = s.top();
        s.pop();

        if(!curr->left && !curr->right){
            count++;
        }

        if(curr->right){
            s.push(curr->right);
        }
        if(curr->left){
            s.push(curr->left);
        }
    }
    return count;
}

//C ) Display the height of the binary tree
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

int countNodes(Node* root) {
    if (!root) return 0;

    int count = 0;
    stack<Node*> s;
    s.push(root);

    while (!s.empty()) {
        Node* curr = s.top();
        s.pop();
        count++;

        if (curr->right) s.push(curr->right);
        if (curr->left) s.push(curr->left);
    }
    return count;
}

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

    cout<<"A) Inorder Traversal : "<<endl;
    inorder(root);
    cout<<"B) Preorder Traversal : "<<endl;
    preorder(root);
    cout<<"C)Display Number of Leaf Nodes : "<<countLeafNodes(root)<<endl;
    cout<<"D) Mirror : (in inorder)"<<endl;
    mirror(root);
    inorder(root);


    // preorder(root);
    // postorder(root);
    // cout << "Total number of nodes : " << countNodes(root) << endl;
    // cout << "Number of leaf nodes : " << countLeafNodes(root) << endl;
    // preorder(root);
    // cout<<endl;
    // postorder(root);
    // cout<<endl;
    // inorder(root);
    // cout<<endl;
    // cout << "Preorder : " << preorder(root)<<endl;
    // cout << postorder(root)<<endl;

    return 0;
}