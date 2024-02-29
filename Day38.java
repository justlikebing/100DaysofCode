import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Meeting {
    int start;
    int end;
    int position;

    public Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

public class Day38 {

    public static int maxMeetings(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        meetings.sort(Comparator.comparingInt(m -> m.end));

        List<Integer> result = new ArrayList<>();
        result.add(meetings.get(0).position);

        int prev_end = meetings.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > prev_end) {
                result.add(meetings.get(i).position);
                prev_end = meetings.get(i).end;
            }
        }

        System.out.println("Maximum number of meetings: " + result.size());
        System.out.println("Meeting positions: " + result);
        return result.size();
    }

    public static void main(String[] args) {
        int N = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        maxMeetings(start, end, N);
    }
}
