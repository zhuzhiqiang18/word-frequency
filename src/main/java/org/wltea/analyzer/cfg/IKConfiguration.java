/**
 * 
 */
package org.wltea.analyzer.cfg;

import com.I9lou.wordFrequency.core.Configuration;
import org.wltea.analyzer.dic.Dictionary;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IKConfiguration implements Configuration {

	//是否启用智能分词
	private  boolean useSmart=true;
	//是否启用小写处理
	private boolean enableLowercase=true;
	public IKConfiguration() {
		this.useSmart =true;
		this.enableLowercase = true;
		Dictionary.initial(this);
	}

	public Path getConfigInPluginDir() throws URISyntaxException {
		return Paths.get(Thread.currentThread().getContextClassLoader().getResource("config").toURI());
	}



	public boolean isUseSmart() {
		return useSmart;
	}

	public IKConfiguration setUseSmart(boolean useSmart) {
		this.useSmart = useSmart;
		return this;
	}


	public boolean isEnableLowercase() {
		return enableLowercase;
	}


}
