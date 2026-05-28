// demo_login.cpp

#include <iostream>
#include <cstring>

// Simulated user database
struct User {
    const char* username;
    const char* password;
};

User users[] = {
    {"admin", "supersecret"},
    {"alice", "password123"},
};

bool isAuthenticated = false; 

bool checkPassword(const char* username, const char* inputPassword) {
    char buffer[16];

    std::cout << "[DEBUG] buffer is at:          " << (void*)buffer << "\n";
    std::cout << "[DEBUG] isAuthenticated is at: " << (void*)&isAuthenticated << "\n";
    
    strcpy(buffer, inputPassword);

    for (auto& user : users) {
        if (strcmp(user.username, username) == 0 &&
            strcmp(user.password, buffer) == 0) {
            return true;
        }
    }
    return false;
}

int main() {
    std::string username, password;

    std::cout << "=== Demo Login System ===\n";
    std::cout << "Username: ";
    std::cin >> username;
    std::cout << "Password: ";
    std::cin >> password;

    if (checkPassword(username.c_str(), password.c_str())) {
        std::cout << "\n Login successful! Welcome, " << username << ".\n";
    } else if (isAuthenticated) {
        std::cout << "\n  Wrong password — but isAuthenticated was overwritten!\n";
        std::cout << " Bypass successful! You're in without valid credentials.\n";
    } else {
        std::cout << "\n Login failed.\n";
    }

    return 0;
}