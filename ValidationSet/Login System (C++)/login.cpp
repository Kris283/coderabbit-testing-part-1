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

bool isAuthenticated = false; // sits adjacent in memory — target for overflow

bool checkPassword(const std::string& username, const std::string& inputPassword) {
    for (auto& user : users) {
        if (user.username == username && user.password == inputPassword) {
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
        // isAuthenticated may have been flipped by the overflow
        std::cout << "\n  Wrong password — but isAuthenticated was overwritten!\n";
        std::cout << " Bypass successful! You're in without valid credentials.\n";
    } else {
        std::cout << "\n Login failed.\n";
    }

    return 0;
}