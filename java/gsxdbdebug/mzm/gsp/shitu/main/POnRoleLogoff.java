/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.shitu.SShiTuLineNotify;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ApprenticeInfo;
/*    */ import xbean.MasterInfo;
/*    */ import xbean.ShiTuTimeInfo;
/*    */ import xbean.role2ShiTuInfo;
/*    */ import xtable.Role2shitu;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 21 */     role2ShiTuInfo xSelectRole2shitu = Role2shitu.select(Long.valueOf(roleId));
/* 22 */     if (xSelectRole2shitu == null)
/*    */     {
/* 24 */       GameServer.logger().error(String.format("[shitu]POnRoleLogoff.processImp@role shi tu info is null|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/*    */ 
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     MasterInfo xMasterInfo = xSelectRole2shitu.getMasterinfo();
/* 31 */     Map<Long, ShiTuTimeInfo> xNowApprenticeTimeInfo = xMasterInfo.getApprentice_now();
/* 32 */     String roleName = mzm.gsp.role.main.RoleInterface.getName(roleId);
/* 33 */     if (xNowApprenticeTimeInfo.size() != 0)
/*    */     {
/* 35 */       SShiTuLineNotify notifyApprentice = new SShiTuLineNotify();
/* 36 */       notifyApprentice.onlinestatus = 0;
/* 37 */       notifyApprentice.profession = 0;
/* 38 */       notifyApprentice.professionname = roleName;
/*    */       
/* 40 */       OnlineManager.getInstance().sendMulti(notifyApprentice, xNowApprenticeTimeInfo.keySet());
/*    */     }
/*    */     
/*    */ 
/* 44 */     ApprenticeInfo xApprenticeInfo = xSelectRole2shitu.getApprenticeinfo();
/* 45 */     ShiTuTimeInfo xApprenticeTimeInfo = xApprenticeInfo.getTimeinfo();
/* 46 */     if ((xApprenticeTimeInfo.getStarttime() <= 0L) || (xApprenticeTimeInfo.getEndtime() != 0L))
/*    */     {
/* 48 */       return true;
/*    */     }
/* 50 */     long masterRoleId = xApprenticeInfo.getMasterroleid();
/*    */     
/* 52 */     if (masterRoleId == 0L)
/*    */     {
/* 54 */       GameServer.logger().error(String.format("[shitu]POnRoleLogoff.processImp@master role id not exist|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 56 */       return true;
/*    */     }
/* 58 */     SShiTuLineNotify notifyMaster = new SShiTuLineNotify();
/* 59 */     notifyMaster.onlinestatus = 0;
/* 60 */     notifyMaster.profession = 1;
/* 61 */     notifyMaster.professionname = roleName;
/*    */     
/* 63 */     OnlineManager.getInstance().send(masterRoleId, notifyMaster);
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */