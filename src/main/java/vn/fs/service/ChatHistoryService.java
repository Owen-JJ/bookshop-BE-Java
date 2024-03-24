package vn.fs.service;

import vn.fs.entity.ChatHistory;
import vn.fs.entity.User;

import java.util.List;

public interface ChatHistoryService {
    ChatHistory saveChatHistory(ChatHistory chatHistory);
    List<ChatHistory> getChatHistoriesByUser(User user);
}