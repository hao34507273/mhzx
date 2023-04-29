/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.QingYuanRoleInfo;
/*    */ import xtable.Role2qingyuan;
/*    */ 
/*    */ public class POnRoleRename
/*    */   extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     long renameRoleId = ((Long)this.arg).longValue();
/* 21 */     List<Long> qingYuanRoleIdList = Role2qingyuan.selectQing_yuan_role_list(Long.valueOf(renameRoleId));
/* 22 */     if (qingYuanRoleIdList == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     String roleName = RoleInterface.getName(renameRoleId);
/* 28 */     for (Iterator i$ = qingYuanRoleIdList.iterator(); i$.hasNext();) { long qingYuanRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 30 */       List<String> argsList = new ArrayList();
/* 31 */       argsList.add(roleName);
/*    */       
/* 33 */       TitleInterface.replaceAppellationArgsNoneRealTime(qingYuanRoleId, getQingYuanAppellationCfgId(qingYuanRoleId, renameRoleId), argsList);
/*    */     }
/*    */     
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   private int getQingYuanAppellationCfgId(long qingYuanRoleId, long renameRoleId)
/*    */   {
/* 41 */     Map<Long, QingYuanRoleInfo> xQingYuanRoleInfoMap = Role2qingyuan.selectQing_yuan_map_info(Long.valueOf(qingYuanRoleId));
/* 42 */     if (xQingYuanRoleInfoMap == null)
/*    */     {
/* 44 */       GameServer.logger().error(String.format("[qingyuan]POnRoleRename.getQingYuanAppellationCfgId@qing yuan role info is null|qing_yuan_role_id=%d|rename_role_id=%d", new Object[] { Long.valueOf(qingYuanRoleId), Long.valueOf(renameRoleId) }));
/*    */       
/*    */ 
/*    */ 
/* 48 */       return 0;
/*    */     }
/*    */     
/* 51 */     QingYuanRoleInfo xQingYuanRoleInfo = (QingYuanRoleInfo)xQingYuanRoleInfoMap.get(Long.valueOf(renameRoleId));
/* 52 */     if (xQingYuanRoleInfo == null)
/*    */     {
/* 54 */       GameServer.logger().error(String.format("[qingyuan]POnRoleRename.getQingYuanAppellationCfgId@qing yuan role info not contains rename roleid|qing_yuan_role_id=%d|rename_role_id=%d", new Object[] { Long.valueOf(qingYuanRoleId), Long.valueOf(renameRoleId) }));
/*    */       
/*    */ 
/*    */ 
/* 58 */       return 0;
/*    */     }
/* 60 */     return xQingYuanRoleInfo.getAppellation_cfg_id();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */