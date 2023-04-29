/*    */ package mzm.gsp.item.main.sift.condition;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipLevelBetweenCon
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 201;
/* 20 */   protected List<Integer> conditionParams = new ArrayList();
/*    */   
/*    */   protected EquipLevelBetweenCon(List<Integer> conditionParams) throws Exception
/*    */   {
/* 24 */     if ((conditionParams == null) || (conditionParams.size() != 2)) {
/* 25 */       throw new Exception("条件参数个数错误,区间筛选条件需要提供上下限参数");
/*    */     }
/* 27 */     Collections.sort(conditionParams);
/* 28 */     this.conditionParams = Collections.unmodifiableList(conditionParams);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isTrue(int itemId)
/*    */   {
/* 35 */     SItemCfg itemCfg = SItemCfg.get(itemId);
/* 36 */     if ((((Integer)this.conditionParams.get(0)).intValue() <= itemCfg.useLevel) && (itemCfg.useLevel <= ((Integer)this.conditionParams.get(1)).intValue())) {
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public int getConId() {
/* 43 */     return 201;
/*    */   }
/*    */   
/*    */   public Object getConditionParams()
/*    */   {
/* 48 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 54 */     if ((obj instanceof EquipLevelBetweenCon)) {
/* 55 */       EquipLevelBetweenCon condition = (EquipLevelBetweenCon)obj;
/* 56 */       if (condition.conditionParams.size() != this.conditionParams.size()) {
/* 57 */         return false;
/*    */       }
/*    */       
/* 60 */       for (int i = 0; i < this.conditionParams.size(); i++) {
/* 61 */         if (((Integer)condition.conditionParams.get(i)).intValue() != ((Integer)this.conditionParams.get(i)).intValue()) {
/* 62 */           return false;
/*    */         }
/*    */       }
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public void sift(Set<Integer> itemIds)
/*    */   {
/* 73 */     Iterator<Integer> itemIterator = itemIds.iterator();
/* 74 */     while (itemIterator.hasNext()) {
/* 75 */       int itemId = ((Integer)itemIterator.next()).intValue();
/* 76 */       SItemCfg itemCfg = SItemCfg.get(itemId);
/* 77 */       if ((itemCfg == null) || (!isTrue(itemId))) {
/* 78 */         itemIterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 86 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\EquipLevelBetweenCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */