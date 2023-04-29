/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CircleTaskInterface
/*    */ {
/*    */   public static boolean isCircleTaskGraphId(int graphId)
/*    */   {
/* 17 */     return CircleTaskConsts.getInstance().TASK_GRAPHIC_ID == graphId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getCircleTaskActivityId()
/*    */   {
/* 25 */     return CircleTaskConsts.getInstance().TASK_ACTIVITY_ID;
/*    */   }
/*    */   
/*    */   public static void setShilianOpenState(boolean value)
/*    */   {
/* 30 */     CircleTaskManager.setShilianOpenState(value);
/*    */   }
/*    */   
/*    */   public static boolean isShilianOpen() {
/* 34 */     return CircleTaskManager.isShilianOpen();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\CircleTaskInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */