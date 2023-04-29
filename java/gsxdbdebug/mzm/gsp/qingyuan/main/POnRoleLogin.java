/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingyuan.SSyncQingYuanInfo;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import xbean.QingYuanRoleInfo;
/*    */ import xbean.Role2QingYuanInfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleId = ((Long)this.arg).longValue();
/* 20 */     Role2QingYuanInfo xRole2QingYuanInfo = xtable.Role2qingyuan.select(Long.valueOf(roleId));
/* 21 */     SSyncQingYuanInfo sSyncQingYuanInfo = new SSyncQingYuanInfo();
/* 22 */     if (xRole2QingYuanInfo == null)
/*    */     {
/*    */ 
/* 25 */       OnlineManager.getInstance().send(roleId, sSyncQingYuanInfo);
/* 26 */       return true;
/*    */     }
/*    */     
/* 29 */     for (Iterator i$ = xRole2QingYuanInfo.getQing_yuan_role_list().iterator(); i$.hasNext();) { long qingYuanRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 31 */       sSyncQingYuanInfo.qing_yuan_role_list.add(Long.valueOf(qingYuanRoleId));
/*    */     }
/*    */     
/*    */ 
/* 35 */     for (Map.Entry<Long, QingYuanRoleInfo> entry : xRole2QingYuanInfo.getQing_yuan_map_info().entrySet())
/*    */     {
/* 37 */       QingYuanRoleInfo xQingYuanRoleInfo = (QingYuanRoleInfo)entry.getValue();
/* 38 */       int appellationCfgId = xQingYuanRoleInfo.getAppellation_cfg_id();
/*    */       
/* 40 */       long qingYuanRoleId = ((Long)entry.getKey()).longValue();
/* 41 */       List<String> appellationArgs = TitleInterface.getAppArgs(roleId, xQingYuanRoleInfo.getAppellation_cfg_id(), false);
/*    */       
/* 43 */       if ((appellationArgs != null) && (!appellationArgs.isEmpty()))
/*    */       {
/* 45 */         String qingYuanRoleName = mzm.gsp.role.main.RoleInterface.getName(qingYuanRoleId);
/* 46 */         String xQingYuanRoleName = (String)appellationArgs.get(0);
/* 47 */         if (!xQingYuanRoleName.equals(qingYuanRoleName))
/*    */         {
/* 49 */           appellationArgs.set(0, qingYuanRoleName);
/* 50 */           TitleInterface.replaceAppellationArgsNoneRealTime(roleId, appellationCfgId, appellationArgs);
/*    */         }
/*    */       }
/*    */     }
/* 54 */     OnlineManager.getInstance().send(roleId, sSyncQingYuanInfo);
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */