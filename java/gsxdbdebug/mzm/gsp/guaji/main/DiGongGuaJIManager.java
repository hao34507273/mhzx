/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SDigongGuaYeConst;
/*    */ import mzm.gsp.activity.confbean.SDigongGuaYeRewardModify;
/*    */ import mzm.gsp.activity.confbean.SMonsterLevelAwardCfg;
/*    */ import mzm.gsp.guaji.confbean.SMapGuajiConf;
/*    */ import mzm.gsp.item.main.access.ItemAccessManager;
/*    */ import mzm.gsp.monster.main.MonsterInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DiGongGuaJIManager
/*    */ {
/* 20 */   private static Map<Integer, SMonsterLevelAwardCfg> sMonsterLevelAwardCfgs = new HashMap();
/*    */   
/*    */   static void init() {
/* 23 */     for (Iterator i$ = SMonsterLevelAwardCfg.getAll().values().iterator(); i$.hasNext();) { cfg = (SMonsterLevelAwardCfg)i$.next();
/* 24 */       if (cfg.activityId == SDigongGuaYeConst.getInstance().ACTIVITYID) {
/* 25 */         ItemAccessManager.registerActivityReward(SDigongGuaYeConst.getInstance().ACTIVITYID, cfg.awardTypeId1);
/*    */         
/* 27 */         ItemAccessManager.registerActivityReward(SDigongGuaYeConst.getInstance().ACTIVITYID, cfg.awardTypeId2);
/*    */         
/* 29 */         for (SMapGuajiConf mapGuajiConf : SMapGuajiConf.getAll().values()) {
/* 30 */           if (mapGuajiConf.minLevel == cfg.levelLimit)
/* 31 */             sMonsterLevelAwardCfgs.put(Integer.valueOf(mapGuajiConf.sendMapId), cfg);
/*    */         }
/*    */       }
/*    */     }
/*    */     SMonsterLevelAwardCfg cfg;
/*    */   }
/*    */   
/*    */   static boolean check(List<Integer> monsterIdList, int groupId) {
/* 39 */     for (Iterator i$ = monsterIdList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/* 40 */       if (groupId == MonsterInterface.getMonsterCategoryId(id)) {
/* 41 */         return true;
/*    */       }
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   static SMonsterLevelAwardCfg getAward(int sceneId) {
/* 48 */     return (SMonsterLevelAwardCfg)sMonsterLevelAwardCfgs.get(Integer.valueOf(sceneId));
/*    */   }
/*    */   
/*    */   public static boolean checkMonster1(List<Integer> monsterIdList) {
/* 52 */     return check(monsterIdList, SDigongGuaYeConst.getInstance().VISIBLE_MONSTER_ID1);
/*    */   }
/*    */   
/*    */   public static boolean checkMonster2(List<Integer> monsterIdList) {
/* 56 */     return check(monsterIdList, SDigongGuaYeConst.getInstance().VISIBLE_MONSTER_ID2);
/*    */   }
/*    */   
/*    */   public static int getModifyTableIdId(int difLv, boolean isUseDoublePoint) {
/* 60 */     for (SDigongGuaYeRewardModify modify : SDigongGuaYeRewardModify.getAll().values()) {
/* 61 */       if ((modify.isCostDoublePoint == isUseDoublePoint) && 
/*    */       
/*    */ 
/* 64 */         (modify.highDifMonsterLevel >= difLv) && (modify.lowDifMonsterLevel <= difLv))
/*    */       {
/*    */ 
/* 67 */         return modify.modifyValueTableId; }
/*    */     }
/* 69 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\DiGongGuaJIManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */