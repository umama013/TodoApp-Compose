A simple notes / to-do Android app built with Kotlin and Jetpack Compose, following Clean Architecture and the MVVM pattern. Users can create, edit, view, and delete notes, which are stored locally on the device with Room.
Features
Add a new note
Edit an existing note
Delete a note
View all notes in a list
Data saved locally and available offline
UI updates automatically when data changes (reactive, using Flow)
Tech Stack
Area	Technology
Language	Kotlin
UI	Jetpack Compose, Material Design
Architecture	Clean Architecture + MVVM
Local database	Room
Async	Kotlin Coroutines and Flow
Dependency injection	Hilt
Build	Gradle
Architecture

The app is organized into three layers inside the feature_note package. Dependencies point inward, so the domain layer does not depend on Android or Room.

com.example.tod0_aug
├── di                      # Dependency injection modules
├── feature_note
│   ├── data                # Data layer
│   │   ├── data_source     # Room: NoteDatabase, Notedao
│   │   └── repository      # NoteRepoImpl (implements NoteRepo)
│   ├── domain              # Domain layer (pure Kotlin)
│   │   ├── model           # Note
│   │   ├── repository      # NoteRepo (interface)
│   │   ├── use_case        # Business logic (add, delete, get notes)
│   │   └── util
│   └── presentation        # UI layer
│       ├── notes           # Notes list screen + components
│       ├── add_edit_notes  # Add/Edit screen + components
│       └── util
├── ui                      # Theme, colors, typography
└── MainActivity.kt
How data flows
Compose UI  →  ViewModel  →  Use Case  →  Repository (interface)
                                              ↑
                                    RepositoryImpl → Room DAO → SQLite
Presentation: Composables display state exposed by ViewModels and send user events back to them.
Domain: Use cases hold the app's business rules. The NoteRepo interface keeps this layer independent of how data is stored.
Data: NoteRepoImpl implements NoteRepo using the Room DAO, and returns data as Flow.
Getting Started
Prerequisites
Android Studio (latest stable version recommended)
JDK 17 (bundled with recent Android Studio versions)
An emulator or physical Android device
Run the app
bash
git clone https://github.com/umama013/TodoApp-Compose.git
Open the project in Android Studio.
Let Gradle sync finish.
Select a device and click Run.
What I Learned
Structuring an Android app with Clean Architecture and separating data, domain, and presentation layers
Building declarative UI with Jetpack Compose and managing UI state
Using Room with Kotlin Flow for reactive local storage
Dependency injection with Hilt
Future Improvements
 Unit tests for use cases and ViewModels (JUnit, MockK)
 UI tests for the main screens
 Search and filter notes
 Sort notes by date or title
 Mark tasks as completed
 Dark mode polish
