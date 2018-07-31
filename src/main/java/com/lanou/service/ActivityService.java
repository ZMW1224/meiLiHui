package com.lanou.service;

import com.lanou.model.Activity;

import java.util.List;

public interface ActivityService {
    public List<Activity> findByActivePrimaryTitle(String string);
}
