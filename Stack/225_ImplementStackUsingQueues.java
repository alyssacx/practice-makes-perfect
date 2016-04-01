/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

class MyStack {

    Queue<Integer> queue;
    Queue<Integer> backupQueue;
    int top;
    public MyStack() {
        queue = new LinkedList<Integer>();
        backupQueue = new LinkedList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) {
        if(empty()) {
            queue.offer(x);
        } else {
            if(queue.size() > 0) {
                backupQueue.offer(x);
                while(!queue.isEmpty())
                    backupQueue.offer(queue.poll());
            } else {
                queue.offer(x);
                while(!backupQueue.isEmpty())
                    queue.offer(backupQueue.poll());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(queue.size() > 0)
             queue.poll();
        else
            backupQueue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.size() > 0 ? queue.peek() : backupQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {

        if(queue.isEmpty() && backupQueue.isEmpty())
            return true;

        return false;
    }
}
