/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.outfight.OutFightEffectInterface;
/*    */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*    */ import mzm.gsp.skill.confbean.SPassiveSkillCfg;
/*    */ 
/*    */ 
/*    */ public class PassiveSkill
/*    */   extends OutFightSkill
/*    */ {
/*    */   private SPassiveSkillCfg passiveSkillCfg;
/*    */   
/*    */   public PassiveSkill(SPassiveSkillCfg cfg, int level)
/*    */   {
/* 18 */     super(level);
/* 19 */     this.passiveSkillCfg = cfg;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<SOutFightEffectGroup> getEffectGroup()
/*    */   {
/* 28 */     List<SOutFightEffectGroup> effectGroups = new ArrayList();
/* 29 */     for (Iterator i$ = this.passiveSkillCfg.skillEffectGroupId.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/* 30 */       SOutFightEffectGroup group = SOutFightEffectGroup.get(id);
/* 31 */       if (group != null) {
/* 32 */         effectGroups.add(group);
/*    */       }
/*    */     }
/* 35 */     return effectGroups;
/*    */   }
/*    */   
/*    */   public List<SOutFightEffectGroup> getFighterEffectList() {
/* 39 */     List<SOutFightEffectGroup> effectList = new ArrayList();
/* 40 */     List<SOutFightEffectGroup> groups = getEffectGroup();
/* 41 */     for (SOutFightEffectGroup group : groups) {
/* 42 */       if (!OutFightEffectInterface.isOutFightEffect(group.effectId))
/*    */       {
/*    */ 
/* 45 */         effectList.add(group); }
/*    */     }
/* 47 */     return effectList;
/*    */   }
/*    */   
/* 50 */   public List<SOutFightEffectGroup> getOutFighterEffectList() { List<SOutFightEffectGroup> effectList = new ArrayList();
/* 51 */     List<SOutFightEffectGroup> groups = getEffectGroup();
/* 52 */     for (SOutFightEffectGroup group : groups) {
/* 53 */       if (OutFightEffectInterface.isOutFightEffect(group.effectId)) {
/* 54 */         effectList.add(group);
/*    */       }
/*    */     }
/* 57 */     return effectList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getPassiveSkillCfgId()
/*    */   {
/* 64 */     if (null == this.passiveSkillCfg) {
/* 65 */       return -1;
/*    */     }
/* 67 */     return this.passiveSkillCfg.id;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\PassiveSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */