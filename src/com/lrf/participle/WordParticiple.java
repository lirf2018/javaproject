package com.lrf.participle;

import com.alibaba.fastjson.JSONObject;
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.List;

/**
 * 创建人: lirf
 * 创建时间:  2018/11/21 14:37
 * 功能介绍: 分词  11大分词器java
 */
public class WordParticiple {

    public static void main(String[] args) throws Exception {
        String str = "11分词器java";
        ansjSplit(str);
    }

    /**
     * word 分词器
     */
    public static void wordSplit(String str) {
        List<Word> words = WordSegmenter.seg(str);//移除停用词
//        List<Word> words = WordSegmenter.segWithStopWords(str);//保留停用词
        System.out.println(JSONObject.toJSONString(words));
        /**
         * 移除停用词：[杨尚川, apdplat, 应用级, 产品, 开发平台, 作者]
         * 保留停用词：[杨尚川, 是, apdplat, 应用级, 产品, 开发平台, 的, 作者]
         */
    }

    /**
     * ansj 分词器
     */
    public static void ansjSplit(String str) throws Exception {
//        Forest forest0 = Library.makeForest("E:/base.dic");//加载自定义词典 Result result = BaseAnalysis.parse(str,forest0);

//        Result result = BaseAnalysis.parse(str);//基本分词：最基本的分词.词语颗粒度最非常小的
        Result result = ToAnalysis.parse(str);//精准分词：在易用性,稳定性.准确性.以及分词效率上.都取得了一个不错的平衡.
//        Result result = NlpAnalysis.parse(str);//nlp分词：语法实体名抽取.未登录词整理.只要是对文本进行发现分析等工作
//        Result result = IndexAnalysis.parse(str);//面向索引分词：故名思议就是适合在lucene等文本检索中用到的分词。
        for (int i = 0; i < result.getTerms().size(); i++) {
            System.out.print(result.getTerms().get(i).getName() + ", ");
        }
    }

    /**
     * Stanford 分词器 stanford-segmenter-3.9.2.jar  jdk 1.8
     */
//    private static final String basedir = System.getProperty("SegDemo", "data");
//    public static void stanfordSplit(String str) throws Exception {
//
//        Properties props = new Properties();
////        props.setProperty("sighanCorporaDict", basedir);
////        // props.setProperty("NormalizationTable", "data/norm.simp.utf8");
////        // props.setProperty("normTableEncoding", "UTF-8");
////        // below is needed because CTBSegDocumentIteratorFactory accesses it
////        props.setProperty("serDictionary", basedir + "/dict-chris6.ser.gz");
////        if (args.length > 0) {
////            props.setProperty("testFile", args[0]);
////        }
////        props.setProperty("inputEncoding", "UTF-8");
////        props.setProperty("sighanPostProcessing", "true");
////
//        CRFClassifier<CoreLabel> segmenter = new CRFClassifier<CoreLabel>(props);
////        segmenter.loadClassifierNoExceptions(basedir + "/ctb.gz", props);
////        for (String filename : args) {
////            segmenter.classifyAndWriteAnswers(filename);
////        }
//
//        List<String> segmented = segmenter.segmentString(str);
//        System.out.println(segmented);
//    }
}
