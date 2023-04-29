/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xbean.Pod;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2gangmember;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PRebuildGangMember extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gangid;
/*    */   private final long contextid;
/*    */   
/*    */   public PRebuildGangMember(long roleid, long gangid, long contextid)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.gangid = gangid;
/* 25 */     this.contextid = contextid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!GameServerInfoManager.isRoamServer()) {
/* 32 */       GangManager.logError("PRebuildGangMember.processImp@not roam server|roleid=%d|gangid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid) });
/*    */       
/*    */ 
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 40 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 44 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 46 */     xbean.Gang xGang = GangManager.getXGang(this.gangid, true);
/* 47 */     if (xGang == null) {
/* 48 */       GangManager.logError("PRebuildGangMember.processImp@gang null|roleid=%d|gangid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid) });
/*    */       
/*    */ 
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     int dutyid = GangManager.getMemberDuty(xGang, this.roleid);
/* 55 */     if (dutyid < 0) {
/* 56 */       GangManager.logError("PRebuildGangMember.processImp@no duty|roleid=%d|gangid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid) });
/*    */       
/*    */ 
/* 59 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 63 */     Role2gangmember.remove(Long.valueOf(this.roleid));
/*    */     
/* 65 */     GangMember xMember = Pod.newGangMember();
/* 66 */     xMember.setGangid(this.gangid);
/* 67 */     xMember.setIs_in_gang(true);
/* 68 */     xMember.setDuty(dutyid);
/* 69 */     Role2gangmember.insert(Long.valueOf(this.roleid), xMember);
/*    */     
/*    */ 
/* 72 */     CrossServerInterface.setUserRoamedInfo(userid, RoamType.CROSS_COMPETE, this.contextid);
/*    */     
/* 74 */     GangManager.logInfo("PRebuildGangMember.processImp@succeed|roleid=%d|gangid=%d|dutyid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid), Integer.valueOf(dutyid) });
/*    */     
/*    */ 
/*    */ 
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRebuildGangMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */