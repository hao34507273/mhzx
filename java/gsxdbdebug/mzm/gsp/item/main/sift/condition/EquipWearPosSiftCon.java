/*    */ package mzm.gsp.item.main.sift.condition;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipWearPosSiftCon
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 202;
/* 20 */   protected List<Integer> conditionParams = new ArrayList();
/*    */   
/*    */   protected EquipWearPosSiftCon(List<Integer> conditionParams) throws Exception
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
/* 33 */     if ((obj instanceof EquipWearPosSiftCon)) {
/* 34 */       EquipWearPosSiftCon condition = (EquipWearPosSiftCon)obj;
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
/*    */ 
/*    */   public void sift(Set<Integer> itemIds)
/*    */   {
/* 53 */     Iterator<Integer> itemIterator = itemIds.iterator();
/* 54 */     while (itemIterator.hasNext()) {
/* 55 */       int itemId = ((Integer)itemIterator.next()).intValue();
/* 56 */       SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(itemId);
/* 57 */       if ((itemEquipCfg == null) || (!isTrue(itemId))) {
/* 58 */         itemIterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isTrue(int itemId)
/*    */   {
/* 65 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(itemId);
/* 66 */     for (int i = 0; i < this.conditionParams.size(); i++) {
/* 67 */       if (itemEquipCfg.wearpos == ((Integer)this.conditionParams.get(i)).intValue()) {
/* 68 */         return true;
/*    */       }
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getConId()
/*    */   {
/* 77 */     return 202;
/*    */   }
/*    */   
/*    */   public Object getConditionParams()
/*    */   {
/* 82 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 88 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\EquipWearPosSiftCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */