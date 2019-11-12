
@test "Finds First Number" {
    [ "$(echo 3 11 22 33 1 11 | java BinarySearch)" -eq 0 ]
}

@test "Finds Middle Number" {
    [ "$(echo 3 11 22 33 1 22 | java BinarySearch)" -eq 1 ]
}

@test "Finds Last Number" {
    [ "$(echo 3 11 22 33 1 33 | java BinarySearch)" -eq 2 ]
}

@test "Doesn't Find Non Existent Middle Number" {
    [ "$(echo 3 11 22 33 1 29 | java BinarySearch)" -eq -1 ]
}

@test "Doesn't Find Non Existent Before Number" {
    [ "$(echo 3 11 22 33 1 5 | java BinarySearch)" -eq -1 ]
}

@test "Doesn't Find Non Existent After Number" {
    [ "$(echo 3 11 22 33 1 1000 | java BinarySearch)" -eq -1 ]
}
