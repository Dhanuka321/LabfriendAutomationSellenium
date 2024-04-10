package contexts;

import java.util.Properties;

import functions.LabFriend_CommonFun;

public class Labfriend_CheckoutProducts {

	private String sku;
	public String propertyFileName;
	public String folderPath;

	public Labfriend_CheckoutProducts(String propertyFileName, String folderPath) {
		this.propertyFileName = propertyFileName;
		this.folderPath = folderPath;

		Properties properties = LabFriend_CommonFun.getPropertyData(propertyFileName, folderPath);
		sku = properties.getProperty("sku");
	}

	public String getSku() {
		return sku;
	}

}
