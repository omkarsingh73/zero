<%@page import="controller.InvestController"%>  

<%  
Double amountAdded = Double.parseDouble(request.getParameter("amountAdded"));
System.out.println("Done1"+amountAdded);
InvestController controller = new InvestController();
controller.loggingInvest(amountAdded,null);  
//if(status>0)  
out.print("You are successfully registered");  
  
%> 