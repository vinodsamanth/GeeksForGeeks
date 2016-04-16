package categoryArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Vinod on 4/4/2016.
 */
public class MergeOverlappingIntervals {
    int num;
    ArrayList<Interval> list;


    class Interval {
        int start;
        int stop;

        public Interval(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }

    public MergeOverlappingIntervals(int num) {
        this.num = num;
        this.list = new ArrayList<Interval>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
    }

    public ArrayList<Interval> mergeIntervals() {
        if (list == null || list.size() <= 1)
            return list;
        Collections.sort(list, new IntervalComparator());
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval cur = list.get(i);

            if (prev.stop >= cur.start) {
                Interval merged = new Interval(prev.start, Math.max(prev.stop, cur.stop));
                prev = merged;
            } else {
                result.add(prev);
                prev = cur;
            }
        }
        result.add(prev);
        return result;
    }

    public ArrayList<Interval> mergeInterval() {
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(list.get(0));
        Collections.sort(list, Collections.reverseOrder());
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Interval cur = stack.peek();
            if (cur.start < list.get(i).stop) {
                stack.pop();
                cur.start = Math.min(cur.start, list.get(i).start);
                stack.push(cur);
            } else {
                stack.push(list.get(i));
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        MergeOverlappingIntervals mergeOI = new MergeOverlappingIntervals(6);
        for (Interval var : mergeOI.list)
            System.out.print(var.start + ", " + var.stop + ", ");
        System.out.println();
        ArrayList<Interval> result = mergeOI.mergeIntervals();
        for (Interval var : result)
            System.out.print(var.start + ", " + var.stop + ", ");
    }

}
