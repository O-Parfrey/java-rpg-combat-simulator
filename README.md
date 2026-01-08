# Java RPG Combat Simulator

A text-based RPG combat simulator built to explore turn-based mechanics, state management, and modular game logic.

## Overview
This project simulates a simple RPG-style combat system where players and enemies take turns performing actions. The focus is on clean object-oriented design, readable logic, and extensibility rather than presentation.

## Features
- Turn-based combat flow
- Player and enemy state tracking (health, actions)
- Modular class design to support future expansion
- Clear separation of game logic and user interaction

## Tech Stack
- Java
- Eclipse

## Concepts Demonstrated
- Object-Oriented Programming
- State-based logic
- Input validation
- Modular system design

## Status
Completed (core combat system implemented; additional features planned)

## Project Structure
- `BattleMain` – Program entry point
- `BattleTurn` – Handles turn-based combat flow
- `Creature` – Base class for all combat entities
- Derived classes implement character-specific behavior

## Planned Improvements
- Randomized damage based on character stats
- Improved console UI feedback
- Resolve known HP display inconsistency
