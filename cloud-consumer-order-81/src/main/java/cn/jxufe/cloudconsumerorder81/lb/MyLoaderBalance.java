package cn.jxufe.cloudconsumerorder81.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hsw
 * @date 2020/7/11 17:35
 */
public class MyLoaderBalance implements LoaderBalance {

    private AtomicInteger count = new AtomicInteger(0);

    /**
     * 本来count是自带getAndIncrement的，但为了不越界写个方法
     * @author hsw
     * @date 21:49 2020/7/11
     * @param
     * @return int
     **/
    private int getAndIncrement() {
        int current, next;
        do {
            current = count.get();
            next = (current == Integer.MAX_VALUE) ? 0 : current + 1;
        } while (!count.compareAndSet(current, next));
        return current;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int key = getAndIncrement();
        System.out.println(key);
        int size = serviceInstances.size();
        return serviceInstances.get(key % size);
    }
}
