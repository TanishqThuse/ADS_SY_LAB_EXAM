/*Q3) 4)WAP to accept a string from user and perform following operations on it
Stack using stacks. A. Palindrome B. String Reverse C. String Concat D.String compare*/
//without stl
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#define MAX 100  // Maximum size of the stack

// Define the stack structure for characters
typedef struct {
    char data[MAX];
    int top;
} Stack;

// Initialize the stack
void initStack(Stack* s) {
    s->top = -1;
}

bool isEmpty(Stack* s){
    return s->top == -1;
}

bool isFull(Stack *s){
    return s->top == MAX - 1;
}

void push(Stack *s, char ch){
    if (isFull(s)) {
        printf("Stack Overflow\n");
        return;
    }
    s->top++;
    s->data[s->top] = ch;
}

char pop(Stack *s){
    if(isEmpty(s)){
        printf("Stack Underflow\n");
        return '\0';
    }
    char x = s->data[s->top--];
    return x;
}

//A Palindrome
bool palindrome(char str[]){
    Stack s;
    initStack(&s);
    int len = strlen(str);

    //push all elements on stack
    for(int i=0; i<len; i++){
        push(&s , str[i]);
    }

    //compare the elements popped from stack to original elements
    for(int i=0; i<len; i++){
        if(pop(&s) != str[i]){
            return false;
        }
    }
    return true;
}

//B String Reverse using stack
void reverseString(char str[]){
    Stack s;
    initStack(&s);
    int len = strlen(str);

    // Push all characters onto the stack
    for (int i = 0; i < len; i++) {
        push(&s, str[i]);
    }

    // Pop characters and build the reversed string
    printf("Reversed String: ");
    while (!isEmpty(&s)) {
        printf("%c", pop(&s));
    }

    printf("\n");
}

// C ) Two strings which we need to conactenate using one stack
void concatStrings(char str1[], char str2[]){
    Stack s;
    initStack(&s);
    int len1 = strlen(str1);
    int len2 = strlen(str2);

    // Push all characters of the second string onto the stack from last
    for (int i = len2-1; i >= 0; i--) {
        push(&s, str2[i]);
    }

    // Push all characters of the first string onto the stack 
    for (int i = len1-1; i >=0; i--) {
        push(&s, str1[i]);
    }

    // Pop characters and build the concatenated string
    printf("Concatenated String: ");
    while (!isEmpty(&s)) {
        printf("%c", pop(&s));
    }

    printf("\n");
}

//D COmapre using stack
void compareStrings(char str1[], char str2[]){
    Stack s;
    initStack(&s);
    int len1 = strlen(str1);
    int len2 = strlen(str2);

    // push all elements of string 1 in stack
    for(int i=0; i<len1; i++){
        push(&s, str1[i]);
    }

    //compare the elements popped from stack to original elements of string 2
    for(int i=0; i<min(len1, len2); i++){
        char ch = pop(&s);
        if(ch == str2[i]){
            // printf("Strings are not equal.\n");
            //do nothing
        }
        if(ch != str2[i]){
            printf("Strings are not equal.\n");
            if(ch > str2[i]){
                printf("String 1 is greater than String 2.\n");
            }
            else{
                printf("String 2 is greater than String 1.\n");
            }
        }
    }
    if(len1==len2){
        printf("Strings are equal.\n");
    }
    else{
        printf("Strings are not equal.\n");
        if(len1 > len2){
            printf("String 1 is greater than String 2.\n");
        }
        else{
            printf("String 2 is greater than String 1.\n");
        }
    }
}


int main(){
    char str1[MAX], str2[MAX]; //two strings which we need to compare
    int choice;

    printf("Enter a string: ");
    scanf("%s", str1);

    printf("Choose an operation:\n");
    printf("1. Palindrome Check\n2. Reverse String\n3. Concatenate Strings\n4. Compare Strings\n");
    scanf("%d", &choice);

    switch (choice) {
    case 1:
        if (palindrome(str1))
            printf("The string is a palindrome.\n");
        else
            printf("The string is not a palindrome.\n");
        break;

    case 2:
        //we will print in function itself
        reverseString(str1);
        break;

    case 3:
        printf("Enter another string to concatenate: ");
        scanf("%s", str2);
        concatStrings(str1, str2);
        break;

    case 4:
        printf("Enter another string to compare: ");
        scanf("%s", str2);
        compareStrings(str1, str2);
        break;

    default:
        printf("Invalid choice.\n");
    }

    return 0;
}
