/*     */ package mzm.gsp.item.main.access;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*     */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*     */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.guaji.main.GuajiInterface;
/*     */ import mzm.gsp.lifeskill.main.LifeSkillInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemAccessManager
/*     */ {
/*  29 */   private static final Map<Integer, Set<Integer>> mapId2rewardIdMap = new HashMap();
/*     */   
/*  31 */   private static final Set<Integer> npcTradeServiceList = new HashSet();
/*  32 */   private static final Map<Integer, Set<Integer>> activityId2rewardIdMap = new HashMap();
/*  33 */   private static final Map<Integer, Set<Integer>> activityId2FixRewardIdMap = new HashMap();
/*     */   
/*  35 */   private static final Map<Integer, Set<Integer>> activityId2pooltypeid = new HashMap();
/*     */   
/*  37 */   private static final Map<Integer, List<Integer>> itemid2Skillbagid = new HashMap();
/*     */   
/*     */ 
/*  40 */   private static final Map<Integer, Set<Integer>> activityId2AwardPoolLibid = new HashMap();
/*     */   
/*     */   public static void init()
/*     */   {
/*  44 */     initNpcForService();
/*  45 */     initActivityForRewardId();
/*  46 */     initMapIdForRewardId();
/*  47 */     initItemid2Skillbagid();
/*     */   }
/*     */   
/*     */   private static void initItemid2Skillbagid()
/*     */   {
/*  52 */     Map<Integer, List<Integer>> skill2item = LifeSkillInterface.getAllLifeSkill2Item();
/*  53 */     for (Iterator i$ = skill2item.keySet().iterator(); i$.hasNext();) { skillbagid = ((Integer)i$.next()).intValue();
/*     */       
/*  55 */       for (i$ = ((List)skill2item.get(Integer.valueOf(skillbagid))).iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*     */         
/*  57 */         if (!itemid2Skillbagid.containsKey(Integer.valueOf(itemid)))
/*     */         {
/*  59 */           itemid2Skillbagid.put(Integer.valueOf(itemid), new ArrayList());
/*     */         }
/*  61 */         ((List)itemid2Skillbagid.get(Integer.valueOf(itemid))).add(Integer.valueOf(skillbagid));
/*     */       }
/*     */     }
/*     */     int skillbagid;
/*     */     Iterator i$;
/*     */   }
/*     */   
/*  68 */   private static void initNpcForService() { npcTradeServiceList.addAll(NpcInterface.getAllNpcTradeServiceId()); }
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
/*     */   private static void initActivityForRewardId()
/*     */   {
/*  81 */     registerActivityReward(BaoTuActivityCfgConsts.getInstance().ACTIVITYID, BaoTuActivityCfgConsts.getInstance().REWARDID1);
/*     */     
/*  83 */     registerActivityReward(BaoTuActivityCfgConsts.getInstance().ACTIVITYID, BaoTuActivityCfgConsts.getInstance().REWARDID2);
/*     */     
/*     */ 
/*  86 */     registerActivityReward(ShimenActivityCfgConsts.getInstance().ACTIVITYID, ShimenActivityCfgConsts.getInstance().REWARD_ID);
/*     */     
/*  88 */     registerActivityReward(ShimenActivityCfgConsts.getInstance().ACTIVITYID, ShimenActivityCfgConsts.getInstance().DAY_PERFECT_CIRCLE_REWARD_ID);
/*     */     
/*  90 */     registerActivityReward(ShimenActivityCfgConsts.getInstance().ACTIVITYID, ShimenActivityCfgConsts.getInstance().WEEK_PERFECT_CIRCLE_REWARD_ID);
/*     */     
/*     */ 
/*  93 */     registerActivityReward(ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, ZhenYaoActivityCfgConsts.getInstance().REWARDID);
/*     */     
/*     */ 
/*  96 */     for (Iterator i$ = SSchoolChallengeCfgConsts.getInstance().circleRewardids.iterator(); i$.hasNext();) { int rewardid = ((Integer)i$.next()).intValue();
/*     */       
/*  98 */       registerActivityReward(SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, rewardid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void initMapIdForRewardId()
/*     */   {
/* 109 */     for (Integer sendMapId : )
/*     */     {
/*     */ 
/* 112 */       int darkMonsterTableId = MapInterface.getDarkMonsterTableId(sendMapId.intValue());
/* 113 */       if (darkMonsterTableId != 0)
/*     */       {
/*     */ 
/*     */ 
/* 117 */         int monsterFightTableId = MapInterface.getDarkMonsterFightId(darkMonsterTableId);
/* 118 */         Set<Integer> rewardIdSet = FightInterface.getAwardList(monsterFightTableId);
/* 119 */         rewardIdSet.remove(Integer.valueOf(0));
/* 120 */         if (rewardIdSet.size() > 0)
/*     */         {
/* 122 */           mapId2rewardIdMap.put(sendMapId, rewardIdSet);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static Set<Integer> getNpcTradeServiceList()
/*     */   {
/* 131 */     return npcTradeServiceList;
/*     */   }
/*     */   
/*     */   static Map<Integer, Set<Integer>> getMapId2rewardIdMap()
/*     */   {
/* 136 */     return mapId2rewardIdMap;
/*     */   }
/*     */   
/*     */   static Map<Integer, Set<Integer>> getActivityId2rewardIdMap()
/*     */   {
/* 141 */     return activityId2rewardIdMap;
/*     */   }
/*     */   
/*     */   static Map<Integer, Set<Integer>> getActivityId2FixRewardIdMap()
/*     */   {
/* 146 */     return activityId2FixRewardIdMap;
/*     */   }
/*     */   
/*     */   static Map<Integer, Set<Integer>> getActivityId2PooltypeidMap()
/*     */   {
/* 151 */     return activityId2pooltypeid;
/*     */   }
/*     */   
/*     */   static Map<Integer, Set<Integer>> getActivityId2AwardPoolLibidMap()
/*     */   {
/* 156 */     return activityId2AwardPoolLibid;
/*     */   }
/*     */   
/*     */   static List<Integer> getSkillbagid(long roleid, int itemid)
/*     */   {
/* 161 */     return (List)itemid2Skillbagid.get(Integer.valueOf(itemid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityReward(int activityId, int rewardId)
/*     */   {
/* 173 */     if (activityId2rewardIdMap.get(Integer.valueOf(activityId)) == null)
/*     */     {
/* 175 */       activityId2rewardIdMap.put(Integer.valueOf(activityId), new HashSet());
/*     */     }
/* 177 */     if ((!((Set)activityId2rewardIdMap.get(Integer.valueOf(activityId))).contains(Integer.valueOf(rewardId))) && (rewardId != 0))
/*     */     {
/* 179 */       ((Set)activityId2rewardIdMap.get(Integer.valueOf(activityId))).add(Integer.valueOf(rewardId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityFixReward(int activityId, int fixRewardId)
/*     */   {
/* 192 */     if (activityId2FixRewardIdMap.get(Integer.valueOf(activityId)) == null)
/*     */     {
/* 194 */       activityId2FixRewardIdMap.put(Integer.valueOf(activityId), new HashSet());
/*     */     }
/* 196 */     if ((!((Set)activityId2FixRewardIdMap.get(Integer.valueOf(activityId))).contains(Integer.valueOf(fixRewardId))) && (fixRewardId != 0))
/*     */     {
/* 198 */       ((Set)activityId2FixRewardIdMap.get(Integer.valueOf(activityId))).add(Integer.valueOf(fixRewardId));
/*     */     }
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
/*     */   public static void registerActivityPooltypeid(int activityId, int pooltypeid)
/*     */   {
/* 212 */     if (activityId2pooltypeid.get(Integer.valueOf(activityId)) == null)
/*     */     {
/* 214 */       activityId2pooltypeid.put(Integer.valueOf(activityId), new HashSet());
/*     */     }
/* 216 */     if (!((Set)activityId2pooltypeid.get(Integer.valueOf(activityId))).contains(Integer.valueOf(pooltypeid)))
/*     */     {
/* 218 */       ((Set)activityId2pooltypeid.get(Integer.valueOf(activityId))).add(Integer.valueOf(pooltypeid));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityAwardPoolLibid(int activityId, int awardpoollibid)
/*     */   {
/* 231 */     if (activityId2AwardPoolLibid.get(Integer.valueOf(activityId)) == null)
/*     */     {
/* 233 */       activityId2AwardPoolLibid.put(Integer.valueOf(activityId), new HashSet());
/*     */     }
/* 235 */     if (!((Set)activityId2AwardPoolLibid.get(Integer.valueOf(activityId))).contains(Integer.valueOf(awardpoollibid)))
/*     */     {
/* 237 */       ((Set)activityId2AwardPoolLibid.get(Integer.valueOf(activityId))).add(Integer.valueOf(awardpoollibid));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\access\ItemAccessManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */