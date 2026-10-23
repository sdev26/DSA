class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
             hm.put(ch, hm.getOrDefault(ch, 0) + 1); 
        }
        int max=0;
        for(Character c:hm.keySet()){
            max=Math.max(max,hm.get(c));
        }
        if(max>(n+1)/2)
            return "";
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> pq =
            new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));

        for (Character c : hm.keySet()) {
            pq.add(c);
        }

        char prev = '!';
        while (!pq.isEmpty()) {
            char temp = pq.poll();
            sb.append(temp);

            hm.put(temp, hm.get(temp) - 1);

            if (prev != '!' && hm.get(prev) > 0) {
                pq.add(prev);
            }

            prev = temp;
        }

        return sb.toString();
    }
}