/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class addFixAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int fixAwardId;
/*    */   private final boolean activeGet;
/*    */   private final boolean isSend;
/*    */   private final AwardReason awardReason;
/*    */   
/*    */   public addFixAward(long roleId, int fixAwardId, boolean activeGet, boolean isSend, AwardReason awardReason)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.fixAwardId = fixAwardId;
/* 20 */     this.activeGet = activeGet;
/* 21 */     this.isSend = isSend;
/* 22 */     this.awardReason = awardReason;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     String userId = RoleInterface.getUserId(this.roleId);
/* 30 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 32 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/* 33 */     AwardInterface.awardFixAward(this.fixAwardId, userId, this.roleId, this.activeGet, this.isSend, this.awardReason);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\addFixAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */