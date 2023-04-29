/*    */ package mzm.gsp.item.main.sift.condition;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrugInFightFunCon
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 303;
/* 19 */   protected List<Integer> conditionParams = new ArrayList();
/*    */   
/*    */   protected DrugInFightFunCon(List<Integer> conditionParams) throws Exception {
/* 22 */     if ((conditionParams == null) || (conditionParams.size() < 1)) {
/* 23 */       throw new Exception("条件参数个数错误");
/*    */     }
/* 25 */     Collections.sort(conditionParams);
/* 26 */     this.conditionParams = Collections.unmodifiableList(conditionParams);
/*    */   }
/*    */   
/*    */   public void sift(Set<Integer> itemIds)
/*    */   {
/* 31 */     Iterator<Integer> itemIterator = itemIds.iterator();
/* 32 */     while (itemIterator.hasNext()) {
/* 33 */       int itemId = ((Integer)itemIterator.next()).intValue();
/* 34 */       SItemDrugInFightCfg itemCfg = SItemDrugInFightCfg.get(itemId);
/* 35 */       if ((itemCfg == null) || (!isTrue(itemId))) {
/* 36 */         itemIterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isTrue(int itemId)
/*    */   {
/* 43 */     SItemDrugInFightCfg drugInFightCfg = SItemDrugInFightCfg.get(itemId);
/* 44 */     for (int i = 0; i < this.conditionParams.size(); i++) {
/* 45 */       if (drugInFightCfg.fun == ((Integer)this.conditionParams.get(i)).intValue()) {
/* 46 */         return true;
/*    */       }
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int getConId() {
/* 53 */     return 303;
/*    */   }
/*    */   
/*    */   public Object getConditionParams()
/*    */   {
/* 58 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 64 */     if ((obj instanceof DrugInFightFunCon)) {
/* 65 */       DrugInFightFunCon condition = (DrugInFightFunCon)obj;
/* 66 */       if (condition.conditionParams.size() != this.conditionParams.size()) {
/* 67 */         return false;
/*    */       }
/*    */       
/* 70 */       for (int i = 0; i < this.conditionParams.size(); i++) {
/* 71 */         if (((Integer)condition.conditionParams.get(i)).intValue() != ((Integer)this.conditionParams.get(i)).intValue()) {
/* 72 */           return false;
/*    */         }
/*    */       }
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 83 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\DrugInFightFunCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */