/*    */ package mzm.gsp.status.event;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ public class RoleStatusChangeArg
/*    */ {
/*    */   public final long roleid;
/*  8 */   public final Set<Integer> addedset = new java.util.HashSet();
/*  9 */   public final Set<Integer> remedSet = new java.util.HashSet();
/*    */   
/*    */   public RoleStatusChangeArg(long roleid) {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\event\RoleStatusChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */