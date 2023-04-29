/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.confbean.SWorldQuestionLib;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuestionSet
/*    */ {
/*    */   static int ranQustionIds(List<Integer> ownQuestions)
/*    */   {
/* 18 */     return ranQustionIds(SWorldQuestionLib.getAll().keySet(), ownQuestions);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int ranQustionIds(Set<Integer> allQuestions, List<Integer> ownQuestions)
/*    */   {
/* 28 */     List<Integer> tempIds = new ArrayList(allQuestions);
/* 29 */     tempIds.removeAll(ownQuestions);
/* 30 */     int seed = tempIds.size();
/* 31 */     if (seed <= 0) {
/* 32 */       return -1;
/*    */     }
/* 34 */     Random random = Xdb.random();
/* 35 */     int ran = random.nextInt(seed);
/* 36 */     return ((Integer)tempIds.get(ran)).intValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\QuestionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */