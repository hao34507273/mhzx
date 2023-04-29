/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PSearchEquipReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final mzm.gsp.market.EquipCondition condition;
/*     */   private final int pubOrSell;
/*     */   private int pageIndex;
/*     */   private final int priceSort;
/*     */   private final long roleId;
/*     */   
/*     */   public PSearchEquipReq(long roleId, mzm.gsp.market.EquipCondition condition, int pubOrSell, int priceSort, int pageIndex)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.condition = condition;
/*  29 */     this.pubOrSell = pubOrSell;
/*  30 */     this.priceSort = priceSort;
/*  31 */     this.pageIndex = pageIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  40 */       String logStr = String.format("[marketsearch]PSearchEquipReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       MarketInterface.getLogger().info(logStr);
/*  43 */       return false;
/*     */     }
/*  45 */     String logStr = String.format("[marketsearch]PSearchEquipReq.processImp@receive search equip req|roleid=%d|subid=%d|level=%d|colors=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.level), this.condition.colors.toString() });
/*     */     
/*     */ 
/*  48 */     MarketInterface.getLogger().info(logStr);
/*     */     
/*  50 */     Lockeys.lock(Role2marketinfo.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  51 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     if (!MarketInterface.isMarketSearchSwitchOpenForRole(this.roleId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     if (!MarketInterface.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.condition.subid))
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(this.condition.subid);
/*  68 */     if (marketSubTypeCfg == null)
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     if ((this.condition.level < marketSubTypeCfg.initLevel) || (this.condition.level > marketSubTypeCfg.maxLevel) || ((this.condition.level - marketSubTypeCfg.initLevel) % marketSubTypeCfg.levelDelta != 0))
/*     */     {
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     for (Iterator i$ = this.condition.colors.iterator(); i$.hasNext();) { int color = ((Integer)i$.next()).intValue();
/*     */       
/*  80 */       if (!ItemInterface.isItemColor(color))
/*     */       {
/*  82 */         return false;
/*     */       }
/*     */     }
/*  85 */     for (Iterator i$ = this.condition.skillids.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */       
/*  87 */       if (!SkillInterface.isPassiveSkill(skillid))
/*     */       {
/*  89 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  93 */     int state = 1;
/*  94 */     if (this.pubOrSell == 1)
/*     */     {
/*  96 */       state = 2;
/*     */     }
/*     */     else
/*     */     {
/* 100 */       state = 1;
/*     */     }
/* 102 */     EquipCondition c = MarketSearcherManager.getEquipConditionFromProtocol(this.condition);
/*     */     
/* 104 */     MarketTlogManager.tlogMarketsearch(this.roleId, SearchTypeEnum.EQUIP.value, this.condition.subid, c, state);
/*     */     
/* 106 */     int size = EquipQueryCache.getInstance().getSize(this.condition.subid, c, state);
/* 107 */     if (size == -1)
/*     */     {
/* 109 */       if ((this.pageIndex == 0) && (!MarketSearcherManager.checkAndSetSearchTime(this.roleId)))
/*     */       {
/* 111 */         return false;
/*     */       }
/*     */       
/* 114 */       int ret = SearchTaskManager.getInstance().addTask(new SearchEquipProcedure(this.roleId, this.condition, this.pubOrSell, this.priceSort, this.pageIndex));
/*     */       
/* 116 */       if (0 != ret)
/*     */       {
/* 118 */         MarketInterface.sendCommonError(this.roleId, 18);
/* 119 */         String log = String.format("[marketsearch]PSearchEquipReq.processImp@search queue full|roleid=%d|tasknum=%d|subid=%d|level=%d|colors=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ret), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.level), this.condition.colors.toString() });
/*     */         
/*     */ 
/*     */ 
/* 123 */         MarketInterface.getLogger().info(log);
/* 124 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 128 */       String log = String.format("[marketsearch]PSearchEquipReq.processImp@add search task into queue success|roleid=%d|tasknum=%d|subid=%d|level=%d|colors=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ret), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.level), this.condition.colors.toString() });
/*     */       
/*     */ 
/*     */ 
/* 132 */       MarketInterface.getLogger().info(log);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 137 */       MarketSearcherManager.fillAndSendQueryEquipResult(this.roleId, this.pubOrSell, this.priceSort, this.condition, this.pageIndex);
/*     */       
/* 139 */       String log = String.format("[marketsearch]PSearchEquipReq.processImp@query from cache  success|roleid=%d|tasknum=%d|subid=%d|level=%d|colors=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(SearchTaskManager.getInstance().taskSize()), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.level), this.condition.colors.toString() });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 144 */       MarketInterface.getLogger().info(log);
/*     */     }
/*     */     
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private static class SearchEquipProcedure
/*     */     extends SearchBaseProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final mzm.gsp.market.EquipCondition condition;
/*     */     private final int pubOrSell;
/*     */     private final int priceSort;
/*     */     private int pageIndex;
/*     */     
/*     */     public SearchEquipProcedure(long roleId, mzm.gsp.market.EquipCondition condition, int pubOrSell, int priceSort, int pageIndex)
/*     */     {
/* 161 */       this.roleId = roleId;
/*     */       
/* 163 */       this.condition = condition;
/* 164 */       this.pubOrSell = pubOrSell;
/* 165 */       this.priceSort = priceSort;
/* 166 */       this.pageIndex = pageIndex;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean search()
/*     */       throws Exception
/*     */     {
/* 173 */       int state = 1;
/* 174 */       if (this.pubOrSell == 1)
/*     */       {
/* 176 */         state = 2;
/*     */       }
/*     */       else
/*     */       {
/* 180 */         state = 1;
/*     */       }
/* 182 */       EquipCondition c = MarketSearcherManager.getEquipConditionFromProtocol(this.condition);
/*     */       
/* 184 */       EquipQueryCache.getInstance().buildByConditionFromIndex(this.condition.subid, c, state);
/*     */       
/* 186 */       MarketSearcherManager.fillAndSendQueryEquipResult(this.roleId, this.pubOrSell, this.priceSort, this.condition, this.pageIndex);
/* 187 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PSearchEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */