import java.util.Scanner;

public class Budjet {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.format("Enter first name:\t\t\t" + " ");
		String firstName = in.next();
		System.out.print("Enter last name:\t\t\t" + " ");
		String lastName = in.next();
		System.out.format("Enter tuition per semester: \t\t" + " " + "$");
		double tuitionPerSemester = in.nextDouble();
		System.out.format("Enter housing cost per month: \t\t" + " " + "$");         //User input of monthly costs, name, and tuition per semester
		double housingPerMonth = in.nextDouble();
		System.out.format("Enter food cost per month: \t\t" + " " + "$");
		double foodPerMonth = in.nextDouble();
		System.out.format("Enter extra costs per month: \t\t" + " " + "$");
		double extraPerMonth = in.nextDouble();
		System.out.println();
		
		
		
		System.out.println("Educational Expenses for " + firstName + " " + lastName);
		System.out.println("****************************************************************");
		double tuitionAnnualnoFees = tuitionPerSemester*2;
		double tuitionAnnual = tuitionAnnualnoFees + tuitionAnnualnoFees*.05;
		double housingAnnual = housingPerMonth*12;
		double foodAnnual = foodPerMonth*12;
		double extraAnnual = extraPerMonth*12;
		double totalAnnual = tuitionAnnual + housingAnnual + foodAnnual + extraAnnual;                      //calculates annual costs and total four year cost
		double totalFourYear = totalAnnual*4;
		System.out.format("Annual tuition cost:\t\t\t $%.2f \n", tuitionAnnual);
		System.out.format("Annual housing cost:\t\t\t $%.2f \n", housingAnnual);
		System.out.format("Annual food cost:\t\t\t $%.2f \n", foodAnnual);
		System.out.format("Annual extra cost:\t\t\t $%.2f \n", extraAnnual);								// prints out annual costs and total four year cost
		System.out.format("Total annual cost:\t\t\t $%.2f \n", totalAnnual);
		System.out.println("****************************************************************");
		System.out.format("Total four year cost:\t\t\t" + " " + "$%.2f \n" , totalFourYear);
		System.out.println();
		
		
		
		System.out.println("Payment");
		System.out.println("****************************************************************");
		System.out.format("Enter annual parental contribution: \t" + " " + "$");
		double parentalContribution = in.nextDouble();
		System.out.format("Enter annual personal contribution: \t" + " " + "$");							//user input of annual parent contribution, personal contribution, and grants
		double personalContribution = in.nextDouble();
		System.out.format("Enter annual grants: \t\t\t" + " " + "$");
		double annualGrants = in.nextDouble();
		double annualLoanValue = totalAnnual - parentalContribution - personalContribution - annualGrants;								//calculates annual loan value
		double fourYearLoan = 1.056*(1.056*(1.056*(1.056*annualLoanValue + annualLoanValue) + annualLoanValue) + annualLoanValue);		//takes annual loan value and calculates the four year loan value including interest
		System.out.println();
		
		
		
		System.out.println("Loans");
		System.out.println("****************************************************************");
		System.out.format("Annual loan value:  \t\t\t"  +  " $%.2f \n" , + annualLoanValue);					//prints out annual loan value and four year loan value including interest. 
		System.out.format("Four year loan total with interest:  \t" + " " + "$%.2f \n" , + fourYearLoan);
		
		
		
		
		
	}

}
