
@test "Test 1" {
  [ `cat testData1.txt | java CarFueling` == "2" ]
}

@test "Test 2" {
  [ `cat testData2.txt | java CarFueling` == "-1" ]
}

@test "Test 3" {
  [ `cat testData3.txt | java CarFueling` == "-1" ]
}

