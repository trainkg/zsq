package zsq.triankg.core.picker;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统所有选择器的picker选项
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: PickerController.java, V1.0.0 2017年3月18日 上午8:01:11 $
 */
@Slf4j
@Controller
@RequestMapping("/picker")
public class PickerController {

	/**
	 * 打开选择器
	 * @param name
	 * @return
	 */
	@RequestMapping("/{name}")
	public String openPicker(@PathVariable String name){
		log.info("open picker name {}",name);
		return "picker/"+name;
	}
}
