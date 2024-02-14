package Queue;

import java.util.*;

public class JobSeqProb {
    static class Job {
        char job_id;
        int deadline;
        int profit;

        Job(char job_id, int deadline, int profit) {
            this.job_id = job_id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static void printJobSchedule(ArrayList<Job> arr) {
        int n = arr.size();
        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });
        ArrayList<Job> res = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    return b.profit - a.profit;
                });

        for (int i = n - 1; i > -1; i--) {
            int slot_avail;
            if (i == 0) {
                slot_avail = arr.get(i).deadline;
            } else {
                slot_avail = arr.get(i).deadline - arr.get(i - 1).deadline;
            }
            maxHeap.add(arr.get(i));
            while (slot_avail > 0 && maxHeap.size() > 0) {
                Job job = maxHeap.remove();
                slot_avail--;
                res.add(job);
            }
        }
        Collections.sort(res, (a, b) -> {
            return a.deadline - b.deadline;
        });
        for (Job job : res) {
            System.out.print(job.job_id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        System.out.println("Following is Maximum " + "Profit Seq of Jobs");
        printJobSchedule(arr);
    }
}
