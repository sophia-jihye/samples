package samples.simpleExcel;

public class CustomerVo {
	private String custId;
	private String custName;
	private String custAge;
	private String custEmail;

	public CustomerVo() {
		super();
	}

	public CustomerVo(String custId, String custName, String custAge,
			String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAge = custAge;
		this.custEmail = custEmail;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAge() {
		return custAge;
	}

	public void setCustAge(String custAge) {
		this.custAge = custAge;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerVo [custId=");
		builder.append(custId);
		builder.append(", custName=");
		builder.append(custName);
		builder.append(", custAge=");
		builder.append(custAge);
		builder.append(", custEmail=");
		builder.append(custEmail);
		builder.append("]");
		return builder.toString();
	}

}
