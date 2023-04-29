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
/*    */ 
/*    */ public class EquipGenderSiftCon
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 204;
/* 21 */   protected List<Integer> conditionParams = new ArrayList();
/*    */   
/* 23 */   protected EquipGenderSiftCon(List<Integer> conditionParams) throws Exception { if ((conditionParams == null) || (conditionParams.size() != 1)) {
/* 24 */       throw new Exception("条件参数个数错误，性别条件只能传一个参数");
/*    */     }
/* 26 */     Collections.sort(conditionParams);
/* 27 */     this.conditionParams = Collections.unmodifiableList(conditionParams);
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 32 */     if ((obj instanceof EquipGenderSiftCon)) {
/* 33 */       EquipGenderSiftCon condition = (EquipGenderSiftCon)obj;
/* 34 */       if (condition.conditionParams.size() != this.conditionParams.size()) {
/* 35 */         return false;
/*    */       }
/*    */       
/* 38 */       for (int i = 0; i < this.conditionParams.size(); i++) {
/* 39 */         if (((Integer)condition.conditionParams.get(i)).intValue() != ((Integer)this.conditionParams.get(i)).intValue()) {
/* 40 */           return false;
/*    */         }
/*    */       }
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void sift(Set<Integer> itemIds)
/*    */   {
/* 52 */     Iterator<Integer> itemIterator = itemIds.iterator();
/* 53 */     while (itemIterator.hasNext()) {
/* 54 */       int itemId = ((Integer)itemIterator.next()).intValue();
/* 55 */       SItemEquipCfg itemCfg = SItemEquipCfg.get(itemId);
/* 56 */       if ((itemCfg == null) || (!isTrue(itemId))) {
/* 57 */         itemIterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isTrue(int itemId)
/*    */   {
/* 64 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(itemId);
/* 65 */     return ((Integer)this.conditionParams.get(0)).intValue() == itemEquipCfg.sex;
/*    */   }
/*    */   
/*    */   public int getConId()
/*    */   {
/* 70 */     return 204;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Object getConditionParams()
/*    */   {
/* 78 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 85 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\EquipGenderSiftCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */