/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.SBuyGoldSilverRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.main.CostResult;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PBuyGoldSilver extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int yuanbaonum;
/*    */   private int moneytype;
/*    */   private long clientyuanbao;
/*    */   
/*    */   public PBuyGoldSilver(long roleid, int yuanbaonum, int moneytype, long clientyuanbao)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.yuanbaonum = yuanbaonum;
/* 26 */     this.moneytype = moneytype;
/* 27 */     this.clientyuanbao = clientyuanbao;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!ItemModuleSwitchInterface.isExchangeGoldSilverItemSwitchOpenForRole(this.roleid))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 39 */       String logStr = String.format("[item]PBuyGoldSilver.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 40 */       ItemManager.logger.info(logStr);
/* 41 */       return false;
/*    */     }
/* 43 */     int serverlevel = ServerInterface.getCurrentServerLevel();
/*    */     
/*    */ 
/* 46 */     String userid = RoleInterface.getUserId(this.roleid);
/* 47 */     long yuanbaoBalance = QingfuInterface.getBalance(userid, true);
/* 48 */     if (this.clientyuanbao != yuanbaoBalance)
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     if (yuanbaoBalance < this.yuanbaonum)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     int value = ItemConfigManager.getExchangeValue(this.moneytype, this.yuanbaonum, serverlevel);
/* 57 */     if (value == -1)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     TLogArg logArg = new TLogArg(LogReason.YUANBAO_BUY, this.moneytype);
/* 62 */     boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, this.yuanbaonum, CostType.COST_BIND_FIRST_ITEM_BUY_GOLD_SLIVER, logArg) == CostResult.Success;
/*    */     
/*    */ 
/* 65 */     if (!ItemManager.addMoneyWithinMax(this.roleid, logArg, value, this.moneytype))
/*    */     {
/* 67 */       return false;
/*    */     }
/* 69 */     SBuyGoldSilverRes res = new SBuyGoldSilverRes();
/* 70 */     res.moneytype = this.moneytype;
/* 71 */     res.value = value;
/* 72 */     res.yuanbaonum = this.yuanbaonum;
/* 73 */     OnlineManager.getInstance().send(this.roleid, res);
/* 74 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PBuyGoldSilver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */