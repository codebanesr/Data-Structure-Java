package interview.crackingthecodinginterview;
class NextGreaterElement {
	public static void main(String argos[]) {
	
    }

    public static String solve(String num) {
        for (int i = num.length() - 2; i >= 0; i--) {
            // 45687
            // if there is a number after i is greater than i; if there's more than one pick the smallest
            int smallestIndex = findSmallestAfteri(num, i);

            if (smallestIndex != -1) {
                num = swap(num, i, smallestIndex);
                break;
            }
        }

        return num;
    }
    
    public static String swap(String num, int a, int b) {
        num = num.substring(0, a) + num.substring(a + 1, num.length());
        return num;
    }



    public static int findSmallestAfteri(String num, int index) {
        int smallestSoFar = Integer.MAX_VALUE;
        int smallestNumIndex = -1;
        int n = Integer.parseInt(num.charAt(index)+"");
        for(int i=index+1; i<num.length(); i++) {
            if(Integer.parseInt(num.charAt(i)+"") > n && Integer.parseInt(num.charAt(i)+"")<smallestSoFar) {
                smallestSoFar = num.charAt(i);
                smallestNumIndex = i;
            }
        }
        return smallestNumIndex;
    }
}
