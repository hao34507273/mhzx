/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingyuan.QingYuanRoleInfo;
/*    */ import mzm.gsp.qingyuan.SGetQingYuanInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Role2QingYuanInfo;
/*    */ import xtable.Role2qingyuan;
/*    */ 
/*    */ public class PCGetQingYuanInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetQingYuanInfo(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1703, true))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (!QingYuanManager.isQingYuanSwitchOpen(this.roleId, "PCGetQingYuanInfo.processImp"))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     SGetQingYuanInfo sGetQingYuanInfo = new SGetQingYuanInfo();
/* 36 */     Role2QingYuanInfo xRole2QingYuanInfo = Role2qingyuan.select(Long.valueOf(this.roleId));
/* 37 */     if (xRole2QingYuanInfo == null)
/*    */     {
/* 39 */       OnlineManager.getInstance().send(this.roleId, sGetQingYuanInfo);
/*    */       
/* 41 */       GameServer.logger().info(String.format("[qingyuan]PCGetQingYuanInfo.processImp@handle get qing yuan info success,role qing yuan info is null|role_id=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 45 */       return true;
/*    */     }
/*    */     
/* 48 */     for (Iterator i$ = xRole2QingYuanInfo.getQing_yuan_role_list().iterator(); i$.hasNext();) { long qingYuanRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 50 */       QingYuanRoleInfo qingYuanRoleInfo = new QingYuanRoleInfo();
/*    */       
/* 52 */       QingYuanManager.setQingYuanRoleInfo(qingYuanRoleId, qingYuanRoleInfo);
/*    */       
/* 54 */       sGetQingYuanInfo.qing_yuan_role_list_info.add(qingYuanRoleInfo);
/*    */     }
/*    */     
/* 57 */     OnlineManager.getInstance().send(this.roleId, sGetQingYuanInfo);
/*    */     
/* 59 */     GameServer.logger().info(String.format("[qingyuan]PCGetQingYuanInfo.processImp@handle get qing yuan info success|role_id=%d|qing_yuan_size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(sGetQingYuanInfo.qing_yuan_role_list_info.size()) }));
/*    */     
/*    */ 
/*    */ 
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\PCGetQingYuanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */