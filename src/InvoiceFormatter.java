/**
 * 
 * @author brettnelson
 * formats an invoice
 */
public class InvoiceFormatter {

	private Invoice invoice;
	
	public InvoiceFormatter(Invoice anInvoice)
	{
		invoice = anInvoice;
	}
	
	/**
		Formats the invoice.
		@return the formatted invoice 
	 */
	public String format() 
	{
		String r= " INVOICE\n\n" + invoice.billingAddress.format()
				+ String.format("\n\n%-30s%8s%5s%8s\n", "Description", "Price", "Qty", "Total");
		
		for (LineItem item : invoice.items) 
			r = r + item.format() + "\n"; 
		
		r = r + String.format("\nAMOUNT DUE: $%8.2f", invoice.getAmountDue()); 
		return r;
	}
}
