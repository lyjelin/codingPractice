{-# LANGUAGE InstanceSigs #-}
{-# LANGUAGE DeriveFunctor #-}

module ListMaybe
  ( LM(..)
  , ML(..)
  ) where
import Control.Applicative
import Control.Monad

import Data.Maybe
import Data.List

newtype LM a = LM { getLM :: [Maybe a] }
  deriving Functor
-- LM :: [Maybe a] -> LM a
-- getLM :: LM -> [Maybe a]

instance Applicative LM where
  pure = return
  (<*>) = liftM2 ($)

-- | Problem 4.1
instance Monad LM where
  return :: a -> LM a
  return = LM . pure . pure

  (>>=) :: LM a -> (a -> LM b) -> LM b
  (LM xs) >>= k = LM [ y | Just x <- xs, y <- getLM $ k x]

newtype ML a = ML { getML :: Maybe [a] }
  deriving Functor

instance Applicative ML where
  pure = return
  (<*>) = liftM2 ($)

-- | Problem 4.2
instance Monad ML where
  return :: a -> ML a
  return = ML . pure . pure

  (>>=) :: ML a -> (a -> ML b) -> ML b
  (ML mxs) >>= k = ML $ fmap (concat . catMaybes . map (getML . k)) mxs

