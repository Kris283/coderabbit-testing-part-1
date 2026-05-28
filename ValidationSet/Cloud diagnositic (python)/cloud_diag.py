import os
import platform

def run_diagnostic():
    print("=== CloudOps Network Diagnostic Tool ===")
    print("Use this tool to verify connectivity to external resources.")
    
    # 1. THE SOURCE: Grab untrusted input from the user
    target = input("Enter target IP or Domain to ping: ")
    
    # Determine the correct ping argument based on the OS (for the demo to work)
    ping_flag = "-n" if platform.system().lower() == "windows" else "-c"
    
    command = f"ping {ping_flag} 2 {target}"
    
    print(f"\n[+] Executing System Command: {command}")
    print("-" * 50)
    
    os.system(command)
    
    print("-" * 50)
    print("[+] Diagnostic complete.")

if __name__ == "__main__":
    run_diagnostic()

