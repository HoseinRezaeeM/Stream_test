package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Car> carList =new ArrayList<>();
        carList.add(new Car("pegout","red",15000));
        carList.add(new Car("benz","black",12000));
        carList.add(new Car("bmw","white",18000));
        carList.add(new Car("bmw","white",18000));
//        Map<Integer ,Object> stringCarMap =carList.stream().collect(Collectors.toMap(Car::getPrice,Car-> Car.getName()));
//        System.out.println(stringCarMap);
        carList.stream().map(s ->s.length()).reduce((a,b)->(a+b))
        carList.stream().distinct().forEach(System.out::println);


        final long count = carList.stream().count();
        System.out.println(count);
        Optional<Integer> optionalInteger =carList.stream().map(Car::getPrice).reduce((price1,price2)->(price1+price2));
        optionalInteger.ifPresent(System.out::println);

        carList.stream().map(Car::getColor);
        carList.stream().skip(1).forEach(System.out::println);
        carList.forEach(System.out::println);
        carList.stream().sorted((a,b)->a.getPrice()- b.getPrice()).forEach(System.out::println);
        carList.stream().parallel().filter(a->"red".equals(a.getColor())).sorted(Comparator.comparingInt(Car::getPrice)).limit(1).forEach(System.out::println);
    }
}
