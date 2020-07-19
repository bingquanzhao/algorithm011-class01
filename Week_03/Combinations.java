import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n, k, 1, new Stack<Integer>());
        return result;

    }

    private void findCombinations(int n, int k, int index, Stack<Integer> p) {
        if (p.size() == k) {
            result.add(new ArrayList<Integer>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++){
            p.push(i);
            findCombinations(n,k,i+1,p);
            p.pop();
        }

    }
}

