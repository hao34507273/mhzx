/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import hub.IndianaAwardRoleInfo;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ReceiveIndianaAwardRoleInfoArg
/*    */ {
/*    */   private final int srcZoneid;
/*    */   private final int activityCfgid;
/*    */   private final int turn;
/*    */   private final int sortid;
/*    */   private final Map<Integer, IndianaAwardRoleInfo> awardRoleInfos;
/*    */   
/*    */   public ReceiveIndianaAwardRoleInfoArg(int srcZoneid, int activityCfgid, int turn, int sortid, Map<Integer, IndianaAwardRoleInfo> awardRoleInfos)
/*    */   {
/* 16 */     this.srcZoneid = srcZoneid;
/* 17 */     this.activityCfgid = activityCfgid;
/* 18 */     this.turn = turn;
/* 19 */     this.sortid = sortid;
/* 20 */     this.awardRoleInfos = awardRoleInfos;
/*    */   }
/*    */   
/*    */   public int getSrcZoneid()
/*    */   {
/* 25 */     return this.srcZoneid;
/*    */   }
/*    */   
/*    */   public int getActivityCfgid()
/*    */   {
/* 30 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */   public int getTurn()
/*    */   {
/* 35 */     return this.turn;
/*    */   }
/*    */   
/*    */   public int getSortid()
/*    */   {
/* 40 */     return this.sortid;
/*    */   }
/*    */   
/*    */   public Map<Integer, IndianaAwardRoleInfo> getAwardRoleInfos()
/*    */   {
/* 45 */     return this.awardRoleInfos;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReceiveIndianaAwardRoleInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */