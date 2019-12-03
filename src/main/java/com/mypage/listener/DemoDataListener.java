package com.mypage.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.mypage.entity.DemoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mengsk on 2019/10/18.
 */
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);

    private static final int BATCH_COUNT = 5;
    List<DemoData> list = new ArrayList<DemoData>();

    /**
     * 在转换异常 获取其他异常下会调用本接口。抛出异常则停止读取。如果这里不抛出异常则 继续读取下一行。
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
//        super.onException(exception, context);
        LOGGER.error("解析失败，但是继续解析下一行", exception);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        LOGGER.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据：{}", JSON.toJSONString(demoData));
        list.add(demoData);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
    }
}
