/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.monster.main.Monster;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*     */ import mzm.gsp.pvc.confbean.PVCRobotCfg;
/*     */ import mzm.gsp.pvc.confbean.SPVCCfg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FightGroupFellow
/*     */   extends FightGroup
/*     */ {
/*     */   FightGroupFellow(int groupid, xbean.FightGroup xGroup, FightTeam fightTeam)
/*     */   {
/*  24 */     super(groupid, xGroup, fightTeam);
/*     */   }
/*     */   
/*     */   void init(Map<Integer, PartnerOutFightObj> posToPartnerMap, long roleid)
/*     */   {
/*  29 */     setRoleid(roleid);
/*     */     
/*     */ 
/*  32 */     for (Map.Entry<Integer, PartnerOutFightObj> entry : posToPartnerMap.entrySet()) {
/*  33 */       int pos = ((Integer)entry.getKey()).intValue();
/*  34 */       PartnerOutFightObj p = (PartnerOutFightObj)entry.getValue();
/*  35 */       FighterFellow ff = generateFighterFellow();
/*  36 */       ff.init(p, pos);
/*     */     }
/*     */   }
/*     */   
/*     */   void initClone(long roleid, Map<Integer, PartnerOutFightObj> partnerMap, SPVCCfg pvCfg, int level) {
/*  41 */     setRoleid(roleid);
/*  42 */     setCloneGroup();
/*  43 */     for (Map.Entry<Integer, PartnerOutFightObj> entry : partnerMap.entrySet()) {
/*  44 */       int pos = ((Integer)entry.getKey()).intValue();
/*  45 */       PartnerOutFightObj p = (PartnerOutFightObj)entry.getValue();
/*  46 */       Map<Integer, Integer> attrsMap = new HashMap();
/*  47 */       Map<Integer, Integer> exaAttrsMap = new HashMap();
/*  48 */       if (OpenInterface.getOpenStatus(239)) {
/*  49 */         p.fillFinalPropertyMap(attrsMap);
/*     */       } else {
/*  51 */         p.fillSelfFixFightProperty(attrsMap);
/*  52 */         p.fillOtherFightProperty(exaAttrsMap);
/*     */       }
/*  54 */       for (Map.Entry<Integer, Integer> proRateEntry : pvCfg.proRateMap.entrySet()) {
/*  55 */         int key = ((Integer)proRateEntry.getKey()).intValue();
/*  56 */         if (attrsMap.containsKey(Integer.valueOf(key))) {
/*  57 */           int value = (int)(((Integer)proRateEntry.getValue()).intValue() * 1.0D / FightArgs.getInstance().defaultRate * ((Integer)attrsMap.get(Integer.valueOf(key))).intValue());
/*     */           
/*  59 */           attrsMap.put(Integer.valueOf(key), Integer.valueOf(value));
/*     */         }
/*     */       }
/*     */       
/*  63 */       if (attrsMap.size() > 0) {
/*  64 */         CloneFighterFellow ff = generateCloneFighterFellow();
/*  65 */         ff.init(p, pos, attrsMap, exaAttrsMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void initClone(long roleid, Map<Integer, PartnerOutFightObj> partnerMap, PVCRobotCfg spvcRobotCfg, int level)
/*     */   {
/*  72 */     setRoleid(roleid);
/*  73 */     setCloneGroup();
/*     */     
/*  75 */     List<Integer> partnerMonsters = FightConfigManager.getInstance().getPartnerids(spvcRobotCfg);
/*  76 */     int index = 0;
/*  77 */     for (Map.Entry<Integer, PartnerOutFightObj> entry : partnerMap.entrySet()) {
/*  78 */       int pos = ((Integer)entry.getKey()).intValue();
/*  79 */       PartnerOutFightObj p = (PartnerOutFightObj)entry.getValue();
/*  80 */       Map<Integer, Integer> attrsMap = new HashMap();
/*  81 */       Map<Integer, Integer> exaAttrsMap = new HashMap();
/*  82 */       if (index < partnerMonsters.size()) {
/*  83 */         Monster monster = MonsterInterface.getMonster(((Integer)partnerMonsters.get(index++)).intValue(), level);
/*  84 */         monster.fillSelfFixFightProperty(attrsMap);
/*  85 */         monster.fillOtherFightProperty(exaAttrsMap);
/*     */       }
/*  87 */       if (attrsMap.size() > 0) {
/*  88 */         CloneFighterFellow ff = generateCloneFighterFellow();
/*  89 */         ff.init(p, pos, attrsMap, exaAttrsMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void fillFightGroupBean(mzm.gsp.fight.FightGroup fightGroupBean)
/*     */   {
/*  97 */     super.fillFightGroupBean(fightGroupBean);
/*  98 */     fightGroupBean.roleid = getRoleid();
/*     */   }
/*     */   
/*     */   protected GroupAI getGroupAI() {
/* 102 */     return this.xGroup.getGroupai();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightGroupFellow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */