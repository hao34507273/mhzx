/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.gang.CSetGangQQGroupReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSyncGangQQGroupRes;
/*    */ import mzm.gsp.gang.event.GangBingingQQArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangMember;
/*    */ import xbean.OutGangStatus;
/*    */ import xtable.Role2outgang;
/*    */ 
/*    */ public class PCSetGangQQGroupReq extends GangProcedure<CSetGangQQGroupReq>
/*    */ {
/*    */   public PCSetGangQQGroupReq(CSetGangQQGroupReq protocol)
/*    */   {
/* 17 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CSetGangQQGroupReq protocol)
/*    */   {
/* 23 */     GangMember xGangMember = xtable.Role2gangmember.get(Long.valueOf(roleId));
/* 24 */     if (null == xGangMember) {
/* 25 */       SGangNormalResult result = new SGangNormalResult();
/* 26 */       result.result = 45;
/* 27 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 32 */     if (null == xGang) {
/* 33 */       SGangNormalResult result = new SGangNormalResult();
/* 34 */       result.result = 46;
/* 35 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 40 */       SGangNormalResult result = new SGangNormalResult();
/* 41 */       result.result = 45;
/* 42 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     xGang.setGrouproleid(roleId);
/* 47 */     xGang.setGroupopenid(protocol.groupopenid);
/*    */     
/* 49 */     OutGangStatus xGangStatus = xbean.Pod.newOutGangStatus();
/* 50 */     xGangStatus.setCreatetime(xGang.getCreatetime());
/* 51 */     xGangStatus.setGangid(xGangMember.getGangid());
/* 52 */     xGangStatus.setGroupopenid(protocol.groupopenid);
/* 53 */     Role2outgang.remove(Long.valueOf(roleId));
/* 54 */     Role2outgang.insert(Long.valueOf(roleId), xGangStatus);
/*    */     
/* 56 */     SSyncGangQQGroupRes syncresult = new SSyncGangQQGroupRes();
/* 57 */     syncresult.groupopenid = xGang.getGroupopenid();
/* 58 */     GangManager.broadcast(xGang, syncresult);
/*    */     
/* 60 */     GangBingingQQArg gangArg = new GangBingingQQArg();
/* 61 */     gangArg.gangId = xGangMember.getGangid();
/* 62 */     gangArg.bingingRoleId = roleId;
/* 63 */     gangArg.QQGroup = protocol.groupopenid;
/* 64 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.GangBingingQQ(), gangArg);
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCSetGangQQGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */