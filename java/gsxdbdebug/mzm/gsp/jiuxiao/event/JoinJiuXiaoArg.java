/*    */ package mzm.gsp.jiuxiao.event;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class JoinJiuXiaoArg
/*    */ {
/*  7 */   public final List<Long> joinRoles = new java.util.ArrayList();
/*    */   
/*    */   public final long endTime;
/*    */   
/*    */   public final int activityid;
/*    */   public final int floor;
/*    */   
/*    */   public JoinJiuXiaoArg(List<Long> joinRoles, long endTime, int activityid, int floor)
/*    */   {
/* 16 */     this.joinRoles.addAll(joinRoles);
/* 17 */     this.endTime = endTime;
/* 18 */     this.activityid = activityid;
/* 19 */     this.floor = floor;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\event\JoinJiuXiaoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */