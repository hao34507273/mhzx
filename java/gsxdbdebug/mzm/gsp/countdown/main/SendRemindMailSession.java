/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SendRemindMailSession
/*    */   extends Session
/*    */ {
/*    */   private final int cfgid;
/*    */   private final int index;
/*    */   
/*    */   public SendRemindMailSession(long interval, long roleId, int cfgid, int index)
/*    */   {
/* 20 */     super(interval, roleId);
/* 21 */     this.cfgid = cfgid;
/* 22 */     this.index = index;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     if (!CountDownManager.isCountDownSwitchOpen())
/*    */     {
/*    */ 
/* 31 */       return;
/*    */     }
/* 33 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 35 */       RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleid), new PSendRemindMail(roleid, this.cfgid, this.index));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\SendRemindMailSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */