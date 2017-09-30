/*
A class that have all dequeue, enqueue and empty methods.
@Gigi Xiaowan Guo
*/
class ArrayQueue implements Queue{
    int cap;//array length
    int n; //count
    int front, end;
    Object q[];
    public ArrayQueue(){
        cap = 10; //array size is 10 
        n = 0; // 
        q = new Object[10]; 
        front = 0;
        end = -1;
    }
    @Override
    public Object dequeue(){
        if(n == 0)
            return null;
        Object ans = q[front];
        front++;
        if(front > cap - 1)
            front = 0;
        n--;
        if(n == 0){
            front = 0;
            end = -1;
        }
        return ans;
    }
    public void enqueue(Object item){
        if(n < cap){
            end++;
            if(end > cap - 1)end = 0;
            q[end] = item;
            n++;
        }
        else{//n == cap
            Object t[] = new Object[cap * 2]; //grow the array when it is full 
            if(front <= end){
                int i,j;
                for(i = front,j = 0;i <= end;++i,++j)
                    t[j] = q[i];
                t[end+1] = item;
                front = 0;
                end++;
            }
            else{//front > end
                int i,j;
                for(i = front,j = 0;i < cap;i++,j++)
                    t[j] = q[i];
                for(i = 0;i <= end;++i,j++)
                    t[j] = q[i];
                front = 0;
                t[end+1] = item;
                end++;
            }
            q = t;
            n++;
            cap *= 2;
        }//end else n == cap
    }//end enqueue
    public boolean empty(){
        if(n == 0)
            return true;
        else return false;
    }
    
}