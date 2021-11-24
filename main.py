array = [
    [1, 0, 0, 0, 0, 0],
    [0, 1, 0, 1, 1, 1],
    [0, 0, 1, 0, 1, 0],
    [1, 1, 0, 0, 1, 0],
    [1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 0, 1],
]


def mix(value: int):
    """
    Hataları engellemek için girilen değerin max ve min değerlerin arasında kalmasını sağlar.
    """
    return max(0, min(len(array) - 1, value))


def explore(row: int, column: int):
    """
    Verilen karenin dört bir tarafındaki 1'leri bulur.
    """
    top = mix(row - 1), column
    bot = mix(row + 1), column
    left = row, mix(column - 1)
    right = row, mix(column + 1)

    return [(r, c) for r, c in (top, bot, left, right) if array[r][c] == 1]


def edge(row: int, column: int):
    """
    Kenarda ve bir mi?
    """
    return (row == 0 or row == len(array) - 1 or column == 0 or column == len(array) - 1) and array[row][column] == 1


def connected(row: int, column: int):
    """
    Kenardaki herhangi bir 1'e bağlı mı?
    """
    points = explore(row, column)
    while not any(edge(r, c) for r, c in points):
        points = [sub_arr for r, c in points for sub_arr in explore(r, c)]
        if len(points) - 1 < 1:  # Şu anki konumda explore'u kullandığımızda listeye eski konum da dahil olduğu için 1 çıkarıyorum.
            return False
    return True


def main():
    for row in range(len(array)):
        for column in range(len(array)):
            if not connected(row, column) and not edge(row, column) and array[row][column] == 1:
                array[row][column] = 0

    for row in array:
        print(row)


if __name__ == '__main__':
    main()

'''
[1, 0, 0, 0, 0, 0]
[0, 0, 0, 1, 1, 1]
[0, 0, 0, 0, 1, 0]
[1, 1, 0, 0, 1, 0]
[1, 0, 0, 0, 0, 0]
[1, 0, 0, 0, 0, 1]
'''
