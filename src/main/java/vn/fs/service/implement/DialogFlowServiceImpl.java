package vn.fs.service.implement;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.cloud.dialogflow.v2.*;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.stereotype.Service;
import vn.fs.service.DialogFlowService;

import java.io.FileInputStream;
import java.util.UUID;

@Service
public class DialogFlowServiceImpl implements DialogFlowService {

    private final static String projectId = "book-bytg";


    @Override
    public QueryResult runIntent(String requestText) throws Exception {
        // Tạo một phiên mới với mỗi lần gọi runIntent
        String sessionId = UUID.randomUUID().toString();
        SessionsSettings settings = SessionsSettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(ServiceAccountCredentials.fromStream(new FileInputStream("book-bytg-3cc03e33cc70.json")))).build();
        SessionsClient sessionsClient = SessionsClient.create(settings);

        SessionName session = SessionName.of(this.projectId, sessionId);
        TextInput.Builder textInput = TextInput.newBuilder().setText(requestText).setLanguageCode("vi");
        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

        return response.getQueryResult();
    }
}
