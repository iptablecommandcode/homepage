package org.iptime.kibnm821.homepage.repository;

import java.util.Map;

public interface ContentDAO {
    Object SelectContent(String sqlMapId, Map<String, Object> dataMap);
}
