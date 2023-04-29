/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.gsp.effect.fighter.Interface.SealType;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.handle.BeforeSealHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeSealHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class Mess extends FighterEffect implements SealType
/*     */ {
/*     */   private int target;
/*     */   private int hitRate;
/*     */   private static final int ALL = 0;
/*     */   private static final int FRIEND = 1;
/*     */   private static final int ENERMY = 2;
/*     */   
/*     */   public Mess(int target, int hitRate)
/*     */   {
/*  26 */     this.target = target;
/*  27 */     this.hitRate = hitRate;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  32 */     boolean isSeal = false;
/*  33 */     if (getGroup() == null) {
/*  34 */       return isSeal;
/*     */     }
/*  36 */     Fighter releaser = getGroup().getReleaser(fighter);
/*  37 */     if (releaser == null) {
/*  38 */       return isSeal;
/*     */     }
/*  40 */     BeforeSealHandle.OutputObj out = releaser.handleBeforeSeal(new BeforeSealHandle.InputObj(releaser, fighter, getGroup().getSkill()));
/*     */     
/*  42 */     int rate = out.sealRate + this.hitRate;
/*  43 */     isSeal = FightFormulaHelp.isSealHit0(releaser, fighter, rate);
/*  44 */     if (isSeal) {
/*  45 */       fighter.addBuffState(103);
/*  46 */       if (fighter.isCmdedInRound()) {
/*  47 */         int leftRound = getGroup().getLeftRound();
/*  48 */         getGroup().setLeftRound(leftRound + SFightConsts.getInstance().SEAL_ACTIONED_ADD_LAST_ROUND);
/*     */       }
/*     */     } else {
/*  51 */       Skill skill = getGroup().getSkill();
/*  52 */       if (skill != null) {
/*  53 */         skill.addNotSealRet(releaser, fighter);
/*     */       }
/*     */     }
/*  56 */     return isSeal;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  61 */     fighter.remBuffState(103);
/*  62 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Fighter> getTargets(Fighter fighter)
/*     */   {
/*  72 */     List<Fighter> fighters = new ArrayList();
/*  73 */     if (this.target == 0) {
/*  74 */       fighters.addAll(fighter.getFriendLiveFighters());
/*  75 */       fighters.addAll(fighter.getEnermyLiveFighters());
/*  76 */     } else if (this.target == 1) {
/*  77 */       fighters.addAll(fighter.getFriendLiveFighters());
/*  78 */     } else if (this.target == 2) {
/*  79 */       fighters.addAll(fighter.getEnermyLiveFighters());
/*     */     }
/*  81 */     if (fighters.size() > 0)
/*     */     {
/*  83 */       Collections.shuffle(fighters);
/*     */       
/*  85 */       Fighter resultFighter = null;
/*  86 */       for (Fighter fighter2 : fighters) {
/*  87 */         if ((!fighter2.equals(fighter)) && (
/*     */         
/*     */ 
/*  90 */           (fighter.isVisible()) || (!fighter2.isInvisible())))
/*     */         {
/*     */ 
/*  93 */           resultFighter = fighter2;
/*     */         }
/*     */       }
/*     */       
/*  97 */       fighters.clear();
/*  98 */       if (resultFighter != null) {
/*  99 */         fighters.add(resultFighter);
/*     */       }
/*     */     }
/*     */     
/* 103 */     return fighters;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Mess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */