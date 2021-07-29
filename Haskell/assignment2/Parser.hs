{-# LANGUAGE GeneralisedNewtypeDeriving #-}

module Parser
  ( Parser(..)
  , success
  , failure
  , parser
  , runParser
  , next
  , satisfy
  , char
  , eof
  , (+++)
  , string
  , many
  , some
  , many1)
  where

import Prelude hiding (fail)

import Control.Monad.State
    ( MonadPlus, MonadState, StateT(..) )

import Control.Applicative (Alternative, (<|>), many, some)
import Control.Monad.Fail (MonadFail(..))

{- |
Haskell magic depends on ghc version 8.6.1,                                                                                                                                                                                     
the definition is equivalent to:
@
Parser a = Parser { getParser :: String -> [(a, String)] }
@

If you don't know what's happening in this definition, just stick to the
utilities provided by the rest of the file.
-}
newtype Parser a = Parser { getParser :: StateT String [] a }
  deriving ( Functor, Applicative, Monad, Alternative
           , MonadPlus, MonadFail, MonadState String)

{-
The following definition may not be optimal in terms of functional programming,
but they should give you additional ideas about how they work.
-}

-- | Trivial success of parser,
-- equivalent to `return` provided by `Monad` in Control.Monad
success :: a -> Parser a
success = return

-- | Trivial failure of parser,
-- similar to `fail` provided by `MonadFail` in Control.Monad.Fail
failure :: Parser a
failure = fail ""

-- | Construct a parser with the parsing function
parser :: (String -> [(a, String)]) -> Parser a
parser = Parser . StateT

-- | Retrieve the result of the parser with a string input
runParser :: Parser a -> String -> [(a, String)]
runParser = runStateT . getParser

-- | Advance the input by one character
next :: Parser Char
next = parser $ \s -> case s of
  [] -> []
  (c : s') -> [(c, s')]

-- | Advance the input by one character, if the character satisfy some condition
-- fail otherwise
satisfy :: (Char -> Bool) -> Parser Char
satisfy p = do
  c <- next
  if p c
    then return c -- or `success c`
    else failure

-- | Match the first character of the input string
char :: Char -> Parser Char
char c = satisfy (== c)

-- | Succeed if the end of input is reached, fail otherwise
eof :: Parser ()
eof = parser $ \s -> case s of
  [] -> [((), [])]
  _  -> []

-- | Choose the parser that succeeds to parse,
-- equivalent to `(<|>)` provided by Control.Applicative.Alternative
(+++) :: Parser a -> Parser a -> Parser a
(+++) = (<|>)

infixl 3 +++

-- | Match a prefix of the input string
string :: String -> Parser String
string s = case s of
  [] -> return []
  c : s' -> do
    char c
    string s'
    return (c : s')

-- | match the parser for one or more times
many1 :: Parser a -> Parser [a]
many1 = some

sepBy1 :: Parser a -> Parser b -> Parser [a]
sepBy1 p sep = do v <- p    -- at least one occurrence of p is ensured, parse & return 
                  s <- sep  -- ignore the sep & continue
                  vs <- sepBy p sep
                  return (v:vs)


sepBy :: Parser a -> Parser b -> Parser [a]
sepBy p sep = sepBy1 p sep +++ return [] 

item :: Parser Char
item =  parser (\inp -> case inp of
                      []     -> []
                      (x:xs) -> [(x,xs)])

{- * Additional Utilities

besides the definition above, you can use the following definition provided
by other modules with some haskell magic:

@
-- match the parser for one or more times,
-- provided by `Alternative` in Control.Applicative
some :: Parser a -> Parser [a]

-- match the parser for zero or more times
-- provided by `Alternative` in Control.Applicative
many :: Parser a -> Parser [a]
@

And of course, the `do` notation, support by `Monad` in Control.Monad
-}
