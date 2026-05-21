#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static const char *VALID_USER = "admin";
static const char *VALID_PASS = "password123";

void read_username(char *username);

char *copy_password(const char *password);


void create_session(const char *username);

void logout(void);

void check_session(void);


void login_failed(const char *username);