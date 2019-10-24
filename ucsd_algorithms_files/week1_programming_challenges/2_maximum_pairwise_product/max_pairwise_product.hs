import Data.List

main = do
    numberOfIntegers <- getLine
    stringIntegers <- getLine

    let integers = inputToNumberList stringIntegers
        answer = maxPairwiseProduct integers
    putStrLn (show answer)

inputToNumberList :: String -> [Integer]
inputToNumberList input = map (\inp -> read inp :: Integer) (words input)

maxPairwiseProduct :: [Integer] -> Integer
maxPairwiseProduct xs =
    product $ take 2 $ reverse $ sort xs
