# Quicksort / Pivot Sort
def qs(arr)
  if arr.length <= 1
    arr
  else
    pivot = arr[0]
    left = arr[1, arr.length - 1].select { |x| x < pivot }
    right = arr[1, arr.length - 1].select { |x| x > pivot }
    qs(left) + [pivot] + qs(right)
  end
end

# Merge Sort / Split Sort
def ms(arr)
  # Base
  if arr.length <= 1
    arr
  else
    # Divide
    middle = arr.length / 2
    left = ms(arr[0, middle])
    right = ms(arr[middle, arr.length - middle])
    
    # Conquer
    left_index = 0
    right_index = 0
    sorted = []
    while left_index < left.length && right_index < right.length
      if left[left_index] <= right[right_index]
        sorted << left[left_index]
        left_index += 1
      else
        sorted << right[right_index]
        right_index += 1
      end
    end

    while left_index < left.length
        sorted << left[left_index]
        left_index += 1
    end

    while right_index < right.length
        sorted << right[right_index]
        right_index += 1
    end
    
    sorted
  end
end

test_array = [5, 10, 1, 3]
p qs(test_array)
p ms(test_array)

