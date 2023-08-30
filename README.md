# Encryptor-and-Decryptor

1. **Imports and Setup:**
   - The code begins by importing required packages and classes. It initializes variables and instances that will be used throughout the program.

2. **Authentication:**
   - Users are prompted to enter their team name and password.
   - The `authorize.authenticate` method checks the validity of the provided team name and password.
   - If authentication succeeds, the program proceeds. Otherwise, it exits with an error.

3. **Menu and Options:**
   - Users are presented with a menu to choose from:
     - `1`: Encrypt File
     - `2`: Decrypt File
     - `-1`: Exit

4. **Option 1: Encrypt File:**
   - The program reads input data from a file named `MyInFile.txt`.
   - It processes the input character by character.
   - For each character:
     - It converts the character into a numerical value.
     - Encrypts the numerical value using a wheel mechanism.
     - Writes the encrypted numerical value to an output file named `MyOutFile.dat`.
     - Displays the character, numerical value, encrypted value, and wheel positions.
   - After processing all characters, the input file is closed, and an audit message is sent.

5. **Option 2: Decrypt File:**
   - Users are prompted to set new wheel positions for decryption.
   - The program reads encrypted data from the output file (`MyOutFile.dat`).
   - For each encrypted numerical value:
     - It decrypts the value using the reverse of the wheel mechanism.
     - Converts the decrypted numerical value back to a character.
     - Writes the decrypted character to an output text file (`MyOutFile.txt`).
     - Displays the decrypted character and current wheel positions.
   - After decrypting all values, the output file is closed, and another audit message is sent.

6. **Exiting the Program:**
   - If users enter `-1`, the program exits gracefully.
