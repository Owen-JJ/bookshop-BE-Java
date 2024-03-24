package vn.fs.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fs.entity.ChatHistory;
import vn.fs.entity.User;
import vn.fs.repository.ChatHistoryRepository;
import vn.fs.service.ChatHistoryService;

import java.util.List;

@Service
public class ChatHistoryServiceImpl implements ChatHistoryService {

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @Override
    public ChatHistory saveChatHistory(ChatHistory chatHistory) {
        return chatHistoryRepository.save(chatHistory);
    }

    @Override
    public List<ChatHistory> getChatHistoriesByUser(User user) {
        return chatHistoryRepository.findByUser(user);
    }
}