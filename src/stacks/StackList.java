package stacks;

import java.util.*;

public class StackList<E> implements Iterable<E> {

//Attributes

    //A variable called top, which points to the top of the stack.

    private Node top;

//Number of elems in a stack
    private int NumberStacks;

//Class Node
    private class Node {
        Node next;
         E Node;

//constructor for Node
        Node(E data) {
            Node = data;
            next = null;
        }

//included in Node class as we are printing the Node items

        public String toString() {
            return Node.toString();
        }
    }
//A constructor that initializes the class all the attributes

    StackList() {
        // name used to test
        top = null;
        NumberStacks = 0;
    }

//adds item to the top of the stack.

    public void push(E item) {
//instantiate temp object
//use temp to replace top items with new items and pushes the other item below
        Node temp = new Node(item);
        temp.next = top;
        top = temp;
        NumberStacks++;
    }

//This method returns the generic item popped

    public E pop() {

        if (isEmpty())
            return null;

        else {
            Node temp = top;
            top = top.next;
            NumberStacks--;
            return temp.Node;
        }
    }

    //This method clears all object references from the
    //linkedList to empty the StackList instance

    public void clear() {
        top = null;
        NumberStacks = 0;
    }

//The toString() method includes the name of the stack passed by the Navigator class
//plus the number of links in the stack.

    public String toString() {

        Node myNode;

        StringBuilder printStack = new StringBuilder();
        for (myNode = top; myNode != null; myNode = myNode.next) {
            printStack.append(myNode.toString());

            if (size() > 1) {
                printStack.append(", ");
            }

        }
        return printStack.toString();
    }

//This method checks if the top of
//the stack is pointing at something

    public boolean isEmpty() {

        return top == null;
    }

//This method returns the number of elements in the stack.

    public int size() {

        return NumberStacks;
    }

//This class implements an the Iterator interface

    private class StackIterator implements Iterator<E> {
        private Node mCurrent = top;

//This method returns an item to the immediate(next) iterator
//and moves the iterator up one using temp

        public E next() {
            E temp = mCurrent.Node;
            mCurrent = mCurrent.next;
            return temp;

        }

//This boolean method returns true if there is something in the list to
//the immediate right of the iterator otherwise returns false

        public boolean hasNext() {
            return mCurrent != null;

        }

//public void remove() will remove the item that was most recently returned by next()
//throw exception as test file will not use this method

        public void remove() {

            System.out.println("there are no files to remove");
        }

    }

//This class that will return the StackIterator value

    public Iterator<E> iterator() {
        return new StackIterator();
    }


}
