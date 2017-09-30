/*
A class that have all push, pop, peek, and empty methods.
@Gigi Xiaowan Guo
*/
public class ArrayStack implements Stack{
    int n; //array length 
    int cap; //count 
    Object s[];//array 
    int end; 
    public ArrayStack(){
        cap = 10;
        n = 0;
        end = -1;
        s = new Object[10]; //array length is 10
    }
    @Override
    public void push(Object item){
        if(n < cap){
            s[++end] = item;
            n++;
            return;
        }
        
        //n >= cap,if it is full, grow array
        Object t[] = new Object[cap * 2];
        t[++end] = item;
        cap *= 2;
        n++;
        s = t;
    }
    public Object pop(){
        if(n == 0)return null;
        n--;
        Object ans = s[end];
        end--;
        return ans;
    }
    public Object peek(){
        if(n == 0)return null;
        return s[end];
    }
    public boolean empty(){
        return (n == 0);
    }
}