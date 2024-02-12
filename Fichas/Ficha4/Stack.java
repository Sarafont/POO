package Ficha4;

import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;
    
    public Stack(){
        this.stack = new ArrayList<>();
    }

    public Stack(ArrayList<String> st){
        this.stack = st;
    }

    public Stack(Stack s){
        this(s.stack);
    }

    public boolean equals (Object o){
        if(this == o){
            return true;
        } 
        if((o == null) || (this.getClass() != o.getClass())){
            return false;
        }
        Stack s = (Stack) o;
        return this.stack.equals(s.stack);
    }


    public String toString(){
        return this.stack.toString();
    }


    public Stack clone(){
        return new Stack(this);
    }

    // (a)
    public String top(){
        return this.stack.get(this.stack.size() - 1);
    }

    // (b)
    public void push(String s){
        //não era necessario pq por default insere sempre no topo
        int stackSize = this.stack.size();
        this.stack.add(stackSize-1, s);
    }

    // (c)
    public void pop(){
        int lastIndex = this.stack.size() - 1;
        this.stack.remove(lastIndex);
    }

    // (d)
    public boolean empty(){
        return this.stack.isEmpty();
    }

    // (e)
    int length(){
        return this.stack.size();
    }
}
