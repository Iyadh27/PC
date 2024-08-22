### Project Overview

This project simulates a musical performance, including live events and studio recordings, by utilizing core Object-Oriented Programming (OOP) concepts such as inheritance, abstraction, encapsulation, and polymorphism. The project models the interactions between the main singer, backup singers, backup dancers, and the music tracks during a performance.

### OOP Concepts Utilized

- **Abstraction**:
  - The `Performance` abstract class provides a general template for different types of performances (e.g., `LivePerforming` and `StudioPerforming`), defining common properties and methods that all performances share, like the venue, year, and performer lists.

- **Inheritance**:
  - The class hierarchy uses inheritance to promote code reuse. For example, `LivePerforming` and `StudioPerforming` inherit from the abstract `Performance` class. Similarly, `Singer`, `MainSinger`, and `Backup_singer` classes inherit from the `Artist` class, inheriting common properties like the artist's name.

- **Encapsulation**:
  - The project encapsulates data within classes, such as the `Music` class, which holds the name and duration of a music track. Access to these properties is controlled via getter and setter methods, providing a way to safely interact with the data.

- **Polymorphism**:
  - The project demonstrates polymorphism through method overriding. For instance, the `Backup_singer` class overrides the `sing` method from the `Singer` class to implement its own version, while still adhering to the general contract provided by the `Singer` class.

### Features

- **Abstract Class `Performance`**: Defines the blueprint for any musical performance, ensuring that all performances have a venue, year, and list of performers.
  
- **Concrete Classes**:
  - `LivePerforming`: Represents a live performance event, extending the `Performance` class.
  - `StudioPerforming`: Represents a studio recording session, also extending the `Performance` class.

- **Artist Hierarchy**:
  - `Artist`: Base class for any artist involved in the performance.
  - `Singer`, `MainSinger`, `Backup_singer`: Define the different types of singers with specific behaviors.
  - `Backup_dancer`: Represents the dancers.

- **Music Class**: Encapsulates the details of each music track, such as its name and duration.

- **Interface `IBackup`**: Enforces the `Backup` method in both `Backup_singer` and `Backup_dancer` classes, promoting a consistent behavior for all backup performers.

### How to Run

1. **Setup**: Ensure that Java is installed. Compile the project files.
   
2. **Execution**: Run the `MusicalPerformanceTest` class to initiate a live performance with predefined music tracks, a main singer, and backup performers.

### Example Output

Running the project will simulate a live performance, with output messages indicating the actions of the main singer, backup singers, and dancers.

### Usage

- **`MusicBegins()` Method**: Starts the musical performance, with the main singer singing and the backup performers doing their parts.
- **Extensible Design**: The project is designed to be extensible, allowing for the easy addition of new types of performances, artists, or interactions between entities.
 

This project is a great example of how OOP principles can be applied to model real-world scenarios in a clear, organized, and maintainable way.
