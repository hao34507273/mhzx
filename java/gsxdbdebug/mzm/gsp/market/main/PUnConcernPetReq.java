/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.market.SUnConcernPetRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ConcernRoleIdSet;
/*    */ import xbean.MarketPet;
/*    */ import xbean.RoleMarketInfo;
/*    */ import xtable.Marketpetid2concernrole;
/*    */ 
/*    */ public class PUnConcernPetReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long marketid;
/*    */   
/*    */   public PUnConcernPetReq(long roleId, long marketid)
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
/* 28 */       String logStr = String.format("[market]PUnConcernPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 30 */       MarketManager.logger.info(logStr);
/* 31 */       return false;
/*    */     }
/* 33 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/* 34 */     xdb.Lockeys.lock(Marketpetid2concernrole.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.marketid) }));
/* 35 */     if (xRoleMarketInfo == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     MarketPet xMarketPet = xtable.Marketpet.get(Long.valueOf(this.marketid));
/* 41 */     if (xMarketPet != null)
/*    */     {
/* 43 */       xMarketPet.setConcern_role_num(Math.max(0, xMarketPet.getConcern_role_num() - 1));
/*    */     }
/* 45 */     xRoleMarketInfo.getConcern_pet_ids().remove(Long.valueOf(this.marketid));
/*    */     
/* 47 */     ConcernRoleIdSet xConcernRoleIdSet = Marketpetid2concernrole.get(Long.valueOf(this.marketid));
/* 48 */     if (xConcernRoleIdSet != null)
/*    */     {
/*    */ 
/* 51 */       xConcernRoleIdSet.getRoleids().remove(Long.valueOf(this.roleId));
/*    */     }
/*    */     
/* 54 */     SUnConcernPetRes res = new SUnConcernPetRes(this.marketid);
/*    */     
/* 56 */     OnlineManager.getInstance().send(this.roleId, res);
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PUnConcernPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */