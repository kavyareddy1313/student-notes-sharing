# Student Notes Sharing App

## 📌 Project Overview
The **Student Notes Sharing App** is a simple web-based application that allows users to create, view, search, pin, edit, and delete notes.  
It is designed to demonstrate backend development using Java and version control practices using Git and GitHub.

---

## 🛠️ Technology Stack

### Backend
- **Java**
- **Spark Java Framework**
- **Gson**
- **Maven**

### Frontend
- **HTML**
- **CSS**

> Note: Minimal client-side scripting is used only for handling user interactions and API calls.

---

## ⚙️ Features
- Add notes with title, content, category, and username
- Search notes dynamically
- Pin and unpin important notes
- Edit and delete existing notes
- Attractive UI with modern gradient and glassmorphism design

---

## 🧩 Project Structure
student-notes-sharing/
│
├── src/main/java/
│ └── NotesApp.java
│
├── src/main/resources/public/
│ ├── index.html
│ └── style.css
│
├── pom.xml
├── README.md
└── .gitignore

---

## 🔄 Git & GitHub Operations Performed

- Initialized Git repository
- Created multiple branches:
  - `experiment`
  - `feature`
  - `test`
  - `bugfix`
- Performed branch merges
- Created and resolved a merge conflict manually
- Maintained meaningful commit history (10+ commits)
- Pushed project to GitHub

---

## ⚠️ Merge Conflict Resolution
A merge conflict was intentionally created while merging the `bugfix` branch.  
The conflict was manually resolved in `index.html` and committed successfully.

---

## ▶️ How to Run the Project

### Build the project
```bash
mvn clean package

