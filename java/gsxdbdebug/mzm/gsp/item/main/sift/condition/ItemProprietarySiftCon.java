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
/*    */ 
/*    */ public class ItemProprietarySiftCon
/*    */   extends AbsSiftCondition
/*    */ {
/*    */   private static final int conId = 101;
/* 21 */   protected List<Boolean> conditionParams = new ArrayList();
/*    */   
/*    */   protected ItemProprietarySiftCon(List<Boolean> conditionParams) throws Exception {
/* 24 */     if ((conditionParams == null) || (conditionParams.size() != 1)) {
/* 25 */       throw new Exception("条件参数个数错误，是否专有条件只能传一个参数");
/*    */     }
/* 27 */     Collections.sort(conditionParams);
/* 28 */     this.conditionParams = Collections.unmodifiableList(conditionParams);
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 33 */     if ((obj instanceof ItemProprietarySiftCon)) {
/* 34 */       ItemProprietarySiftCon condition = (ItemProprietarySiftCon)obj;
/* 35 */       if (condition.conditionParams.size() != this.conditionParams.size()) {
/* 36 */         return false;
/*    */       }
/*    */       
/* 39 */       for (int i = 0; i < this.conditionParams.size(); i++) {
/* 40 */         if (((Boolean)condition.conditionParams.get(i)).booleanValue() != ((Boolean)this.conditionParams.get(i)).booleanValue()) {
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
/* 55 */       SItemCfg itemCfg = SItemCfg.get(itemId);
/* 56 */       if ((itemCfg == null) || (!isTrue(itemId))) {
/* 57 */         itemIterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isTrue(int itemId)
/*    */   {
/* 64 */     SItemCfg itemCfg = SItemCfg.get(itemId);
/* 65 */     return ((Boolean)this.conditionParams.get(0)).booleanValue() == itemCfg.isProprietary;
/*    */   }
/*    */   
/*    */   public int getConId() {
/* 69 */     return 101;
/*    */   }
/*    */   
/*    */   public Object getConditionParams()
/*    */   {
/* 74 */     return this.conditionParams;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 80 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\ItemProprietarySiftCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */