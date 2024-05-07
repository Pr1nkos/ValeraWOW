package ru.pr1nkos;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Отправить гоблина на разведку рас
        sendGoblinToScoutFactions();

        // Пересчитать сокровища драконьей пещеры
        recountTreasuresInDragonCave();

        // Отыскать хитрого гнома по координате X = 2
        findCraftyGnomeByCoordinateX(2);

        // Отыскать бородатого эльфа по координате y = 2
        findBeardedElfByCoordinateY(2);

        // Найти тролля с несамым красивым сундуком на карте
        findRichObjectByIndex(3);

        // Подсчитать золото по расам
        countGoldByFaction(races.GNOME);

        // Найти героя с несамым блестящим снаряжением на каждой клетке
        findHeroWithShiniestGearOnWorld(2);

    }

    private static void findHeroWithShiniestGearOnWorld(int index) {
        Map<Coordinate, GameObject> secondOnCoordinateByGold = GameWorld
                .getGame()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .sorted(Comparator.comparingInt(GameObject::getGold)
                                        .reversed())
                                .skip(index -1)
                                .findFirst()
                                .orElseThrow()
                ));
        secondOnCoordinateByGold.forEach((coordinate, gameObject) -> {
            System.out.print("Прошу поклониться великому и могущественному Герою на координатах: " + "[x = "
                    + coordinate.getX() + " y = "
                    + coordinate.getY()
                    + "]  "
                    + index
                    + "-й  по количеству золота объект  -------->  ");
            System.out.println(gameObject);
        });
    }

    private static void countGoldByFaction(races raceToCompare) {
        Integer countGoldByRace = GameWorld
                .getGame()
                .values()
                .stream()
                .flatMap(List::stream)
                .filter(gameObject -> gameObject.getRace() == raceToCompare)
                .mapToInt(GameObject::getGold)
                .sum();
        System.out.println("Сколько золота собрала раса " + raceToCompare + "? Не скажу, но это много!" + " (" +countGoldByRace + ")");
    }

    private static void findRichObjectByIndex(int index) {
        GameObject foundByIndex = GameWorld
                .getGame()
                .values()
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(GameObject::getGold).reversed())
                .skip(index - 1)
                .findFirst()
                .orElseThrow();
        System.out.println("Поищи третьего по богатству. Он будет куда интереснее!" + " ("+foundByIndex+")");
    }

    private static void findCraftyGnomeByCoordinateX(int xCoordinateToCount) {

        Integer countByCoordinateX = GameWorld.getGame()
                .keySet()
                .stream()
                .filter(coordinate -> coordinate.getX() == xCoordinateToCount)
                .mapToInt(entry -> entry.getX())
                .sum();
        System.out.println("Может, на координатах X = 2 спрятался Гном? Хитрец, знаешь ли!" + " (Количество объектов: " +countByCoordinateX + ")");

    }

    private static void findBeardedElfByCoordinateY(int yCoordinateToCount) {
        Integer countByCoordinateY = (int) GameWorld.getGame()
                .keySet()
                .stream()
                .filter(coordinate -> coordinate.getX() == yCoordinateToCount)
                .mapToInt(entry -> entry.getY())
                .sum();

        System.out.println("А что там на координате Y = 2? Возможно, там где-то бродит бородатый Эльф!" + " (Количество объектов: " +countByCoordinateY + ")");
    }

    private static void recountTreasuresInDragonCave() {
        Integer AllGold = GameWorld.getGame()
                .values()
                .stream()
                .flatMap(List::stream)
                .mapToInt(GameObject::getGold)
                .sum();
        System.out.println("Общее количество золота в драконьей пещере? Сколько душа пожелает!" + " (" +AllGold + ")");
    }

    private static void sendGoblinToScoutFactions() {
        List<races> races = GameWorld
                .getGame()
                .values()
                .stream()
                .flatMap(List::stream)
                .map(GameObject::getRace)
                .toList();
        System.out.println("Отправляем гоблина на разведку рас: " + races);
    }

}





