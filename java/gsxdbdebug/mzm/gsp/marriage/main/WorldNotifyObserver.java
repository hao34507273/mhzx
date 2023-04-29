/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.marriage.SSynAllParadeMsg;
/*    */ 
/*    */ public class WorldNotifyObserver extends NotifyObserver
/*    */ {
/*    */   public WorldNotifyObserver(long interval, int paradeCfgid, long roleId1, long roleid2, long timeMills)
/*    */   {
/*  9 */     super(interval, paradeCfgid, roleId1, roleid2, timeMills);
/*    */   }
/*    */   
/*    */   public void notifyMsg()
/*    */   {
/* 14 */     SSynAllParadeMsg synAllParadeMsg = new SSynAllParadeMsg();
/* 15 */     synAllParadeMsg.paradecfgid = this.paradeCfgid;
/* 16 */     MarriageManager.fillInParadeRoleInfo(synAllParadeMsg.role1info, this.roleid1);
/* 17 */     MarriageManager.fillInParadeRoleInfo(synAllParadeMsg.role2info, this.roleid2);
/* 18 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAll(synAllParadeMsg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\WorldNotifyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */