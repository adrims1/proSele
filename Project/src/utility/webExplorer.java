package utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class webExplorer {
	
	public webExplorer() {
		
	}
	
public void DropdownClick(List<WebElement> dropdown, String textValue) {
		
	for ( WebElement e : dropdown ) {
			String str = e.getAttribute("innerHTML");
			System.out.println("innerHTML : " + str);
			if( str.contentEquals(textValue)) {
				e.click();
				break;
			}
		}
	}

}
