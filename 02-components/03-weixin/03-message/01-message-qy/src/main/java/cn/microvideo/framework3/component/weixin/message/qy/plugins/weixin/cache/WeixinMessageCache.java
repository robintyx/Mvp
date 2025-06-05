package cn.microvideo.framework3.component.weixin.message.qy.plugins.weixin.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ningchuanwei
 * @description
 * @com 感动科技
 * @date 2022/10/23 14:47
 **/
public class WeixinMessageCache {
    public static Map<String,String> userMap=new HashMap<>();

    public static synchronized void setUser(String userId,String openUserId){
        userMap.put(userId,openUserId);
    }
    public static  String getUser(String userId){
        if(!userMap.containsKey(userId)){
            return null;
        }
        return userMap.get(userId);
    }
}
