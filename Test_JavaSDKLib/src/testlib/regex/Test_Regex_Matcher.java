package testlib.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test_Regex_Matcher {

    public static void main(String[] args) throws Exception {

        Pattern p =Pattern.compile("((?:\\d{1,3}\\.){3}\\d{1,3}) - (\\S*) \\[(.*)\\] .*");
        Matcher m = p.matcher("192.168.1.101 - - [07/Apr/2024:14:00:00 +0800] \"POST /index");

        if(m.matches()){
            System.out.println(m.groupCount());
            System.out.println(m.group(3));
        }

        // Matcher.replaceAll()
        String jsonStr = m.replaceAll("{\"remote_addr\": \"$1\", \"remote_user\": \"$2\", \"time_local\": \"$3\"}");

        System.out.println(jsonStr);

    }

}
