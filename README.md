# GitHub User and Repository Info App

This Android application allows users to view GitHub user profiles and repositories using the GitHub API. It showcases user profiles, their repositories, and other related information.

## Project Overview

- **Package Name**: `com.github.myapplication`
- **APIs Used**: GitHub REST API
- **Libraries Used**: Retrofit, Gson

## Features

- Fetch and display a list of GitHub users.
- View detailed profiles of individual GitHub users.
- Retrieve and display repositories for a specific GitHub user.

## API Endpoints

The application interacts with the following GitHub API endpoints:

1. **Get List of Users**
   - **Endpoint**: `GET /users`
   - **Description**: Fetches a list of GitHub users.
   - **Response**: List of `GitHubUser` objects.

2. **Get User Repositories**
   - **Endpoint**: `GET /users/{username}/repos`
   - **Description**: Fetches repositories for a specified GitHub user.
   - **Path Parameter**: `username` (GitHub username)
   - **Response**: List of `GitHubRepo` objects.

3. **Get User Profile**
   - **Endpoint**: `GET /users/{username}`
   - **Description**: Fetches detailed profile information for a specified GitHub user.
   - **Path Parameter**: `username` (GitHub username)
   - **Response**: `GitHubUserprofile` object.

