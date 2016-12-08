package ru.popov.bodya.multiintelligence;

import ru.popov.bodya.pojo.GraphNode;
import ru.popov.bodya.pojo.XOField;

import java.util.*;

public class MultiGraphBuilderVersion1 {

    public GraphNode build(final XOField.Figure currentFigure, final XOField currentField, final int deepLevel) {
        if (deepLevel > 3)
            return new GraphNode(currentField, Collections.emptySet());
        final List<Thread> threads = new ArrayList<>();
        final XOField.Figure nextFigure = currentFigure == XOField.Figure.O ? XOField.Figure.X : XOField.Figure.O;
        final Set<GraphNode> children = new HashSet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) {
                    continue;
                }
                final XOField newField = new XOField(currentField);
                newField.setFigure(x, y, nextFigure);
                final Thread threadThatAddsChildren = new Thread() {
                    @Override
                    public void run() {
                        children.add(build(nextFigure, newField, deepLevel + 1));
                    }
                };
                threadThatAddsChildren.start();
                threads.add(threadThatAddsChildren);
            }
        }
        for (Thread th: threads) {
            try {
                th.join();
            } catch (final InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return new GraphNode(currentField, children);
    }
}
