# 피보나치 수열
def fibo1(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    return fibo1(n - 1) + fibo1(n - 2) + 1


def fibo2(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    return fibo2(n - 2) + fibo2(n - 1)


n = int(input())
print(fibo1(n), fibo2(n))