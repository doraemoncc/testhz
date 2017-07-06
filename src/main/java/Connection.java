import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.io.IOException;
import java.util.Map;

/**
 * Created by dora_ on 2017/7/6.
 */
public class Connection {
    public static void main(String[] args) throws IOException, InterruptedException {

        String configUrl="hazelcast-client.xml";
        ClientConfig clientConfig = new XmlClientConfigBuilder(configUrl).build();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("test1");
        MapConfig mapConfig = new MapConfig("test1");
        map.put(1,"jim");
        Thread.sleep(mapConfig.getMaxIdleSeconds()+1);
        System.out.println(map.get(1));

//        mapConfig.setTimeToLiveSeconds(60);
        mapConfig.setMaxIdleSeconds(5);
        map.put(2,"tom");
        Thread.sleep(5000);
        System.out.println(map.get(2));




    }



}
