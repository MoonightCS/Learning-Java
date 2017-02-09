package com.javarush.task.task24.task2413;

/*
Арканоид(8)
Но и это еще не все.
Классу BaseObject нужны еще методы.
Пока это будут пустые методы draw(Canvas canvas) и move().
Классы-наследники должны будут переопределить их у себя и реализовать необходимую функциональность (пока можешь оставить их пустыми, просто чтобы код компилировался).
Объяви эти методы, но сделай их абстрактными.
Также сделай абстрактным сам класс BaseObject.

А еще нам нужно будет определять попал шарик в кирпич или в подставку.
Это будем делать так:
В этом же классе, создадим специальный метод: boolean isIntersec(BaseObject o)
Он будет определять — «пересеклись» объекты или нет. Если пересеклись — возвращать true, если нет — false.

Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия
Если центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.

Или еще проще:
дистанция_между_объектами <= max (радиус_первого_объекта, радиус_второго_объекта)
 */

public abstract class BaseObject {

    private double x;
    private double y;
    private double radius;

    public boolean isIntersec(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double realDest = Math.sqrt(dx * dx + dy * dy);
        double dest = Math.max(radius, o.radius);
        return realDest <= dest;
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

//    private double findDistance(BaseObject o1, BaseObject o2) {
//        double xDif = o2.getX() - o1.getX();
//        double yDif = o2.getY() - o2.getY();
//        return Math.sqrt(xDif * xDif + yDif * yDif);
//    }
}
