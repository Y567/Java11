import java.util.*;

public class subString {
//    List<String> subdomainVisits(String[] cpdomains){
//
//
//        }
//    }

    public static void main(String[] args) {
        String[] cpdomains = {"500 www.baidu.com", "300 google.com"};
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] a = s.split(" ");
            int n = Integer.valueOf(a[0]);
            String domain = a[1];
            String[] b = domain.split("\\.");
            for (int i = 0; i < b.length; i++) {
                String[] c = Arrays.copyOfRange(b, i, b.length);
//                System.out.println(Arrays.toString(c));
                String subdomain = String.join(".",c);
                Integer oldCount = map.getOrDefault(subdomain,0);
                map.put(subdomain,oldCount+n);
            }
        }

        //走到这里所有的字符串处理完毕，并加到map集合里
        List<String> result = new ArrayList<>();
        for (Map.Entry<String,Integer> m : map.entrySet()){
            Integer value = m.getValue();
            String key = m.getKey();
            String ret = value + " "+ key;
            result.add(ret);
        }
/*        System.out.println(result);
        String s = "baidu+afheuf+aefwebfweu+jahj";
        String[] split = s.split("\\+");
        System.out.println(Arrays.toString(split));*/
    }
}
