# Ops Portal

A comprehensive Spring Boot application with Thymeleaf UI for operations management, featuring health checks, infrastructure monitoring, command execution, configuration management, and emergency operations.

## Features

### 🏠 Dashboard Section
- **Market Open**: Real-time market status with trading volume, orders, and emergency operations
- **System Health**: Comprehensive health monitoring of various services and endpoints
- **Inventory**: CSV-based inventory management with filtering and search capabilities

### 🔍 Dry Run Section
- **Report**: Comprehensive dry run report generation with artifact, health, config, and certificate validation
- **Linux**: SSH-based command execution on Linux servers with preset commands
- **Windows**: PowerShell command execution on Windows VMs with system management tools

### 🚨 Break Glass Section
- **Traffic Controller**: Traffic diversion management among clusters with emergency failover
- **DR Ops**: Planned Disaster Recovery operations with step-by-step guidance
- **Emergency Ops**: Immediate recovery operations for critical system issues

### 📋 DoD (Definition of Done) Section
- **Config Review**: JSON configuration comparison with visual diff highlighting
- **Kafka**: Topic and permission management with filtering capabilities
- **Certificate**: Certificate management with expiry tracking and status monitoring
- **Service Accounts**: Service account management with rotation tracking
- **Firewall**: Firewall testing and cluster connectivity validation

## Technology Stack

- **Backend**: Spring Boot 3.2.0
- **Frontend**: Thymeleaf, Bootstrap 5, jQuery
- **SSH Client**: JSch
- **HTTP Client**: Spring RestTemplate
- **Git Operations**: Command-line git (via ProcessBuilder)
- **Data Processing**: Jackson ObjectMapper for JSON operations
- **CSV Processing**: Custom CSV parsing for inventory management
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

### Inventory Management
- `GET /api/inventory/data` - Get inventory data from CSV
- `GET /api/certificate/data` - Get certificate data from CSV
- `GET /api/service-accounts/data` - Get service account data from CSV

### Kafka Management
- `GET /api/kafka/data` - Get Kafka topic and permission data

### Configuration Review
- `GET /api/config-review/default` - Get default config comparison

### Firewall Testing
- `POST /api/firewall/test` - Run firewall tests on clusters

### Dry Run Reports
- `POST /api/dry-run/generate-report` - Generate clean dry run report
- `POST /api/dry-run/generate-report-with-issues` - Generate report with warnings

## Navigation Structure

### Dashboard Section
- **Market Open** (`/market-open`): Market status, trading volume, emergency operations
- **System Health** (`/system-health`): Health monitoring and status tracking
- **Inventory** (`/inventory`): CSV-based inventory with filtering

### Dry Run Section
- **Report** (`/dry-run/report`): Comprehensive dry run report generation
- **Linux** (`/dry-run/linux`): Linux command execution via SSH
- **Windows** (`/dry-run/windows`): Windows PowerShell command execution

### Break Glass Section
- **Traffic Controller** (`/break-glass/traffic-controller`): Traffic diversion management
- **DR Ops** (`/break-glass/dr-ops`): Disaster Recovery operations
- **Emergency Ops** (`/break-glass/emergency-ops`): Emergency recovery operations

### DoD Section
- **Config Review** (`/dod/config-review`): Configuration comparison and diff
- **Kafka** (`/dod/kafka`): Kafka topic and permission management
- **Certificate** (`/dod/certificate`): Certificate management and monitoring
- **Service Accounts** (`/dod/service-accounts`): Service account management
- **Firewall** (`/dod/firewall`): Firewall testing and validation

## Key Features

### 🏥 Health Check Dashboard
- Real-time health monitoring of various services
- Custom health check endpoints
- Response time tracking
- Status visualization with color-coded indicators
- Sample endpoint: https://www.rvybot.com/health

### 📊 Inventory Management
- CSV-based data loading and filtering
- Dropdown filters for Application, Pool, AppID, Type, DC, C, Domain, Status
- Real-time table updates
- Summary statistics and counts
- Export capabilities

### 🔍 Dry Run Reports
- Comprehensive validation of artifacts, health, configuration, and certificates
- Step-by-step validation process
- Detailed recommendations and warnings
- Multiple report types (clean vs. with issues)

### 🚨 Break Glass Operations
- **Traffic Controller**: Cluster traffic diversion with emergency failover
- **DR Ops**: Structured disaster recovery with progress tracking
- **Emergency Ops**: Immediate recovery operations with priority levels

### 📋 DoD Management
- **Config Review**: JSON comparison with visual diff highlighting
- **Kafka**: Topic management with permission tracking
- **Certificate**: Expiry monitoring and status tracking
- **Service Accounts**: Rotation tracking and status monitoring
- **Firewall**: Cluster connectivity testing and validation

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

## Data Files

The application uses several CSV files for data management:

- `inventory.csv`: Server inventory data
- `cert.csv`: Certificate information
- `sa.csv`: Service account data

And JSON files for configuration:

- `config1.json`: Primary configuration file
- `config2.json`: Secondary configuration file for comparison

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

### Dry Run Report
```bash
curl -X POST "http://localhost:8080/api/dry-run/generate-report" \
  -d "applicationName=my-app&version=1.0.0&infrastructureDetails=AWS EKS"
```

### Firewall Test
```bash
curl -X POST "http://localhost:8080/api/firewall/test" \
  -d "clusterName=cluster1&dns=example.com&port=443"
```

## Security Considerations

1. **SSH Keys**: Ensure SSH private keys are properly secured
2. **Network Access**: Configure firewall rules for server access
3. **Authentication**: Consider adding authentication to the portal
4. **HTTPS**: Use HTTPS in production environments
5. **Credentials**: Store sensitive credentials securely
6. **Break Glass Operations**: Implement proper access controls for emergency operations
7. **Audit Logging**: Log all operations for compliance and security

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

5. **CSV Data Not Loading**
   - Verify CSV files exist in resources directory
   - Check CSV format and column headers
   - Ensure proper file permissions

6. **Break Glass Operations Not Working**
   - Verify all controller mappings are present
   - Check template files for proper navigation
   - Ensure all required services are running

## Development

### Project Structure
```
src/
├── main/
│   ├── java/com/opsportal/
│   │   ├── controller/     # REST controllers
│   │   ├── model/         # Data models
│   │   ├── service/       # Business logic
│   │   ├── config/        # Configuration classes
│   │   └── OpsPortalApplication.java
│   └── resources/
│       ├── templates/     # Thymeleaf templates
│       ├── *.csv          # Data files
│       ├── *.json         # Configuration files
│       └── application.yml
```

### Adding New Features
1. Create model classes in `model/` package
2. Implement business logic in `service/` package
3. Add REST endpoints in `controller/` package
4. Create UI templates in `templates/` directory
5. Update navigation in layout files
6. Add controller mappings in `DashboardController`

### Template Structure
- Each page is self-contained with its own navigation
- Navigation sections: Dashboard, Dry Run, Break Glass, DoD
- Consistent styling and layout across all pages
- Responsive design with Bootstrap 5

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Update documentation
6. Submit a pull request

## Support

For support and questions, please create an issue in the repository.