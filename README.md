# Merito Tap

> Tap to fly. Dodge the obstacles. Beat your high score.

[![Platform](https://img.shields.io/badge/platform-[Android%20%7C%20iOS%20%7C%20Web%20%7C%20PC]-blue)]()
[![Engine](https://img.shields.io/badge/engine-[Unity%20%7C%20Godot%20%7C%20Other]-lightgrey)]()
[![Status](https://img.shields.io/badge/status-in%20development-orange)]()
[![License](https://img.shields.io/badge/license-[MIT]-green)](LICENSE)

## About

**Merito Tap** is a fast, simple one-tap arcade game. Guide your character through a stream of obstacles, one tap at a time. Each gap you pass earns a point, and one mistake ends the run. It is easy to learn, hard to master, and built for quick "one more try" sessions.

## Features

- One-tap controls that anyone can pick up in seconds
- Endless gameplay with gradually increasing difficulty
- Local high score saved between sessions
- Smooth, responsive physics
- [Unlockable characters or skins] - to come
- [Daily challenges or leaderboards] - to come maybe ....?

## Screenshots

| Menu | Gameplay | Game Over |
| ---- | -------- | --------- |
| ![Menu](docs/menu.png) | ![Gameplay](docs/gameplay.png) | ![Game Over](docs/gameover.png) |

## How to Play

1. Tap (or click / press Space) to make your character jump.
2. Let gravity pull you down between taps.
3. Fly through the gaps without touching obstacles, the ground, or the ceiling.
4. Each gap passed scores 1 point.
5. Try to beat your best score.

## Controls

| Platform | Action |
| -------- | ------ |
| Mobile | Tap the screen |
| PC / Web | Left click or Space |
| Pause | [Esc / Pause button] |

## Getting Started

### Requirements

- [VS code, or a working Java IDE]
- Git

### Installation

```bash
git clone https://github.com/AndriiSynytsia/Merito_Tap.git
cd merito-tap
```

Then open the project in [your engine] and load the scene `[Scenes/MainMenu]`.

### Running the Game

1. Open the project in [your engine].
2. Open the scene `[Scenes/MainMenu]`.
3. Press **Play**.

### Building

1. Go to **[File > Build Settings]**.
2. Select your target platform: [Android / iOS / WebGL / Windows].
3. Click **Build**

## Project Structure

```
Merito/
├── .vscode/
├── bin/
├── lib/
├── src/
│   ├── Merito.class         # ...
│   ├── MErito.java          # ...
│   ├── MeritoBird.java      # ...
├── bottompillar.png         # Game image
├── LICENSE                  # MIT license for the game
├── meritodwn.png            # Game image
├── mertotapbg.png           # Game image
├── meritoup.png             # Game image
├── README.md                # Info about the game
└── toppillar.png            # Game image
```

## Tech Stack

- **Engine:** Java
- **Language:** Java
- **Art:** Paint.NET
- **Audio:** None

## Roadmap

- [x] Core tap-to-fly mechanic
- [x] Obstacle spawning and scoring
- [x] High score saving
- [ ] Main menu and settings
- [ ] Sound and music
- [ ] More characters and themes
- [ ] Leaderboards
- [ ] Release on [store or platform]

## Known Issues

- [List any current bugs or limitations here]

## Contributing

Contributions, ideas, and bug reports are welcome.

1. Fork the repository.
2. Create a branch: `git checkout -b feature/your-feature`.
3. Commit your changes: `git commit -m "Add your feature"`.
4. Push the branch: `git push origin feature/your-feature`.
5. Open a Pull Request.

## License

This project is licensed under the [MIT] License. See the [LICENSE](LICENSE) file for details.

## Credits

- **Game design and development:** Bradley & Andrii
- **Art:** Bradley Bosinney
- **Fonts and libraries:** 

## Contact
Bradley Bosinney 
Andrii Synytsia 

Project link: https://github.com/AndriiSynytsia/Merito_Tap.git