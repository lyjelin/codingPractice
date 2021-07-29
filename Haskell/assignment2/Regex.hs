module Regex
  ( Regex
  , regexP
  , matcher
  ) where

import Combinators
import Parser

import Control.Applicative hiding (optional)
import Control.Arrow
import Control.Monad
import Control.Monad.State
import Prelude

import Data.Char
import Data.Functor
import Data.List 
import Data.Monoid

import Text.Printf


{- * Question 6 - 7. (40 pts)

Add definitions of Regex, replace `undefined` with your implementation.
You are encouraged to add auxilliary functions and data types to aid your
implementation.

-}
  -- Alternatively, you can define `showsPrec` instead of `show`,
  -- as long as you know what you are doing.
  -- -- showsPrec :: Int -> Regex -> String
  -- showsPrec = undefined

data Regex = Epsilon
           | Star Regex
           | Plus Regex
           | Quest Regex
           | Union Regex Regex
           | Con Regex Regex
           | Group Regex
           | Term Char
           | Var Regex Regex 


instance Show Regex where
  -- show :: Regex -> String
  show (Star r)       = show r ++ "*"             -- star
  show (Plus r)       = show r ++ "+"
  show (Quest r)      = show r ++ "?"
  show (Union r1 r2)  = show r1 ++ "|" ++ show r2 -- unionP
  show (Con r1 r2)    = show r1 ++ show r2        -- concatenation
  show (Group r)      = "(" ++ show r ++ ")"      -- 
  show (Term c)       = [c]                       -- term
  show (Var r1 r2) = show r1 ++ "." ++ show r2

term :: Parser Regex
term = Term <$> foldr ((<|>) . char) empty (['a' .. 'z'] ++ ['0' .. '9'])

epsilon :: Parser Regex
epsilon = (\_ -> Epsilon) <$> char '&'

subRegExp :: Parser Regex
subRegExp = char '(' *> regexP <* char ')'

factor :: Parser Regex
factor = term <|> subRegExp <|> epsilon

star :: Parser Regex
star = Star <$> (factor <* char '*')

plus :: Parser Regex
plus = Plus <$> ( <* char '+')

quest :: Parser Regex
quest = Quest <$> (factor <* char '?')

concatenation :: Parser Regex
concatenation =
    Con
        <$> (star <|> factor)
        <*> (concatenation <|> star <|> factor)

unionP :: Parser Regex
unionP = Union
        <$> ((concatenation <|> star <|> factor) <* char '+')
        <*> (regexP <|> subRegExp)

regexP :: Parser Regex
regexP = unionP <|> concatenation <|> star <|> factor <|> plus <|> quest


{- * Question 8. (25 pts)

Replace `undefined` with your implementation

-}

matcher :: Regex -> Parser String
matcher = undefined

