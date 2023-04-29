/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ class RoleObserverTimeoutRunnable
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final int clearType;
/*    */   
/*    */   public RoleObserverTimeoutRunnable(int clearType)
/*    */   {
/* 16 */     this.clearType = clearType;
/*    */   }
/*    */   
/*    */ 
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 23 */     List<Long> roleList = OnlineManager.getInstance().getAllRolesInWorld();
/* 24 */     Iterator<Long> iterator = roleList.iterator();
/* 25 */     while (iterator.hasNext())
/*    */     {
/* 27 */       long roleid = ((Long)iterator.next()).longValue();
/*    */       
/* 29 */       new InitRoleAwardPoolPrecious(roleid, this.clearType).call();
/*    */       
/* 31 */       iterator.remove();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\RoleObserverTimeoutRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */