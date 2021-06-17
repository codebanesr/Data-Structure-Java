package interview.sprint1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MaxSumPath {
  public static void main(String args[]) {
    int a[] = { 2, 3, 4, 5, 6, 7, 13, 14, 17 };
    int b[] = { 7, 8, 9, 10, 13 };

    int result = Solve(a, b);
    System.out.println("Found max sum " + result);
  }

  public static int Solve(int a[], int b[]) {
    
    Set<Integer> common = findCommon(a,b);
    
    ArrayList<ArrayList<Integer>> split1 = getSplit(a, common);
    ArrayList<ArrayList<Integer>> split2 = getSplit(b, common);

    int i=0, j=0;
    int answer = 0;
    while(i<split1.size() && j<split2.size()) {
      ArrayList<Integer> part1 = split1.get(i);
      ArrayList<Integer> part2 = split2.get(i);

      if(sum(part1) > sum(part2)) {
        answer = answer+sum(part1);
      } else {
        answer = answer+sum(part2);
      }

      i++;
      j++;
    }

    while(i<split1.size()) {
      answer += sum(split1.get(i++));
    }

    while(j<split2.size()) {
      answer += sum(split2.get(j++));
    }

    for(Integer ce: common) {
      answer += ce;
    }
    return answer;
  }

  public static int sum(ArrayList<Integer> l) {
    int sum = 0;
    for(Integer i: l) {
      sum += i;
    }
    return sum;
  }


  public static Set<Integer> findCommon(int a[], int b[]) {
    Set<Integer> temp = new HashSet<Integer>();
    for(Integer e: a) {
      temp.add(e);
    }

    Set<Integer> common = new HashSet<>();

    for(int some: b) {
      if(temp.contains(some)) {
        common.add(some);
      }
    }
    return common;
  }



  public static ArrayList<ArrayList<Integer>>getSplit(int arr[], Set<Integer> s) {
    ArrayList<ArrayList<Integer>> split = new ArrayList<>();
    
    ArrayList<Integer> temp = new ArrayList<>();
    for(Integer a: arr) {
      if(!s.contains(a)) {
        temp.add(a);
      }else {
        split.add(temp);
        temp = new ArrayList<>();
      }
    }
    split.add(temp);
    return split;
  }
}
