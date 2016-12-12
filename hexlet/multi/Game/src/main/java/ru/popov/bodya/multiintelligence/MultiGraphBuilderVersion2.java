package ru.popov.bodya.multiintelligence;

import ru.popov.bodya.pojo.GraphNode;
import ru.popov.bodya.pojo.XOField;

import java.util.*;
import java.util.concurrent.*;

public class MultiGraphBuilderVersion2 {

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public GraphNode build(final XOField.Figure currentFigure, final XOField currentField, final int deepLevel) {
        if (deepLevel > 4) {
            return new GraphNode(currentField, Collections.emptySet());
        }

        final List<Future> futures = new ArrayList<>();
        final XOField.Figure nextFigure = currentFigure == XOField.Figure.O ? XOField.Figure.X : XOField.Figure.O;
        final Set<GraphNode> children = new HashSet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) {
                    continue;
                }
                final XOField newField = new XOField(currentField);
                newField.setFigure(x, y, nextFigure);

                final Future<?> future = EXECUTOR_SERVICE.submit(new Runnable() {
                    @Override
                    public void run() {
                        children.add(build(nextFigure, newField, deepLevel + 1));
                    }
                });
                //final Future<?> future1 = EXECUTOR_SERVICE.submit(() -> children.add(build(nextFigure, newField, deepLevel + 1)));
                futures.add(future);
            }
        }
        for (Future<?> future: futures) {
            try {
                future.get();
            } catch (final InterruptedException | ExecutionException e) {
                throw  new RuntimeException(e);
            }
        }
        return new GraphNode(currentField, children);
    }
}
