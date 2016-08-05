package io.pturczyk.playground.zk;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.zookeeper.config.ZookeeperConfigProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class PropertyController {

    @Autowired
    private Environment env;

    @Autowired
    private ZookeeperConfigProperties zkProperties;

    @Autowired
    private CuratorFramework client;

    @RequestMapping(value = "/env-property/{name}", method = RequestMethod.GET)
    public String getProperty(@PathVariable("name") String name) {
        return env.getProperty(name);
    }

    @RequestMapping(value = "/zk-property/{name}", method = RequestMethod.GET)
    public String getZkProperty(@PathVariable("name") String name) throws Exception {
        return Arrays.toString(client.getData().forPath("/" + zkProperties.getRoot() + "/" + name));

    }

}
