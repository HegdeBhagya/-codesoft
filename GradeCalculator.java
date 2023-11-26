import java.util.Scanner;
public class GradeCalculator{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int sub=scanner.nextInt();
        int[] marks=new int[sub];
        for(int i=0;i<sub;i++)
        {
            System.out.print("Enter marks for subjects"+(i+1)+":");
            marks[i]=scanner.nextInt();
        }
        int total=calculate(marks);
        double avgPercentage=calculateAvgPercentage(total,sub);
        char grade=assignGrade(avgPercentage);
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);
        scanner.close();
    }
    private static int calculate(int[] marks)
    {
        int totals=0;
        for (int mark:marks)
        {
            totals+=mark;
        }
        return totals;
    }
    private static double calculateAvgPercentage(int total, int sub) {
        return (double) total/ sub;
    }
    private static char assignGrade(double avgPercentage) {
        if (avgPercentage >= 90) {
            return 'A';
        } else if (avgPercentage >= 80) {
            return 'B';
        } else if (avgPercentage >= 70) {
            return 'C';
        } else if (avgPercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
