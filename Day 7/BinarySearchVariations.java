import java.util.Arrays;

public class BinarySearchVariations {

    // =========================================================
    // 1. NORMAL BINARY SEARCH
    // =========================================================
    // Finds any occurrence of target.
    //
    // Example:
    // [1, 2, 4, 6, 8, 10]
    // target = 6
    // returns index 3
    //
    // Time: O(log n)
    // Space: O(1)
    // =========================================================

    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }


    // =========================================================
    // 2. FIRST OCCURRENCE
    // =========================================================
    // Finds the first position of target.
    //
    // Example:
    // [1, 2, 2, 2, 4]
    // target = 2
    //
    // answer = 1
    //
    // Important:
    // When target is found, DON'T return.
    // Search further LEFT.
    // =========================================================

    public static int firstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                answer = mid;

                // Maybe another target exists on the left
                right = mid - 1;
            }
            else if (arr[mid] < target) {

                left = mid + 1;
            }
            else {

                right = mid - 1;
            }
        }

        return answer;
    }


    // =========================================================
    // 3. LAST OCCURRENCE
    // =========================================================
    // Finds the last position of target.
    //
    // Example:
    // [1, 2, 2, 2, 4]
    // target = 2
    //
    // answer = 3
    //
    // When target is found:
    // Search further RIGHT.
    // =========================================================

    public static int lastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                answer = mid;

                // Maybe another target exists on the right
                left = mid + 1;
            }
            else if (arr[mid] < target) {

                left = mid + 1;
            }
            else {

                right = mid - 1;
            }
        }

        return answer;
    }


    // =========================================================
    // 4. COUNT OCCURRENCES
    // =========================================================
    // Uses first and last occurrence.
    //
    // count = last - first + 1
    // =========================================================

    public static int countOccurrences(int[] arr, int target) {

        int first = firstOccurrence(arr, target);

        // Target doesn't exist
        if (first == -1) {
            return 0;
        }

        int last = lastOccurrence(arr, target);

        return last - first + 1;
    }


    // =========================================================
    // 5. FLOOR
    // =========================================================
    // Floor = largest value <= target
    //
    // Example:
    // [2, 5, 8, 12, 16]
    // target = 10
    //
    // floor = 8
    //
    // If arr[mid] <= target:
    //     save it
    //     search RIGHT for a larger valid value
    // =========================================================

    public static int floor(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {

                answer = arr[mid];

                // Look for a bigger valid value
                left = mid + 1;
            }
            else {

                right = mid - 1;
            }
        }

        return answer;
    }


    // =========================================================
    // 6. CEILING
    // =========================================================
    // Ceiling = smallest value >= target
    //
    // Example:
    // [2, 5, 8, 12, 16]
    // target = 10
    //
    // ceiling = 12
    //
    // If arr[mid] >= target:
    //     save it
    //     search LEFT for a smaller valid value
    // =========================================================

    public static int ceiling(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {

                answer = arr[mid];

                // Look for a smaller valid value
                right = mid - 1;
            }
            else {

                left = mid + 1;
            }
        }

        return answer;
    }


    // =========================================================
    // 7. LOWER BOUND
    // =========================================================
    // Finds the FIRST index where:
    //
    // arr[index] >= target
    //
    // Example:
    // [1, 2, 4, 4, 4, 7]
    // target = 4
    //
    // answer = 2
    //
    // This is essentially the index version of CEILING.
    // =========================================================

    public static int lowerBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {

                // mid could be the answer
                right = mid;
            }
            else {

                // mid is definitely not the answer
                left = mid + 1;
            }
        }

        return left;
    }


    // =========================================================
    // 8. UPPER BOUND
    // =========================================================
    // Finds the FIRST index where:
    //
    // arr[index] > target
    //
    // Example:
    // [1, 2, 4, 4, 4, 7]
    // target = 4
    //
    // answer = 5
    //
    // Therefore:
    //
    // last occurrence = upperBound(target) - 1
    // =========================================================

    public static int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {

                right = mid;
            }
            else {

                left = mid + 1;
            }
        }

        return left;
    }


    // =========================================================
    // 9. FIRST OCCURRENCE USING LOWER BOUND
    // =========================================================

    public static int firstUsingLowerBound(int[] arr, int target) {

        int index = lowerBound(arr, target);

        if (index == arr.length || arr[index] != target) {
            return -1;
        }

        return index;
    }


    // =========================================================
    // 10. LAST OCCURRENCE USING UPPER BOUND
    // =========================================================

    public static int lastUsingUpperBound(int[] arr, int target) {

        int index = upperBound(arr, target) - 1;

        if (index < 0 || arr[index] != target) {
            return -1;
        }

        return index;
    }


    // =========================================================
    // 11. SEARCH INSERT POSITION
    // =========================================================
    // Finds where target should be inserted while maintaining
    // sorted order.
    //
    // This is exactly LOWER BOUND.
    //
    // Example:
    // [1, 3, 5, 6]
    // target = 4
    //
    // answer = 2
    //
    // [1, 3, 4, 5, 6]
    //       ^
    //      index 2
    // =========================================================

    public static int searchInsertPosition(int[] arr, int target) {

        return lowerBound(arr, target);
    }


    // =========================================================
    // 12. BINARY SEARCH ON ANSWER
    // =========================================================
    //
    // Example problem:
    //
    // Given weights and number of days,
    // find minimum ship capacity needed.
    //
    // IMPORTANT:
    //
    // We are NOT binary searching the array.
    //
    // We are binary searching the possible ANSWERS.
    // =========================================================

    public static int minimumShipCapacity(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Minimum possible capacity =
        // largest individual weight
        //
        // Maximum possible capacity =
        // sum of all weights

        for (int weight : weights) {

            left = Math.max(left, weight);

            right += weight;
        }


        // Search for minimum feasible capacity

        while (left < right) {

            int capacity = left + (right - left) / 2;

            if (canShip(weights, days, capacity)) {

                // Capacity works.
                // Try a smaller capacity.
                right = capacity;
            }
            else {

                // Capacity doesn't work.
                // Need larger capacity.
                left = capacity + 1;
            }
        }

        return left;
    }


    // =========================================================
    // HELPER FOR SEARCH ON ANSWER
    // =========================================================
    //
    // Can we ship all weights within 'days'
    // using this capacity?
    // =========================================================

    private static boolean canShip(
            int[] weights,
            int days,
            int capacity) {

        int daysUsed = 1;

        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight > capacity) {

                // Start another day
                daysUsed++;

                currentLoad = 0;
            }

            currentLoad += weight;
        }

        return daysUsed <= days;
    }


    // =========================================================
    // 13. MAXIMUM FEASIBLE ANSWER
    // =========================================================
    //
    // Example:
    //
    // Given positions of stalls, place k cows.
    //
    // We want to MAXIMIZE the minimum distance.
    //
    // This demonstrates the opposite search direction.
    // =========================================================

    public static int aggressiveCows(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int left = 1;

        int right = stalls[stalls.length - 1]
                - stalls[0];

        int answer = 0;

        while (left <= right) {

            int distance = left
                    + (right - left) / 2;

            if (canPlaceCows(stalls, cows, distance)) {

                // This distance works.
                // Try a bigger distance.
                answer = distance;

                left = distance + 1;
            }
            else {

                // Distance doesn't work.
                // Try smaller.
                right = distance - 1;
            }
        }

        return answer;
    }


    // =========================================================
    // HELPER FOR AGGRESSIVE COWS
    // =========================================================

    private static boolean canPlaceCows(
            int[] stalls,
            int cows,
            int minimumDistance) {

        int cowsPlaced = 1;

        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= minimumDistance) {

                cowsPlaced++;

                lastPosition = stalls[i];

                if (cowsPlaced == cows) {
                    return true;
                }
            }
        }

        return false;
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       BINARY SEARCH VARIATIONS");
        System.out.println("==========================================");


        // -----------------------------------------------------
        // Array for normal / boundary searches
        // -----------------------------------------------------

        int[] arr = {1, 2, 2, 2, 4, 5, 5, 8, 10};

        System.out.println("\nArray:");
        System.out.println(Arrays.toString(arr));


        // -----------------------------------------------------
        // 1. Normal Binary Search
        // -----------------------------------------------------

        int target = 5;

        System.out.println("\n1. NORMAL BINARY SEARCH");

        int index = binarySearch(arr, target);

        System.out.println(
                "Target = " + target +
                ", Index = " + index
        );


        // -----------------------------------------------------
        // 2. First Occurrence
        // -----------------------------------------------------

        System.out.println("\n2. FIRST OCCURRENCE");

        int first = firstOccurrence(arr, target);

        System.out.println(
                "Target = " + target +
                ", First Index = " + first
        );


        // -----------------------------------------------------
        // 3. Last Occurrence
        // -----------------------------------------------------

        System.out.println("\n3. LAST OCCURRENCE");

        int last = lastOccurrence(arr, target);

        System.out.println(
                "Target = " + target +
                ", Last Index = " + last
        );


        // -----------------------------------------------------
        // 4. Count Occurrences
        // -----------------------------------------------------

        System.out.println("\n4. COUNT OCCURRENCES");

        int count = countOccurrences(arr, target);

        System.out.println(
                "Target = " + target +
                ", Count = " + count
        );


        // -----------------------------------------------------
        // 5. Floor
        // -----------------------------------------------------

        target = 6;

        System.out.println("\n5. FLOOR");

        System.out.println(
                "Target = " + target +
                ", Floor = " + floor(arr, target)
        );


        // -----------------------------------------------------
        // 6. Ceiling
        // -----------------------------------------------------

        System.out.println("\n6. CEILING");

        System.out.println(
                "Target = " + target +
                ", Ceiling = " + ceiling(arr, target)
        );


        // -----------------------------------------------------
        // 7. Lower Bound
        // -----------------------------------------------------

        target = 5;

        System.out.println("\n7. LOWER BOUND");

        int lower = lowerBound(arr, target);

        System.out.println(
                "Target = " + target +
                ", First index >= target = " + lower
        );


        // -----------------------------------------------------
        // 8. Upper Bound
        // -----------------------------------------------------

        System.out.println("\n8. UPPER BOUND");

        int upper = upperBound(arr, target);

        System.out.println(
                "Target = " + target +
                ", First index > target = " + upper
        );


        // -----------------------------------------------------
        // 9. First using Lower Bound
        // -----------------------------------------------------

        System.out.println("\n9. FIRST USING LOWER BOUND");

        System.out.println(
                "First occurrence = " +
                firstUsingLowerBound(arr, target)
        );


        // -----------------------------------------------------
        // 10. Last using Upper Bound
        // -----------------------------------------------------

        System.out.println("\n10. LAST USING UPPER BOUND");

        System.out.println(
                "Last occurrence = " +
                lastUsingUpperBound(arr, target)
        );


        // -----------------------------------------------------
        // 11. Search Insert Position
        // -----------------------------------------------------

        target = 6;

        System.out.println("\n11. SEARCH INSERT POSITION");

        System.out.println(
                "Target = " + target +
                ", Insert index = " +
                searchInsertPosition(arr, target)
        );


        // -----------------------------------------------------
        // 12. SEARCH ON ANSWER
        // -----------------------------------------------------

        System.out.println("\n12. SEARCH ON ANSWER");

        int[] weights = {1, 2, 3, 4, 5};

        int days = 3;

        int capacity =
                minimumShipCapacity(weights, days);

        System.out.println(
                "Weights = " +
                Arrays.toString(weights)
        );

        System.out.println(
                "Days = " + days
        );

        System.out.println(
                "Minimum ship capacity = " +
                capacity
        );


        // -----------------------------------------------------
        // 13. MAXIMUM FEASIBLE ANSWER
        // -----------------------------------------------------

        System.out.println("\n13. MAXIMUM FEASIBLE ANSWER");

        int[] stalls = {1, 2, 4, 8, 9};

        int cows = 3;

        int maximumDistance =
                aggressiveCows(stalls, cows);

        System.out.println(
                "Stalls = " +
                Arrays.toString(stalls)
        );

        System.out.println(
                "Cows = " + cows
        );

        System.out.println(
                "Maximum minimum distance = " +
                maximumDistance
        );


        // -----------------------------------------------------
        // SUMMARY
        // -----------------------------------------------------

        System.out.println("\n==========================================");
        System.out.println("SUMMARY");
        System.out.println("==========================================");

        System.out.println(
                "Normal Search       -> Find target"
        );

        System.out.println(
                "First Occurrence    -> First target"
        );

        System.out.println(
                "Last Occurrence     -> Last target"
        );

        System.out.println(
                "Floor               -> Largest <= target"
        );

        System.out.println(
                "Ceiling             -> Smallest >= target"
        );

        System.out.println(
                "Lower Bound         -> First index >= target"
        );

        System.out.println(
                "Upper Bound         -> First index > target"
        );

        System.out.println(
                "Search on Answer    -> Minimum/maximum feasible answer"
        );
    }
}