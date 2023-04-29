/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.SBuyGoldUseInGotRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.confbean.MoneyExchangeCfgConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PBuyGoldUseIngot
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int inGotNum;
/*    */   private long clientIngotNum;
/*    */   
/*    */   public PBuyGoldUseIngot(long roleid, int inGotNum, long clientIngotNum)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.inGotNum = inGotNum;
/*    */     
/* 24 */     this.clientIngotNum = clientIngotNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (this.inGotNum <= 0)
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (!ItemModuleSwitchInterface.isExchangeGoldSilverItemSwitchOpenForRole(this.roleid))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 40 */       String logStr = String.format("[item]PBuyGoldUseIngot.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 41 */       ItemManager.logger.info(logStr);
/* 42 */       return false;
/*    */     }
/* 44 */     if (this.clientIngotNum != RoleInterface.getGoldIngot(this.roleid))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     TLogArg logArg = new TLogArg(LogReason.INGOT_BUY_GOLD, 2);
/*    */     
/* 50 */     if (!RoleInterface.cutGoldIngot(this.roleid, this.inGotNum, logArg))
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     int addNum = (int)(this.inGotNum * MoneyExchangeCfgConsts.getInstance().INGOT_TO_GOLD_NUM);
/* 55 */     if (!ItemManager.addMoneyWithinMax(this.roleid, logArg, addNum, 2))
/*    */     {
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     String logStr = String.format("[item]PBuyGoldUseIngot.processImp@buy god use ingot success|inGotNum=%d|buyGoldNum=%d", new Object[] { Integer.valueOf(this.inGotNum), Integer.valueOf(addNum) });
/*    */     
/* 62 */     ItemManager.logger.info(logStr);
/* 63 */     SBuyGoldUseInGotRes res = new SBuyGoldUseInGotRes();
/* 64 */     res.buygoldnum = addNum;
/* 65 */     res.ingotnum = this.inGotNum;
/* 66 */     OnlineManager.getInstance().send(this.roleid, res);
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PBuyGoldUseIngot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */