class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        long value = 1;

        row.add(1);

        for (int col = 0; col < rowIndex; col++) {

            value = value * (rowIndex - col) / (col + 1);

            row.add((int)value);
        }

        return row;
    }
}