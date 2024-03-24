package vn.fs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fs.entity.ChatHistory;
import vn.fs.entity.User;
import vn.fs.repository.UserRepository;
import vn.fs.service.ChatHistoryService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/chat")
public class ChatHistoryApi {

    @Autowired
    private ChatHistoryService chatHistoryService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<ChatHistory> saveChatHistory(@RequestBody ChatHistory chatHistory) {
        return ResponseEntity.ok(chatHistoryService.saveChatHistory(chatHistory));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChatHistory>> getChatHistoriesByUserId(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<ChatHistory> chatHistories = chatHistoryService.getChatHistoriesByUser(user);
        return ResponseEntity.ok(chatHistories);
    }
}