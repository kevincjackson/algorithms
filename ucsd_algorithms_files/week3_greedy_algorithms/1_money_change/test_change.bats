
@test "0" {
  [ `echo 0 | java Change` == "0" ]
}

@test "1" {
  [ `echo 1 | java Change` == "1" ]
}

@test "5" {
  [ `echo 5 | java Change` == "1" ]
}

@test "10" {
  [ `echo 10 | java Change` == "1" ]
}

@test "28" {
  [ `echo 28 | java Change` == "6" ]
}
