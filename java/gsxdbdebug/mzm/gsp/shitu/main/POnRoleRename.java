/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MasterInfo;
/*    */ import xbean.role2ShiTuInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2shitu;
/*    */ 
/*    */ public class POnRoleRename extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     long masterRoleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 24 */     String masterUserId = RoleInterface.getUserId(masterRoleId);
/* 25 */     lock(Lockeys.get(xtable.User.getTable(), masterUserId));
/*    */     
/* 27 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.get(Long.valueOf(masterRoleId));
/* 28 */     if (xRole2ShiTuInfo == null)
/*    */     {
/* 30 */       GameServer.logger().error(String.format("[shitu]POnRoleRename.processImp@role shi tu info is null|master_role_id=%d", new Object[] { Long.valueOf(masterRoleId) }));
/*    */       
/* 32 */       return false;
/*    */     }
/* 34 */     String xMasterRoleName = RoleInterface.getName(masterRoleId);
/*    */     
/* 36 */     MasterInfo xMasterInfo = xRole2ShiTuInfo.getMasterinfo();
/* 37 */     for (Iterator i$ = xMasterInfo.getApprentice_role_list().iterator(); i$.hasNext();) { long chuShiApprenticeRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 39 */       List<String> argsListString = new ArrayList();
/* 40 */       argsListString.add(xMasterRoleName);
/*    */       
/* 42 */       TitleInterface.replaceAppellationArgsNoneRealTime(chuShiApprenticeRoleId, ShiTuConsts.getInstance().chuShiAppellationId, argsListString);
/*    */     }
/*    */     
/*    */ 
/* 46 */     for (Iterator i$ = xMasterInfo.getNow_apprentice_role_list().iterator(); i$.hasNext();) { long nowApprenticeRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 48 */       List<String> argsListString = new ArrayList();
/* 49 */       argsListString.add(xMasterRoleName);
/*    */       
/* 51 */       TitleInterface.replaceAppellationArgsNoneRealTime(nowApprenticeRoleId, ShiTuConsts.getInstance().apprenticeAppellationId, argsListString);
/*    */     }
/*    */     
/*    */ 
/* 55 */     GameServer.logger().info(String.format("[shitu]POnRoleRename.processImp@handle master change role name success|master_role_id=%d|chu_shi_apprentice_role_id_list=%s|now_apprentice_role_id_list=%s", new Object[] { Long.valueOf(masterRoleId), xMasterInfo.getApprentice_role_list().toString(), xMasterInfo.getNow_apprentice_role_list().toString() }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */