package com.gdp.demo.model;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long gdp;

    public Country(String name, long gdp) {

        this.id = counter.incrementAndGet();
        this.name = name;
        this.gdp = gdp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
        this.gdp = gdp;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gdp=" + gdp +
                '}';
    }
}
