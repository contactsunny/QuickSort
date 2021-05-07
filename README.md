# Quick Sort

This is a simple Java program to demonstrate how quick sort works.

## Input

```shell script
Original array: [3, 7, 8, 2, 1]
-----------------
```

## Output

```shell script
Sorted array: [1, 2, 3, 7, 8]
-----------------
```

## Process

Consider the input array mentioned above. First, we find the partition index.

In the ```getPartitionIndex()``` method,

```shell script
left = 0, right = 4
pivot = array[right] = 4
partitionIndex = left - 1 = 0 - 1 = -1

index = left = 0
is array[0] < pivot => is 3 less than 1? No! index++
is array[1] < pivot => is 7 less than 1? No! index++
is array[2] < pivot => is 8 less than 1? No! index++
is array[3] < pivot => is 2 less than 1? No! index++

Loop is complete. Swap pivot with partitionIndex + 1.
The new array now is
[1, 7, 8, 2, 3]
partition index = -1 + 1 = 0

Now, we quick sort the left and the right sub arrays.
Left sub-array = index 0 to index (partition index -1) => 0 to 0 => [1]
Right sub-array = (partition index + 1) to right => 1 to 4 => [7, 8, 2, 3]

---

Since the left sub-array has only one element, it'll be returned as is.

---

The right sub-array is [7, 8, 2, 3]

left = 0, right = 3
pivot = array[right] = 3
parition index = left - 1 = 1 - 1 = 0

index = left to (right - 1) = 0 to 3 - 1 = 0 to 2
is array[0] < pivot => is 7 less than 3? => No! index++
is array[1] < pivot => is 8 less than 3? => No! index++
is array[2] < pivot => is 2 less than 3? => Yes! 
increment partition index, swap with index element.
New array = [2, 8, 7, 3]
partition index = 1

Loop is complete. Swap the pivot with partition index + 1
New array = [2, 3, 7, 8]

The returned parttion index = 1 + 1 = 2

---

The new sorted array is now left sub-array + right sub-array
=> [1, 2, 3, 7, 8] 
```