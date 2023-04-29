/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import hub.AllLottoRoleInfo;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ReceiveAllLottoAwardRoleInfoArg
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int turn;
/*    */   private final List<AllLottoRoleInfo> awardRoleInfos;
/*    */   
/*    */   public ReceiveAllLottoAwardRoleInfoArg(int activityCfgid, int turn, List<AllLottoRoleInfo> awardRoleInfos)
/*    */   {
/* 14 */     this.activityCfgid = activityCfgid;
/* 15 */     this.turn = turn;
/* 16 */     this.awardRoleInfos = awardRoleInfos;
/*    */   }
/*    */   
/*    */   public int getActivityCfgid()
/*    */   {
/* 21 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */   public int getTurn()
/*    */   {
/* 26 */     return this.turn;
/*    */   }
/*    */   
/*    */   public List<AllLottoRoleInfo> getAwardRoleInfos()
/*    */   {
/* 31 */     return this.awardRoleInfos;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReceiveAllLottoAwardRoleInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */