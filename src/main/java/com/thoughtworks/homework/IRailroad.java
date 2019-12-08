
package com.thoughtworks.homework;

import java.util.Set;

public interface IRailroad {
    Railroad addTrack(char startTown, char endTown, int distance);

    Set<Character> getTracksChildKeys(char fromTown);

    Integer distance(char fromTown, char toTown);

     Integer distance(String route);
}
