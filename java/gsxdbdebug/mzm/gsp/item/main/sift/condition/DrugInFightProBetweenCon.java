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
/*    */ public class DrugInFightProBetweenCon
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 301;
/* 19 */   protected List<Integer> conditionParams = new ArrayList();
/*    */   
/*    */   protected DrugInFightProBetweenCon(List<Integer> conditionParams) throws Exception {
/* 22 */     if ((conditionParams == null) || (conditionParams.size() != 2)) {
/* 23 */       throw new Exception("条件参数个数错误,区间筛选条件需要提供上下限参数");
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
/* 43 */     SItemDrugInFightCfg itemCfg = SItemDrugInFightCfg.get(itemId);
/* 44 */     if ((((Integer)this.conditionParams.get(0)).intValue() <= itemCfg.drugPro) && (itemCfg.drugPro <= ((Integer)this.conditionParams.get(1)).intValue())) {
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int getConId() {
/* 51 */     return 301;
/*    */   }
/*    */   
/*    */   public Object getConditionParams()
/*    */   {
/* 56 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 62 */     if ((obj instanceof DrugInFightProBetweenCon)) {
/* 63 */       DrugInFightProBetweenCon condition = (DrugInFightProBetweenCon)obj;
/* 64 */       if (condition.conditionParams.size() != this.conditionParams.size()) {
/* 65 */         return false;
/*    */       }
/*    */       
/* 68 */       for (int i = 0; i < this.conditionParams.size(); i++) {
/* 69 */         if (((Integer)condition.conditionParams.get(i)).intValue() != ((Integer)this.conditionParams.get(i)).intValue()) {
/* 70 */           return false;
/*    */         }
/*    */       }
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 81 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\DrugInFightProBetweenCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */