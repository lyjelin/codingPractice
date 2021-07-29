import Prelude
import qualified Data.IntSet as Set
import Control.Monad (guard)

-- prob1
solve :: Int -> Int -> [Int]
solve n 0 = []
solve n m
 | n `rem` m == 0 =  myList
 | otherwise = (drop (n `rem` m) myList) ++ (replicate (n `rem` m) ((n `quot` m)+1))  
 where 
  myList = replicate m (n `quot` m)

-- prob 2
ismember _ [] = False
ismember x (y:ys) =
 if x == y then
  True
 else 
  ismember x ys
                   
-- prob 3
checkHappyDigits :: [Int] -> Int -> Int
checkHappyDigits [] _ = 0
checkHappyDigits (x:xs) k = sum[check47 a k | a <- (x:xs)]   
 
check47 n k
   | n < 10^k = 1 
   | n >= 10^k = check47' n k 0

       
check47' n k x
  | k > x && (n `rem` 10 == 4 || n `rem` 10 == 7) = check47' m k x'
  | k > x && (n `rem` 10 /= 4 || n `rem` 10 /= 7) = check47' m k x
  | k == x && (n `rem` 10 == 4 || n `rem` 10 == 7) = check47' m k x'
  | k == x && (n `rem` 10 /= 4 || n `rem` 10 /= 7) = 1
  | k < x = 0
    where 
      x' = x + 1
      m = n `div` 10

-- prob 4
numBST :: Int -> Int
numBST n = rem (sum([nthBST 1 t n | t <- [1..n]])) (10^9 + 7)
nthBST l m r
    | l == m && m == r = 1
    | l == m && m /= r = sum([nthBST (m+1) mr r | mr <- [(m+1)..r]])
    | l /= m && m == r = sum([nthBST l ml (m-1) | ml <- [l..(m-1)]])
    | otherwise = (sum([nthBST l ml (m-1) | ml <- [l..(m-1)]])) * (sum([nthBST (m+1) mr r | mr <- [(m+1)..r]]))

-- prob 5
getX (x:xs) k
  | k == 1 = [x] ++ [0]
  | otherwise = getX arr k'
    where
      c = head (x:xs)
      arr = tail (x:xs)
      k' = k - 1

qsort :: Ord a => [a] -> [a]
qsort [] = []
qsort (x:xs) = qsort smaller ++ [x] ++ qsort larger
  where
    smaller = [a|a <- xs, a <= x]
    larger = [b|b <- xs, b>x]

pointIn :: [Int] -> Int -> [Int]
pointIn (x:xs) k 
  | check < k = [-1]
  | check >= k = getX ar2 k 
    where
      ar1 = qsort (x:xs)
      ar2 = reverse ar1
      check = head ar2 

   
-- prob 6
isTwinPaired :: [Int] -> Bool
isTwinPaired [] = True
isTwinPaired (x:xs) = checkUp evenList && checkDown oddList 
 where
  evenList = [a|a <- xs, a `mod` 2 == 0 ]
  oddList = [b|b <- xs, b `mod` 2 == 1 ]
 
checkUp :: (Ord a) => [a] -> Bool
checkUp [] = True
checkUp (x : []) = True
checkUp (x:y:xs) = (x <= y) && checkUp (y:xs)
 
checkDown :: (Ord a) => [a] -> Bool
checkDown [] = True
checkDown (x : []) = True
checkDown (x:y:xs) = (x >= y) && checkDown (y:xs)

-- prob 7
-- chessboard size : N*N (8<=N<15)
-- N knights on chessboard
-- 1. Must not lie on same row/column/diagonal
-- 2. Must not lie 'L-shape' to another knight:30

chess :: Int -> Int
chess n
    = length (go Set.empty Set.empty Set.empty
                 (100, 100)
                 n)
    where go _ _ _ _ 0
              = return ()
          go hor d antidiag (j1, j2) left = do
              j <- [1..n]
              let i = n - left
                  cord = j - i
                  diag = j + i
              guard $ abs (j2 - j) /= 2
              guard $ abs (j1 - j) /= 1
              guard $ j `Set.notMember` hor
              guard $ cord `Set.notMember` d
              guard $ diag `Set.notMember` antidiag
              go (Set.insert j hor)
                 (Set.insert cord d)
                 (Set.insert diag antidiag)
                 (j2, j)
                 (left - 1)

main :: IO ()
main = interact $ show . chess . read










