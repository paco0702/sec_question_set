
public class AssignmentProblem {
	AssignmentProblem(){
		
	}
	/*
	have N person 
	each person have exactly one job 
	each of them have thier own capability 

	you task is to assign the jobs to the persons in 
	such a way that the total time taken is min 
	
	
	 */
	public static void main(String[] args) {
	/*
	 first line of each test case contain an integer N 
	 N is the number of jobs 
	 and number of person under you 
	 
	 N^2 positive integers 
	 first N of these interger denote the time taken by the first person to do the N jobs 
	 the net N integers denote the time taken by the second person to do the N job 
	 	
	 */
		
		
		AssignmentProblem as = new AssignmentProblem();
		
		int numOfPerson = 3;
		int numOfTask = 3;
		
		int [] taskTime  = {
				2,1,2,9,8,1,1,1,1
		};
		
		int [][] selectedTask = as.assignTask(taskTime, numOfPerson, numOfTask);
		int minTime =0;
		for(int i=0; i<selectedTask.length; i++) {
			for(int j=0; j<selectedTask[i].length; j++) {
				if(selectedTask[i][j]!=1000) {
					System.out.println("Person "+(j+1)+" Picked Task "+ i );
					minTime = minTime + selectedTask [i][j];
				}
			}
		}
		System.out.println("Min Time is: "+ minTime);
	}
	
	
	public int [][] assignTask(int [] taskTime, int numOfPerson, int numOfTask) {
		int [][] organizeTime = new int[numOfPerson][numOfTask];
		int k =0 ;
		for(int i=0; i<organizeTime.length; i++) {
			for(int j=0; j<organizeTime[i].length; j++) {
				organizeTime[i][j] = taskTime[k];
				k++;
			}
		}
		return assign(organizeTime, numOfPerson, numOfTask);
	}
	
	private int [][] assign(int [][] organizeTime, int numOfPerson, int numOfTask) {
		int pickedIndex = 0;
		int [] selectedTask = new int [numOfTask];
		int s = 0;
		
		for(int i=0; i<numOfPerson; i++) {
			int minTime = 100;
			for(int j=0; j<numOfTask;j++) {
				if(organizeTime[i][j]<minTime) {
					minTime = organizeTime[i][j];
					pickedIndex = j;
				}
			}
			selectedTask[s] = organizeTime[i][pickedIndex];
			s++;
			// change the value of picked person
			for(int k=0; k<numOfTask; k++) {
				if(k!=i) {
					organizeTime[k][pickedIndex] = 1000 ;
				}
			}
		}
		
		return organizeTime;
	}
	
	
}
