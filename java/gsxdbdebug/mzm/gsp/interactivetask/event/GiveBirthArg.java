/*    */ package mzm.gsp.interactivetask.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ public class GiveBirthArg
/*    */ {
/*  9 */   public final List<Long> roleids = new ArrayList();
/*    */   public final boolean isSuccess;
/*    */   
/*    */   public GiveBirthArg(Collection<Long> roleids, boolean isSuccess)
/*    */   {
/* 14 */     this.roleids.addAll(roleids);
/* 15 */     this.isSuccess = isSuccess;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\event\GiveBirthArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */