class Solution {
    public int numberOfBeams(String[] bank) {
        int lastRowCount = 0;
        int totalBeams = 0;
        
        for (String row : bank) {
            int currentRowCount = 0;
            
            for (char cell : row.toCharArray()) {
                if (cell == '1') {
                    currentRowCount++;
                }
            }
            
            if (currentRowCount > 0) {
                if (lastRowCount > 0) {
                    totalBeams += lastRowCount * currentRowCount;
                }
                
                lastRowCount = currentRowCount;
            }
        }
        
        return totalBeams;
    }
}