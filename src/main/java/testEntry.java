import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dora_ on 2017/7/6.
 */
public class testEntry {
    public static void main(String[] agrs)throws IOException{
        String configUrl="hazelcast-client.xml";
        ClientConfig clientConfig = new XmlClientConfigBuilder(configUrl).build();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap map = client.getMap("test1");
        map.put(1,1,1000, TimeUnit.MILLISECONDS);
        map.evictAll();
    }
}
