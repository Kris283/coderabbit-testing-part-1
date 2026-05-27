CXX      = g++
CXXFLAGS = -O2 -Wall -Wextra
TARGET   = login.exe 

.PHONY: all clean

all: $(TARGET)

$(TARGET): login.cpp
	$(CXX) $(CXXFLAGS) -o $@ $^

clean:
	rm -f $(TARGET)w