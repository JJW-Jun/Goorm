a, b = map(int, input('').split())
c, d = list(map(int, input().split())), list(map(int, input().split()))
c.extend(d), c.sort()
for i in range(len(c)) :
    print(c[i], end = ' ')