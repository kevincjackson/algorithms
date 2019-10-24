
main = do
  input <- getLine
  let stringArray = words input
      readInt :: String -> Int
      readInt = read
      integers = map readInt stringArray
      total = sum integers
  putStrLn $ show total
