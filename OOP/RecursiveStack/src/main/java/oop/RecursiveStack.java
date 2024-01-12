package oop;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 * A Recursive Stack is a stack (LIFO)
 * that is immutable.
 * @param <E>
 */
public class RecursiveStack<E>  implements Iterable<E> {

    final E e;
    final RecursiveStack<E> next;

    /**
     * Creates an empty stack
     */
    public RecursiveStack() {
        // TODO
        this.e = null;
        this.next = null;
    }

    /**
     * Create a stack with e on top and next as the next stack.
     * The next is unchanged.
     *
     * @param e the element to put on top
     * @param next the following stack
     */
    private RecursiveStack(E e, RecursiveStack<E> next) {
        // TODO
        this.e = e;
        this.next = next;
    }

    /**
     * Creates and return a new stack with e on top and the
     * current stack at the bottom.
     * The current stack is unchanged.
     *
     * @param e the element to place on top
     * @return the new stack
     */
    public RecursiveStack<E> add(E e) {
        // TODO
        return new RecursiveStack<>(e, this);
    }

    /**
     * Returns the element on top of the stack
     *
     * @throws EmptyStackException if the stack is empty
     * @return the element on top of the stack
     */
    public E top() {
        // TODO
        if (size() == 0) throw new EmptyStackException();
        return this.e;
    }

    /**
     * Return the stack with element on top removed.
     * The current stack is unchanged.
     *
     * @return the stack with the top element removed
     */
    public RecursiveStack<E> removeTop() {
        // TODO
        if (size() == 0) throw new EmptyStackException();
        return this.next;
    }

    /**
     * Computes the number of elements in the stack
     *
     * @return the number of element in the stack
     */
    public int size() {
        // TODO
        return this.next == null ? 0 : this.next.size() + 1;
    }

    /**
     * Reverse the stack.
     * The current stack is unchanged.
     *
     * @return a reversed version of the current stack (the top element becomes the bottom one)
     */
    public RecursiveStack<E> reverse() {
        // TODO
        if (this.next == null) return this;
        RecursiveStack<E> inverted = new RecursiveStack<>();
        for (E e: this){
            inverted = inverted.add(e);
        }
        return inverted;

    }

    /**
     * Creates a top-down iterator on the stack
     * The delete is not implemented
     *
     * @return the top-down iterator.
     */
    @Override
    public Iterator<E> iterator() {
        // TODO: think about implementing an inner class
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {

        private RecursiveStack<E> stack = RecursiveStack.this; // .this reference to the instance of the outer class

        @Override
        public boolean hasNext() {
            return stack.next != null;
        }

        @Override
        public E next() {
            E e = stack.e;
            stack = stack.next;
            return e;
        }
    }
}
