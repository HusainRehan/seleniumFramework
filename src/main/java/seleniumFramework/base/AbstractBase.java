package seleniumFramework.base;

import seleniumFramework.util.PropertyUtil;

public abstract class AbstractBase {
	
	protected String getProperty(String key) {
		return PropertyUtil.getProperty(key);
	}

}
