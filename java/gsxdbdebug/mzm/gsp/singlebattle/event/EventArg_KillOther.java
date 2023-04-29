/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ public class EventArg_KillOther
/*    */ {
/*    */   private final long roleId;
/*    */   private final Set<Long> otherIds;
/*    */   
/*    */   public EventArg_KillOther(long roleId, Set<Long> otherIds)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.otherIds = otherIds;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 18 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public Set<Long> getOtherIds()
/*    */   {
/* 23 */     return this.otherIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\EventArg_KillOther.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */