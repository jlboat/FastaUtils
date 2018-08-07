## FastaUtils

[![Build Status](https://travis-ci.com/jlboat/FastaUtils.png?branch=master)](https://travis-ci.com/jlboat/FastaUtils)

### Use
This package was designed to facilitate biological sequence manipulation.

### Build
```bash
git clone https://github.com/jlboat/FastaUtils
cd FastaUtils
mvn package
```

### Examples (run in JShell) -- IN PROGRESS
In terminal:
```bash
export CLASSPATH="./target/FastaUtils-1.0-jar-with-dependencies.jar"
jshell -c "./target/FastaUtils-1.0-jar-with-dependencies.jar"
```

In JShell:
```java
jshell> import com.github.jlboat.fastautils.DNA;

jshell> DNA dna = new DNA("ACTGCATGCTGACTGATCGAT");
dna ==> ACTGCATGCTGACTGATCGAT
```

