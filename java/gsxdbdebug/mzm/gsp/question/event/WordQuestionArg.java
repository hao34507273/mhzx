/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WordQuestionArg
/*    */ {
/* 12 */   public List<Long> roleList = new ArrayList();
/* 13 */   public Map<Long, Integer> rightNumMap = new HashMap();
/*    */   public int questionNum;
/*    */   public boolean isPass;
/*    */   public Object attachObject;
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\WordQuestionArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */