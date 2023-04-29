/*    */ package mzm.gsp.compensate.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class CompensateInterface
/*    */ {
/*    */   public static final boolean addCompensate(CompensateInfo compensateInfo)
/*    */   {
/*  9 */     return CompensateManager.addCompensate(compensateInfo);
/*    */   }
/*    */   
/*    */   public static final boolean removeCompensate(int tag)
/*    */   {
/* 14 */     return CompensateManager.removeCompensate(tag);
/*    */   }
/*    */   
/*    */   public static final boolean removeCompensate(long id, int tag)
/*    */   {
/* 19 */     return CompensateManager.removeCompensate(id, tag);
/*    */   }
/*    */   
/*    */   public static final List<CompensateInfo> getCompensates()
/*    */   {
/* 24 */     return CompensateManager.getCompensates();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\compensate\main\CompensateInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */