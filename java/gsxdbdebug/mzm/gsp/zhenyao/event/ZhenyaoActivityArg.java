/*    */ package mzm.gsp.zhenyao.event;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class ZhenyaoActivityArg
/*    */ {
/*  7 */   private List<Long> roleids = new java.util.ArrayList();
/*    */   private int activityId;
/*    */   private int killMonsterNum;
/*    */   
/* 11 */   public ZhenyaoActivityArg(List<Long> roleids, int activityid, int killMonsterNum) { this.roleids.addAll(roleids);
/* 12 */     this.activityId = activityid;
/*    */     
/* 14 */     this.killMonsterNum = killMonsterNum;
/*    */   }
/*    */   
/* 17 */   public int getActivityId() { return this.activityId; }
/*    */   
/*    */   public List<Long> getRoleids()
/*    */   {
/* 21 */     return this.roleids;
/*    */   }
/*    */   
/* 24 */   public int getKillMonsterNum() { return this.killMonsterNum; }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\event\ZhenyaoActivityArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */