/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import xbean.RoleMarketInfo;
/*    */ 
/*    */ public class PAutoGetMoneyReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PAutoGetMoneyReq(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 21 */       String logStr = String.format("[market]PAutoGetMoneyReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 23 */       MarketManager.logger.info(logStr);
/* 24 */       return false;
/*    */     }
/* 26 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/* 27 */     if (xRoleMarketInfo == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     for (Iterator i$ = xRoleMarketInfo.getOnshelf_item_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*    */       
/* 33 */       new PGetMoneyItemReq(this.roleId, marketId).execute();
/*    */     }
/* 35 */     for (Iterator i$ = xRoleMarketInfo.getOnshelf_pet_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*    */       
/* 37 */       new PGetMoneyPetReq(this.roleId, marketId).execute();
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PAutoGetMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */