package vn.fs.service;

import com.google.cloud.dialogflow.v2.QueryResult;
import org.springframework.stereotype.Service;

public interface DialogFlowService {
    QueryResult runIntent(String requestText) throws Exception;
}
