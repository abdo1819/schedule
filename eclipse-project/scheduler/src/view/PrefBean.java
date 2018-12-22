package view;
import java.util.List;
import dto.Preference;
//import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
//import javax.faces.bean.ViewScoped;
import dal.*;
public class PrefBean {
	
	private List<Preference> prefList;
	private String test;

	@PostConstruct
	public void init() {
		try {
		DAOFactory dbfactory = new DAOFactory();
		prefList = dbfactory.createPreferenceDAO().getAllPreferences();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}


	public List<Preference> getPrefList() {
		return prefList;
	}


	public void setPrefList(List<Preference> prefList) {
		this.prefList = prefList;
	}
	
	
}
