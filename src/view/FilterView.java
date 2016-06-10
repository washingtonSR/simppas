package view;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="filtro")
@ViewScoped
public class FilterView implements Serializable {
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
	    String filterText = (filter == null) ? null : filter.toString().trim();
	    if(filterText == null||filterText.equals("")) {
	        return true;
	    }
	    if(value == null) {
	        return false;
	    }
	    return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
}