package lab11;

import java.util.ArrayList;

public class ServiceManagement<T> {
    public static <T extends Hub> T moveArea(T t, String area) {
        t.setArea(area);
        return t;
    }

    public static <T extends Hub> T raisePerBox(T t, double rate) {
        t.setPrice_per_box(t.getPrice_per_box() * rate);
        return t;
    }

    public static <T extends Hub> int findIndexByNum(ArrayList<T> tList, int num) {
        for (T i : tList) {
            if (i.getNumber() == num) {
                return tList.indexOf(i);
            }
        }

        // for (int i = 0; i < tList.size(); i++) {
        // if (tList.get(i).getNumber() == num) {
        // return i;
        // }
        // }
        return -1;
    }

    public static <T extends Hub> ArrayList<T> raiseAll(ArrayList<T> tList, double rate) {
        for (int i = 0; i < tList.size(); i++) {
            tList.get(i).setPrice_per_box(tList.get(i).getPrice_per_box() * rate);
        }
        return tList;
    }
}
