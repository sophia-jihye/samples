package samples.simpleExcel;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		System.out.println("* Reader * ");
		CustomerExcelReader excelReader = new CustomerExcelReader();

		System.out.println("===xls===");
		List<CustomerVo> xlsList = excelReader
				.xlsCustomerVoList("C:\\DevelopTools\\Eclipse\\Workspace\\PRIVATE\\samples\\input\\1.xls");
		System.out.println(xlsList);
		System.out.println("======��======");

		System.out.println("===xlsx===");
		List<CustomerVo> xlsxList = excelReader
				.xlsxCustomerVoList("C:\\DevelopTools\\Eclipse\\Workspace\\PRIVATE\\samples\\input\\2.xlsx");
		System.out.println(xlsxList);
		System.out.println("======��======");
		System.out.println("* Reader ��* ");

		System.out.println("* Writer *");
		CustomerExcelWriter excelWriter = new CustomerExcelWriter();
		List<CustomerVo> list = new ArrayList<CustomerVo>();
		list.add(new CustomerVo("id10", "������10", "10", "email10"));
		list.add(new CustomerVo("id20", "������20", "20", "email20"));
		list.add(new CustomerVo("id30", "������30", "30", "email30"));

		System.out.println("===xls===");
		excelWriter
				.xlsWriter(list,
						"C:\\DevelopTools\\Eclipse\\Workspace\\PRIVATE\\samples\\output\\1.xls");
		System.out.println("======��======");

		System.out.println("===xlsx===");
		excelWriter
				.xlsxWriter(list,
						"C:\\DevelopTools\\Eclipse\\Workspace\\PRIVATE\\samples\\output\\2.xls");
		System.out.println("======��======");

	}
}
