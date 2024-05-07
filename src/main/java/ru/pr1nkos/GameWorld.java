package ru.pr1nkos;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class GameWorld {
    @Getter
    public static final Map<Coordinate, List<GameObject>> game =
            Map.ofEntries(
                    Map.entry(new Coordinate(1, 1), List.of(new GameObject(200, races.ELF), new GameObject(205, races.GNOME))),
                    Map.entry(new Coordinate(2, 1), List.of(new GameObject(400, races.DWARF), new GameObject(4200, races.ORK))),
                    Map.entry(new Coordinate(3, 1), List.of(new GameObject(350, races.DWARF), new GameObject(355, races.TROLL))),
                    Map.entry(new Coordinate(1, 2), List.of(new GameObject(2400, races.HUMAN), new GameObject(325, races.HUMAN))),
                    Map.entry(new Coordinate(2, 2), List.of(new GameObject(5400, races.HUMAN), new GameObject(2300, races.ORK))),
                    Map.entry(new Coordinate(3, 2), List.of(new GameObject(1350, races.ELF), new GameObject(6050, races.GNOME))),
                    Map.entry(new Coordinate(1, 3), List.of(new GameObject(7400, races.GNOME), new GameObject(300, races.TROLL))),
                    Map.entry(new Coordinate(2, 3), List.of(new GameObject(2356, races.HUMAN), new GameObject(1600, races.ORK))),
                    Map.entry(new Coordinate(3, 3), List.of(new GameObject(1350, races.ELF), new GameObject(4000, races.DWARF)))
            );

}
