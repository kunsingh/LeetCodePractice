import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    static boolean solution(String[] numbers) {
        final Map<String, List<String>> prefixes = new HashMap<>();
        for (final String number : numbers) {
            for (int len = 0; len < number.length(); ++len) {
                final String prefix = number.substring(0, len);
                List<String> hasPrefix = prefixes.computeIfAbsent(prefix, k -> new ArrayList<>());
                hasPrefix.add(number);
            }
        }

        for (final String number : numbers) {
            if (prefixes.containsKey(number)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"64630488",
//                "6463043",
//                "64630438",
//                /*"64630412",
//                "64630483",
//                "6463048",
//                "64630498",
//                "64630426",
//                "64630463",
//                "64630439",
//                "6463040",
//                "64630422",
//                "6463049",
//                "6463046",
//                "6463045",
//                "64630420",
//                "6463042",
//                "64630408",
//                "64630418",
//                "64630430"*/}));

        String doc = "Alex:(486)-619-9812, Maria: 632 831 1993, Donald: 232-618-93200, John: 621) 198 1082";
        //\\(\\d\\d\\d\\)
        Pattern pattern = Pattern.compile("\\(?\\d\\d\\d\\)?-? *\\d\\d\\d-? -?\\d\\d\\d\\d");
        Matcher matches = pattern.matcher(doc);
        int s = 0;
        while (matches.find()) {
            s++;
        }
        System.out.println(s);
    }



}
