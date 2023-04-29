/*    */ package mzm.gsp.lifeskill.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.skill.confbean.SCookDrugQualityCfg;
/*    */ import mzm.gsp.skill.confbean.SLifeSkillBag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GangMiYaoSkill
/*    */   extends LianYaoSkill
/*    */ {
/*    */   private boolean exclude;
/*    */   private GangMiYaoSkill excludeSkill;
/*    */   
/*    */   public GangMiYaoSkill(SLifeSkillBag skillBag, int level, boolean exclude, GangMiYaoSkill targetSkill)
/*    */   {
/* 19 */     super(skillBag, level);
/* 20 */     this.exclude = exclude;
/* 21 */     this.excludeSkill = targetSkill;
/*    */   }
/*    */   
/*    */   public List<Integer> getItemIdList()
/*    */   {
/* 26 */     if (this.excludeSkill == null) return super.getItemIdList();
/* 27 */     if (!this.exclude) { return this.excludeSkill.getItemIdList();
/*    */     }
/* 29 */     List<Integer> rpList = this.excludeSkill.getItemIdList();
/*    */     
/* 31 */     List<Integer> parentItemList = super.getItemIdList();
/* 32 */     Iterator<Integer> it = parentItemList.iterator();
/* 33 */     while (it.hasNext()) {
/* 34 */       int id = ((Integer)it.next()).intValue();
/* 35 */       if (rpList.contains(Integer.valueOf(id))) {
/* 36 */         it.remove();
/*    */       }
/*    */     }
/* 39 */     return parentItemList;
/*    */   }
/*    */   
/*    */   public int generateItem()
/*    */   {
/* 44 */     if (this.exclude) {
/* 45 */       return super.generateItem();
/*    */     }
/* 47 */     SCookDrugQualityCfg sCookDrugQualityCfg = randomQuality();
/* 48 */     if (sCookDrugQualityCfg == null) return -1;
/* 49 */     if (this.skillBag.idType == 0) {
/* 50 */       return this.skillBag.siftItemId;
/*    */     }
/* 52 */     return randomItemId(sCookDrugQualityCfg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\GangMiYaoSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */