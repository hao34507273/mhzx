/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.market.SQueryPetInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AuctionPetInfo;
/*    */ import xbean.MarketPet;
/*    */ import xbean.RoleMarketInfo;
/*    */ import xtable.Role2marketinfo;
/*    */ 
/*    */ public class PQueryPetInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long marketId;
/*    */   private int petCfgId;
/*    */   
/*    */   public PQueryPetInfo(long roleId, long marketId, int petCfgId, int price)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.marketId = marketId;
/* 23 */     this.petCfgId = petCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     xdb.Lockeys.lock(Role2marketinfo.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 33 */     if (this.petCfgId <= 0)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 39 */       String logStr = String.format("[market]PQueryPetInfo.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 41 */       MarketManager.logger.info(logStr);
/* 42 */       return false;
/*    */     }
/* 44 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     if (!MarketManager.isMarketOpen(this.roleId))
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     SQueryPetInfoRes res = new SQueryPetInfoRes();
/* 53 */     res.petcfgid = this.petCfgId;
/* 54 */     res.marketid = this.marketId;
/*    */     
/* 56 */     MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(this.marketId));
/* 57 */     AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.select(Long.valueOf(this.marketId));
/* 58 */     if (xMarketPet == null)
/*    */     {
/* 60 */       RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleId));
/* 61 */       if (xRoleMarketInfo == null)
/*    */       {
/* 63 */         MarketManager.sendCommonError(this.roleId, 8);
/* 64 */         return false;
/*    */       }
/* 66 */       xMarketPet = (MarketPet)xRoleMarketInfo.getMarketid2timeoutorselledpet().get(Long.valueOf(this.marketId));
/* 67 */       if (xMarketPet == null)
/*    */       {
/* 69 */         MarketManager.sendCommonError(this.roleId, 8);
/* 70 */         return false;
/*    */       }
/* 72 */       res.price = xMarketPet.getPrice();
/* 73 */       res.sellerroleid = xMarketPet.getRoleid();
/* 74 */       MarketManager.fillProtocolMarketPet(res.marketpet, this.marketId, xMarketPet, xAuctionPetInfo);
/*    */       
/* 76 */       PetInterface.fillPetInfo(this.roleId, xMarketPet.getPet(), res.petinfo);
/* 77 */       OnlineManager.getInstance().send(this.roleId, res);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 82 */       if (xMarketPet.getPet().getTemplateid() != this.petCfgId)
/*    */       {
/* 84 */         MarketManager.sendCommonError(this.roleId, 8);
/* 85 */         return false;
/*    */       }
/* 87 */       res.price = xMarketPet.getPrice();
/* 88 */       res.sellerroleid = xMarketPet.getRoleid();
/* 89 */       MarketManager.fillProtocolMarketPet(res.marketpet, this.marketId, xMarketPet, xAuctionPetInfo);
/* 90 */       PetInterface.fillPetInfo(this.roleId, xMarketPet.getPet(), res.petinfo);
/* 91 */       OnlineManager.getInstance().send(this.roleId, res);
/*    */     }
/*    */     
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryPetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */