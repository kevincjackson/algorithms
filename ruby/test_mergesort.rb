require "minitest/autorun"
require_relative "mergesort"

class TestMeme < Minitest::Test
  def test_empty_array
    assert_equal([], mergesort([]))
  end

  def test_one_element_array
    assert_equal([true], mergesort([true]))
	end

  def test_two_element_array
    assert_equal([11, 22], mergesort([22, 11]))
  end

  def test_long_array
    assert_equal([11, 22, 33, 44, 55, 66], mergesort([55, 22, 11, 33, 66, 44]))
  end
end
