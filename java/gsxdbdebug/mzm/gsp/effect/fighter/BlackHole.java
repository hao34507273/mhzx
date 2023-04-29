/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.AbsorbDamage;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.EscapeHandle;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class BlackHole
/*     */   extends FighterEffect implements AbsorbDamage, BeKilledHandle, EscapeHandle
/*     */ {
/*     */   private int enemyFighterId;
/*     */   private int friendFighterId;
/*     */   private int rate;
/*     */   private int times;
/*     */   private static final int NO_ENEMY_ID = 0;
/*     */   
/*     */   public BlackHole(int rate, int times)
/*     */   {
/*  40 */     this.rate = rate;
/*  41 */     this.times = times;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  47 */     FighterBuff buff = getGroup();
/*  48 */     if (buff == null) {
/*  49 */       return true;
/*     */     }
/*  51 */     Fighter releaser = buff.getReleaser(fighter);
/*  52 */     if (releaser == null) {
/*  53 */       return true;
/*     */     }
/*     */     
/*  56 */     Fighter friendFighter = fighter;
/*  57 */     this.friendFighterId = friendFighter.getid();
/*  58 */     friendFighter.addBeDamageHandle(this);
/*  59 */     friendFighter.addBeKilledHandle(this);
/*  60 */     friendFighter.addEscapeHandle(this);
/*     */     
/*  62 */     this.enemyFighterId = randomEnemy(releaser, friendFighter);
/*  63 */     if (this.enemyFighterId != 0) {
/*  64 */       Fighter enemyFighter = fighter.getFighter(this.enemyFighterId);
/*  65 */       if (enemyFighter.isGhost()) {
/*  66 */         int resistFighterId = this.enemyFighterId;
/*  67 */         this.enemyFighterId = 0;
/*  68 */         Skill skill = buff.getSkill();
/*  69 */         if (skill != null) {
/*  70 */           AttackResult attackResult = skill.getAttackResult(resistFighterId);
/*  71 */           AttackResultBean attackResultBean = null;
/*  72 */           int size = attackResult.attackresultbeans.size();
/*  73 */           if (size > 0) {
/*  74 */             attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(size - 1);
/*     */           } else {
/*  76 */             attackResultBean = new AttackResultBean();
/*  77 */             releaser.fillFighterStatus(attackResultBean.attackerstatus);
/*  78 */             enemyFighter.fillFighterStatus(attackResultBean.targetstatus);
/*  79 */             attackResult.attackresultbeans.add(attackResultBean);
/*     */             
/*  81 */             attackResultBean.targetstatus.status_set.add(Integer.valueOf(31));
/*  82 */             skill.addEffectTarget(resistFighterId);
/*     */           }
/*     */         }
/*     */         
/*  86 */         return true;
/*     */       }
/*  88 */       if (enemyFighter != null) {
/*  89 */         enemyFighter.addBeKilledHandle(this);
/*     */       }
/*  91 */       friendFighter.addEffectTargets(-30, this.enemyFighterId);
/*     */     }
/*     */     
/*  94 */     GameServer.logger().info(String.format("[effect]BlackHole.attach@attack blackhole|releaserId=%d|enemyFighterId=%d", new Object[] { Integer.valueOf(friendFighter.getid()), Integer.valueOf(this.enemyFighterId) }));
/*     */     
/*     */ 
/*  97 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 103 */     fighter.remBeDamageHandle(this);
/* 104 */     fighter.remBeKilledHandle(this);
/* 105 */     fighter.remEscapeHandle(this);
/*     */     
/* 107 */     if (this.enemyFighterId != 0) {
/* 108 */       Fighter enemyFighter = fighter.getFighter(this.enemyFighterId);
/* 109 */       if (enemyFighter != null) {
/* 110 */         enemyFighter.remBeKilledHandle(this);
/*     */       }
/*     */       
/* 113 */       fighter.removeEffectTargets(-30, this.enemyFighterId);
/*     */     }
/*     */     
/* 116 */     GameServer.logger().info(String.format("[effect]BlackHole.detach@attack blackhole|releaserId=%d|enemyFighterId=%d", new Object[] { Integer.valueOf(fighter.getid()), Integer.valueOf(this.enemyFighterId) }));
/*     */     
/*     */ 
/* 119 */     this.enemyFighterId = 0;
/* 120 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*     */   {
/* 127 */     if (this.times <= 0) {
/* 128 */       return;
/*     */     }
/*     */     
/* 131 */     Fighter target = inputObj.getTarget();
/* 132 */     if (target == null) {
/* 133 */       return;
/*     */     }
/*     */     
/*     */ 
/* 137 */     int nowDamage = outputObj.nowDamage;
/* 138 */     outputObj.nowDamage = 0;
/* 139 */     this.times -= 1;
/* 140 */     if (this.times <= 0) {
/* 141 */       if ((target != null) && (this.enemyFighterId != 0)) {
/* 142 */         target.removeEffectTargets(-30, this.enemyFighterId);
/*     */       }
/* 144 */       setLeftRound(0);
/*     */     }
/* 146 */     if (this.enemyFighterId != 0) {
/* 147 */       Fighter blackholeTarget = target.getFighter(this.enemyFighterId);
/* 148 */       if (blackholeTarget == null) {
/* 149 */         return;
/*     */       }
/* 151 */       outputObj.shareDamageFighters.add(blackholeTarget);
/* 152 */       int sharedDamage = (int)(nowDamage * (this.rate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 153 */       outputObj.shareDamageUnvampire += sharedDamage;
/*     */       
/* 155 */       Set<Integer> fighterShareDamageTypes = (Set)outputObj.fighterShareDamageTypes.get(Integer.valueOf(this.enemyFighterId));
/* 156 */       if (fighterShareDamageTypes == null) {
/* 157 */         fighterShareDamageTypes = new HashSet();
/* 158 */         outputObj.fighterShareDamageTypes.put(Integer.valueOf(this.enemyFighterId), fighterShareDamageTypes);
/*     */       }
/* 160 */       fighterShareDamageTypes.add(Integer.valueOf(32));
/* 161 */       fighterShareDamageTypes.add(Integer.valueOf(20));
/*     */     }
/*     */   }
/*     */   
/*     */   protected int randomEnemy(Fighter releaser, Fighter friendFighter) {
/* 166 */     Set<Fighter> aliveEnemys = releaser.getEnermyLiveFighters();
/* 167 */     if (aliveEnemys.size() == 0) {
/* 168 */       return 0;
/*     */     }
/* 170 */     List<Fighter> list = new ArrayList();
/* 171 */     for (Fighter enemyFighter : aliveEnemys)
/*     */     {
/* 173 */       if ((releaser.isVisible()) || (!enemyFighter.isInvisible())) {
/* 174 */         list.add(enemyFighter);
/*     */       }
/*     */     }
/* 177 */     if (list.size() == 0) {
/* 178 */       return 0;
/*     */     }
/* 180 */     int index = Xdb.random().nextInt(list.size());
/* 181 */     return ((Fighter)list.get(index)).getid();
/*     */   }
/*     */   
/*     */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*     */   {
/* 186 */     Fighter target = inputObj.target;
/* 187 */     if (target == null) {
/* 188 */       return;
/*     */     }
/* 190 */     Fighter friendFighter = target.getFighter(this.friendFighterId);
/* 191 */     if (friendFighter == null) {
/* 192 */       return;
/*     */     }
/* 194 */     Fighter enemyFighter = target.getFighter(this.enemyFighterId);
/*     */     
/* 196 */     if ((friendFighter.isDead()) || (enemyFighter == null) || (enemyFighter.isDead())) {
/* 197 */       friendFighter.removeEffectTargets(-30, this.enemyFighterId);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onEscaped(Fighter escapedFighter, Fighter notifiedFighter)
/*     */   {
/* 203 */     if (escapedFighter.getid() != this.enemyFighterId) {
/* 204 */       return;
/*     */     }
/*     */     
/*     */ 
/* 208 */     Fighter friendFighter = escapedFighter.getFighter(this.friendFighterId);
/* 209 */     if (friendFighter == null) {
/* 210 */       return;
/*     */     }
/*     */     
/* 213 */     friendFighter.removeEffectTargets(-30, this.enemyFighterId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BlackHole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */