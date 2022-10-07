package BaseTest;

import java.util.Arrays;
import java.util.List;

public class Regression_Datasheet {

	public List<Object> Datasheet(String Transaction_Name, String Regression_LOB)
	{
		
		String Datasheet = null;
		
		if(Transaction_Name.contains("Quote")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Quote Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Quote Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Issue")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Issue Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Issue Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Endorsement")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Endorsement Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Endorsement Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Renewal") || Transaction_Name.contains("Renew")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Renewal Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Renewal Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Cancellation") || Transaction_Name.contains("Flat Cancel")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Cancellation Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Cancellation Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Reinstate") || Transaction_Name.contains("Reinstatement")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Reinstatement Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Reinstatement Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Audit")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Audit Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Audit Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Establish�Non-Renewal")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Non-Renewal Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Non-Renewal Workflow_OCM.xlsx";
				
			}
			
		}
		
		else if(Transaction_Name.contains("Remove�Non-Renewal")) 
		{
			
			if(Regression_LOB.equalsIgnoreCase("Workers Compensation")) 
			{
				
				Datasheet = "Policy Decision Remove Non-Renewal Workflow_WCA.xlsx";
				
			}
			
			else if(Regression_LOB.equalsIgnoreCase("Ocean Marine")) 
			{
				
				Datasheet = "Policy Decision Remove Non-Renewal Workflow_OCM.xlsx";
				
			}
			
		}
		
		return Arrays.asList(Datasheet);
	}
	
}
