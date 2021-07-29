module TicTacToe (tictactoe) where

import Control.Applicative ()
import Control.Monad ()
import Control.Monad.State ()

import Data.Char ()
import Data.List (intercalate, unfoldr)

import Text.Read ( readMaybe )

data Move = X | O deriving (Eq, Show)
data Cell = Occupied Move | Empty deriving Eq

instance Show Cell where
  show (Occupied X) = "X"
  show (Occupied O) = "O"
  show Empty = " "

data Validation = CorrectMove Int Int | OutOfBounds | NonEmpty | ParseError
data Status = Draw | Win Move | Playing
type Board = [Cell]

renderRow :: Board -> String
renderRow row = "| " ++ (intercalate " | " $ fmap show row) ++ " |"

dividingLine :: String
dividingLine = ".---.---.---."

renderBoard :: Board -> IO ()
renderBoard board = do
    putStrLn dividingLine
    putStrLn $ renderRow firstRow
    putStrLn dividingLine
    putStrLn $ renderRow secondRow
    putStrLn dividingLine
    putStrLn $ renderRow thirdRow
    putStrLn dividingLine
    where 
        firstRow  = take 3 board
        secondRow = drop 3 . take 6 $ board
        thirdRow  = drop 6 board

isWinning :: Board -> Move -> Bool
isWinning board = flip elem [map (board!!) x | x <- [0,4,8]:[2,4,6]:[0,3,6]:[1,4,7]:[2,5,8]:chunks 3 [0..8]] . replicate 3 . Occupied where
  chunks n = takeWhile (not . null) . unfoldr (Just . splitAt n)

gameOver :: Board -> Status
gameOver board
  | isWinning board X = Win X
  | isWinning board O = Win O
  | Empty `notElem` board = Draw
  | otherwise = Playing

nextMove :: Move -> Move
nextMove X = O
nextMove O = X

makeMove :: Board -> Move -> Int -> Int -> IO ()
makeMove board turn x y = do
  let newBoard = take i board ++ [Occupied turn] ++ drop (i + 1) board where i = (x - 1)*3 + y - 1
  case gameOver newBoard of
    Win player -> do
      renderBoard newBoard
      putStrLn $ show player ++ " WINS"
      return ()
    Draw -> do
      renderBoard newBoard
      putStrLn "DRAW"
      return ()
    Playing -> playRound newBoard (nextMove turn)

cell :: Board -> Int -> Int -> Cell
cell board x y = board !! ((x - 1) * 3 + y - 1)

validate :: String -> Board -> Validation
validate input board = case words input of
   [xStr, yStr] -> 
      case (readMaybe xStr, readMaybe yStr) of
         (Just x, Just y)
            | x < 1 || x > 3 || y < 1 || y > 3 -> OutOfBounds
            | cell board x y /= Empty -> NonEmpty
            | otherwise -> CorrectMove x y
         _ -> ParseError
   _ -> ParseError

playerInput :: Board -> Move -> IO()
playerInput board turn = do
  inp <- getLine
  case validate inp board of
     ParseError  -> do
       putStrLn "INVALID POSITION"
       playerInput board turn
     NonEmpty    -> do
       putStrLn "INVALID POSITION"
       playerInput board turn
     OutOfBounds -> do
       putStrLn "INVALID POSITION"
       playerInput board turn
     CorrectMove x y -> makeMove board turn x y

playRound :: Board -> Move -> IO ()
playRound board move = do
  renderBoard board
  putStrLn $ show move ++ " MOVE"
  playerInput board move

tictactoe :: IO ()
tictactoe = do
  let board = replicate 9 Empty
  playRound board O