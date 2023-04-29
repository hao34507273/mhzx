/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ public class AppearanceMountsObserverArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final long mountsId;
/*    */   private final long remainMillisSeconds;
/*    */   
/*    */   public AppearanceMountsObserverArg(long roleId, long mountsId, long remainMillSeconds)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.mountsId = mountsId;
/* 13 */     this.remainMillisSeconds = remainMillSeconds;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 18 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public long getMountsId()
/*    */   {
/* 23 */     return this.mountsId;
/*    */   }
/*    */   
/*    */   public long getRemainMillisSeconds()
/*    */   {
/* 28 */     return this.remainMillisSeconds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\AppearanceMountsObserverArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */