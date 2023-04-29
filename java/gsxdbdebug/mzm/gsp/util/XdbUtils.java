/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import xdb.Bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XdbUtils
/*    */ {
/*    */   public static <T extends Bean> void swapXBean(List<T> xbeanList, int index1, int index2)
/*    */   {
/* 29 */     if (index1 == index2) {
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     if (index1 > index2) {
/* 34 */       index1 ^= index2;
/* 35 */       index2 ^= index1;
/* 36 */       index1 ^= index2;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 41 */     T xbean2 = (Bean)xbeanList.remove(index2);
/* 42 */     T xbean1 = (Bean)xbeanList.set(index1, xbean2);
/* 43 */     xbeanList.add(index2, xbean1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static <T extends Bean> void sortXBean(List<T> xbeanList, Comparator<? super T> comparator)
/*    */   {
/* 56 */     List<T> list = new ArrayList(xbeanList.size());
/* 57 */     Iterator<T> iterator = xbeanList.iterator();
/* 58 */     while (iterator.hasNext()) {
/* 59 */       T t = (Bean)iterator.next();
/* 60 */       list.add(t);
/*    */       
/*    */ 
/* 63 */       iterator.remove();
/*    */     }
/* 65 */     Collections.sort(list, comparator);
/* 66 */     xbeanList.addAll(list);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\XdbUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */