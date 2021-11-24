array = [
    [1, 0, 0, 0, 0, 0],
    [0, 1, 0, 1, 1, 1],
    [0, 0, 1, 0, 1, 0],
    [1, 1, 0, 0, 1, 0],
    [1, 0, 1, 1, 0, 0],
    [1, 0, 0, 0, 0, 1],
]


# kenarlardaki birler
def is_edge_one(row, column):
    return (row == 0 or row == len(array) - 1 or column == 0 or column == len(array[0]) - 1) and array[row][column] == 1


# kenarlardaki birlere bağlı olan birler
def next_to_edge_one(row, column):
    def mix(val):
        return max(0, min(len(array) - 1, val))

    def ones(r, c):
        top = mix(r - 1), c
        bot = mix(r + 1), c
        left = r, mix(c - 1)
        right = r, mix(c + 1)

        return [(r, c) for r, c in (top, bot, left, right) if array[r][c] == 1]

    points = ones(row, column)
    while not any(is_edge_one(r, c) for r, c in points):
        points = [y for r, c in points for y in ones(r, c)]
        if len(points) - 1 < 1:  # şu anki konuma gelirken kullandığımız konumu siliyorum
            return False
    return True


def main():
    for y in range(len(array)):
        for x in range(len(array[0])):
            if not next_to_edge_one(y, x) and not is_edge_one(y, x) and array[y][x] == 1:
                array[y][x] = 0

    for i in array:
        print(i)


if __name__ == '__main__':
    main()
