import java.util.*;


public class task_scheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> tasksMap = new HashMap<>();
        Map<Character, Integer> timeMap = new HashMap<>();
        PriorityQueue<Character> taskQueue = new PriorityQueue<>((a,b)-> (tasksMap.get(a) != tasksMap.get(b))?  tasksMap.get(b)- tasksMap.get(a): timeMap.get(a) - timeMap.get(b));

        for(char c : tasks){
            tasksMap.put(c, tasksMap.getOrDefault(c, 0) +1);
        }

        for(Character c : tasksMap.keySet()){
            timeMap.put(c, 0);
            taskQueue.add(c);
        }

        int currentTime = 0;

        while(!taskQueue.isEmpty()){
            List<Character> cycle = new ArrayList<>();
            int size = n+1;
            for(int x = 0; x< size; x++ ){
                if(taskQueue.isEmpty())
                    break;
                char c = taskQueue.poll();
                currentTime = Math.max(currentTime, timeMap.get(c));
                tasksMap.put(c, tasksMap.get(c) -1);
                timeMap.put(c, currentTime + n + 1);
                
                if(tasksMap.get(c) != 0){
                    cycle.add(c);
                }

                currentTime++;
            }

            //Add back to queue
            for(Character c: cycle){
                taskQueue.add(c);
            }
            
        }

        return currentTime;
    }
        
}
