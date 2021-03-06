package act.graph.controller;

import act.graph.model.GraphResult;
import act.graph.service.GraphService;
import act.graph.service.SegService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wave on 16-12-6.
 */
@Controller
@RequestMapping("/graphQA")
public class GraphSearchController {

    @Autowired
    GraphService graphService;

    @Autowired
    SegService segService;

    @RequestMapping(value = "/entity.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getentityinfoforme(String keyId) throws Exception {
        //if (keyword != null) keyword = new String(keyword.getBytes("iso-8859-1"),"UTF-8");
        JsonObject entityinfo = graphService.searchEntityInfo(keyId);
        return entityinfo.toString();
    }

    @RequestMapping(value = "/answering.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
    @ResponseBody
    public String answerforme(String keyword) throws Exception {
        //if (keyword != null) keyword = new String(keyword.getBytes("iso-8859-1"),"UTF-8");
        List<String> finallist = segService.getFinalList(keyword);
        GraphResult result = graphService.bloomNow(finallist.get(0));
        result = segService.enlightList(result,finallist);
        return new Gson().toJson(result);
    }
}
