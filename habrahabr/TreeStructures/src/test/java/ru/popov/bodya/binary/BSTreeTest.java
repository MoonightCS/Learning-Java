package ru.popov.bodya.binary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTreeTest {

    private BSTree<Integer, String> bsTree;
    
    @Before
    public void initTree(){
        bsTree = new BSTree<Integer, String>();
        bsTree.add(10, "Bodya");
        bsTree.add(5, "Maryana");
        bsTree.add(35, "Dima");
        bsTree.add(1, "Alex");
        bsTree.add(20, "Bob");
        bsTree.add(99, "Julia");
        bsTree.add(4, "Marina");
        bsTree.add(17, "Luis");
        bsTree.add(31, "Tony");
    }

    @Test
    public void checkingRemoveMethod(){
        Assert.assertEquals(true,bsTree.containsKey(99));
        Assert.assertEquals(false,bsTree.containsKey(98));
        bsTree.remove(99);
        Assert.assertEquals(false,bsTree.containsKey(99));
    }

}