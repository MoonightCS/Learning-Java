package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Тебе необходимо реализовать:
1. метод add(String s) — добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName), искать место для вставки начинаем слева направо.
2. метод remove(String s) — удаляет элемент дерева имя которого было полученного в качестве параметра.
3. метод size() — возвращает текущее количество элементов в дереве.
4. метод getParent(String s) — возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.

*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    @Override
    public boolean add(String s) {
        if (root == null) {
            root = new Entry<>(s);
            return true;
        }
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        boolean isAdded = false;
        while (!isAdded && !queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild != null) {
                queue.add(currentEntry.leftChild);
            } else {
                if (!isAdded && currentEntry.availableToAddLeftChildren) {
                    Entry<String> newEntry = new Entry<>(s);
                    newEntry.parent = currentEntry;
                    currentEntry.leftChild = newEntry;
                    isAdded = true;
                    currentEntry.checkChildren();
                }
            }
            if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild != null) {
                queue.add(currentEntry.rightChild);
            } else {
                if (!isAdded && currentEntry.availableToAddRightChildren) {
                    Entry<String> newEntry = new Entry<>(s);
                    newEntry.parent = currentEntry;
                    currentEntry.rightChild = newEntry;
                    isAdded = true;
                    currentEntry.checkChildren();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 0;
    }
}
