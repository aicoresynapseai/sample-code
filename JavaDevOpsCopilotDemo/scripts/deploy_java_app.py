import os
import subprocess
import argparse
import time
import requests # For simulating API calls

# This script demonstrates how GitHub Copilot can assist with writing Python deployment scripts.
# Python is often used for more complex deployment logic, interacting with APIs, or parsing config files.
# Open this file and start typing comments or function definitions to see Copilot's suggestions.

def parse_arguments():
    # Copilot can help define command-line argument parsing.
    # Try typing `# Parse command line arguments`
    parser = argparse.ArgumentParser(description="Deploy Java application to a remote server.")
    parser.add_argument("--host", required=True, help="Remote host IP or hostname")
    parser.add_argument("--user", default="ec2-user", help="Remote SSH username")
    parser.add_argument("--jar", default="JavaDevOpsCopilotDemo-0.0.1-SNAPSHOT.jar", help="JAR file name")
    parser.add_argument("--app_dir", default="/opt/JavaDevOpsCopilotDemo", help="Remote application directory")
    parser.add_argument("--service_name", default="JavaDevOpsCopilotDemo.service", help="Systemd service name")
    parser.add_argument("--port", type=int, default=8080, help="Application port for health check")
    return parser.parse_args()

def run_remote_command(host, user, command):
    # Copilot can suggest running SSH commands.
    # Try typing `# Function to execute remote command via SSH`
    ssh_command = ["ssh", f"{user}@{host}", command]
    print(f"Executing: {' '.join(ssh_command)}")
    try:
        result = subprocess.run(ssh_command, check=True, capture_output=True, text=True)
        print(result.stdout)
        if result.stderr:
            print(f"Stderr: {result.stderr}")
        return True
    except subprocess.CalledProcessError as e:
        print(f"Error executing command: {e}")
        print(f"Stdout: {e.stdout}")
        print(f"Stderr: {e.stderr}")
        return False

def check_health(host, port):
    # Copilot can assist with HTTP requests for health checks.
    # Try typing `# Check application health endpoint`
    url = f"http://{host}:{port}/health"
    print(f"Checking application health at {url}...")
    try:
        response = requests.get(url, timeout=10)
        if response.status_code == 200 and "up and running" in response.text:
            print("Application is healthy!")
            return True
        else:
            print(f"Health check failed. Status: {response.status_code}, Response: {response.text}")
            return False
    except requests.exceptions.RequestException as e:
        print(f"Health check request failed: {e}")
        return False

def main():
    args = parse_arguments()

    local_jar_path = os.path.join(os.path.dirname(__file__), "..", "target", args.jar)
    if not os.path.exists(local_jar_path):
        print(f"Error: JAR file not found at {local_jar_path}. Please run 'mvn package' first.")
        exit(1)

    print(f"--- Starting Python deployment to {args.host} ---")

    # Stop service
    if not run_remote_command(args.host, args.user, f"sudo systemctl stop {args.service_name} || true"):
        print("Failed to stop service, but continuing...")

    # Ensure app directory exists
    if not run_remote_command(args.host, args.user, f"sudo mkdir -p {args.app_dir} && sudo mkdir -p /var/log/{args.service_name.replace('.service', '')}"):
        print("Failed to create remote directories. Exiting.")
        exit(1)

    # Transfer JAR
    # Copilot can suggest subprocess calls for `scp`.
    # Try typing `# Copy JAR using scp`
    print(f"Transferring {args.jar} to {args.host}:{args.app_dir}/")
    try:
        subprocess.run(["scp", local_jar_path, f"{args.user}@{args.host}:{args.app_dir}/"], check=True)
        print("JAR transferred successfully.")
    except subprocess.CalledProcessError as e:
        print(f"Error transferring JAR: {e}")
        exit(1)

    # Start service
    if not run_remote_command(args.host, args.user, f"sudo systemctl start {args.service_name}"):
        print("Failed to start service. Exiting.")
        exit(1)

    # Wait for service to come up and perform health check
    print("Waiting for application to start (max 60 seconds)...")
    for _ in range(12): # Try for 1 minute (12 * 5 seconds)
        if check_health(args.host, args.port):
            break
        time.sleep(5)
    else:
        print("Application did not become healthy within the timeout.")
        run_remote_command(args.host, args.user, f"sudo systemctl status {args.service_name} --no-pager") # Show status if failed
        exit(1)

    print(f"--- Deployment to {args.host} completed successfully! ---")

if __name__ == "__main__":
    # To run this script:
    # python deploy_java_app.py --host your_remote_server_ip
    main()