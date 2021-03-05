package org.iptime.kibnm821.homepage.repository;

import java.util.Map;

public interface ContentDAO {
    Object SelectContent(String sqlMapId, Map<String, Object> dataMap);
    void InsertContent(String sqlMapId, Map<String, Object> dataMap);
    void UpdateContent(String sqlMapid, Map<String, Object> dataMap);
}
