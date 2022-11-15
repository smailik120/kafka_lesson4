package com.example.kafka.config;
import com.example.kafka.settings.TopicSettings;
import com.example.kafka.templates.TopicSetting;
import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
@Component
@Configuration
public class KafkaTopicConfig {
    @Autowired
    private TopicSettings topicSettings;
    private Properties properties;

    private List<TopicSetting> settings;

    private List<NewTopic> topics;
    @PostConstruct
    public void postConstruct() {
        initProperties();
        initTopics();
    }
    public void initProperties() {
        properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, topicSettings.getServers());
    }

    public void initTopics() {
        topics = new ArrayList<>();
        settings = topicSettings.getTopics();
        System.out.println("settings");
        System.out.println(settings);
        try (Admin admin = Admin.create(properties)) {
            for (TopicSetting topic : settings) {
                NewTopic newTopic = new NewTopic(topic.getName(), topic.getPartitions(), topic.getReplicas());
                topics.add(newTopic);
                System.out.println(topic.getName());
            }
            admin.createTopics(topics);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
