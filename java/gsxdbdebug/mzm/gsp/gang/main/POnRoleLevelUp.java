/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     GangMember xGangMember = xtable.Role2gangmember.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 11 */     if (xGangMember == null) {
/* 12 */       return false;
/*    */     }
/*    */     
/* 15 */     long gangId = xGangMember.getGangid();
/*    */     
/* 17 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 18 */     if ((xGang == null) || (!GangManager.isInGang(xGang, ((RoleLevelUpArg)this.arg).roleId))) {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     tryBecomeNormal(((RoleLevelUpArg)this.arg).roleId, xGangMember, gangId, xGang);
/*    */     
/*    */ 
/* 25 */     GangManager.syncGangMemberInfoChange(((RoleLevelUpArg)this.arg).roleId, xGangMember, xGang);
/*    */     
/*    */ 
/* 28 */     mzm.gsp.gang.cache.GangCacheManager.changeMemberLevel(gangId, ((RoleLevelUpArg)this.arg).roleId, ((RoleLevelUpArg)this.arg).newLevel);
/*    */     
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   private void tryBecomeNormal(long roleid, GangMember xMember, long gangid, xbean.Gang xGang) {
/* 34 */     if (xMember.getDuty() != mzm.gsp.gang.confbean.SGangConst.getInstance().XUETU_ID) {
/* 35 */       return;
/*    */     }
/* 37 */     int lv = ((RoleLevelUpArg)this.arg).newLevel;
/* 38 */     if (lv >= xGang.getApprenticemaxlv()) {
/* 39 */       if (GangManager.isGangNormalFull(xGang)) {
/* 40 */         return;
/*    */       }
/*    */       
/*    */ 
/* 44 */       GangManager.changeDutyRelation(roleid, xMember, gangid, xGang, mzm.gsp.gang.confbean.SGangConst.getInstance().BANGZHONG_ID, GangSystemChangeDutyActionLogEnum.XUETU_LEVELUP_BANGZHONG.value, 0);
/*    */       
/* 46 */       GangManager.logInfo("POnRoleLevelUp.tryBecomeNormal@xuetu up to bangzhong|roleid=%d|role_oldlevel=%d|role_newlevel=%d|gangid=%d", new Object[] { Long.valueOf(((RoleLevelUpArg)this.arg).roleId), Integer.valueOf(((RoleLevelUpArg)this.arg).oldLevel), Integer.valueOf(((RoleLevelUpArg)this.arg).newLevel), Long.valueOf(xMember.getGangid()) });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */