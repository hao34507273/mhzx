/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.qingfu.main.CostResult;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PBuyChallengeCount extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int buycount;
/*    */   
/*    */   public PBuyChallengeCount(long roleid, int buycount)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.buycount = buycount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!JingjiManager.isRoleStateCanJoinJIngjiActivity(this.roleid))
/*    */     {
/* 31 */       String logStr = String.format("[jingji]PBuyChallengeCount.processImp@role state can not join jingji activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 33 */       JingjiManager.logger.info(logStr);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     String userid = RoleInterface.getUserId(this.roleid);
/* 38 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 40 */     int restcount = JingjiManager.getTotalChallengeCount(this.roleid);
/* 41 */     if ((this.buycount != 1) || (restcount > 0))
/*    */     {
/* 43 */       String logstr = String.format("[jingji]PBuyChallengeCount.processImp@buy count error|roleid=%d|buycount=%d|restcount=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.buycount), Integer.valueOf(restcount) });
/*    */       
/*    */ 
/* 46 */       JingjiManager.logger.error(logstr);
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     boolean ret = JingjiManager.addBuyChallengeCount(this.roleid, this.buycount);
/* 51 */     if (!ret)
/*    */     {
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     int oldDayBuycount = JingjiManager.getBuyCount(this.roleid);
/* 57 */     int startprice = JingjiActivityCfgConsts.getInstance().FIRST_BUY_YUANBAO_PRICE + oldDayBuycount * JingjiActivityCfgConsts.getInstance().YUANBAO_PRICE_ADD_NUM;
/*    */     
/*    */ 
/* 60 */     int totalpay = 0;
/* 61 */     for (int i = 0; i < this.buycount; i++)
/*    */     {
/*    */ 
/* 64 */       startprice += JingjiActivityCfgConsts.getInstance().YUANBAO_PRICE_ADD_NUM;
/* 65 */       totalpay += startprice;
/*    */     }
/*    */     
/* 68 */     ret = JingjiManager.addBuyCount(this.roleid, this.buycount);
/* 69 */     if (!ret)
/*    */     {
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     if (totalpay > 0)
/*    */     {
/* 76 */       TLogArg logArg = new TLogArg(LogReason.JINGJI_ACTIVITY_BUY_CHALLENGECOUNR_REM);
/*    */       
/* 78 */       ret = QingfuInterface.costYuanbao(userid, this.roleid, totalpay, CostType.COST_BIND_FIRST_JINGJI_BUY_CHALLENGE_COUNT, logArg) == CostResult.Success;
/*    */       
/* 80 */       if (!ret)
/*    */       {
/* 82 */         JingjiManager.sendErrorInfo(this.roleid, 2);
/* 83 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 87 */     JingjiManager.synBuyChallengeCount(this.roleid, this.buycount);
/* 88 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PBuyChallengeCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */