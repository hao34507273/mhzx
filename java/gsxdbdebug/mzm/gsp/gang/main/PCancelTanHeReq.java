/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gang.CCancelTanHeReq;
/*    */ import mzm.gsp.gang.SSyncCancelTanHe;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PCancelTanHeReq
/*    */   extends GangProcedure<CCancelTanHeReq>
/*    */ {
/*    */   public PCancelTanHeReq(CCancelTanHeReq protocol)
/*    */   {
/* 17 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CCancelTanHeReq protocol)
/*    */   {
/* 23 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 24 */     if (xGangMember == null) {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 29 */     if (xGang == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 33 */       return false;
/*    */     }
/* 35 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/* 36 */     if (!dutyCfg.isCanTanHe) {
/* 37 */       return false;
/*    */     }
/* 39 */     if (xGang.getTanheroleid() != roleId) {
/* 40 */       return false;
/*    */     }
/* 42 */     xGang.setTanheroleid(0L);
/* 43 */     xGang.setTanheendtime(0L);
/* 44 */     GangTanHeObserver.stopTanHe(xGangMember.getGangid());
/* 45 */     SSyncCancelTanHe sSyncCancelTanHe = new SSyncCancelTanHe();
/* 46 */     sSyncCancelTanHe.roleid = roleId;
/* 47 */     GangManager.broadcast(xGang, sSyncCancelTanHe);
/*    */     
/* 49 */     StringBuilder tLogStr = new StringBuilder();
/*    */     
/* 51 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(roleId)).append("|").append(roleId).append("|").append(xGang.getBangzhuid()).append("|").append(xGangMember.getGangid()).append("|").append(xGangMember.getDuty()).append("|").append(GangTanheLogEnum.CANCEL).append("|").append(xGang.getDisplayid());
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 59 */     TLogManager.getInstance().addLog(roleId, "GangTanHe", tLogStr.toString());
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCancelTanHeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */