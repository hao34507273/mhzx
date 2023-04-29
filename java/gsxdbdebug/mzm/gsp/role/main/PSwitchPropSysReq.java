/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SSwitchPropSysRes;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ public class PSwitchPropSysReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int BPSIndex;
/*    */   private final long roleId;
/*    */   private final long currentSilver;
/*    */   
/*    */   public PSwitchPropSysReq(int bpsIndex, long roleId, long currentSilver)
/*    */   {
/* 27 */     this.BPSIndex = bpsIndex;
/* 28 */     this.roleId = roleId;
/* 29 */     this.currentSilver = currentSilver;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 221, true))
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/*    */     
/* 41 */     if (this.currentSilver != xProperties.getSilver())
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     if (xProperties.getActivitybpsys() == this.BPSIndex)
/*    */     {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     if (!xProperties.getPropertysysmap().containsKey(Integer.valueOf(this.BPSIndex)))
/*    */     {
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(this.roleId);
/* 56 */     role.dayUpdate();
/*    */     
/* 58 */     int count = xProperties.getTodaypropsysswitchcount();
/* 59 */     if (!payPrice(count))
/*    */     {
/* 61 */       GameServer.logger().error(String.format("[role]PSwitchPropSysReq.processImp@ cost err!|roleId=%d|BPSIndex=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.BPSIndex) }));
/*    */       
/* 63 */       return false;
/*    */     }
/* 65 */     xProperties.setTodaypropsysswitchcount(count + 1);
/*    */     
/* 67 */     xProperties.setActivitybpsys(this.BPSIndex);
/* 68 */     SSwitchPropSysRes res = new SSwitchPropSysRes();
/* 69 */     res.propsys = this.BPSIndex;
/* 70 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 72 */     role.setHP(role.getFinalMaxHP());
/* 73 */     role.setMP(role.getFinalMaxMP());
/* 74 */     role.syncClientRoleProperty();
/*    */     
/* 76 */     LogRolePropertySystemManager.tlogRolePropertySystem(RoleInterface.getUserId(this.roleId), this.roleId, xProperties, 3, this.BPSIndex);
/*    */     
/* 78 */     return true;
/*    */   }
/*    */   
/*    */   private boolean payPrice(int count)
/*    */   {
/* 83 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/*    */ 
/* 86 */       return true;
/*    */     }
/* 88 */     int costSilver = count * RoleCommonConstants.getInstance().SWITCH_PROP_SYS_COST;
/* 89 */     if (!RoleInterface.cutSilver(this.roleId, costSilver, new TLogArg(LogReason.ROLE_SWITCH_PROP_SYS_REM)))
/*    */     {
/* 91 */       return false;
/*    */     }
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PSwitchPropSysReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */