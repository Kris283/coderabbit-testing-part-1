## Toy Login System (C++)

A small command-line login program written in C++ that supports account creation
and persists accounts.

### Features

- **Create account** — choose a username and password; the account is saved
  immediately.
- **Login** — verify credentials against stored accounts.
- **Password hashing** — passwords are run through a djb2 hash before being
  stored, so the raw password is never saved.

### Build

```bash
make
```

### Run

```bash
./login
```

### Usage

```
=== Toy Login System ===
1. Login
2. Create account
3. Exit
Choice:
```

Select **2** to create a new account, **1** to log in, or **3** to quit.

### Clean

```bash
make clean   # removes the binary
```
