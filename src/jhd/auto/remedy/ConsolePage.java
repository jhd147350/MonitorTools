package jhd.auto.remedy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import jhd.auto.BaseWebPage;
import jhd.auto.Ticket;

public class ConsolePage extends BaseWebPage {

	@FindBy(id = "WIN_1_304017100")
	private WebElement unConfirm;

	@FindBys({ @FindBy(id = "T302087200"), @FindBy(tagName = "tbody"), @FindBy(tagName = "tr") })
	private List<WebElement> trs;

	protected ConsolePage(WebDriver driver) {
		super(driver);
	}

	public List<RemedyTicket> getUnConfirmTicket() {
		List<RemedyTicket> tickets = new ArrayList<RemedyTicket>();
		unConfirm.click();
		for (int i = 1; i < trs.size(); i++) {// 跳过第一个，第一个是表头
			List<WebElement> tds = trs.get(i).findElements(By.tagName("td"));
			if (tds != null && tds.size() >= 4) {
				// 第四列是状态״̬
				String status = tds.get(3).getText();
				if (status.equals("已指派")) {
					// trs.get(i)
					RemedyTicket ticket = new RemedyTicket();
					ticket.setId(tds.get(0).getText());// 第一列是id
					ticket.setPriority(tds.get(2).getText());// 第三列是优先级
					ticket.setTitle(tds.get(1).getText());// 第二列是标题
					ticket.setStatus(status);
					tickets.add(ticket);
				}
			}
		}
		return tickets;
	}

}
