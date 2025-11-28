| Operator | Name                | Bit Rule                        | Easy Trick           | Example (Binary)   | Result      | Common Use Cases                     |
|----------|---------------------|----------------------------------|-----------------------|---------------------|-------------|----------------------------------------|
| &        | AND                 | 1 & 1 = 1, else 0                | Both must be 1        | 1010 & 1100         | 1000 (8)    | Masking bits, HashMap index            |
| \|       | OR                  | 1\|0=1, 0\|1=1, 1\|1=1           | At least one 1        | 1010 \| 1100        | 1110 (14)   | Set bit ON, flags                      |
| ^        | XOR                 | Same = 0, Different = 1          | Different = 1         | 1010 ^ 1100         | 0110 (6)    | Hashing, difference check, XOR swap     |
| ~        | NOT                 | Flip all bits                    | Reverse bits          | ~1010               | 0101        | Bit inversion, low-level ops           |
| <<       | Left Shift          | Shift left by n                  | Multiply by 2ⁿ        | 0101 << 1           | 1010 (10)   | Fast multiplication                    |
| >>       | Right Shift         | Shift right by n                 | Divide by 2ⁿ          | 1010 >> 1           | 0101 (5)    | Fast division                          |
| >>>      | Unsigned Right Shift| Right shift + fill 0             | Shift with zero fill  | 1110 >>> 1          | 0111        | Hash mixing (HashMap)                 |



| Symbol | Meaning          | Memory Trick               |
|--------|------------------|-----------------------------|
| &      | AND              | Both 1 → 1                 |
| \|     | OR               | Any 1 → 1                  |
| ^      | XOR              | Same=0, Different=1         |
| ~      | NOT              | Flip bits                  |
| <<     | Left shift       | × 2                        |
| >>     | Right shift      | ÷ 2                        |
| >>>    | Unsigned right   | Shift with zeros           |

## Super Mini Memory Table (Very Useful!)

| Operator | x op 0 | x op 1 | Trick |
|----------|--------|--------|--------|
| **x & ?** | 0 | x | AND → only **1 & 1 = 1** |
| **x | ?** | x | 1 | OR → **any 1 makes result 1** |
| **x ^ ?** | x | flip | XOR → **same = 0, different = 1** |
| **~x** | flips | flips | NOT → **reverse all bits** |
| **x << ?** | x | x×2 | Left shift → **multiply by 2** |
| **x >> ?** | x | x÷2 | Right shift → **divide by 2** |
| **x >>> ?** | x | shift+0 | Zero-fill right shift → **shift + fill zeros** |
