/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_GiveFixAward extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int fixAwardId;
/*    */   private final int time;
/*    */   
/*    */   public PGM_GiveFixAward(long roleId, int fixAwardId, int time)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.fixAwardId = fixAwardId;
/* 20 */     this.time = time;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     String userId = RoleInterface.getUserId(this.roleId);
/* 28 */     lock(Lockeys.get(User.getTable(), userId));
/* 29 */     if (this.time <= 0)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.roleId, "奖励次数必须大于0!");
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     AwardReason awardReason = new AwardReason(LogReason.AWARD_GM_FIX_ADD);
/* 36 */     RoleAwardManager.awardFixAwardNTime(this.fixAwardId, this.time, userId, this.roleId, false, true, awardReason);
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PGM_GiveFixAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */