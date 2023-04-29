/*    */ package mzm.gsp.item.main.sift.condition;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SItemDrugOutFightCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrugOutFightProBetweenCon
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 401;
/* 19 */   protected List<Integer> conditionParams = new ArrayList();
/*    */   
/*    */   protected DrugOutFightProBetweenCon(List<Integer> conditionParams) throws Exception {
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
/* 34 */       SItemDrugOutFightCfg itemCfg = SItemDrugOutFightCfg.get(itemId);
/* 35 */       if ((itemCfg == null) || (!isTrue(itemId))) {
/* 36 */         itemIterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTrue(int itemId)
/*    */   {
/* 44 */     SItemDrugOutFightCfg itemCfg = SItemDrugOutFightCfg.get(itemId);
/* 45 */     if ((((Integer)this.conditionParams.get(0)).intValue() <= itemCfg.drugPro) && (itemCfg.drugPro <= ((Integer)this.conditionParams.get(1)).intValue())) {
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int getConId() {
/* 52 */     return 401;
/*    */   }
/*    */   
/*    */   public Object getConditionParams()
/*    */   {
/* 57 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 63 */     if ((obj instanceof DrugOutFightProBetweenCon)) {
/* 64 */       DrugOutFightProBetweenCon condition = (DrugOutFightProBetweenCon)obj;
/* 65 */       if (condition.conditionParams.size() != this.conditionParams.size()) {
/* 66 */         return false;
/*    */       }
/*    */       
/* 69 */       for (int i = 0; i < this.conditionParams.size(); i++) {
/* 70 */         if (((Integer)condition.conditionParams.get(i)).intValue() != ((Integer)this.conditionParams.get(i)).intValue()) {
/* 71 */           return false;
/*    */         }
/*    */       }
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 82 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\DrugOutFightProBetweenCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */