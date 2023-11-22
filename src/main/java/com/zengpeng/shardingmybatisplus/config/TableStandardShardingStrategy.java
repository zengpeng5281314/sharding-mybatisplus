package com.zengpeng.shardingmybatisplus.config;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Properties;

public class TableStandardShardingStrategy implements StandardShardingAlgorithm<Comparable<?>> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Comparable<?>> preciseShardingValue) {
        for (String tableName : collection) {
           long val = ((Number) preciseShardingValue.getValue()).longValue();
            if (tableName.endsWith(val % 4 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Comparable<?>> rangeShardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());

        for (Long i = (Long) rangeShardingValue.getValueRange().lowerEndpoint(); i <= (Long)rangeShardingValue.getValueRange().upperEndpoint(); i++) {
            for (String each : collection) {
                if (each.endsWith(i % 4 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }

    @Override
    public Properties getProps() {
        return new Properties();
    }

    @Override
    public void init(Properties properties) {

    }

    @Override
    public String getType() {
        return "TABLE_HINT";
    }
}
