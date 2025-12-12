package solutions;

import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        Collections.sort(events, (a, b) -> {

            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 == t2) {
                String e1 = a.get(0);
                String e2 = b.get(0);

                int w1 = e1.equals("OFFLINE") ? 0 : 1;
                int w2 = e2.equals("OFFLINE") ? 0 : 1;
                return Integer.compare(w1, w2);

            } else {
                return Integer.compare(t1, t2);
            }
        });

        int[] result = new int[numberOfUsers];
        int[] offline = new int[numberOfUsers];

        for (List<String> event : events) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(event.get(2));
                offline[id] = timestamp + 60;
                continue;
            }

            String mtype = event.get(2);

            if (mtype.equals("ALL")) {
                for (int i = 0; i < numberOfUsers; i++) {
                    result[i]++;
                }
            } else if (mtype.equals("HERE")) {
                for (int i = 0; i < numberOfUsers; i++) {
                    if (offline[i] <= timestamp) {
                        result[i]++;
                    }
                }
            } else {
                String[] ids = mtype.split(" ");

                for (String sID : ids) {
                    int id = Integer.parseInt(sID.substring(2));
                    result[id]++;
                }
            }

        }

        return result;
    }
}
