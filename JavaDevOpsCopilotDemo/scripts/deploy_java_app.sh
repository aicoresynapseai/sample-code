#!/bin/bash
# This script demonstrates how GitHub Copilot can assist with writing Bash deployment scripts.
# Open this file and start typing comments or commands to see Copilot's suggestions.

# Exit immediately if a command exits with a non-zero status.
# Copilot can suggest robust script practices like this.
# Try typing `# Exit on error`
set -e

# Define variables
APP_NAME="JavaDevOpsCopilotDemo"
JAR_NAME="${APP_NAME}-0.0.1-SNAPSHOT.jar"
REMOTE_USER="ec2-user"
REMOTE_HOST=$1 # First argument is the remote host IP/hostname
APP_DIR="/opt/${APP_NAME}"
LOG_DIR="/var/log/${APP_NAME}"

# Validate input
# Copilot can help with conditional checks. Try typing `# Check if host is provided`
if [ -z "$REMOTE_HOST" ]; then
  echo "Usage: $0 <remote_host_ip>"
  exit 1
fi

echo "--- Starting deployment to $REMOTE_HOST ---"

# Stop the existing Java application service (if running)
# Copilot can suggest `systemctl` commands. Try typing `# Stop Java service`
echo "Stopping existing ${APP_NAME} service..."
ssh "$REMOTE_USER@$REMOTE_HOST" "sudo systemctl stop ${APP_NAME}.service || true" # '|| true' to avoid error if service not running

# Create application directory if it doesn't exist
# Copilot can suggest directory management. Try typing `# Create app directory`
echo "Ensuring application directory exists on remote host..."
ssh "$REMOTE_USER@$REMOTE_HOST" "sudo mkdir -p ${APP_DIR} && sudo mkdir -p ${LOG_DIR}"

# Transfer the new JAR artifact to the remote server
# Copilot helps with `scp` commands. Try typing `# Copy JAR to remote server`
echo "Transferring ${JAR_NAME} to ${REMOTE_HOST}:${APP_DIR}/"
scp "./target/${JAR_NAME}" "$REMOTE_USER@$REMOTE_HOST":"${APP_DIR}/${JAR_NAME}"

# Update symbolic link (optional, for blue/green or zero-downtime deployments)
# Copilot might suggest symlink management
# echo "Updating symbolic link..."
# ssh "$REMOTE_USER@$REMOTE_HOST" "sudo ln -sf ${APP_DIR}/${JAR_NAME} ${APP_DIR}/current-app.jar"


# Start the Java application service
# Copilot suggests `systemctl` commands. Try typing `# Start Java service`
echo "Starting ${APP_NAME} service..."
ssh "$REMOTE_USER@$REMOTE_HOST" "sudo systemctl start ${APP_NAME}.service"

# Check the service status
# Copilot helps with status checks. Try typing `# Check service status`
echo "Checking ${APP_NAME} service status..."
ssh "$REMOTE_USER@$REMOTE_HOST" "sudo systemctl status ${APP_NAME}.service --no-pager"

echo "--- Deployment to $REMOTE_HOST completed successfully! ---"

# Simulate a systemd service file (for demonstration, Copilot can help generate this too)
# This file should be placed in /etc/systemd/system/JavaDevOpsCopilotDemo.service on the remote server
#
# Copilot suggestion for systemd service file:
# Try typing `# Systemd service file for Java app`
<<COMMENT
[Unit]
Description=Java DevOps Copilot Demo Application
After=network.target

[Service]
User=ec2-user # Or appropriate user
ExecStart=/usr/bin/java -jar /opt/JavaDevOpsCopilotDemo/JavaDevOpsCopilotDemo-0.0.1-SNAPSHOT.jar
SuccessExitStatus=143
StandardOutput=file:/var/log/JavaDevOpsCopilotDemo/stdout.log
StandardError=file:/var/log/JavaDevOpsCopilotDemo/stderr.log
Restart=always
RestartSec=10

[Install]
WantedBy=multi-user.target
COMMENT