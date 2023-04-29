/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.marriage.SSynGangParadeMsg;
/*    */ 
/*    */ public class GangNotifySession extends NotifyObserver
/*    */ {
/*    */   public GangNotifySession(long interval, int paradeCfgid, long roleId1, long roleid2, long timeMills)
/*    */   {
/*  9 */     super(interval, paradeCfgid, roleId1, roleid2, timeMills);
/*    */   }
/*    */   
/*    */   public void notifyMsg()
/*    */   {
/* 14 */     long gangid1 = mzm.gsp.gang.main.GangInterface.getGangId(this.roleid1);
/* 15 */     long gangid2 = mzm.gsp.gang.main.GangInterface.getGangId(this.roleid2);
/* 16 */     if (gangid1 != gangid2) {
/* 17 */       if (gangid1 > 0L) {
/* 18 */         brocastInGang(gangid1, this.roleid1, this.roleid2);
/*    */       }
/* 20 */       if (gangid2 > 0L) {
/* 21 */         brocastInGang(gangid1, this.roleid2, this.roleid1);
/*    */       }
/*    */     }
/* 24 */     else if (gangid1 > 0L) {
/* 25 */       brocastInGang(gangid1, this.roleid1, this.roleid2);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private void brocastInGang(long myGangid, long myRoleid, long coupleRoleid)
/*    */   {
/* 32 */     SSynGangParadeMsg synGangParadeMsg = new SSynGangParadeMsg();
/* 33 */     MarriageManager.fillInParadeRoleInfo(synGangParadeMsg.myinfo, myRoleid);
/* 34 */     MarriageManager.fillInParadeRoleInfo(synGangParadeMsg.coupleinfo, coupleRoleid);
/* 35 */     synGangParadeMsg.paradecfgid = this.paradeCfgid;
/* 36 */     mzm.gsp.gang.main.GangInterface.brocastInGang(synGangParadeMsg, myGangid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\GangNotifySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */