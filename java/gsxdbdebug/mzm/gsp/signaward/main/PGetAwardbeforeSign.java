/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.signaward.SGetAwardbeforeSignRes;
/*    */ import mzm.gsp.signaward.confbean.SAwardBeforeSignCfg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Openserver;
/*    */ import xbean.Pod;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2openserver;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGetAwardbeforeSign extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int day;
/*    */   
/*    */   public PGetAwardbeforeSign(long roleid, int day)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.day = day;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     SAwardBeforeSignCfg awardBeforeSignCfg = SAwardBeforeSignCfg.get(this.day);
/* 33 */     if (awardBeforeSignCfg == null)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     String userid = RoleInterface.getUserId(this.roleid);
/* 40 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 42 */     Openserver openserver = Role2openserver.get(Long.valueOf(this.roleid));
/* 43 */     if (openserver == null)
/*    */     {
/* 45 */       openserver = Pod.newOpenserver();
/* 46 */       Role2openserver.insert(Long.valueOf(this.roleid), openserver);
/*    */     }
/* 48 */     long curtime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 50 */     long openserday = mzm.gsp.server.main.ServerInterface.getOpenServerDay(curtime, false);
/* 51 */     if (this.day != openserday)
/*    */     {
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     if (openserver.getAwardeddays().contains(Integer.valueOf(this.day)))
/*    */     {
/* 58 */       SignAwardManager.sendErrorProtocal(this.roleid, 9);
/*    */       
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     TLogArg logArg = new TLogArg(LogReason.OPEN_SERVER_AWARD_ADD, awardBeforeSignCfg.id);
/*    */     
/* 65 */     AwardModel awardModel = AwardInterface.awardFixAward(awardBeforeSignCfg.rewardid, userid, this.roleid, true, true, new mzm.gsp.award.main.AwardReason(logArg.getLogReason(), logArg.getSubReason()));
/*    */     
/* 67 */     SGetAwardbeforeSignRes res = new SGetAwardbeforeSignRes();
/* 68 */     res.day = this.day;
/*    */     
/* 70 */     return awardModel != null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PGetAwardbeforeSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */