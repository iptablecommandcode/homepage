package org.iptime.kibnm821.homepage.service;

import java.util.Map;

public interface ContentService {
    Object TopContent(Map<String, Object> dataMap);
    Object Notice_Board(Map<String, Object> dataMap);
    Object Search_Board(Map<String, Object> dataMap);
    Object Board(Map<String, Object> dataMap);
    void insert_Board(Map<String, Object> dataMap);
    void update_Board(Map<String, Object> dataMap);
}
