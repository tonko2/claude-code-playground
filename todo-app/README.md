# Todo App

A full-stack todo application built with Spring WebFlux (Java) backend and React (TypeScript) frontend.

## Features

- ✅ Create, read, update, and delete todos
- ✅ Mark todos as completed/incomplete
- ✅ Persistent data storage with H2 database
- ✅ Reactive programming with Spring WebFlux
- ✅ Modern React frontend with TypeScript
- ✅ Responsive UI design
- ✅ Docker containerization

## Technology Stack

### Backend
- **Java 17+**
- **Spring Boot 3.1.0**
- **Spring WebFlux** (Reactive programming)
- **Spring Data R2DBC** (Reactive database access)
- **H2 Database** (File-based persistent storage)
- **Gradle** (Build tool)

### Frontend
- **React 18**
- **TypeScript**
- **Axios** (HTTP client)
- **CSS3** (Styling)
- **Create React App** (Build tool)

## Project Structure

```
todo-app/
├── backend/                 # Spring WebFlux backend
│   ├── src/main/java/
│   │   └── com/example/todoapp/
│   │       ├── TodoAppApplication.java
│   │       ├── controller/  # REST API controllers
│   │       ├── service/     # Business logic
│   │       ├── repository/  # Data access layer
│   │       ├── model/       # Entity models
│   │       └── config/      # Configuration
│   ├── src/main/resources/
│   │   ├── application.yml  # Application configuration
│   │   └── schema.sql       # Database schema
│   ├── data/               # H2 database files (persistent)
│   ├── build.gradle        # Gradle build configuration
│   └── Dockerfile
├── frontend/               # React frontend
│   ├── src/
│   │   ├── components/     # React components
│   │   ├── api/           # API client
│   │   ├── types/         # TypeScript type definitions
│   │   ├── App.tsx        # Main app component
│   │   └── App.css        # Styling
│   ├── package.json       # npm dependencies
│   └── Dockerfile
├── docker-compose.yml     # Docker orchestration
├── .gitignore            # Git ignore rules
└── README.md            # This file
```

## Getting Started

### Prerequisites

- **Java 17 or higher**
- **Node.js 16 or higher**
- **npm or yarn**
- **Gradle** (or use wrapper)
- **Docker & Docker Compose** (optional)

### Option 1: Run with Docker (Recommended)

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd todo-app
   ```

2. **Start the application**
   ```bash
   docker-compose up -d
   ```

3. **Access the application**
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:8080/api/todos

4. **Stop the application**
   ```bash
   docker-compose down
   ```

### Option 2: Run Locally

#### Backend Setup

1. **Navigate to backend directory**
   ```bash
   cd backend
   ```

2. **Run the backend**
   ```bash
   ./gradlew bootRun
   # or if gradlew is not executable:
   gradle bootRun
   ```

The backend will start on http://localhost:8080

#### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm start
   ```

The frontend will start on http://localhost:3000

## API Endpoints

The backend provides the following REST API endpoints:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/todos` | Get all todos |
| GET | `/api/todos/{id}` | Get todo by ID |
| POST | `/api/todos` | Create new todo |
| PUT | `/api/todos/{id}` | Update todo |
| DELETE | `/api/todos/{id}` | Delete todo |
| GET | `/api/todos?completed=true/false` | Filter todos by completion status |

### Example Todo Object

```json
{
  "id": 1,
  "title": "Learn Spring WebFlux",
  "description": "Study reactive programming concepts",
  "completed": false
}
```

## Database

The application uses H2 database with file-based storage for persistence:

- **Database file**: `backend/data/tododb.mv.db`
- **Console**: http://localhost:8080/h2-console (when running locally)
- **JDBC URL**: `jdbc:h2:file:./data/tododb`
- **Username**: `sa`
- **Password**: (empty)

## Development

### Backend Development

1. **Build the project**
   ```bash
   cd backend
   ./gradlew build
   ```

2. **Run tests**
   ```bash
   ./gradlew test
   ```

3. **Generate JAR**
   ```bash
   ./gradlew bootJar
   ```

### Frontend Development

1. **Start development server**
   ```bash
   cd frontend
   npm start
   ```

2. **Run tests**
   ```bash
   npm test
   ```

3. **Build for production**
   ```bash
   npm run build
   ```

4. **Lint code**
   ```bash
   npm run lint
   ```

## Deployment

### Docker Deployment

1. **Build and run with Docker Compose**
   ```bash
   docker-compose up -d
   ```

2. **View logs**
   ```bash
   docker-compose logs -f
   ```

3. **Scale services** (if needed)
   ```bash
   docker-compose up -d --scale backend=2
   ```

### Production Deployment

For production deployment:

1. **Update API URL** in `frontend/src/api/todoApi.ts`
2. **Configure environment variables**
3. **Use production database** (PostgreSQL, MySQL, etc.)
4. **Set up reverse proxy** (Nginx, Apache)
5. **Enable HTTPS**
6. **Configure monitoring and logging**

## Environment Variables

### Backend

| Variable | Description | Default |
|----------|-------------|---------|
| `SERVER_PORT` | Server port | `8080` |
| `SPRING_PROFILES_ACTIVE` | Active profile | `default` |
| `SPRING_R2DBC_URL` | Database URL | `r2dbc:h2:file:///./data/tododb` |

### Frontend

| Variable | Description | Default |
|----------|-------------|---------|
| `REACT_APP_API_URL` | Backend API URL | `http://localhost:8080` |
| `PORT` | Frontend port | `3000` |

## Troubleshooting

### Common Issues

1. **Port already in use**
   ```bash
   # Find process using port
   lsof -i :8080
   # Kill process
   kill -9 <PID>
   ```

2. **Database connection issues**
   - Check if `backend/data` directory exists
   - Verify database URL in `application.yml`

3. **Frontend can't connect to backend**
   - Ensure backend is running on port 8080
   - Check CORS configuration in backend
   - Verify API URL in frontend

4. **Docker build fails**
   - Check Dockerfile syntax
   - Ensure all required files are present
   - Clean Docker cache: `docker system prune -a`

### Logs

- **Backend logs**: Check console output or `backend.log`
- **Frontend logs**: Check browser console
- **Docker logs**: `docker-compose logs [service-name]`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is licensed under the MIT License.

## Support

For questions or issues, please:
1. Check the troubleshooting section
2. Review the logs
3. Create an issue in the repository