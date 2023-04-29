/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.handle.EnterFightHandle;
/*     */ import mzm.gsp.fight.handle.FighterDeadHandle;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.fight.main.FighterFellow;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class LiveLove
/*     */   extends FighterEffect
/*     */   implements EnterFightHandle, FighterDeadHandle, Validate
/*     */ {
/*     */   private int type;
/*     */   private int influence;
/*     */   private int effectid;
/*     */   private int partnerid1;
/*     */   private int partnerid2;
/*     */   private int partnerid3;
/*  33 */   private boolean effect = false;
/*     */   
/*     */   private static final int TYPE_FRIEND = 1;
/*     */   
/*     */   private static final int TYPE_ENERMY = 2;
/*     */   
/*     */   private static final int INFLUENCE_SELF = 1;
/*     */   private static final int INFLUENCE_OTHER = 2;
/*  41 */   private Set<Integer> partnerSet = new HashSet();
/*  42 */   private Map<Integer, FighterBuff> effectBuffMap = new HashMap();
/*     */   
/*     */   public LiveLove(int type, int influence, int effectid, int partnerid1, int partnerid2, int partnerid3) {
/*  45 */     this.type = type;
/*  46 */     this.influence = influence;
/*  47 */     this.effectid = effectid;
/*  48 */     this.partnerid1 = partnerid1;
/*  49 */     this.partnerid2 = partnerid2;
/*  50 */     this.partnerid3 = partnerid3;
/*  51 */     if (this.partnerid1 > 0) {
/*  52 */       this.partnerSet.add(Integer.valueOf(partnerid1));
/*     */     }
/*  54 */     if (this.partnerid2 > 0) {
/*  55 */       this.partnerSet.add(Integer.valueOf(partnerid2));
/*     */     }
/*  57 */     if (this.partnerid3 > 0) {
/*  58 */       this.partnerSet.add(Integer.valueOf(partnerid3));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  64 */     fighter.addEnterFightHandle(this);
/*  65 */     fighter.addFighterDeadHandle(this);
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  71 */     fighter.remEnterFightHandle(this);
/*  72 */     fighter.remFighterDeadHandle(this);
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   public void onEnterFight(Fighter fighter)
/*     */   {
/*  78 */     if (this.effect) {
/*  79 */       return;
/*     */     }
/*  81 */     Map<Integer, Set<Fighter>> parternerMap = getFellowFighters(fighter);
/*  82 */     Iterator i$; if (parternerMap.keySet().containsAll(this.partnerSet)) {
/*  83 */       this.effect = true;
/*  84 */       if ((this.influence & 0x1) > 0) {
/*  85 */         FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/*  86 */         if (addGroup != null) {
/*  87 */           int level = super.getSkillLevel();
/*  88 */           FighterBuff fighterBuff2 = addGroup.run(level, fighter, fighter, fighter.getid());
/*  89 */           if (fighterBuff2 != null) {
/*  90 */             this.effectBuffMap.put(Integer.valueOf(fighter.getid()), fighterBuff2);
/*     */           }
/*     */         } else {
/*  93 */           GameServer.logger().error("不存在的效果组id" + this.effectid);
/*     */         }
/*     */       }
/*  96 */       if ((this.influence & 0x2) > 0) {
/*  97 */         for (i$ = this.partnerSet.iterator(); i$.hasNext();) { int partnerid = ((Integer)i$.next()).intValue();
/*  98 */           Set<Fighter> targetSet = (Set)parternerMap.get(Integer.valueOf(partnerid));
/*  99 */           for (Fighter target : targetSet) {
/* 100 */             FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 101 */             if (addGroup != null) {
/* 102 */               int level = super.getSkillLevel();
/* 103 */               FighterBuff fighterBuff2 = addGroup.run(level, fighter, target, target.getid());
/* 104 */               if (fighterBuff2 != null) {
/* 105 */                 this.effectBuffMap.put(Integer.valueOf(target.getid()), fighterBuff2);
/*     */               }
/*     */             } else {
/* 108 */               GameServer.logger().error("不存在的效果组id" + this.effectid);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private Map<Integer, Set<Fighter>> getFellowFighters(Fighter fighter) {
/* 117 */     Set<Fighter> fighters = new HashSet();
/* 118 */     if ((this.type & 0x1) > 0) {
/* 119 */       fighters.addAll(fighter.getFriendLiveFighters());
/*     */     }
/* 121 */     if ((this.type & 0x2) > 0) {
/* 122 */       fighters.addAll(fighter.getEnermyLiveFighters());
/*     */     }
/* 124 */     Map<Integer, Set<Fighter>> parternerMap = new HashMap();
/* 125 */     for (Fighter otherFighter : fighters) {
/* 126 */       if (otherFighter.getid() != fighter.getid())
/*     */       {
/*     */ 
/* 129 */         if (otherFighter.isFellow()) {
/* 130 */           int partnerid = ((FighterFellow)otherFighter).getPartnerid();
/* 131 */           if (parternerMap.containsKey(Integer.valueOf(partnerid))) {
/* 132 */             ((Set)parternerMap.get(Integer.valueOf(partnerid))).add(otherFighter);
/*     */           } else {
/* 134 */             Set<Fighter> fighters2 = new HashSet();
/* 135 */             fighters2.add(otherFighter);
/* 136 */             parternerMap.put(Integer.valueOf(partnerid), fighters2);
/*     */           }
/*     */         } }
/*     */     }
/* 140 */     return parternerMap;
/*     */   }
/*     */   
/*     */   public void onFighterDead(Fighter ownFighter, Fighter deadFighter)
/*     */   {
/* 145 */     if (this.effect) {
/* 146 */       Map<Integer, Set<Fighter>> parternerMap = getFellowFighters(ownFighter);
/* 147 */       if (!parternerMap.keySet().containsAll(this.partnerSet)) {
/* 148 */         Iterator<Map.Entry<Integer, FighterBuff>> iterator = this.effectBuffMap.entrySet().iterator();
/* 149 */         while (iterator.hasNext()) {
/* 150 */           Map.Entry<Integer, FighterBuff> entry = (Map.Entry)iterator.next();
/* 151 */           Fighter hasBuffFighter = ownFighter.getFighter(((Integer)entry.getKey()).intValue());
/* 152 */           if (hasBuffFighter != null) {
/* 153 */             hasBuffFighter.removeBuff((FighterBuff)entry.getValue());
/*     */           }
/* 155 */           iterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean validate()
/*     */   {
/* 163 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 164 */     if (effectGroup == null) {
/* 165 */       throw new RuntimeException("LiveLove中配置的效果组id不存在:效果组id" + this.effectid);
/*     */     }
/* 167 */     if ((this.partnerid1 > 0) && (PartnerInterface.getSPartnerCfgById(this.partnerid1) == null)) {
/* 168 */       throw new RuntimeException("LiveLove伙伴的配置的id不存在partnerid:" + this.partnerid1);
/*     */     }
/* 170 */     if ((this.partnerid2 > 0) && (PartnerInterface.getSPartnerCfgById(this.partnerid2) == null)) {
/* 171 */       throw new RuntimeException("LiveLove伙伴的配置的id不存在partnerid:" + this.partnerid2);
/*     */     }
/* 173 */     if ((this.partnerid3 > 0) && (PartnerInterface.getSPartnerCfgById(this.partnerid3) == null)) {
/* 174 */       throw new RuntimeException("LiveLove伙伴的配置的id不存在partnerid:" + this.partnerid3);
/*     */     }
/* 176 */     if (this.partnerSet.size() == 0) {
/* 177 */       throw new RuntimeException("LiveLove没有配置对应的伙伴!!");
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\LiveLove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */