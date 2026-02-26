<div align="center">

# 🔫 Juan Wick: Pixel Vengeance
### Pixel Masters Game Project

_An intense 2D pixel-art action game inspired by the John Wick universe. Survive waves of enemies, customize your character, and seek vengeance in this retro-styled adventure._

<img src="Readme head.png" alt="Pixel Heads">

[![Last Commit](https://img.shields.io/badge/last%20commit-today-brightgreen)](https://github.com/NMSU-CS-CS371/cs371-fa2023-teamproject-pixel-masters)
[![Languages](https://img.shields.io/badge/languages-1-blue)]()
[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)](https://jdk.java.net/21/)
</div>

---

## 📚 Table of Contents

- [✨ Features](#features)
- [🏗️ Project Structure](#project-structure)
- [🎮 Controls](#controls)
- [⚙️ Setup Instructions](#setup-instructions)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Game](#running-the-game)
- [👥 Authors](#authors)
- [🤝 Contributing](#contributing)

---

<a id="features"></a>
## ✨ Features

- 🕴️ **Character Customization**: Choose from different Juan Wick skins (Gray, Blue, Black suits).
- 🚧 **Unique Maps** (Under Development): Battle across distinct terrains and levels.
- 🚧 **Background Story** (Under Development): Engage with the lore of the pixelated underworld.
- 🔫 **Action-Packed Gameplay**: Fast-paced combat mechanics.
- 🎵 **Immersive Audio**: Sound effects and music to enhance the atmosphere.

<a id="project-structure"></a>
## 🏗️ Project Structure

```bash
├── FinalProject/
│   ├── src/             # Source code
│   │   ├── main/        # Core game loop, UI, KeyHandler
│   │   ├── entity/      # Player, Enemy, Entity classes
│   │   ├── object/      # Game objects
│   │   └── tile/        # Map and Tile management
│   ├── res/             # Resources (Images, Sounds, Maps)
│   └── bin/             # Compiled classes (generated)
├── sprites/             # Additional sprite assets
└── Readme head.png      # Repository banner
```

<a id="controls"></a>
## 🎮 Controls

Master the controls to survive the onslaught!

### Menu Navigation
- **W / S**: Navigate Menu Options
- **ENTER**: Select Option

### In-Game Actions
- **W / A / S / D**: Move Player (Up, Left, Down, Right)
- **ENTER**: Shoot / Attack
- **P**: Pause Game
- **ESCAPE**: Open Options Menu

### Options Menu
- **W / S**: Navigate Settings
- **A / D**: Adjust Volume
- **ESCAPE**: Return to Game

<a id="setup-instructions"></a>
## ⚙️ Setup Instructions

### Prerequisites
- **Java Development Kit (JDK) 21**: Ensure Java is installed and configured in your PATH.
- **Git**: To clone the repository.

### Installation

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/NMSU-CS-CS371/cs371-fa2023-teamproject-pixel-masters.git
    cd cs371-fa2023-teamproject-pixel-masters
    ```

2.  **Navigate to the project directory**:
    ```bash
    cd FinalProject
    ```

3.  **Compile the source code**:
    Ensure the `bin` directory exists:
    ```bash
    mkdir bin
    ```
    Then compile:
    ```bash
    javac -d bin -sourcepath src src/main/Main.java
    ```

### Running the Game

**On Windows:**
```bash
java -cp "bin;res" main.Main
```

**On Unix/Linux/macOS:**
```bash
java -cp bin:res main.Main
```

<a id="authors"></a>
## 👥 Authors

Developed by:
- **Horacio Gonzalez**
- **Carlos Torres**
- **Erick Nevarez**
- **Erick Lopez**

<a id="contributing"></a>
## 🤝 Contributing

We welcome contributions!

1.  Fork this repository.
2.  Create a branch: `git checkout -b feature-name`
3.  Commit changes: `git commit -m 'Add new feature'`
4.  Push to branch: `git push origin feature-name`
5.  Submit a pull request.

---
<div align="center">
⭐ Don't forget to give a star if you like this project!
</div>
