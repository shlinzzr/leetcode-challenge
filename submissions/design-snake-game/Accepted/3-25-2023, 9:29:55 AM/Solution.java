// https://leetcode.com/problems/design-snake-game

public class SnakeGame {

    //2D position info is encoded to 1D and stored as two copies 
    Set<Integer> set; // this copy is good for fast loop-up for eating body case
    Deque<Integer> dq; // this copy is good for updating tail
    int score;
    int[][] food;
    int foodIndex;
    int width;
    int height;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0); //intially at [0][0]
        dq = new LinkedList<>();
        dq.offerLast(0);
    }
    
  
    public int move(String direction) {
        //case 0: game already over: do nothing
        if (score == -1) {
            return -1;
        }
        
        // compute new head
        int rowHead = dq.peekFirst() / width;
        int colHead = dq.peekFirst() % width;
        switch (direction) {
            case "U" : rowHead--;
                       break;
            case "D" : rowHead++;
                       break;
            case "L" : colHead--;
                       break;
            default :  colHead++;
        }
        int head = rowHead * width + colHead;
        
        //case 1: out of boundary or eating body
        set.remove(dq.peekLast()); // new head is legal to be in old tail's position, remove from set temporarily 
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        
        // add head for case2 and case3
        set.add(head); 
        dq.offerFirst(head);
        
        //case2: eating food, keep tail, add head
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(dq.peekLast()); // old tail does not change, so add it back to set
            foodIndex++;
            return ++score;
        }
        
        //case3: normal move, remove tail, add head
        dq.pollLast();
        return score;
        
    }
}