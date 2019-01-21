# Sort an array
#   Strategy: divide an array into empty or size 1 arrays,
#   and then merge into new array by only comparing the first
#   elements.
# [] -> []
def mergesort(array)
  # End Condition
	# There's nothing to sort
	if array.length <= 1
  	array 

	else
    # Divide: keep splitting the array into left and right halves
  	# until they're empty or of size 1
    middle = array.length / 2
    left = mergesort array[0, middle]
    right = mergesort array[middle, array.length - middle]

    # Conquer: merge the right and left into a new merged array by
  	# comparing the first elements
  	merged = []
  	left_index = 0
  	right_index = 0

		while left_index < left.length && right_index < right.length
			if left[left_index] <= right[right_index]
				merged << left[left_index]
				left_index += 1
			else
				merged << right[right_index]
				right_index += 1
			end
		end

		while left_index < left.length
      merged << left[left_index]
      left_index += 1
		end

		while right_index < right.length
      merged << right[right_index]
      right_index += 1
		end

  	merged
	end
end


