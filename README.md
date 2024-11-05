# ComponentCommand

The ComponentCommand is a dynamic and feature-rich code that elevates your Minecraft server's interaction capabilities. By leveraging the powerful Foundation API, this plugin enables the creation of interactive components, allowing players to engage with the server in unique and exciting ways. But you can also use the native approach, but Foundation API will save you a lot of time!

# Features
Dynamic Components: Integrate dynamic components in chat messages, providing an immersive and interactive experience for players.
# Installation
To supercharge your plugin with Foundation API, follow these simple steps:

Step 1: Add JitPack Repository

Insert the JitPack repository into your Maven project by adding the following code to the ```<repositories>``` section in your pom.xml file:
```
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Step 2: Add Dependency

Include the ComponentCommand dependency in the ```<dependencies>``` section of your pom.xml file. Replace "REPLACE_WITH_LATEST_VERSION" with the latest version from :
[Foundation Releases](https://github.com/kangarko/Foundation/releases)
```
<dependency>
    <groupId>com.github.kangarko</groupId>
    <artifactId>Foundation</artifactId>
    <version>REPLACE_WITH_LATEST_VERSION</version>
</dependency>
```

Step 3: Explore Foundation

For more in-depth information on Foundation and how to use it with tools other than Maven, visit 
[Jitpack Foundation](https://jitpack.io/#kangarko/Foundation/)

# Usage
Once installed, the ComponentCommand provides two powerful functionalities:

1. GitHub Native
Command: /component githubnative
Displays a chat message with a clickable GitHub link leading to this page.
Provides information about the item the player is holding.

2. GitHub Foundation
Command: /component githubfoundation
Utilizes the Foundation API to create a dynamic chat message with clickable text and item hover details.
Demonstrates a creative way to engage players with interactive components.
Get Creative!

Feel free to modify and extend the ComponentCommand code to suit your server's unique needs. Explore the Foundation API to unleash the full potential of interactive components in your Minecraft world.

Note: Ensure you have the latest version of Foundation to enjoy all the features and enhancements.

Explore the world of interactive components and enhance player engagement with the ComponentCommand!
