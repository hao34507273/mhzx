/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import mzm.gsp.bigboss.SBuyChallengeCountRes;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.main.CostResult;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BigBoss;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PBuyChallengeCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int buycount;
/*    */   
/*    */   public PBuyChallengeCount(long roleid, int buycount)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.buycount = buycount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!BigbossManager.isRoleStateCanJoinBigbossActivity(this.roleid))
/*    */     {
/* 33 */       String logStr = String.format("[bigboss]PBuyChallengeCount.processImp@role state can not join bigboss activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 35 */       BigbossManager.logger.info(logStr);
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     String userid = RoleInterface.getUserId(this.roleid);
/* 40 */     lock(Lockeys.get(User.getTable(), userid));
/* 41 */     BigBoss xBigBoss = BigbossManager.getBigboss(this.roleid, true);
/* 42 */     if (xBigBoss == null)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     int rescount = BigbossManager.getTotalChallengecount(xBigBoss);
/* 48 */     if ((this.buycount != 1) || (rescount > 0))
/*    */     {
/* 50 */       String logstr = String.format("[bigboss]PBuyChallengeCount.processImp@Bigboss buycount error|roleid=%d|buycount=%d|restcount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.buycount), Integer.valueOf(rescount) });
/*    */       
/*    */ 
/* 53 */       BigbossManager.logger.info(logstr);
/*    */       
/* 55 */       BigbossManager.sendErrorInfo(this.roleid, 8);
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     int oldDayBuycount = xBigBoss.getBuycount();
/* 60 */     if (oldDayBuycount >= SBigbossCfgConsts.getInstance().MAX_BUY_COUNT)
/*    */     {
/* 62 */       BigbossManager.sendErrorInfo(this.roleid, 6);
/* 63 */       return false;
/*    */     }
/* 65 */     int yuanbaonum = SBigbossCfgConsts.getInstance().FIRST_BUY_YUANBAO_PRICE + oldDayBuycount * SBigbossCfgConsts.getInstance().YUANBAO_PRICE_ADD_NUM;
/*    */     
/*    */ 
/* 68 */     int totalpay = 0;
/* 69 */     for (int i = 0; i < this.buycount; i++)
/*    */     {
/* 71 */       yuanbaonum += SBigbossCfgConsts.getInstance().YUANBAO_PRICE_ADD_NUM;
/* 72 */       totalpay += yuanbaonum;
/*    */     }
/*    */     
/* 75 */     xBigBoss.setBuycount(this.buycount + xBigBoss.getBuycount());
/* 76 */     xBigBoss.setRestbuycount(xBigBoss.getRestbuycount() + this.buycount);
/*    */     
/* 78 */     if (totalpay > 0)
/*    */     {
/* 80 */       TLogArg logArg = new TLogArg(LogReason.BIGBOSS_ACTIVITY_BUY_CHALLENGECOUNR_REM);
/* 81 */       boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, totalpay, CostType.COST_BIND_FIRST_BIGBOSS_BUY_CHALLENGE_COUNT, logArg) == CostResult.Success;
/*    */       
/* 83 */       if (!ret)
/*    */       {
/* 85 */         BigbossManager.sendErrorInfo(this.roleid, 2);
/* 86 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 90 */     SBuyChallengeCountRes s = new SBuyChallengeCountRes();
/* 91 */     s.buycount = this.buycount;
/* 92 */     s.challengecount = (xBigBoss.getChallengecount() + xBigBoss.getRestbuycount());
/* 93 */     s.totalbuycount = xBigBoss.getBuycount();
/* 94 */     OnlineManager.getInstance().send(this.roleid, s);
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PBuyChallengeCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */