/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeSealHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class IceCool extends mzm.gsp.effect.main.FighterEffect implements BeDamageHandle, mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.SealType
/*     */ {
/*     */   private int max;
/*     */   private int seallevel;
/*     */   private int sealrate;
/*     */   
/*     */   public IceCool(int max, int seallevel, int sealrate)
/*     */   {
/*  28 */     this.max = max;
/*  29 */     this.seallevel = seallevel;
/*  30 */     this.sealrate = sealrate;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  35 */     boolean isSeal = false;
/*     */     
/*  37 */     if (getGroup() == null) {
/*  38 */       return isSeal;
/*     */     }
/*  40 */     Fighter releaser = getGroup().getReleaser(fighter);
/*  41 */     if (releaser == null) {
/*  42 */       return isSeal;
/*     */     }
/*  44 */     BeforeSealHandle.OutputObj out = releaser.handleBeforeSeal(new mzm.gsp.fight.handle.BeforeSealHandle.InputObj(releaser, fighter, getGroup().getSkill()));
/*     */     
/*  46 */     int rate = out.sealRate + this.sealrate;
/*     */     
/*  48 */     isSeal = FightFormulaHelp.isSealHit(releaser, fighter, this.seallevel, rate);
/*     */     
/*  50 */     if (isSeal) {
/*  51 */       fighter.addBuffState(128);
/*  52 */       fighter.addBeDamageHandle(this);
/*  53 */       if (fighter.isCmdedInRound()) {
/*  54 */         int leftRound = getGroup().getLeftRound();
/*  55 */         getGroup().setLeftRound(leftRound + SFightConsts.getInstance().SEAL_ACTIONED_ADD_LAST_ROUND);
/*     */       }
/*  57 */       Set<Integer> influenceFighters = releaser.releaseUniqBuff(getGroup(), fighter.getid());
/*  58 */       Skill skill = getGroup().getSkill();
/*  59 */       Map<Integer, FighterStatus> influenceOtherMap; Iterator i$; if ((skill != null) && (influenceFighters.size() > 0)) {
/*  60 */         Map<Integer, Map<Integer, FighterStatus>> targetInfluenceOtherMap = skill.getTargetInfluenceMap();
/*  61 */         influenceOtherMap = null;
/*  62 */         if (targetInfluenceOtherMap.containsKey(Integer.valueOf(fighter.getid()))) {
/*  63 */           influenceOtherMap = (Map)targetInfluenceOtherMap.get(Integer.valueOf(fighter.getid()));
/*     */         } else {
/*  65 */           influenceOtherMap = new HashMap();
/*  66 */           targetInfluenceOtherMap.put(Integer.valueOf(fighter.getid()), influenceOtherMap);
/*     */         }
/*  68 */         for (i$ = influenceFighters.iterator(); i$.hasNext();) { int fighterid = ((Integer)i$.next()).intValue();
/*  69 */           Fighter influenceFighter = fighter.getFighter(fighterid);
/*  70 */           if (influenceFighter != null) {
/*  71 */             FighterStatus fighterStatus = new FighterStatus();
/*  72 */             influenceFighter.fillFighterStatus(fighterStatus);
/*  73 */             influenceOtherMap.put(Integer.valueOf(fighterid), fighterStatus);
/*     */           }
/*     */         }
/*     */       }
/*  77 */       else if (skill == null) {
/*  78 */         GameServer.logger().error("产生效果组的技能不存在:cfgid:" + getGroup().getBuffCfgId());
/*     */       }
/*  80 */       releaser.addUniqBuff(getGroup().getEffectGroupStatus(), fighter.getid());
/*     */     } else {
/*  82 */       Skill skill = getGroup().getSkill();
/*  83 */       if (skill != null) {
/*  84 */         skill.addNotSealRet(releaser, fighter);
/*     */       }
/*     */     }
/*  87 */     return isSeal;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  92 */     fighter.remBuffState(128);
/*  93 */     fighter.remBeDamageHandle(this);
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*     */   {
/* 104 */     if (outputObj.nowDamage > this.max) {
/* 105 */       outputObj.nowDamage = this.max;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\IceCool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */