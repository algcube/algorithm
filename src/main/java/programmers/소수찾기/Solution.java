package programmers.소수찾기;


class Solution {

    private static int result = 0;

    public static void main(String[] args) {
        new Solution().solution("17");
    }
    public int solution(String numbers) {
        char[] nums = new char[numbers.length()+1];
        System.arraycopy(numbers.toCharArray(),0,nums,0,numbers.length());
        dfs(nums,new boolean[nums.length],"",0);
        return result;
    }

    private void dfs(char[] nums,boolean[] visited,String num,int index){
        if(index == visited.length){
            String trim = num.trim();
            if (trim.length() == 0){
                return;
            }
            Integer candidate = Integer.parseInt(trim);
            // 소수여부 판별
            if(candidate == 0 || candidate == 1){return;}
            for (int i = 2; i <candidate - 1 ;i++){
                if (candidate % i == 0){
                    return;
                }
            }
            result+=1;
            return;
        }
        for(int i = 0; i< visited.length;i++){
            if(!visited[i]){
                visited[i] =true;
                dfs(nums,visited,num+nums[i],i+1);
                visited[i] = false;
            }
        }

    }
}