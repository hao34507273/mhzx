/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.item.confbean.SPetXilianItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetXiLianItemComparator
/*    */   implements Comparator<SPetXilianItem>
/*    */ {
/*    */   public int compare(SPetXilianItem o1, SPetXilianItem o2)
/*    */   {
/* 13 */     return o1.xilianItemLevel - o2.xilianItemLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetXiLianItemComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */