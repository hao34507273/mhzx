/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ public class DivorceReqSession
/*    */   extends Session
/*    */ {
/* 12 */   private final Set<Long> roleidSet = Collections.synchronizedSet(new HashSet());
/*    */   
/*    */   public DivorceReqSession(long interval, long roleId) {
/* 15 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut() {}
/*    */   
/*    */ 
/*    */   void addAgreeRole(long roleid)
/*    */   {
/* 24 */     this.roleidSet.add(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */   boolean containsAgreeRole(long roleid) {
/* 28 */     return this.roleidSet.contains(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */   boolean containsAllRole(Collection<Long> roleids) {
/* 32 */     return this.roleidSet.containsAll(roleids);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\DivorceReqSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */