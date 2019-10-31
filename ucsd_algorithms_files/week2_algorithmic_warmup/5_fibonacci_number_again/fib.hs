-- by Kirill Elagin

fib :: Int-> Integer -> Integer
fib i = fibs !! i
  where fibs = 0 : iterate (\x -> x + (last fibs)) 1
