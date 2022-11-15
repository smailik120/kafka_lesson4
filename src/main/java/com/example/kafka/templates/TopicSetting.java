package com.example.kafka.templates;

import org.springframework.stereotype.Component;
@Component
public class TopicSetting {
    private String name;

    private int partitions;

    private short replicas;

    public short getReplicas() {
        return replicas;
    }

    public void setReplicas(short replicas) {
        this.replicas = replicas;
    }


    public int getPartitions() {
        return partitions;
    }

    public void setPartitions(int partitions) {
        this.partitions = partitions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}