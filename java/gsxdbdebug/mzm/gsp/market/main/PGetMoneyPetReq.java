/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.ModMoneyResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.role.main.RoleModuleManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MarketPet;
/*    */ import xbean.Pet;
/*    */ import xbean.RoleMarketInfo;
/*    */ import xtable.Role2marketinfo;
/*    */ 
/*    */ public class PGetMoneyPetReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long marketid;
/*    */   
/*    */   public PGetMoneyPetReq(long roleId, long marketid)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.marketid = marketid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 28 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId)) {
/* 29 */       String logStr = String.format("[market]PGetMoneyPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 30 */       MarketManager.logger.info(logStr);
/* 31 */       return false; }
/* 32 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId)) {
/* 33 */       return false;
/*    */     }
/* 35 */     RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleId));
/* 36 */     if (xRoleMarketInfo == null)
/* 37 */       return false;
/* 38 */     if (!xRoleMarketInfo.getOnshelf_pet_ids().contains(Long.valueOf(this.marketid))) {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 44 */     if (xRoleMarketInfo.getMarketid2timeoutorselledpet().containsKey(Long.valueOf(this.marketid))) {
/* 45 */       MarketPet xMarketPet = (MarketPet)xRoleMarketInfo.getMarketid2timeoutorselledpet().get(Long.valueOf(this.marketid));
/* 46 */       if (xMarketPet.getState() != 4) {
/* 47 */         return false;
/*    */       }
/* 49 */       int afterTax = MarketManager.computeGoldAfterCutTax(xMarketPet.getPrice());
/* 50 */       if (!RoleModuleManager.addGoldIngotInAll(this.roleId, afterTax, new TLogArg(LogReason.MARKET_SELL, xMarketPet.getPet().getTemplateid()), true).isSucceed()) {
/* 51 */         String logStr = String.format("[market]PGetMoneyPetReq.processImp@add gold error|roleid=%d|gold=%d|hasgold=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(afterTax), Long.valueOf(RoleInterface.getGold(this.roleId)) });
/* 52 */         MarketManager.logger.info(logStr);
/* 53 */         MarketManager.sendCommonError(this.roleId, 11);
/* 54 */         return false;
/*    */       }
/* 56 */       MarketManager.sendSGetMoneyPetRes(this.roleId, this.marketid, xMarketPet.getPet().getTemplateid(), afterTax);
/* 57 */       String logStr = String.format("[market]PGetMoneyPetReq.processImp@add gold success|roleid=%d|gold=%d|marketId=%d|petCfgId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(afterTax), Long.valueOf(this.marketid), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Integer.valueOf(xMarketPet.getPrice()) });
/* 58 */       MarketManager.logger.info(logStr);
/* 59 */       xRoleMarketInfo.getOnshelf_pet_ids().remove(Long.valueOf(this.marketid));
/* 60 */       xRoleMarketInfo.getMarketid2timeoutorselledpet().remove(Long.valueOf(this.marketid));
/* 61 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 65 */     MarketPet xMarketPet = xtable.Marketpet.get(Long.valueOf(this.marketid));
/* 66 */     if (xMarketPet == null)
/* 67 */       return false;
/* 68 */     if (xMarketPet.getState() != 4)
/* 69 */       return false;
/* 70 */     if (xMarketPet.getRoleid() != this.roleId) {
/* 71 */       return false;
/*    */     }
/* 73 */     int afterTax = MarketManager.computeGoldAfterCutTax(xMarketPet.getPrice());
/* 74 */     if (!RoleModuleManager.addGoldIngotInAll(this.roleId, afterTax, new TLogArg(LogReason.MARKET_SELL, xMarketPet.getPet().getTemplateid()), true).isSucceed()) {
/* 75 */       String logStr = String.format("[market]PGetMoneyPetReq.processImp@add gold error|roleid=%d|gold=%d|hasgold=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(afterTax), Long.valueOf(RoleInterface.getGold(this.roleId)) });
/* 76 */       MarketManager.logger.info(logStr);
/* 77 */       MarketManager.sendCommonError(this.roleId, 11);
/* 78 */       return false;
/*    */     }
/* 80 */     xRoleMarketInfo.getOnshelf_pet_ids().remove(Long.valueOf(this.marketid));
/* 81 */     MarketManager.sendSGetMoneyPetRes(this.roleId, this.marketid, xMarketPet.getPet().getTemplateid(), afterTax);
/* 82 */     String logStr = String.format("[market]PGetMoneyPetReq.processImp@add gold success|roleid=%d|gold=%d|marketId=%d|petCfgId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(afterTax), Long.valueOf(this.marketid), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Integer.valueOf(xMarketPet.getPrice()) });
/* 83 */     MarketManager.logger.info(logStr);
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PGetMoneyPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */