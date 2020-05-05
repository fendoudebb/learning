# 十进制转二进制
print(bin(123))


def decimal_to_binary(n):
    bin_str = ''
    while n:
        bin_str = str(n % 2) + bin_str
        n //= 2
    return bin_str


print(decimal_to_binary(123))

# 二进制转十进制
print(int('0b1111011', 2))


def binary_to_decimal(m):
    length = len(m)
    i = 1
    decimal = 0
    for c in m:
        decimal += int(c) * (2 ** (length - i))
        i += 1
    return decimal


print(binary_to_decimal('1111011'))
