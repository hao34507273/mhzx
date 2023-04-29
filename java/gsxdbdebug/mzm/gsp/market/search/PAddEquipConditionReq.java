/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.SAddEquipConditionRes;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CustommizedCons;
/*     */ import xbean.MarketEquipCon;
/*     */ import xbean.MarketEquipConSet;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2customized;
/*     */ 
/*     */ public class PAddEquipConditionReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final mzm.gsp.market.EquipCondition condition;
/*     */   private final long roleId;
/*     */   
/*     */   public PAddEquipConditionReq(long roleId, mzm.gsp.market.EquipCondition condition)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.condition = condition;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  43 */       String logStr = String.format("[marketcustomized]PAddEquipConditionReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  45 */       MarketInterface.getLogger().info(logStr);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     String userid = RoleInterface.getUserId(this.roleId);
/*  50 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  51 */     lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  53 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     if (!MarketInterface.isMarketCustomizedSwitchOpenForRole(this.roleId))
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if (!MarketInterface.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.condition.subid))
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if (!MarketInterface.isItemSubtype(this.condition.subid))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(this.condition.subid);
/*  75 */     if (marketSubTypeCfg == null)
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     if ((this.condition.level < marketSubTypeCfg.initLevel) || (this.condition.level > marketSubTypeCfg.maxLevel) || ((this.condition.level - marketSubTypeCfg.initLevel) % marketSubTypeCfg.levelDelta != 0))
/*     */     {
/*     */ 
/*  82 */       MarketInterface.sendCommonError(this.roleId, 20);
/*  83 */       return false;
/*     */     }
/*  85 */     if (this.condition.skillids.isEmpty())
/*     */     {
/*  87 */       MarketInterface.sendCommonError(this.roleId, 20);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     for (Iterator i$ = this.condition.skillids.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */       
/*  93 */       if (!mzm.gsp.skill.main.SkillInterface.isPassiveSkill(skillid))
/*     */       {
/*  95 */         MarketInterface.sendCommonError(this.roleId, 20);
/*  96 */         return false;
/*     */       }
/*     */     }
/*  99 */     if (this.condition.colors.isEmpty())
/*     */     {
/* 101 */       MarketInterface.sendCommonError(this.roleId, 20);
/* 102 */       return false;
/*     */     }
/* 104 */     for (Iterator i$ = this.condition.colors.iterator(); i$.hasNext();) { int color = ((Integer)i$.next()).intValue();
/*     */       
/* 106 */       if (!ItemInterface.isItemColor(color))
/*     */       {
/* 108 */         MarketInterface.sendCommonError(this.roleId, 20);
/* 109 */         return false;
/*     */       }
/*     */     }
/* 112 */     CustommizedCons xCustommizedCons = Role2customized.get(Long.valueOf(this.roleId));
/* 113 */     if (xCustommizedCons == null)
/*     */     {
/* 115 */       xCustommizedCons = Pod.newCustommizedCons();
/* 116 */       Role2customized.insert(Long.valueOf(this.roleId), xCustommizedCons);
/*     */     }
/* 118 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 119 */     CustomizedConditionManager.getInstance().removeRoleTimeOutConditions(xCustommizedCons, now);
/* 120 */     if (CustomizedConditionManager.getInstance().isCustomizedToMax(xCustommizedCons))
/*     */     {
/* 122 */       String log = String.format("[marketcustomized]PAddEquipConditionReq.processImp@customized condition to max|roleid=%d|subid=%d|level=%d|colors=%s|maxnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.level), this.condition.colors.toString(), Integer.valueOf(SMarketConsts.getInstance().MAX_CUSTOMIZED_CONDITION_NUM) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 127 */       MarketInterface.getLogger().info(log);
/* 128 */       return false;
/*     */     }
/* 130 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_CUSTOMIZED, this.condition.subid);
/*     */     
/* 132 */     CostResult result = mzm.gsp.qingfu.main.QingfuInterface.costYuanbao(userid, this.roleId, SMarketConsts.getInstance().CUSTOMIZED_NEED_YUANBAO_NUM, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_MARKET_CUSTOMIZED, logArg);
/*     */     
/* 134 */     if (result != CostResult.Success)
/*     */     {
/* 136 */       String log = String.format("[marketcustomized]PAddEquipConditionReq.processImp@cost yuanbao fialed|roleid=%d|subid=%d|level=%d|colors=%s|costnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.level), this.condition.colors.toString(), Integer.valueOf(SMarketConsts.getInstance().CUSTOMIZED_NEED_YUANBAO_NUM) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 141 */       MarketInterface.getLogger().info(log);
/*     */       
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     MarketEquipCon xEquipCon = Pod.newMarketEquipCon();
/* 147 */     xEquipCon.setLevel(this.condition.level);
/* 148 */     xEquipCon.getColors().addAll(this.condition.colors);
/* 149 */     xEquipCon.getSkillids().addAll(this.condition.skillids);
/* 150 */     xEquipCon.setCusttime(TimeUnit.MILLISECONDS.toSeconds(now));
/* 151 */     MarketEquipConSet xMarketEquipConSet = (MarketEquipConSet)xCustommizedCons.getSubid2equipcons().get(Integer.valueOf(this.condition.subid));
/* 152 */     if (xMarketEquipConSet == null)
/*     */     {
/* 154 */       xMarketEquipConSet = Pod.newMarketEquipConSet();
/* 155 */       xCustommizedCons.getSubid2equipcons().put(Integer.valueOf(this.condition.subid), xMarketEquipConSet);
/*     */     }
/* 157 */     EquipCondition c = MarketSearcherManager.getEquipConditionFromProtocol(this.condition);
/* 158 */     for (MarketEquipCon xMarketEquipCon : xMarketEquipConSet.getEquipcons())
/*     */     {
/* 160 */       if (CustomizedConditionManager.getInstance().isSame(xMarketEquipCon, c))
/*     */       {
/* 162 */         String log = String.format("[marketcustomized]PAddEquipConditionReq.processImp@condition already exists|roleid=%d|subid=%d|level=%d|colors=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.condition.subid), Integer.valueOf(this.condition.level), this.condition.colors.toString() });
/*     */         
/*     */ 
/*     */ 
/* 166 */         MarketInterface.getLogger().info(log);
/*     */         
/* 168 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 172 */     xMarketEquipConSet.getEquipcons().add(xEquipCon);
/*     */     
/* 174 */     SAddEquipConditionRes res = new SAddEquipConditionRes();
/* 175 */     res.condition = this.condition;
/* 176 */     res.condition.custtime = xEquipCon.getCusttime();
/* 177 */     res.index = xMarketEquipConSet.getEquipcons().size();
/* 178 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 180 */     CustomizedConditionManager.getInstance().addEquipConditionRoleId(this.condition.subid, c, this.roleId);
/*     */     
/* 182 */     MarketTlogManager.tlogMarketcustomized(this.roleId, SearchTypeEnum.EQUIP.value, this.condition.subid, c);
/* 183 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PAddEquipConditionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */