import random

# Reading the file
file_path = 'words.txt'
with open(file_path, 'r') as file:
    content = file.read()

words = content.strip().split()
words = [word.lower() for word in words]

# Picking a random word
random_word = random.choice(words)

# Initialize
totalLives = 6
answer = ['_'] * len(random_word)

while totalLives:
    indices = []
    start = 0
    print(answer)
    print(f"Remaining lives = {totalLives}")
    guess = input("Which letter will you choose? ")
    # Check if input is 1 letter
    if not len(guess) == 1:
        print("Error! You entered multiple characters. Please try again.")

    # Check if word contains guess
    guess = guess.lower()
    check = random_word.find(guess)
    if not check == -1:
        # Contains, search for indices with char
        while True:
            index = random_word.find(guess, start)
            if index == -1:
                break
            indices.append(index)
            start = index + 1

        # Replacing indices
        for i in range(len(indices)):
            answer[indices[i]] = guess

    else:
        # Does not contain
        totalLives = totalLives - 1
        print(f"The word does not contain '{guess}' ")

    final = ''.join(answer)
    if final == random_word:
        print(f"You've guessed the word '{random_word}'!")
        exit()
    else:
        continue

print(f"Game over! All lives were lost. The word was '{random_word}'!")
