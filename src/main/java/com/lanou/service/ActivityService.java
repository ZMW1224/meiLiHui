package com.lanou.service;

import com.lanou.model.Activity;

import java.util.List;

public interface ActivityService {
     List<Activity> findByActivePrimaryTitle(String string);
}
