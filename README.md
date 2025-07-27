# Ops Portal

A comprehensive Spring Boot application with Thymeleaf UI for operations management, featuring health checks, infrastructure monitoring, command execution, and configuration management.

## Features

### 🏥 Health Check Dashboard
- Real-time health monitoring of various services
- Custom health check endpoints
- Response time tracking
- Status visualization with color-coded indicators
- Sample endpoint: https://www.rvybot.com/health

### 🖥️ Infrastructure Report
- Overview of Linux servers and Windows VMs
- System health summary with percentage scores
- Service status tracking
- Infrastructure inventory management

### 🐧 Linux Command Execution
- SSH-based command execution on Linux servers
- Quick command buttons for common operations
- Real-time command output display
- Support for custom commands
- JSch library for secure SSH connections

### 🪟 Windows Command Execution
- PowerShell command execution on Windows VMs
- Quick command buttons for system information
- Remote command execution capabilities
- Process and service management

### 📁 Configuration File Management
- Git-based configuration file comparison
- Branch-to-branch diff viewing
- Repository management
- Configuration version control

## Technology Stack

- **Backend**: Spring Boot 3.2.0
- **Frontend**: Thymeleaf, Bootstrap 5, jQuery
- **SSH Client**: JSch
- **HTTP Client**: Spring RestTemplate
- **Git Operations**: Command-line git (via ProcessBuilder)
- **Java Version**: 17

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Git (for configuration operations)
- SSH access to Linux servers
- PowerShell access to Windows VMs

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd opsportal
   ```

2. **Build the application**
   ```bash
   mvn clean install
   ```

3. **Configure the application**
   Edit `src/main/resources/application.yml` to configure:
   - Health check endpoints
   - SSH server details
   - Windows VM details
   - Git repository paths

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the portal**
   Open your browser and navigate to: `http://localhost:8080`

## Configuration

### Health Check Endpoints
```yaml
health:
  endpoints:
    - name: "RvyBot"
      url: "https://www.rvybot.com/health"
      timeout: 5000
    - name: "Database"
      url: "http://localhost:8080/health/db"
      timeout: 3000
```

### SSH Server Configuration
```yaml
ssh:
  default-timeout: 30000
  servers:
    - name: "prod-server-1"
      host: "192.168.1.100"
      port: 22
      username: "admin"
      key-path: "/path/to/private/key"
```

### Windows VM Configuration
```yaml
windows:
  servers:
    - name: "win-vm-1"
      host: "192.168.1.200"
      username: "administrator"
      domain: "WORKGROUP"
```

### Git Repository Configuration
```yaml
git:
  repositories:
    - name: "config-repo"
      url: "https://github.com/your-org/config-repo.git"
      local-path: "/tmp/config-repo"
      branches:
        - "main"
        - "develop"
        - "staging"
```

## API Endpoints

### Health Checks
- `GET /api/health/check-all` - Check all configured health endpoints
- `GET /api/health/check/{serviceName}?url={url}` - Check specific service
- `POST /api/health/check-custom` - Custom health check

### Command Execution
- `POST /api/commands/linux/execute` - Execute Linux command
- `POST /api/commands/windows/execute` - Execute Windows command
- `GET /api/commands/linux/servers` - Get Linux servers
- `GET /api/commands/windows/servers` - Get Windows VMs

### Configuration Management
- `POST /api/config/diff` - Compare branches
- `GET /api/config/repositories` - Get repositories
- `GET /api/config/branches/{repoName}` - Get branches

## Usage Examples

### Health Check
```bash
curl -X GET "http://localhost:8080/api/health/check-all"
```

### Linux Command Execution
```bash
curl -X POST "http://localhost:8080/api/commands/linux/execute" \
  -d "serverName=prod-server-1&command=df -h"
```

### Windows Command Execution
```bash
curl -X POST "http://localhost:8080/api/commands/windows/execute" \
  -d "serverName=win-vm-1&command=Get-Process"
```

### Configuration Diff
```bash
curl -X POST "http://localhost:8080/api/config/diff" \
  -d "repoName=config-repo&fileName=application.yml&branch1=main&branch2=develop"
```

## Security Considerations

1. **SSH Keys**: Ensure SSH private keys are properly secured
2. **Network Access**: Configure firewall rules for server access
3. **Authentication**: Consider adding authentication to the portal
4. **HTTPS**: Use HTTPS in production environments
5. **Credentials**: Store sensitive credentials securely

## Troubleshooting

### Common Issues

1. **SSH Connection Failed**
   - Verify SSH key permissions (600)
   - Check server connectivity
   - Ensure SSH service is running

2. **Windows Command Execution Failed**
   - Verify PowerShell execution policy
   - Check network connectivity
   - Ensure proper credentials

3. **Git Operations Failed**
   - Verify git is installed
   - Check repository access
   - Ensure local paths exist

4. **Health Check Timeouts**
   - Increase timeout values in configuration
   - Check network connectivity
   - Verify endpoint URLs

## Development

### Project Structure
```
src/
├── main/
│   ├── java/com/opsportal/
│   │   ├── controller/     # REST controllers
│   │   ├── model/         # Data models
│   │   ├── service/       # Business logic
│   │   └── OpsPortalApplication.java
│   └── resources/
│       ├── templates/     # Thymeleaf templates
│       └── application.yml
```

### Adding New Features
1. Create model classes in `model/` package
2. Implement business logic in `service/` package
3. Add REST endpoints in `controller/` package
4. Create UI templates in `templates/` directory

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## Support

For support and questions, please create an issue in the repository.