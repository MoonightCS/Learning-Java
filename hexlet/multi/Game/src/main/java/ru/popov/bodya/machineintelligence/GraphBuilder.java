package ru.popov.bodya.machineintelligence;

import ru.popov.bodya.pojo.GraphNode;
import ru.popov.bodya.pojo.XOField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class GraphBuilder implements Callable<GraphNode> {

    private final ExecutorService executorService;

    private final XOField.Figure nextFigure;

    private final XOField currentFiled;

    private final int deepLevel;

    public GraphBuilder(ExecutorService executorService, XOField.Figure nextFigure, XOField currentFiled, int deepLevel) {
        this.executorService = executorService;
        this.nextFigure = nextFigure;
        this.currentFiled = currentFiled;
        this.deepLevel = deepLevel;
    }

    @Override
    public GraphNode call() throws Exception {
        final List<Future<GraphNode>> futures = new ArrayList<>();
        final Set<GraphNode> children = new CopyOnWriteArraySet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentFiled.getFigure(x, y) != null) {
                    continue;
                }
                final XOField newField = new XOField(currentFiled);
                newField.setFigure(x, y, nextFigure);
                final GraphBuilder graphBuilder = new GraphBuilder(executorService, nextFigure, newField, deepLevel + 1);

            }
        }
    }


}
