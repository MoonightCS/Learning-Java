package ru.popov.bodya.accounts;

import ru.popov.bodya.database.DBService;
import ru.popov.bodya.database.datasets.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;

    private final DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile user) {
        loginToProfile.put(user.getLogin(), user);
        dbService.addUser(user);
    }

    public UserProfile getUserByLogin(String login) {
        return dbService.getUserByLogin(login);
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
