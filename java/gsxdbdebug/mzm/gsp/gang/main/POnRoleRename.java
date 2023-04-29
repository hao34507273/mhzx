/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncMemberInfoChange;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ public class POnRoleRename extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     GangMember xGangMember = xtable.Role2gangmember.get((Long)this.arg);
/* 12 */     if (xGangMember == null) {
/* 13 */       return false;
/*    */     }
/* 15 */     long gangId = xGangMember.getGangid();
/*    */     
/* 17 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 18 */     if (xGang == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     if (!GangManager.isInGang(xGang, ((Long)this.arg).longValue())) {
/* 22 */       return false;
/*    */     }
/* 24 */     SSyncMemberInfoChange sync = new SSyncMemberInfoChange();
/* 25 */     GangManager.fillGangMemberInfo(((Long)this.arg).longValue(), xGangMember, sync.memberinfo);
/* 26 */     GangManager.broadcast(xGang, sync);
/*    */     
/* 28 */     String name = mzm.gsp.role.main.RoleInterface.getName(((Long)this.arg).longValue());
/*    */     
/*    */ 
/* 31 */     mzm.gsp.gang.cache.GangCacheManager.changeMemberName(gangId, ((Long)this.arg).longValue(), name);
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */