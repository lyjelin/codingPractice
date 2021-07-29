module Combinators
  ( lookAhead
  , optional
  , choose
  , followedBy
  , manyUntil) where

import Parser

import Control.Applicative hiding (optional)
import Control.Monad ()
import Control.Monad.State

import Control.Arrow

import Data.Char
import Data.Functor
import Data.Monoid

{- * Question 1 - 5. (35 pts)

Replace `undefined` with your implementation.
You are free to add auxilliary functions or data types to aid your
implementation.
-}

-- Q1
lookAhead :: Parser Char
lookAhead = parser $ \s ->
            case s of
              [] -> []
              (x : s') -> [(x, s)]

-- Q2
-- auxiliary function for optional
opt a b = parser $ \s ->
  if null $ runParser a s
    then runParser b s
    else runParser a s
             
optional :: Parser a -> Parser (Maybe a)
optional p = opt (fmap Just p) (return Nothing)
  
-- Q3  
choose :: [Parser a] -> Parser a
choose =  foldr (<|>) empty

-- Q4
followedBy :: Parser a -> Parser b -> Parser a
followedBy p q =  p >>= (\inp -> q >> return inp)

-- Q5
manyUntil :: Parser a -> Parser b -> Parser [a]
manyUntil p q = (q >> pure [])
               <|> ((:) <$> p <*> manyUntil p q)

