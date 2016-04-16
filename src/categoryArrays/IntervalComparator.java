package categoryArrays;

import java.util.Comparator;

/**
 * Created by Vinod on 4/4/2016.
 */
public class IntervalComparator implements Comparator<MergeOverlappingIntervals.Interval> {

    @Override
    public int compare(MergeOverlappingIntervals.Interval o1, MergeOverlappingIntervals.Interval o2) {
        return o1.start - o2.start;
    }
}
