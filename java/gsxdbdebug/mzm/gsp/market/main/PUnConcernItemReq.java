/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.market.SUnConcernItemRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ConcernRoleIdSet;
/*    */ import xbean.MarketItem;
/*    */ import xbean.RoleMarketInfo;
/*    */ import xtable.Marketitemid2concernrole;
/*    */ 
/*    */ public class PUnConcernItemReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long marketid;
/*    */   
/*    */   public PUnConcernItemReq(long roleId, long marketid)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.marketid = marketid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 28 */       String logStr = String.format("[market]PUnConcernItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 30 */       MarketManager.logger.info(logStr);
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/* 35 */     xdb.Lockeys.lock(Marketitemid2concernrole.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.marketid) }));
/* 36 */     if (xRoleMarketInfo == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     xRoleMarketInfo.getConcern_item_ids().remove(Long.valueOf(this.marketid));
/* 42 */     MarketItem xMarketItem = xtable.Marketitem.get(Long.valueOf(this.marketid));
/* 43 */     if (xMarketItem != null)
/*    */     {
/* 45 */       xMarketItem.setConcern_role_num(Math.max(0, xMarketItem.getConcern_role_num() - 1));
/*    */     }
/*    */     
/* 48 */     ConcernRoleIdSet xConcernRoleIdSet = Marketitemid2concernrole.get(Long.valueOf(this.marketid));
/* 49 */     if (xConcernRoleIdSet != null)
/*    */     {
/* 51 */       xConcernRoleIdSet.getRoleids().remove(Long.valueOf(this.roleId));
/*    */     }
/*    */     
/* 54 */     SUnConcernItemRes res = new SUnConcernItemRes(this.marketid);
/*    */     
/* 56 */     OnlineManager.getInstance().send(this.roleId, res);
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PUnConcernItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */