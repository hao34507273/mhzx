/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.Set;
/*    */ import xbean.NewerChannel;
/*    */ 
/*    */ public class XNewerChannelComparator implements Comparator<NewerChannel>
/*    */ {
/*    */   public int compare(NewerChannel o1, NewerChannel o2)
/*    */   {
/* 11 */     return o2.getNewerids().size() - o1.getNewerids().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\XNewerChannelComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */