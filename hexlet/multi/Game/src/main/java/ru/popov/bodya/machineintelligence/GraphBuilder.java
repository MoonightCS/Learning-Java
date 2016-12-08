package ru.popov.bodya.machineintelligence;

import ru.popov.bodya.pojo.GraphNode;
import ru.popov.bodya.pojo.XOField;

import java.util.HashSet;
import java.util.Set;

public class GraphBuilder {

    public GraphNode build(final XOField.Figure currentFigure, final XOField currentField) {
        final XOField.Figure nextFigure = currentFigure == XOField.Figure.O ? XOField.Figure.X : XOField.Figure.O;
        final Set<GraphNode> children = new HashSet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) == null) {
                    final XOField newField = new XOField(currentField);
                    newField.setFigure(x, y, nextFigure);
                    children.add(build(nextFigure, newField));
                }
            }

        }
        return new GraphNode(currentField, children);
    }
}
