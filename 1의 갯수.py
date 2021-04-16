num = int(input())
b1, b2 = str(bin(num)[2:]), str(bin(int('0x'+str(num), 16))[2:])
count1, count2 = 0, 0
for i in range(len(b1)) :
    if b1[i] == '1' :
        count1 += 1

for i in range(len(b2)) :
    if b2[i] == '1' :
        count2 += 1

b1, b2 = count1, count2
print(b1, b2)
