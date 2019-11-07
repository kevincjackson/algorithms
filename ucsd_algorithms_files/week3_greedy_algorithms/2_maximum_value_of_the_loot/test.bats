
@test "1" {
  [ `cat test_data1.txt | java FractionalKnapsack` == "180.0000" ]
}

@test "2" {
  [ `cat test_data2.txt | java FractionalKnapsack` == "166.6667" ]
}

@test "3" {
  [ `cat test_data3.txt | java FractionalKnapsack` == "500.0000" ]
}
