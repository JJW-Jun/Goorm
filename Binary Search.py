int(input(''))
numbers = map(int, input('').split())
numbers = list(numbers)
number = int(input(''))
if number in numbers :
    print(numbers.index(number)+1)
else :
    print('X')