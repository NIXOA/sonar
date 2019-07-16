import java.util.HashMap;
import java.util.Map;

/**
 * @Author Godzilla
 * @Date 2019/7/16 15:41
 */
public class IfSimlifyTest {
    private static Map<String, String> MODE_MAP;

    private static void initModeMap() {
        MODE_MAP = new HashMap<>();
        MODE_MAP.put("HOME_IN_MODE", "回家模式");
        MODE_MAP.put("HOME_OUT_MODE", "离家模式");
        MODE_MAP.put("MORN_MODE", "清晨模式");
        MODE_MAP.put("MOVIE_MODE", "观影模式");
    }

    static String identfy_mode_device(String speech) {
        String modeAction = null;
        initModeMap();
        for (Map.Entry<String, String> entry : MODE_MAP.entrySet()) {
            if (speech.contains(entry.getValue())) {
                modeAction = entry.getKey();
                break;
            }
        }

        return modeAction;

    }
}
