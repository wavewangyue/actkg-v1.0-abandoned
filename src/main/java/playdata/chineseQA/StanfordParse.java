package playdata.chineseQA;

/**
 * Created by wave on 16-11-25.
 */

import java.util.Collection;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.trees.international.pennchinese.ChineseGrammaticalStructure;

public class StanfordParse {

    public static void main(String[] args) {
        String modelpath="stanfordParserModel/xinhuaFactoredSegmenting.ser.gz";
        String str="张宇的性别是什么";
        LexicalizedParser lp = LexicalizedParser.loadModel(modelpath);
        Tree t = lp.parse(str);
//      TokenizerFactory<CoreLabel> tokenizerFactory =PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
//      List<CoreLabel> rawWords2 =tokenizerFactory.getTokenizer(new StringReader(str)).tokenize();
//      Tree t1 = lp.apply(rawWords2);
//      ChineseTreebankLanguagePack tlp = new ChineseTreebankLanguagePack();
//      GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
        ChineseGrammaticalStructure gs = new ChineseGrammaticalStructure(t);
//      List<TypedDependency> tdl = gs.typedDependenciesCCprocessed();
        Collection<TypedDependency> tdl = gs.typedDependenciesCollapsed();
        System.out.println(tdl.toString());
        String s="";
        for(int i = 0;i < tdl.size();i ++)
        {
            TypedDependency td = (TypedDependency)tdl.toArray()[i];
            String age = td.dep().toString();
            s+=age+"/";
        }
        System.out.println(s);

    }
}
