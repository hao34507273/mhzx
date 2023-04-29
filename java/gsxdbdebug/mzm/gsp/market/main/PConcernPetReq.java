/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.SConcernPetRes;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConcernRoleIdSet;
/*     */ import xbean.MarketPet;
/*     */ import xbean.RoleMarketInfo;
/*     */ 
/*     */ public class PConcernPetReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long marketid;
/*     */   private int petCfgId;
/*     */   
/*     */   public PConcernPetReq(long roleId, long marketid, int petCfgId)
/*     */   {
/*  18 */     this.roleId = roleId;
/*  19 */     this.marketid = marketid;
/*  20 */     this.petCfgId = petCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  29 */       String logStr = String.format("[market]PConcernPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  31 */       MarketManager.logger.info(logStr);
/*  32 */       return false;
/*     */     }
/*  34 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/*     */     
/*  44 */     if (xRoleMarketInfo == null)
/*     */     {
/*  46 */       xRoleMarketInfo = xbean.Pod.newRoleMarketInfo();
/*  47 */       xtable.Role2marketinfo.insert(Long.valueOf(this.roleId), xRoleMarketInfo);
/*     */     }
/*     */     
/*  50 */     xbean.RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/*  51 */     if ((xRoleAuctionInfo != null) && (xRoleAuctionInfo.getAuction_pet_ids().contains(Long.valueOf(this.marketid))))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int alreadyConcernNum = xRoleMarketInfo.getConcern_item_ids().size() + xRoleMarketInfo.getConcern_pet_ids().size();
/*  57 */     if (alreadyConcernNum >= MarketManager.getRoleMaxConcernNum())
/*     */     {
/*  59 */       MarketManager.removeRolecConcernIds(xRoleMarketInfo);
/*  60 */       alreadyConcernNum = xRoleMarketInfo.getConcern_item_ids().size() + xRoleMarketInfo.getConcern_pet_ids().size();
/*  61 */       if (alreadyConcernNum >= MarketManager.getRoleMaxConcernNum())
/*     */       {
/*  63 */         String logStr = String.format("[market]PConcernPetReq.processImp@market concern num to max |roleid=%d|concernNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alreadyConcernNum) });
/*     */         
/*     */ 
/*  66 */         MarketManager.logger.error(logStr);
/*  67 */         MarketManager.sendCommonError(this.roleId, 12);
/*  68 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  72 */     if (xRoleMarketInfo.getConcern_pet_ids().contains(Long.valueOf(this.marketid)))
/*     */     {
/*  74 */       return false;
/*     */     }
/*  76 */     MarketPet xMarketPet = xtable.Marketpet.get(Long.valueOf(this.marketid));
/*  77 */     if ((xMarketPet == null) || (xMarketPet.getState() == 8) || (xMarketPet.getState() == 4))
/*     */     {
/*     */ 
/*  80 */       MarketManager.sendCommonError(this.roleId, 8);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (xMarketPet.getPet().getTemplateid() != this.petCfgId)
/*     */     {
/*  86 */       return false;
/*     */     }
/*  88 */     if (xMarketPet.getRoleid() == this.roleId)
/*     */     {
/*  90 */       MarketManager.sendCommonError(this.roleId, 17);
/*  91 */       return false;
/*     */     }
/*  93 */     xRoleMarketInfo.getConcern_pet_ids().add(Long.valueOf(this.marketid));
/*  94 */     xMarketPet.setConcern_role_num(xMarketPet.getConcern_role_num() + 1);
/*     */     
/*  96 */     SConcernPetRes concernPetRes = new SConcernPetRes();
/*  97 */     xbean.AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.select(Long.valueOf(this.marketid));
/*  98 */     MarketManager.fillProtocolMarketPet(concernPetRes.concernmarketpet, this.marketid, xMarketPet, xAuctionPetInfo);
/*     */     
/* 100 */     if (MarketManager.hasState(xMarketPet.getState(), 1))
/*     */     {
/* 102 */       ConcernRoleIdSet xConcernRoleIdSet = xtable.Marketpetid2concernrole.get(Long.valueOf(this.marketid));
/* 103 */       if (xConcernRoleIdSet == null)
/*     */       {
/* 105 */         xConcernRoleIdSet = xbean.Pod.newConcernRoleIdSet();
/* 106 */         xtable.Marketpetid2concernrole.insert(Long.valueOf(this.marketid), xConcernRoleIdSet);
/*     */       }
/* 108 */       if (xConcernRoleIdSet.getRoleids().size() >= MarketManager.getConcernMax())
/*     */       {
/* 110 */         int r = xdb.Xdb.random().nextInt(MarketManager.getConcernMax());
/* 111 */         xConcernRoleIdSet.getRoleids().remove(r);
/* 112 */         xConcernRoleIdSet.getRoleids().add(Long.valueOf(this.roleId));
/*     */       }
/*     */       else
/*     */       {
/* 116 */         xConcernRoleIdSet.getRoleids().add(Long.valueOf(this.roleId));
/*     */       }
/*     */     }
/*     */     
/* 120 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, concernPetRes);
/* 121 */     String logStr = String.format("[market]PConcernPetReq.processImp@concern pet success|roleid=%d|petCfgId=%d|marketId=%d|concernNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketid), Integer.valueOf(xMarketPet.getConcern_role_num()) });
/*     */     
/*     */ 
/* 124 */     MarketManager.logger.info(logStr);
/*     */     
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PConcernPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */