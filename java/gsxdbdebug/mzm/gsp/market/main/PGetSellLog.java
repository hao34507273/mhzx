/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.market.SGetSellLogRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.SaleLog;
/*    */ import xtable.Role2marketlog;
/*    */ 
/*    */ public class PGetSellLog extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGetSellLog(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 27 */       String logStr = String.format("[market]PGetSellLog.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 28 */       MarketManager.logger.info(logStr);
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     SGetSellLogRes res = new SGetSellLogRes();
/* 33 */     xbean.MarketLog xMarketLog = Role2marketlog.select(Long.valueOf(this.roleId));
/* 34 */     if (xMarketLog != null)
/*    */     {
/*    */ 
/* 37 */       for (SaleLog xLog : xMarketLog.getSelllog())
/*    */       {
/* 39 */         mzm.gsp.market.MarketLog marketLog = new mzm.gsp.market.MarketLog();
/* 40 */         marketLog.itemidorpetcfgid = xLog.getItemorpetcfgid();
/* 41 */         marketLog.price = xLog.getPrice();
/* 42 */         marketLog.rolename = RoleInterface.getName(xLog.getRoleid());
/* 43 */         marketLog.time = TimeUnit.MILLISECONDS.toSeconds(xLog.getBuytime());
/* 44 */         marketLog.num = xLog.getNum();
/* 45 */         res.selllogs.add(marketLog);
/*    */       }
/*    */     }
/* 48 */     OnlineManager.getInstance().send(this.roleId, res);
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PGetSellLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */