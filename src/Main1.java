
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Main1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> taskName = new ArrayList<>();
        ArrayList<Boolean> visit=new ArrayList<>();
        while (true) {


            System.out.println("===== MyTodoList =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Exit");
            System.out.println("Enter your Choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }


            int n = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            switch (n) {

                case 1:
                    System.out.println("==Add Task==");
                    System.out.println("Enter Task:");

                    String task = sc.nextLine();

                    if(task.trim().isEmpty()){
                        System.out.println("Task name cannot be empty");
                        break;
                    }

                    task=task.trim();

                    if(taskName.contains(task)){
                        System.out.println("Task already exist");
                        break;
                    }


                        taskName.add(task);

                        visit.add(false);

                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.println("==View Task==");
                    if(taskName.isEmpty()){
                        System.out.println("you haven't added a task yet");
                        break;
                    }

                        for (int i = 0; i < taskName.size(); i++) {
                            if(visit.get(i)==true) {
                                System.out.println(i + 1 + "." + taskName.get(i) + "---Completed");
                            }
                            else{
                                System.out.println(i + 1 + "." + taskName.get(i) + "---pending");
                            }
                        }

                    break;

                case 3:
                    System.out.println("==Update Task==");




                    if(taskName.isEmpty()){
                        System.out.println("You haven't added a task yet");
                        break;
                    }

                    System.out.println("Enter the task you have to change");

                    String oldTask=sc.nextLine();
                    if(oldTask.trim().isEmpty()){
                        System.out.println("Task name cannot be empty");
                        break;
                    }

                    boolean seen=false;
                    Iterator<String> it1=taskName.iterator();
                    while(it1.hasNext()) {
                        if(it1.next().equals(oldTask)) {
                            int index = taskName.indexOf(oldTask);
                            String newTask = sc.nextLine();
                            if(newTask.trim().isEmpty()){
                                System.out.println("Task name cannot be empty");
                                break;
                            }
                            if(taskName.contains(newTask)){
                                System.out.println("Existing task");
                                break;
                            }

                            taskName.set(index, newTask);
                            seen=true;
                            visit.set(index,false);
                            System.out.println("Updated Successfully");
                            break;
                        }

                    }

                    if(!seen){
                        System.out.println("No such tasks existed");
                    }



                    break;
                    case 4:
                    System.out.println("Delete Task");

                    if(taskName.isEmpty()){
                        System.out.println("You haven't added a task yet");
                        break;
                    }
                        System.out.println("Enter the task you have to delete");
                    String taskRemove=sc.nextLine();
                        Iterator<String>it=taskName.iterator();
                        boolean flag=false;
                    while(it.hasNext()){
                        if(it.next().equals(taskRemove)){

                            int indexRemove=taskName.indexOf(taskRemove);
                            taskName.remove(indexRemove);
                            visit.remove(indexRemove);
                            flag=true;
                            System.out.println("Task Deleted successfully");
                            break;
                        }



                    }
                    if(!flag) {
                        System.out.println("No such tasks existed");
                    }
                    break;

                case 5:
                    System.out.println("Mark Task as completed");


                    if(taskName.isEmpty()){
                        System.out.println("NO tasks added");
                        break;
                    }
                    System.out.println("Enter the task");
                    String completedTask=sc.nextLine();


                    boolean hasseen=false;
                    for(int i=0;i<taskName.size();i++) {
                        if (completedTask.equals(taskName.get(i))) {
                            visit.set(i,true);
                            hasseen=true;
                            System.out.println(taskName.get(i) + "--" + "Completed");
                            break;
                        }
                    }

                    if(!hasseen){
                        System.out.println("No such tasks exist");
                    }
                    break;

                case 6:
                    System.out.println("Exit");
                    System.out.println("Thank you for using MyTodoList!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            if (n == 6) {
                break;
            }
        }

    }
}
