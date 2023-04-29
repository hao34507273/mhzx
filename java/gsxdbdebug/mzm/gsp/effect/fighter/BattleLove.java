/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.handle.EnterFightHandle;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterFellow;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class BattleLove
/*     */   extends FighterEffect
/*     */   implements EnterFightHandle, Validate
/*     */ {
/*     */   private int type;
/*     */   private int influence;
/*     */   private int effectid;
/*     */   private int partnerid1;
/*     */   private int partnerid2;
/*     */   private int partnerid3;
/*  29 */   private boolean effect = false;
/*     */   
/*     */   private static final int TYPE_FRIEND = 1;
/*     */   
/*     */   private static final int TYPE_ENERMY = 2;
/*     */   
/*     */   private static final int INFLUENCE_SELF = 1;
/*     */   private static final int INFLUENCE_OTHER = 2;
/*  37 */   private Set<Integer> partnerSet = new HashSet();
/*     */   
/*     */   public BattleLove(int type, int influence, int effectid, int partnerid1, int partnerid2, int partnerid3) {
/*  40 */     this.type = type;
/*  41 */     this.influence = influence;
/*  42 */     this.effectid = effectid;
/*  43 */     this.partnerid1 = partnerid1;
/*  44 */     this.partnerid2 = partnerid2;
/*  45 */     this.partnerid3 = partnerid3;
/*  46 */     if (this.partnerid1 > 0) {
/*  47 */       this.partnerSet.add(Integer.valueOf(partnerid1));
/*     */     }
/*  49 */     if (this.partnerid2 > 0) {
/*  50 */       this.partnerSet.add(Integer.valueOf(partnerid2));
/*     */     }
/*  52 */     if (this.partnerid3 > 0) {
/*  53 */       this.partnerSet.add(Integer.valueOf(partnerid3));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  59 */     fighter.addEnterFightHandle(this);
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  65 */     fighter.remEnterFightHandle(this);
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public void onEnterFight(Fighter fighter)
/*     */   {
/*  71 */     if (this.effect) {
/*  72 */       return;
/*     */     }
/*  74 */     Set<Fighter> fighters = new HashSet();
/*  75 */     if ((this.type & 0x1) > 0) {
/*  76 */       fighters.addAll(fighter.getFriendLiveFighters());
/*     */     }
/*  78 */     if ((this.type & 0x2) > 0) {
/*  79 */       fighters.addAll(fighter.getEnermyLiveFighters());
/*     */     }
/*  81 */     Map<Integer, Fighter> parternerMap = new HashMap();
/*  82 */     for (Fighter otherFighter : fighters)
/*  83 */       if (otherFighter.getid() != fighter.getid())
/*     */       {
/*     */ 
/*  86 */         if (otherFighter.isFellow()) {
/*  87 */           int partnerid = ((FighterFellow)otherFighter).getPartnerid();
/*  88 */           parternerMap.put(Integer.valueOf(partnerid), otherFighter);
/*     */         } }
/*     */     Iterator i$;
/*  91 */     if (parternerMap.keySet().containsAll(this.partnerSet)) {
/*  92 */       this.effect = true;
/*  93 */       if ((this.influence & 0x1) > 0) {
/*  94 */         FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/*  95 */         if (addGroup != null) {
/*  96 */           int level = super.getSkillLevel();
/*  97 */           addGroup.run(level, fighter, fighter, fighter.getid());
/*     */         } else {
/*  99 */           GameServer.logger().error("不存在的效果组id" + this.effectid);
/*     */         }
/*     */       }
/* 102 */       if ((this.influence & 0x2) > 0) {
/* 103 */         for (i$ = this.partnerSet.iterator(); i$.hasNext();) { int partnerid = ((Integer)i$.next()).intValue();
/* 104 */           Fighter target = (Fighter)parternerMap.get(Integer.valueOf(partnerid));
/* 105 */           FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 106 */           if (addGroup != null) {
/* 107 */             int level = super.getSkillLevel();
/* 108 */             addGroup.run(level, fighter, target, target.getid());
/*     */           } else {
/* 110 */             GameServer.logger().error("不存在的效果组id" + this.effectid);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean validate()
/*     */   {
/* 119 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 120 */     if (effectGroup == null) {
/* 121 */       throw new RuntimeException("BattleLove中配置的效果组id不存在:效果组id" + this.effectid);
/*     */     }
/* 123 */     if ((this.partnerid1 > 0) && (PartnerInterface.getSPartnerCfgById(this.partnerid1) == null)) {
/* 124 */       throw new RuntimeException("BattleLove伙伴的配置的id不存在partnerid:" + this.partnerid1);
/*     */     }
/* 126 */     if ((this.partnerid2 > 0) && (PartnerInterface.getSPartnerCfgById(this.partnerid2) == null)) {
/* 127 */       throw new RuntimeException("BattleLove伙伴的配置的id不存在partnerid:" + this.partnerid2);
/*     */     }
/* 129 */     if ((this.partnerid3 > 0) && (PartnerInterface.getSPartnerCfgById(this.partnerid3) == null)) {
/* 130 */       throw new RuntimeException("BattleLove伙伴的配置的id不存在partnerid:" + this.partnerid3);
/*     */     }
/* 132 */     if (this.partnerSet.size() == 0) {
/* 133 */       throw new RuntimeException("BattleLove没有配置相应的伙伴");
/*     */     }
/* 135 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BattleLove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */