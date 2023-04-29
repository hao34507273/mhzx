/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.Pet;
/*     */ import xbean.RoleAuctionInfo;
/*     */ 
/*     */ public class PGetAuctionPetReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long marketId;
/*     */   private final int petCfgId;
/*     */   
/*     */   public PGetAuctionPetReq(long roleId, long marketId, int petCfgId)
/*     */   {
/*  19 */     this.roleId = roleId;
/*  20 */     this.marketId = marketId;
/*  21 */     this.petCfgId = petCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     String log = String.format("[marketauction]PGetAuctionPetReq.processImp@receive get auction pet req|roleid=%d|petCfgId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId) });
/*     */     
/*     */ 
/*  32 */     MarketInterface.getLogger().info(log);
/*     */     
/*  34 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  36 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  38 */       MarketInterface.getLogger().info(logStr);
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!MarketInterface.isMarketAuctionSwitchOpenForRole(this.roleId))
/*     */     {
/*  44 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet failed,role is ban play|roleid=%d|petCfgId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  47 */       MarketInterface.getLogger().error(logStr);
/*     */       
/*  49 */       return false;
/*     */     }
/*  51 */     RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/*  52 */     if (xRoleAuctionInfo == null)
/*     */     {
/*  54 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet failed,xRoleAuctionInfo null|roleid=%d|petCfgId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  57 */       MarketInterface.getLogger().error(logStr);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!xRoleAuctionInfo.getAuction_pet_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/*  63 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet failed,marketId wrong|roleid=%d|petCfgId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  66 */       MarketInterface.getLogger().error(logStr);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  71 */     AuctionPetInfo xAuctionInfo = xtable.Marketpetid2auction.get(Long.valueOf(this.marketId));
/*  72 */     if (xAuctionInfo == null)
/*     */     {
/*  74 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet failed,xAuctionInfo null|roleid=%d|petCfgId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  77 */       MarketInterface.getLogger().error(logStr);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (xAuctionInfo.getEndtime() > now)
/*     */     {
/*  83 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet error ,time error|roleid=%d|petCfgId=%d|marketId=%d|endtime=%d|now=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Long.valueOf(xAuctionInfo.getEndtime()), Long.valueOf(now) });
/*     */       
/*     */ 
/*  86 */       MarketInterface.getLogger().info(logStr);
/*     */       
/*  88 */       return false;
/*     */     }
/*  90 */     if (xAuctionInfo.getAuctionroleid() != this.roleId)
/*     */     {
/*  92 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet error ,roleid error|roleid=%d|petCfgId=%d|marketId=%d|maxPriceRoleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Long.valueOf(xAuctionInfo.getAuctionroleid()) });
/*     */       
/*     */ 
/*  95 */       MarketInterface.getLogger().info(logStr);
/*     */       
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     int price = xAuctionInfo.getAuctionprice();
/*     */     
/* 102 */     Pet xPet = (Pet)xRoleAuctionInfo.getMarketid2auctionpet().get(Long.valueOf(this.marketId));
/* 103 */     if (xPet == null)
/*     */     {
/* 105 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet failed,xPet null|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(price) });
/*     */       
/*     */ 
/* 108 */       MarketInterface.getLogger().error(logStr);
/*     */       
/* 110 */       return false;
/*     */     }
/* 112 */     if (xPet.getTemplateid() != this.petCfgId)
/*     */     {
/* 114 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet failed,petCfgId error|roleid=%d|petCfgId=%d|marketId=%d|price=%d|serverPetCfgId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(price), Integer.valueOf(xPet.getTemplateid()) });
/*     */       
/*     */ 
/* 117 */       MarketInterface.getLogger().error(logStr);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     xRoleAuctionInfo.getMarketid2auctionpet().remove(Long.valueOf(this.marketId));
/* 122 */     xRoleAuctionInfo.getAuction_pet_ids().remove(Long.valueOf(this.marketId));
/*     */     
/* 124 */     MarketAuctionManager.removeMarketPetAuction(this.marketId, false, false, true);
/*     */     
/* 126 */     boolean ret = MarketInterface.addPetToRole(this.roleId, xPet, TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime()));
/*     */     
/* 128 */     if (!ret)
/*     */     {
/* 130 */       String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet failed,pet bag full|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(price) });
/*     */       
/*     */ 
/* 133 */       MarketInterface.getLogger().info(logStr);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     String logStr = String.format("[marketauction]PGetAuctionPetReq.processImp@get auction pet success|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(price) });
/*     */     
/*     */ 
/* 140 */     MarketInterface.getLogger().info(logStr);
/*     */     
/* 142 */     mzm.gsp.market.SGetAuctionPetRes res = new mzm.gsp.market.SGetAuctionPetRes();
/* 143 */     res.marketid = this.marketId;
/* 144 */     res.petcfgid = this.petCfgId;
/*     */     
/* 146 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 148 */     MarketInterface.triggerBuyPetEvent(this.roleId, xPet.getId(), this.petCfgId, xAuctionInfo.getAuctionprice());
/* 149 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PGetAuctionPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */