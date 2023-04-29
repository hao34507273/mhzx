/*    */ package mzm.gsp.lifeskill.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Random;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.skill.confbean.SCookDrugCfg;
/*    */ import mzm.gsp.skill.confbean.SLifeSkillBag;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class LianYaoSkillBag extends LifeSkillBag<LianYaoSkill>
/*    */ {
/* 17 */   private static final Logger logger = Logger.getLogger(LianYaoSkillBag.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public LianYaoSkillBag(int lefSkillBagCfgId, int level)
/*    */   {
/* 26 */     super(lefSkillBagCfgId, level);
/*    */   }
/*    */   
/*    */   public LianYaoSkill newLifeSkill(int skillId)
/*    */   {
/* 31 */     SLifeSkillBag sLifeSkillBag = SLifeSkillBag.get(skillId);
/* 32 */     return new LianYaoSkill(sLifeSkillBag, this.level);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public LianYaoSkill randomSkill(List<Integer> exceptSkillIdList)
/*    */   {
/* 42 */     Map<Integer, LianYaoSkill> skillMap = getAvaliableLifeSkillMap();
/* 43 */     if (exceptSkillIdList != null) {
/* 44 */       Iterator<Map.Entry<Integer, LianYaoSkill>> it = skillMap.entrySet().iterator();
/* 45 */       while (it.hasNext()) {
/* 46 */         LianYaoSkill skill = (LianYaoSkill)((Map.Entry)it.next()).getValue();
/* 47 */         if (exceptSkillIdList.contains(Integer.valueOf(skill.getId()))) {
/* 48 */           it.remove();
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 53 */     SCookDrugCfg sCookDrugCfg = null;
/* 54 */     for (SCookDrugCfg temp : SCookDrugCfg.getAll().values()) {
/* 55 */       if ((temp.skillBagCfgId == this.lifeSkillBagCfgId) && 
/*    */       
/*    */ 
/* 58 */         (temp.maxLevel >= this.level) && (temp.minLevel <= this.level))
/*    */       {
/*    */ 
/* 61 */         sCookDrugCfg = temp;
/*    */       }
/*    */     }
/* 64 */     if (sCookDrugCfg == null) {
/* 65 */       logger.error(String.format("not find lianyao config skillbagcfg id : %d , level : %d ", new Object[] { Integer.valueOf(this.lifeSkillBagCfgId), Integer.valueOf(this.level) }));
/* 66 */       return null;
/*    */     }
/* 68 */     int totalProp = 0;
/* 69 */     for (Map.Entry<Integer, LianYaoSkill> skillEntry : skillMap.entrySet()) {
/* 70 */       totalProp += ((Integer)sCookDrugCfg.skillBagPropList.get(((Integer)skillEntry.getKey()).intValue())).intValue();
/*    */     }
/* 72 */     if (totalProp == 0) {
/* 73 */       return null;
/*    */     }
/* 75 */     int randomValue = Xdb.random().nextInt(totalProp);
/*    */     
/* 77 */     int nowProp = 0;
/* 78 */     for (Map.Entry<Integer, LianYaoSkill> skillEntry : skillMap.entrySet()) {
/* 79 */       nowProp += ((Integer)sCookDrugCfg.skillBagPropList.get(((Integer)skillEntry.getKey()).intValue())).intValue();
/* 80 */       if (randomValue < nowProp) {
/* 81 */         return (LianYaoSkill)skillEntry.getValue();
/*    */       }
/*    */     }
/* 84 */     logger.error("not random life skill , skill bag id " + this.lifeSkillBagCfgId);
/* 85 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public LianYaoSkill randomSkill()
/*    */   {
/* 93 */     return randomSkill(null);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\LianYaoSkillBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */