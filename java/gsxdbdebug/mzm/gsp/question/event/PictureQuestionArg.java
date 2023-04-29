/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PictureQuestionArg
/*    */ {
/* 11 */   public List<Long> roleList = new ArrayList();
/*    */   public boolean isPass;
/*    */   public Map<Long, Integer> roleScoreMap;
/*    */   public Map<Long, Integer> rightNumMap;
/*    */   public Map<Long, Integer> questionNumMap;
/*    */   public Object attachObject;
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\PictureQuestionArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */