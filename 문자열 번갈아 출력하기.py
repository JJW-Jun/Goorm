text = str(input(''))
text_list = list(text)
for i in range(len(text_list)) :
    if ((2*i)-1) in range(len(text_list)):
        text_list.insert(2*i-1, text_list[-1])
        text_list.pop(-1)
answer = ''.join(text_list)
print(answer)