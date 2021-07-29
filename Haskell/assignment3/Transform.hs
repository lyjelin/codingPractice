{-# LANGUAGE InstanceSigs #-}
{-# LANGUAGE DeriveFunctor #-}

module Transform
   ( Transform(..)
   , next
   , runTransform
   , evalTransform
   , Tree(..)
   , tFoldl
   , tToListWith
   ) where

import Control.Monad

newtype Transform a b = Transform { getTransform :: (b, a -> a) }
  deriving Functor

instance Applicative (Transform a) where
   pure = return
   (<*>) = liftM2 ($)

-- | Problem 2
instance Monad (Transform a) where
   return :: b -> Transform a b
   return x = Transform (x,id)

   (>>=) :: Transform a b -> (b -> Transform a c) -> Transform a c
   (Transform (x,f)) >>= k =
     case k x of
       Transform (y,g) -> Transform $ (y, g . f)

next :: (a -> a) -> Transform a ()
next k = Transform ((),k)

evalTransform :: Transform a b -> b
evalTransform = fst . getTransform

runTransform :: Transform a b -> a -> a
runTransform = snd . getTransform

countedFibonacci :: Int -> Transform Int Int
countedFibonacci 0 = return 0
countedFibonacci 1 = return 1
countedFibonacci n = do
   a <- countedFibonacci (n - 1)
   next (+1)
   b <- countedFibonacci (n - 2)
   return $ a + b

data Tree a = Leaf | Branch (Tree a) a (Tree a)

-- | Problem 3
tFoldl :: (b -> a -> b) -> b -> Tree a -> Transform [a] b
tFoldl f b Leaf = pure b
tFoldl f b (Branch l a r) = do
  b' <- tFoldl f b l
  next (++[a])
  tFoldl f (f b' a) r

tToListWith :: (b -> a -> b) -> Tree a -> Transform b [a]
tToListWith f Leaf = pure []
tToListWith f (Branch l a r) = do
  xs <- tToListWith f l
  next (`f` a)
  ys <- tToListWith f r
  pure (xs ++ a : ys)
