package structure.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebsiteFactory {

    private Map<String, ConcreteWebsite> cache = new ConcurrentHashMap<>();

    public Website getWebsite(String type) {
        if (!cache.containsKey(type)) {
            cache.put(type, new ConcreteWebsite(type));
        }
        return cache.get(type);
    }

    public int getCacheSize() {
        return cache.size();
    }

}
