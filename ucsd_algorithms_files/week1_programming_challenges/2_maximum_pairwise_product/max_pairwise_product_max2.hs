import Data.List

main = do
    numberOfIntegers <- getLine
    stringIntegers <- getLine

    let integers = inputToNumberList stringIntegers
        answer = product (max2 integers)
    putStrLn (show answer)

inputToNumberList :: String -> [Integer]
inputToNumberList input = map (\inp -> read inp :: Integer) (words input)

-- Benchmark 1s
maxPairwiseProduct :: [Integer] -> Integer
maxPairwiseProduct xs =
    product $ take 2 $ reverse $ sort xs

-- Benchmark 0.6s
max2 :: [Integer] -> [Integer]
max2 [] = []
max2 [x] = [x]
max2 [x,y] = [x,y]
max2 xs = [m1, m2]
          where m1 = maximum xs
                m1Index = maybeToInt $ elemIndex m1 xs
                m2 = maximum (removeAt m1Index xs)

maybeToInt :: Maybe Int -> Int
maybeToInt (Just x) = x
maybeToInt Nothing = 0

removeAt :: Int -> [a] -> [a]
removeAt i xs = (take i xs) ++ (drop (i + 1) xs)
