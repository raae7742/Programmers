import java.util.*;

class Solution {
    
    // enroll: 각 판매원의 이름 (1 <= x <= 10000)
    // referral: 각 판매원의 추천인 (1 <= x <= 10000, 없는 경우 "-")
    // seller: 판매량 집계 데이터의 판매원 이름 ( 1 <= x <= 100000)
    // amount: 판매량 집계 데이터의 판매 수량
    
    final int profit = 100;
    
    class Node {
        String name;
        int price;
        Node top;
        
        public Node(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
    
    public List<Integer> solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        List<Integer> answer = new ArrayList();
        HashMap<String, Node> map = new HashMap();
        
        for (int i = 0; i < enroll.length; i++) {
            Node node = new Node(enroll[i], 0);
            if (referral[i].compareTo("-") != 0) 
                node.top = map.get(referral[i]);
            
            map.put(enroll[i], node);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int a = amount[i] * profit;
            
            Node node = map.get(s);    
            while (node != null) {
                int fee = a / 10 * 1;
                node.price += a - fee;
                a = fee;
                
                node = node.top;
            }
        }
        
        for (String e : enroll)
            answer.add(map.get(e).price);
        
        return answer;
    }
}
