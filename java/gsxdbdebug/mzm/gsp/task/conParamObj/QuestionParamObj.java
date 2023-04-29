/*    */ package mzm.gsp.task.conParamObj;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class QuestionParamObj
/*    */ {
/*    */   private final List<Long> roleList;
/*    */   private final boolean isPass;
/*    */   private final Map<Long, Integer> rightNumMap;
/*    */   private final int questionNum;
/*    */   private final Object attachObject;
/*    */   
/*    */   public QuestionParamObj(List<Long> roleList, boolean isPass, Map<Long, Integer> rightNumMap, int questionNum, Object attachObject)
/*    */   {
/* 17 */     this.roleList = roleList;
/* 18 */     this.isPass = isPass;
/* 19 */     this.rightNumMap = rightNumMap;
/* 20 */     this.questionNum = questionNum;
/* 21 */     this.attachObject = attachObject;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRightNum(long roleId)
/*    */   {
/* 33 */     Integer num = (Integer)this.rightNumMap.get(Long.valueOf(roleId));
/* 34 */     if (num == null)
/*    */     {
/* 36 */       return 0;
/*    */     }
/* 38 */     return num.intValue();
/*    */   }
/*    */   
/*    */   public List<Long> getRoleList()
/*    */   {
/* 43 */     return this.roleList;
/*    */   }
/*    */   
/*    */   public boolean isPass()
/*    */   {
/* 48 */     return this.isPass;
/*    */   }
/*    */   
/*    */   public Map<Long, Integer> getRightNumMap()
/*    */   {
/* 53 */     return this.rightNumMap;
/*    */   }
/*    */   
/*    */   public int getQuestionNum()
/*    */   {
/* 58 */     return this.questionNum;
/*    */   }
/*    */   
/*    */   public Object getAttachObject()
/*    */   {
/* 63 */     return this.attachObject;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\conParamObj\QuestionParamObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */