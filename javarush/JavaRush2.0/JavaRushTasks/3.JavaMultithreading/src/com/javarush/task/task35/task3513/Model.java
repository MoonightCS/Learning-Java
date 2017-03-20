package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score = 0;
    protected int maxTile = 2;

    public Model() {
        resetGameTiles();
    }

    public static void main(String[] args) {
        Model model = new Model();
        Tile[] tiles = new Tile[]{
                new Tile(2),
                new Tile(4),
                new Tile(8),
                new Tile(16)};
        System.out.println(model.compressTiles(tiles));
        System.out.println(model.mergeTiles(tiles));
        for (int i = 0; i < FIELD_WIDTH; i++) {
            System.out.print(tiles[i].value + " ");
        }
    }

    protected void left() {
        boolean isCompressed = false;
        boolean isMerged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            isCompressed = compressTiles(gameTiles[i]) || isCompressed;
            isMerged = mergeTiles(gameTiles[i]) || isMerged;
        }
        if (isCompressed || isMerged) {
            addTile();
        }
    }


    private boolean mergeTiles(Tile[] tiles) {
        boolean isArrayChanged;
        Queue<Tile> queue = new ArrayDeque<>(FIELD_WIDTH);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].value != 0 && (i < FIELD_WIDTH - 1) && tiles[i].value == tiles[i + 1].value) {
                int value = tiles[i].value * 2;
                maxTile = maxTile < value ? value : maxTile;
                score += value;
                queue.offer(new Tile(value));
                i++;
            } else {
                queue.offer(tiles[i]);
            }
        }
        isArrayChanged = (queue.size() != 4 && queue.size() != 0);
        if (!isArrayChanged) {
            return false;
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!queue.isEmpty()) {
                tiles[i] = queue.poll();
            } else {
                tiles[i] = new Tile();
            }
        }
        return true;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isArrayChanged = false;
        Tile[] testArray = new Tile[FIELD_WIDTH];

        Queue<Tile> queue = new ArrayDeque<>(FIELD_WIDTH);
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].value != 0) {
                queue.offer(tiles[i]);
            } else {
                testArray[i] = tiles[i];
            }
        }

        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!queue.isEmpty()) {
                testArray[i] = queue.poll();
            }
        }

        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i] != testArray[i]) {
                tiles[i] = testArray[i];
                isArrayChanged = true;
            }
        }
        return isArrayChanged;
    }

    protected void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() == 0) {
            return;
        }
        int randomIndex = (int) (emptyTiles.size() * Math.random());
        Tile tile = emptyTiles.get(randomIndex);
        tile.value = Math.random() < 0.9 ? 2 : 4;
    }

    private List<Tile> getEmptyTiles() {

        List<Tile> emptyTiles = new ArrayList<>();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }
}
