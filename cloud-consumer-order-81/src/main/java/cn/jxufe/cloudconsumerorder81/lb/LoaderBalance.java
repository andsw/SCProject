package cn.jxufe.cloudconsumerorder81.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author hsw
 * @date 2020/7/11 17:33
 */
public interface LoaderBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
