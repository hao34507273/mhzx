/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gang.CSetXueTuMaxLevel;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSyncXueTuMaxLevelChange;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PSetXueTuMaxLevelReq
/*    */   extends GangProcedure<CSetXueTuMaxLevel>
/*    */ {
/*    */   public PSetXueTuMaxLevelReq(CSetXueTuMaxLevel protocol)
/*    */   {
/* 21 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CSetXueTuMaxLevel protocol)
/*    */   {
/* 27 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 28 */     if (xGangMember == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     long gangId = xGangMember.getGangid();
/*    */     
/* 33 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 34 */     if (xGang == null) {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 38 */       return false;
/*    */     }
/* 40 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/* 41 */     if (!dutyCfg.isCanMgeApplyList) {
/* 42 */       return false;
/*    */     }
/* 44 */     if (protocol.level < SGangConst.getInstance().XUETU_MAX_LV - SGangConst.getInstance().SETTING_XUETU_MIN_OFFSET_LV) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     int maxLv = ServerInterface.getCurrentServerLevel() - SGangConst.getInstance().SETTING_XUETU_MAX_OFFSET_LV;
/* 49 */     if (protocol.level > maxLv) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     xGang.setApprenticemaxlv(protocol.level);
/* 54 */     SGangNormalResult result = new SGangNormalResult();
/* 55 */     result.result = 20;
/* 56 */     OnlineManager.getInstance().send(roleId, result);
/* 57 */     SSyncXueTuMaxLevelChange sSyncXueTuMaxLevelChange = new SSyncXueTuMaxLevelChange();
/* 58 */     sSyncXueTuMaxLevelChange.level = protocol.level;
/* 59 */     GangManager.broadcast(xGang, sSyncXueTuMaxLevelChange);
/*    */     
/* 61 */     StringBuilder tLogStr = new StringBuilder();
/* 62 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(roleId)).append("|").append(roleId).append("|").append(xGangMember.getDuty()).append("|").append(xGangMember.getGangid()).append("|").append(protocol.level).append("|").append(xGang.getDisplayid());
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 69 */     TLogManager.getInstance().addLog(roleId, "GangSetXueTuLevel", tLogStr.toString());
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSetXueTuMaxLevelReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */