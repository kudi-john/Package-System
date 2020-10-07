import java.util.*;
public class city {
    private static List<String> closestStraightCity(int numOfCities, List<String> cities,
                                                    List<Integer> xCoordinates,
                                                    List<Integer> yCoordinates,
                                                    int numOfQueries,
                                                    List<String> queries) {

        Map<String, Integer> name = new HashMap<>();
        Map<Integer, List<Integer>> xx = new HashMap<>();
        Map<Integer, List<Integer>> yy = new HashMap<>();
        for (int i = 0; i < cities.size(); i++) {
            name.put(cities.get(i), i);
            int x = xCoordinates.get(i);
            int y = yCoordinates.get(i);
            if (xx.get(x) == null) {
                xx.put(x, new LinkedList<>());
            }
            xx.get(x).add(i);
            if (yy.get(y) == null) {
                yy.put(y, new LinkedList<>());
            }
            yy.get(y).add(i);
        }
        List<String> result = new LinkedList<>();
        for (String queryName : queries) {
            int iii = name.getOrDefault(queryName, -1);
            if (iii == -1) {
                result.add("NONE");
                continue;
            }
            int x = xCoordinates.get(iii);
            int y = yCoordinates.get(iii);
            String r = "NONE";
            int distance = Integer.MAX_VALUE;
            for (int m : xx.getOrDefault(x, new LinkedList<>())) {
                if (m == iii) {
                    continue;
                }
                int delta = Math.abs(yCoordinates.get(m) - yCoordinates.get(iii));
                if (delta < distance) {
                    r = cities.get(m);
                    distance = delta;
                } else if (delta == distance) {
                    if (cities.get(m).compareTo(r) < 0) {
                        r = cities.get(m);
                    }
                }
            }
            for (int m : yy.getOrDefault(y, new LinkedList<>())) {
                if (m == iii) {
                    continue;
                }
                int delta = Math.abs(xCoordinates.get(m) - xCoordinates.get(iii));
                if (delta < distance) {
                    r = cities.get(m);
                    distance = delta;
                } else if (delta == distance) {
                    if (cities.get(m).compareTo(r) < 0) {
                        r = cities.get(m);
                    }
                }
            }
            result.add(r);
        }
        return result;
    }

    public static void main(String[] args) {
        // c3, NONE, c1
        List<String> citis = Arrays.asList(new String[]{"c1", "c2", "c3"});
        List<Integer> x = Arrays.asList(new Integer[]{3, 2, 1});
        List<Integer> y = Arrays.asList(new Integer[]{3, 2, 3});
        List<String> queries = Arrays.asList(new String[]{"c1", "c2", "c3"});
        List<String> result = closestStraightCity(citis.size(), citis, x, y, queries.size(),
                queries);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("");
        // c2, c1, c1, c1, c6, c5, NONE, c6
        citis = Arrays.asList(new String[]{"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"});
        x = Arrays.asList(new Integer[]{4, 4, 2, 4, 6, 6, 5, 3});
        y = Arrays.asList(new Integer[]{3, 5, 3, 1, 3, 4, 2, 4});
        queries = Arrays.asList(new String[]{"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"});
        result = closestStraightCity(citis.size(), citis, x, y, queries.size(), queries);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("");
    }
}

