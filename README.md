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

### Examples (run in JShell)
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

jshell> dna.getNucleotideCount()
$3 ==> int[7] { 5, 5, 5, 6, 0, 0, 0 }

jshell> dna.reverseComplement()
$4 ==> "ATCGATCAGTCAGCATGCAGT"

jshell> dna.getKmers(18)
$5 ==> String[4] { "ACTGCATGCTGACTGATC", "CTGCATGCTGACTGATCG", "TGCATGCTGACTGATCGA", "GCATGCTGACTGATCGAT" }
```

```java
jshell> import com.github.jlboat.fastautils.Fasta;
jshell> import com.github.jlboat.fastautils.FastaUtils;
jshell> Fasta fasta = new Fasta("DNA.fasta","DNA");
fasta ==> DNA.fasta contains 50 entries

jshell> fasta.containsAmbiguous()
$4 == > false

jshell> fasta.toFile("New_DNA.fasta")

jshell> Set<String> keys = fasta.getKeys()
keys ==> [>asmbl_477, >asmbl_1949, >asmbl_61, >asmbl_1533, ... >asmbl_1885, >asmbl_1469]

jshell> Collection<Sequence> values = fasta.getValues()
values ==> [ATGGTTCACCACCATCGCCACCACCCCCCAGCAGCAGCGGAGCAAGTAT ... GGTGCATCATTTATGTTTGGAAGATT

jshell> FastaUtils.stats(fasta)
$8 ==> {Count=50, Minimum=189, Maximum=7047, Median=900.0, Mean=1112.74, N50=1341}

jshell> FastaUtils.minLength(fasta)
$9 ==> 189

jshell> FastaUtils.nX(fasta, 90)
$10 ==> 522
```
