CXX      = gcc
CXXFLAGS = -Wextra -Wall
TARGET   = login

.PHONY: all clean

all: $(TARGET)

$(TARGET): login.c
	$(CXX) $(CXXFLAGS) -o $(TARGET) login.c

clean:
	rm -f $(TARGET)
