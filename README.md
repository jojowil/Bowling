# Bowling!

We will use some basic parsing skills to both make the scoring string look pretty, but also determine the score.

[Starting Code in Java](https://github.com/jojowil/Bowling)

---

## Game Basics

Here are some basic rules:

- There are 10 frames. Each frame constitutes a turn.
- You are allowed up to 3 balls in a frame depending on the frame number.
- The number of pins knocked down impacts how many more times you may roll the ball.

---

## Game play

For frames 1-9, you are allowed at least one roll of the ball. Depending on your results you may be allowed a second roll.

- If you knock down all 10 pins on the first ball, you score a strike (X) and no second ball is allowed. 
- If you know down less than 10 pins, record the number and throw a second ball.
    - If the remaining pins are knocked down, mark a spare (/) after to the previous number.
    - Otherwise, record the number of pins.

This ends one frame.

For the 10th frame

- If you roll a strike on the first ball, you may roll two more times.
- If you know down less than 10 pins, but make the spare, you may roll a third time.

## Game Scoring

- If you fail to score 10 pins in a frame, the points are added to the previous frame score and place in that frame.
- If you score 10 pins with two rolls (spare), the 10 pins plus the next roll (NOT frames) are added to the previous frame score and place in that frame.
- If you score 10 pins with one roll (strike), the 10 pins plus the next two rolls (NOT frames) are added to the previous frame score and place in that frame.

That's it!

## Further Reading

Data validation is an important part of solution. You can read more about how to approach validating the frames with regular expressions in the document below.

[Bowling Regex](https://programmingby.design/algorithms/bowling-regex/)