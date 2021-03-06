package medium;

/**
 * @author takaibun
 * <p>
 * 给你一个用字符数组tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * <p>
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的 最短时间 。
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] tackCount = new int[26];
        for (char task : tasks) {
            tackCount[task - 'A']++;
        }
        int max = 0;
        for (int count : tackCount) {
            max = Math.max(max, count);
        }

        int maxCount = 0;
        for (int count : tackCount) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max((n + 1) * (max - 1) + maxCount, tasks.length);
    }
}
