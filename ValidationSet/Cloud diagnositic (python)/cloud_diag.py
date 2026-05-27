import os
import platform
import subprocess

def run_diagnostic():
    print("=== CloudOps Network Diagnostic Tool (SECURED) ===")
    target = input("Enter target IP or Domain to ping: ")
    
    ping_flag = "-n" if platform.system().lower() == "windows" else "-c"
    
    print(f"\n[+] Executing Secure Diagnostic on: {target}")
    print("-" * 50)
    
    try:
        subprocess.run(["ping", ping_flag, "2", target], check=True)
    except subprocess.CalledProcessError:
        print("[-] Diagnostic failed: Could not reach the target.")
        
    print("-" * 50)

if __name__ == "__main__":
    run_diagnostic()

