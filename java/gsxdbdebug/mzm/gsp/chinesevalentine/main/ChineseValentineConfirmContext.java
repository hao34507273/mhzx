/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ 
/*    */ 
/*    */ public class ChineseValentineConfirmContext
/*    */   implements TeamConfirmContext
/*    */ {
/*    */   private final List<Long> roleIdList;
/*    */   private int activityId;
/*    */   
/*    */   public int getActivityId()
/*    */   {
/* 15 */     return this.activityId;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleIdList()
/*    */   {
/* 20 */     return this.roleIdList;
/*    */   }
/*    */   
/*    */   public ChineseValentineConfirmContext(List<Long> roleIdList, int activityId)
/*    */   {
/* 25 */     this.roleIdList = roleIdList;
/* 26 */     this.activityId = activityId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\ChineseValentineConfirmContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */