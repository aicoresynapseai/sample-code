# This file demonstrates how GitHub Copilot assists with Infrastructure as Code (IaC) using Terraform.
# Open this file and start typing comments or resource definitions to see Copilot in action.

# Configure the AWS provider
# Copilot can suggest provider blocks. Try typing `# Configure AWS provider`
provider "aws" {
  region = "us-east-1" # You might need to change this region
}

# Create an AWS S3 bucket for application logs
# Copilot can generate resource blocks based on descriptive comments.
# Try typing `# Create an S3 bucket for Java application logs`
resource "aws_s3_bucket" "java_app_logs" {
  bucket = "java-devops-copilot-demo-app-logs-unique-12345" # Replace with a unique bucket name
  acl    = "private"

  # Copilot can suggest common tags
  tags = {
    Name        = "JavaAppLogs"
    Environment = "Dev"
    ManagedBy   = "Terraform"
  }
}

# Define an AWS EC2 instance for our Java application
# Copilot excels at suggesting common EC2 configurations.
# Try typing `# Create an EC2 instance for our Java Spring Boot app`
resource "aws_instance" "java_app_server" {
  ami           = "ami-0abcdef1234567890" # Replace with a valid AMI ID for your region (e.g., Amazon Linux 2 AMI)
  instance_type = "t2.micro"
  key_name      = "my-ssh-key" # Replace with your EC2 Key Pair name
  vpc_security_group_ids = [aws_security_group.app_security_group.id]

  # Copilot can suggest user data scripts for bootstrapping
  user_data = <<-EOF
              #!/bin/bash
              sudo yum update -y
              sudo yum install java-17-amazon-corretto -y
              # Install other dependencies or deploy your Java app here
              echo "Java app server setup complete."
              EOF

  tags = {
    Name        = "JavaAppServer"
    Environment = "Dev"
    Application = "JavaDevOpsCopilotDemo"
  }
}

# Define a Security Group for the EC2 instance
# Copilot can help define security group rules (e.g., allowing SSH, HTTP)
# Try typing `# Create a security group to allow SSH and HTTP access`
resource "aws_security_group" "app_security_group" {
  name        = "java-app-sg"
  description = "Allow SSH and HTTP access for Java app server"
  vpc_id      = "vpc-0abcdef1234567890" # Replace with your VPC ID

  # Ingress rule for SSH
  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Be more restrictive in production
  }

  # Ingress rule for HTTP (e.g., Spring Boot default port)
  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # Egress rule for all outbound traffic
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "JavaAppSecurityGroup"
  }
}

# Output the S3 bucket name
# Copilot can help define outputs
# Try typing `# Output the name of the S3 bucket`
output "s3_bucket_name" {
  description = "The name of the S3 bucket created for application logs"
  value       = aws_s3_bucket.java_app_logs.bucket
}

# Output the public IP of the EC2 instance
# Try typing `# Output the public IP address of the EC2 instance`
output "ec2_public_ip" {
  description = "The public IP address of the Java application EC2 instance"
  value       = aws_instance.java_app_server.public_ip
}