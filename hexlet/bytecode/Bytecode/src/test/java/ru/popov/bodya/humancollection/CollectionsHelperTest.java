package ru.popov.bodya.humancollection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CollectionsHelperTest {

    private List<Human> list;
    private  CollectionsHelper<Human> collectionsHelper;

    @Before
    public void initList(){
        list = new ArrayList<>();
        collectionsHelper = new CollectionsHelper<>();

        list.add(new Man("Dima"));
        list.add(new Woman("Maryna"));
        list.add(new Man("Bodya"));
        list.add(new Man("Bor"));
    }

    @Test (expected = NoSuchElementException.class)
    public void ckeckNoSuchElementException(){
       collectionsHelper.findFirst(list, "g", Sex.M);
    }

    @Test public void ckeckHuman(){
        Assert.assertEquals("Bodya", collectionsHelper.findFirst(list, "Bo", Sex.M).toString());
    }

}