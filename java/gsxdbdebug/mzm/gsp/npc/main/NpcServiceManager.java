/*     */ package mzm.gsp.npc.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.npc.condition.BianShenConditon;
/*     */ import mzm.gsp.npc.condition.Condition;
/*     */ import mzm.gsp.npc.condition.FactionConditon;
/*     */ import mzm.gsp.npc.condition.ForceMarryConditon;
/*     */ import mzm.gsp.npc.condition.JieBaiConditon;
/*     */ import mzm.gsp.npc.condition.MarryConditon;
/*     */ import mzm.gsp.npc.condition.MenPaiConditon;
/*     */ import mzm.gsp.npc.condition.RoleLevelConditon;
/*     */ import mzm.gsp.npc.condition.SexConditon;
/*     */ import mzm.gsp.npc.condition.ShiTuConditon;
/*     */ import mzm.gsp.npc.condition.TeamCondition;
/*     */ import mzm.gsp.npc.confbean.SNPCBuffCfg;
/*     */ import mzm.gsp.npc.confbean.SNPCFightCfg;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.npc.confbean.SNpcService;
/*     */ import mzm.gsp.npc.confbean.SServiceConditon;
/*     */ import mzm.gsp.npc.confbean.SServiceTransfor;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NpcServiceManager
/*     */ {
/*  34 */   private static final Logger logger = Logger.getLogger(NpcServiceManager.class);
/*     */   
/*  36 */   private static Map<Integer, ConditionGroup> serviceConMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static final int PRO_SUM = 10000;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkNpcService(int npcId, int serviceId, long roleId)
/*     */   {
/*  50 */     return checkNpcService(npcId, serviceId, roleId, new NpcLocationChecker(roleId, npcId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkNpcService(int npcId, int serviceId, long roleId, ConditionChecker checker)
/*     */   {
/*  64 */     SNpc sNpc = NpcManager.getNpc(npcId);
/*  65 */     if (sNpc == null) {
/*  66 */       if (logger.isDebugEnabled())
/*  67 */         logger.debug("[NPC]NpcServiceManager 不存在npc:" + npcId);
/*  68 */       return false;
/*     */     }
/*  70 */     if (!sNpc.npcServiceTradeList.contains(Integer.valueOf(serviceId))) {
/*  71 */       if (logger.isDebugEnabled())
/*  72 */         logger.debug("[NPC]NpcServiceManager npc不存在该服务:npcId:" + npcId + " serviceid:" + serviceId);
/*  73 */       return false;
/*     */     }
/*  75 */     SNpcService sNpcService = SNpcService.get(serviceId);
/*  76 */     if (sNpcService == null) {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (NpcManager.isBanNpcService(serviceId)) {
/*  81 */       NpcManager.sendNormalResult(roleId, 100, new String[0]);
/*  82 */       return false;
/*     */     }
/*  84 */     if ((checker != null) && (!checker.check())) {
/*  85 */       if (logger.isDebugEnabled()) {
/*  86 */         logger.debug(String.format("[npc]NpcServiceManager.checkNpcService@extra checker check failed|roleid=%d|serviceid=%d|npcid=%d|checker_class=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(serviceId), Integer.valueOf(npcId), checker.getClass().getName() }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     if (sNpcService.conditonGroupId > 0) {
/*  97 */       ConditionGroup conditionGraph = (ConditionGroup)serviceConMap.get(Integer.valueOf(sNpcService.conditonGroupId));
/*  98 */       if (conditionGraph == null) {
/*  99 */         return false;
/*     */       }
/* 101 */       if (!conditionGraph.isTrue(roleId)) {
/* 102 */         return false;
/*     */       }
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   static void initCondition() {
/* 109 */     Map<Integer, ConditionGroup> serviceConMap = new HashMap();
/* 110 */     for (SServiceConditon serviceConditon : SServiceConditon.getAll().values()) {
/* 111 */       ConditionGroup conditionGroup = new ConditionGroup(null);
/*     */       
/* 113 */       if (serviceConditon.bianShenState != 1) {
/* 114 */         BianShenConditon bianShenConditon = new BianShenConditon(serviceConditon.bianShenState);
/* 115 */         conditionGroup.addCondition(bianShenConditon);
/*     */       }
/*     */       
/* 118 */       if (serviceConditon.factionState != 1) {
/* 119 */         FactionConditon factionConditon = new FactionConditon(serviceConditon.factionState);
/* 120 */         conditionGroup.addCondition(factionConditon);
/*     */       }
/*     */       
/* 123 */       if (serviceConditon.jieBaiState != 1) {
/* 124 */         JieBaiConditon jieBaiConditon = new JieBaiConditon(serviceConditon.jieBaiState);
/* 125 */         conditionGroup.addCondition(jieBaiConditon);
/*     */       }
/*     */       
/* 128 */       if (serviceConditon.marriedState != 1) {
/* 129 */         MarryConditon marryConditon = new MarryConditon(serviceConditon.marriedState);
/* 130 */         conditionGroup.addCondition(marryConditon);
/*     */       }
/*     */       
/* 133 */       if (serviceConditon.forceDivorce != 1) {
/* 134 */         ForceMarryConditon forceMarryConditon = new ForceMarryConditon(serviceConditon.forceDivorce);
/* 135 */         conditionGroup.addCondition(forceMarryConditon);
/*     */       }
/*     */       
/* 138 */       if (serviceConditon.menpai != 0) {
/* 139 */         MenPaiConditon menPaiConditon = new MenPaiConditon(serviceConditon.menpai);
/* 140 */         conditionGroup.addCondition(menPaiConditon);
/*     */       }
/*     */       
/* 143 */       if (serviceConditon.sex != 0) {
/* 144 */         SexConditon sexConditon = new SexConditon(serviceConditon.sex);
/* 145 */         conditionGroup.addCondition(sexConditon);
/*     */       }
/*     */       
/* 148 */       if (serviceConditon.shiTuState != 1) {
/* 149 */         ShiTuConditon shuTuConditon = new ShiTuConditon(serviceConditon.shiTuState);
/* 150 */         conditionGroup.addCondition(shuTuConditon);
/*     */       }
/*     */       
/* 153 */       TeamCondition teamCondition = new TeamCondition(serviceConditon.teamNumMin, serviceConditon.teamNumMax, serviceConditon.teamLevelMin, serviceConditon.teamState);
/*     */       
/* 155 */       conditionGroup.addCondition(teamCondition);
/*     */       
/* 157 */       if ((serviceConditon.levelMax > 0) || (serviceConditon.levelMin > 0)) {
/* 158 */         RoleLevelConditon roleLevelConditon = new RoleLevelConditon(serviceConditon.levelMin, serviceConditon.levelMax);
/*     */         
/* 160 */         conditionGroup.addCondition(roleLevelConditon);
/*     */       }
/* 162 */       serviceConMap.put(Integer.valueOf(serviceConditon.id), conditionGroup);
/*     */     }
/*     */     
/* 165 */     serviceConMap = serviceConMap;
/* 166 */     SServiceConditon.getAll().clear();
/*     */   }
/*     */   
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */   static void postInit() {}
/*     */   
/*     */ 
/*     */   private static class ConditionGroup
/*     */   {
/* 178 */     private List<Condition> conditonList = new ArrayList();
/*     */     
/*     */     public boolean isTrue(long roleId) {
/* 181 */       for (Condition condition : this.conditonList) {
/* 182 */         if (!condition.isTrue(roleId)) {
/* 183 */           return false;
/*     */         }
/*     */       }
/* 186 */       return true;
/*     */     }
/*     */     
/*     */     void addCondition(Condition condition) {
/* 190 */       this.conditonList.add(condition);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isNpcServiceAvailable(int serviceId, long roleId)
/*     */   {
/* 202 */     SNpcService sNpcService = SNpcService.get(serviceId);
/* 203 */     if (sNpcService == null) {
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     if (sNpcService.conditonGroupId > 0) {
/* 208 */       ConditionGroup conditionGraph = (ConditionGroup)serviceConMap.get(Integer.valueOf(sNpcService.conditonGroupId));
/* 209 */       if (conditionGraph == null) {
/* 210 */         return false;
/*     */       }
/* 212 */       if (!conditionGraph.isTrue(roleId)) {
/* 213 */         return false;
/*     */       }
/*     */     }
/* 216 */     return true;
/*     */   }
/*     */   
/*     */   static SServiceTransfor getServiceTransfor(int serviceid) {
/* 220 */     return SServiceTransfor.get(serviceid);
/*     */   }
/*     */   
/*     */   static SNPCBuffCfg getServiceBuff(int serviceid) {
/* 224 */     return SNPCBuffCfg.get(serviceid);
/*     */   }
/*     */   
/*     */   static SNPCFightCfg getServiceFight(int serviceid) {
/* 228 */     return SNPCFightCfg.get(serviceid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */