/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PSearchPetReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final mzm.gsp.market.PetCondition condition;
/*     */   private final int pubOrSell;
/*     */   private final int priceSort;
/*     */   private final int pageIndex;
/*     */   private final long roleId;
/*     */   
/*     */   public PSearchPetReq(long roleId, mzm.gsp.market.PetCondition condition, int pubOrSell, int priceSort, int pageIndex)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.condition = condition;
/*     */     
/*  27 */     this.pubOrSell = pubOrSell;
/*  28 */     this.priceSort = priceSort;
/*  29 */     this.pageIndex = pageIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[marketsearch]PSearchPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       MarketInterface.getLogger().info(logStr);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     String logStr = String.format("[marketsearch]PSearchPetReq.processImp@receive search pet req|roleid=%d|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), this.condition.pettypes, this.condition.skillids.toString(), this.condition.qualitys.toString(), Integer.valueOf(this.condition.skillnum) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  49 */     MarketInterface.getLogger().info(logStr);
/*     */     
/*  51 */     Lockeys.lock(Role2marketinfo.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  52 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     if (!MarketInterface.isMarketSearchSwitchOpenForRole(this.roleId))
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     if (!MarketInterface.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.condition.subid))
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(this.condition.subid);
/*  69 */     if (marketSubTypeCfg == null)
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     int state = 1;
/*  75 */     if (this.pubOrSell == 1)
/*     */     {
/*  77 */       state = 2;
/*     */     }
/*     */     else
/*     */     {
/*  81 */       state = 1;
/*     */     }
/*  83 */     PetCondition c = MarketSearcherManager.getPetConditionFromProtocol(this.condition);
/*  84 */     MarketTlogManager.tlogMarketsearch(this.roleId, SearchTypeEnum.PET.value, this.condition.subid, c, state);
/*  85 */     int size = PetQueryCache.getInstance().getSize(this.condition.subid, c, state);
/*     */     
/*  87 */     if (size == -1)
/*     */     {
/*  89 */       if ((this.pageIndex == 0) && (!MarketSearcherManager.checkAndSetSearchTime(this.roleId)))
/*     */       {
/*     */ 
/*  92 */         return false;
/*     */       }
/*  94 */       int ret = SearchTaskManager.getInstance().addTask(new SearchPetProcedure(this.roleId, this.condition, this.pubOrSell, this.priceSort, this.pageIndex));
/*     */       
/*  96 */       if (0 != ret)
/*     */       {
/*  98 */         MarketInterface.sendCommonError(this.roleId, 18);
/*  99 */         String log = String.format("[marketsearch]PSearchPetReq.processImp@search queue full|roleid=%d|tasknum=%d|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ret), Integer.valueOf(this.condition.subid), this.condition.pettypes, this.condition.skillids.toString(), this.condition.qualitys.toString(), Integer.valueOf(this.condition.skillnum) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 104 */         MarketInterface.getLogger().info(log);
/* 105 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 109 */       String log = String.format("[marketsearch]PSearchPetReq.processImp@add search task into queue success|roleid=%d|tasknum=%d|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ret), Integer.valueOf(this.condition.subid), this.condition.pettypes, this.condition.skillids.toString(), this.condition.qualitys.toString(), Integer.valueOf(this.condition.skillnum) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 114 */       MarketInterface.getLogger().info(log);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 119 */       MarketSearcherManager.fillAndSendQueryPetResult(this.roleId, this.pubOrSell, this.priceSort, this.condition, this.pageIndex);
/*     */       
/* 121 */       String log = String.format("[marketsearch]PSearchPetReq.processImp@query from cache success|roleid=%d|tasknum=%d|subid=%d|petTypes=%s|skillids=%s|qualitys=%s|skillnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(SearchTaskManager.getInstance().taskSize()), Integer.valueOf(this.condition.subid), this.condition.pettypes, this.condition.skillids.toString(), this.condition.qualitys.toString(), Integer.valueOf(this.condition.skillnum) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 126 */       MarketInterface.getLogger().info(log);
/*     */     }
/*     */     
/*     */ 
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   private static class SearchPetProcedure
/*     */     extends SearchBaseProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final mzm.gsp.market.PetCondition condition;
/*     */     private final int pubOrSell;
/*     */     private final int priceSort;
/*     */     private int pageIndex;
/*     */     
/*     */     public SearchPetProcedure(long roleId, mzm.gsp.market.PetCondition condition, int pubOrSell, int priceSort, int pageIndex)
/*     */     {
/* 144 */       this.roleId = roleId;
/*     */       
/* 146 */       this.condition = condition;
/* 147 */       this.pubOrSell = pubOrSell;
/* 148 */       this.priceSort = priceSort;
/* 149 */       this.pageIndex = pageIndex;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean search()
/*     */       throws Exception
/*     */     {
/* 156 */       if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */       {
/* 158 */         return false;
/*     */       }
/* 160 */       if (!MarketInterface.isMarketSearchSwitchOpenForRole(this.roleId))
/*     */       {
/* 162 */         return false;
/*     */       }
/* 164 */       if (!MarketInterface.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.condition.subid))
/*     */       {
/* 166 */         return false;
/*     */       }
/* 168 */       if (!MarketInterface.isMarketOpen(this.roleId))
/*     */       {
/* 170 */         return false;
/*     */       }
/* 172 */       int state = 1;
/* 173 */       if (this.pubOrSell == 1)
/*     */       {
/* 175 */         state = 2;
/*     */       }
/*     */       else
/*     */       {
/* 179 */         state = 1;
/*     */       }
/* 181 */       PetCondition c = MarketSearcherManager.getPetConditionFromProtocol(this.condition);
/*     */       
/* 183 */       PetQueryCache.getInstance().buildByConditionFromIndex(this.condition.subid, c, state);
/*     */       
/* 185 */       MarketSearcherManager.fillAndSendQueryPetResult(this.roleId, this.pubOrSell, this.priceSort, this.condition, this.pageIndex);
/* 186 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PSearchPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */