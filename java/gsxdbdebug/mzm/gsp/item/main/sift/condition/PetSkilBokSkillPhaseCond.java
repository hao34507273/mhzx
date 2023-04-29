/*    */ package mzm.gsp.item.main.sift.condition;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetSkilBokSkillPhaseCond
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 502;
/* 20 */   protected List<Integer> conditionParams = new ArrayList();
/*    */   
/*    */   protected PetSkilBokSkillPhaseCond(List<Integer> conditionParams) throws Exception
/*    */   {
/* 24 */     if ((conditionParams == null) || (conditionParams.size() < 1)) {
/* 25 */       throw new Exception("条件参数个数错误");
/*    */     }
/* 27 */     Collections.sort(conditionParams);
/* 28 */     this.conditionParams = Collections.unmodifiableList(conditionParams);
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 33 */     if ((obj instanceof PetSkilBokSkillPhaseCond)) {
/* 34 */       PetSkilBokSkillPhaseCond condition = (PetSkilBokSkillPhaseCond)obj;
/* 35 */       if (condition.conditionParams.size() != this.conditionParams.size()) {
/* 36 */         return false;
/*    */       }
/*    */       
/* 39 */       for (int i = 0; i < this.conditionParams.size(); i++) {
/* 40 */         if (((Integer)condition.conditionParams.get(i)).intValue() != ((Integer)this.conditionParams.get(i)).intValue()) {
/* 41 */           return false;
/*    */         }
/*    */       }
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public void sift(Set<Integer> itemIds)
/*    */   {
/* 52 */     Iterator<Integer> itemIterator = itemIds.iterator();
/* 53 */     while (itemIterator.hasNext()) {
/* 54 */       int itemId = ((Integer)itemIterator.next()).intValue();
/* 55 */       SPetSkillBookCfg petSkillBookCfg = SPetSkillBookCfg.get(itemId);
/* 56 */       if ((petSkillBookCfg == null) || (!isTrue(itemId))) {
/* 57 */         itemIterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isTrue(int itemId)
/*    */   {
/* 64 */     SPetSkillBookCfg petSkillBookCfg = SPetSkillBookCfg.get(itemId);
/* 65 */     for (int i = 0; i < this.conditionParams.size(); i++) {
/* 66 */       if (petSkillBookCfg.skillPhase == ((Integer)this.conditionParams.get(i)).intValue()) {
/* 67 */         return true;
/*    */       }
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getConId()
/*    */   {
/* 76 */     return 502;
/*    */   }
/*    */   
/*    */   public Object getConditionParams()
/*    */   {
/* 81 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 87 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\PetSkilBokSkillPhaseCond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */