/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.SBuyGoldIngotRsp;
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
/*    */ public class PCBuyGoldIngotReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int yuanbaoNum;
/*    */   private final long clientYuanbao;
/*    */   
/*    */   public PCBuyGoldIngotReq(long roleid, int yuanbaoNum, long clientYuanbao)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.yuanbaoNum = yuanbaoNum;
/* 25 */     this.clientYuanbao = clientYuanbao;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!ItemModuleSwitchInterface.isExchangeIngotItemSwitchOpenForRole(this.roleid))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 37 */       String logStr = String.format("[item]PCBuyGoldIngotReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 39 */       ItemManager.logger.info(logStr);
/* 40 */       return false;
/*    */     }
/* 42 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*    */     
/*    */ 
/* 45 */     String userid = RoleInterface.getUserId(this.roleid);
/* 46 */     long yuanbao = QingfuInterface.getYuanbao(userid, true);
/* 47 */     if ((this.clientYuanbao != yuanbao) || (yuanbao < this.yuanbaoNum))
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     int value = ItemConfigManager.getExchangeValue(5, this.yuanbaoNum, serverLevel);
/* 53 */     if (value == -1)
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     TLogArg logArg = new TLogArg(LogReason.YUANBAO_BUY, 5);
/* 59 */     boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, this.yuanbaoNum, CostType.COST_ITEM_BUY_GOLD_INGOT, logArg) == CostResult.Success;
/*    */     
/* 61 */     if (!ret)
/*    */     {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     if (!ItemManager.addMoneyWithinMax(this.roleid, logArg, value, 5))
/*    */     {
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     SBuyGoldIngotRsp res = new SBuyGoldIngotRsp();
/* 72 */     res.yuanbao_num = this.yuanbaoNum;
/* 73 */     res.value = value;
/* 74 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCBuyGoldIngotReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */