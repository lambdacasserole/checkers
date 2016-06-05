# Checkers
BSD checksum Maven package for Java.

Checkers will compute a [16-bit BSD checksum](https://en.wikipedia.org/wiki/BSD_checksum) for a given byte array an return it as either a length-2 byte array or 16-bit integer (short). It *has not* been checked against the output from GNU `sum` but it has been checked against [another online implementation](http://codepen.io/ImagineProgramming/post/checksum-algorithms-in-javascript-checksum-js-engine) successfully.

## Installation
You can pull this package into your Maven project straight from here using JitPack. Add JitPack as a repository first:

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then add a dependency on Checkers:

```
<dependencies>
    <dependency>
        <groupId>com.github.lambdacasserole</groupId>
        <artifactId>checkers</artifactId>
        <version>v1.0</version>
    </dependency>
</dependencies>
```

## Verification
Again, Checkers *has not* been tested agains the official BSD-16 implementation for reasons of "I'm on Windows and I don't really wanna install VirtualBox or compile `sum.c` from source". Output is consistent with another online implmentation however. Here is test data for reference:

| Data (ASCII)       | Data (Hexadecimal)                 | Hash (Hexadecimal)   |
|--------------------|------------------------------------|----------------------|
| `NfQsKFp1Q7JzTwDK` | `4e6651734b46703151374a7a5477444b` | `3e6d`               |
| `hI2ZcuhrQDUjF3qn` | `6849325a637568725144556a4633716e` | `d38b`               |
| `Jr3m4FFTZZlfOE4j` | `4a72336d344646545a5a6c664f45346a` | `966f`               |
| `QaqudA9DPEhBrsRp` | `51617175644139445045684272735270` | `9f0b`               |
| `aQnXUSzGqumPcGSO` | `61516e5855537a4771756d506347534f` | `6cf8`               |
| `fI3z3qvax3JL91jJ` | `6649337a3371766178334a4c39316a4a` | `f663`               |
| `M3FSpDugNr0qD6vm` | `4d334653704475674e7230714436766d` | `be0f`               |
| `ujwFsX3UCVwriZYF` | `756a77467358335543567772695a5946` | `742d`               |

## Contributing
For most intents and purposes, Checkers is considered to fulfil its original use case. Bug fixes and suggestions are welcome, however, from any member of the community.
