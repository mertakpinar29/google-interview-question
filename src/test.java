import java.lang.reflect.Array;
import java.util.ArrayList;

public class test {

    public static boolean arraylistContains(int[] islandCoordinates, ArrayList<int[]> islands){
        for(int[] island: islands) {
            if(island[0] == islandCoordinates[0] && island[1] == islandCoordinates[1])
                return true;
        }
        return false;
    }

    public static ArrayList<int[]> findBorders(int[][] array, ArrayList<int[]> islands) {
        ArrayList<int[]> borders = new ArrayList<>();

        // ilk satırdaki 1'ler
        for(int i = 0; i < array[0].length; i++) {
            if(array[0][i] == 1) {
                int[] border = {0,i};
                borders.add(border);
                islands.add(border);
            }
        }

        // son satırdaki 1'ler
        for(int i = 0; i < array[array.length - 1].length; i++) {
            if(array[array.length-1][i] == 1) {
                int[] border = {array.length-1, i};
                borders.add(border);
                islands.add(border);
            }
        }

        // sol sütundaki 1'ler
        for(int i = 1; i < array.length - 1; i++){
            if(array[i][0] == 1) {
                int[] border = {i,0};
                borders.add(border);
                islands.add(border);
            }
        }

        // sağ sütundaki 1'ler
        for(int i = 1; i < array.length - 1; i++) {
            if(array[i][array.length - 1] == 1) {
                int[] border = {i, array.length - 1};
                borders.add(border);
                islands.add(border);
            }
        }
        return borders;
    }

    public static void findPath(int x, int y, int[][] array, ArrayList<int[]> islands) {
        // yukarıdaki eleman 1 ise
        if(x > 0 && array[x-1][y] == 1) {
            int[] point = { x-1, y };
            if(!arraylistContains(point,islands)) {
                islands.add(point);
                findPath(x-1, y, array, islands);
            }
        }
        // aşağıdaki eleman 1 ise
        if(x < array.length - 1 && array[x+1][y] == 1) {
            int[] point = { x+1, y };
            if(!arraylistContains(point,islands)) {
                islands.add(point);
                findPath(x+1, y, array, islands);
            }
        }
        // soldaki eleman 1 ise
        if(y > 0 && array[x][y-1] == 1) {
            int[] point = { x, y-1 };
            if(!arraylistContains(point,islands)) {
                islands.add(point);
                findPath(x, y-1, array, islands);
            }
        }
        // sağdaki eleman 1 ise
        if(y < array[x].length - 1 && array[x][y+1] == 1) {
            int[] point = { x, y+1 };
            if(!arraylistContains(point,islands)) {
                islands.add(point);
                findPath(x, y+1, array, islands);
            }
        }
    }

    public static int[][] removeIslands(int[][] array) {
        // silinmeyecek bütün 1'lerin koordinatlarını tutacak arraylist
        ArrayList<int[]> islands = new ArrayList<>();
        // sınırlardaki 1'lerin koordinatlarını tutacak arraylist
        ArrayList<int[]> borders = findBorders(array,islands);

        for(int[] border: borders) {
            findPath(border[0], border[1], array, islands);
        }

        int[][] result = new int[array.length][array[0].length];
        for(int[] island: islands) {
            result[island[0]][island[1]] = 1;
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] island = {
                { 1, 0, 0, 0, 0, 0, 1, 0, 0, 1 }, // 0
                { 0, 1, 0, 1, 1, 1, 0, 0, 1, 1 }, // 1
                { 0, 0, 1, 0, 1, 0, 1, 1, 1, 0 }, // 2
                { 1, 1, 0, 0, 1, 0, 0, 0, 0, 0 }, // 3
                { 1, 0, 1, 1, 0, 0, 1, 1, 1, 0 }, // 4
                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
                { 0, 1, 0, 1, 1, 1, 0, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 1, 0, 0, 1, 0, 0, 0, 0, 0 }
        };

        int[][] result = removeIslands(island);

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }
}
