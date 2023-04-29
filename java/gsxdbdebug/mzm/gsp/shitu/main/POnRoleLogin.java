/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.shitu.SShiTuLineNotify;
/*     */ import mzm.gsp.shitu.SSyncShiTuInfo;
/*     */ import mzm.gsp.shitu.ShiTuRoleInfoAndModelInfo;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  28 */     role2ShiTuInfo xRole2ShiTuInfo = Role2shitu.select(Long.valueOf(roleId));
/*  29 */     SSyncShiTuInfo sSyncShiTuInfo = new SSyncShiTuInfo();
/*  30 */     if (xRole2ShiTuInfo == null)
/*     */     {
/*     */ 
/*  33 */       xRole2ShiTuInfo = xbean.Pod.newrole2ShiTuInfo();
/*  34 */       Role2shitu.add(Long.valueOf(roleId), xRole2ShiTuInfo);
/*     */       
/*  36 */       OnlineManager.getInstance().send(roleId, sSyncShiTuInfo);
/*  37 */       return true;
/*     */     }
/*     */     
/*  40 */     MasterInfo xMasterInfo = xRole2ShiTuInfo.getMasterinfo();
/*  41 */     Map<Long, ShiTuTimeInfo> xNowApprenticeMap = xMasterInfo.getApprentice_now();
/*     */     
/*  43 */     sSyncShiTuInfo.totalapprenticenum = (xNowApprenticeMap.size() + xMasterInfo.getApprentice_graduate().size());
/*  44 */     sSyncShiTuInfo.aleardy_awarded_cfg_id_set.addAll(xMasterInfo.getAlwardy_awarded_cfg_set());
/*     */     
/*  46 */     if (sSyncShiTuInfo.totalapprenticenum > 0)
/*     */     {
/*  48 */       MasterRankManager.getInstance().rank(roleId, sSyncShiTuInfo.totalapprenticenum);
/*     */       
/*  50 */       if (!TitleInterface.isRoleHaveAppellationId(roleId, ShiTuConsts.getInstance().masterAppellationId))
/*     */       {
/*  52 */         TitleInterface.addAppellationNoneRealTime(roleId, ShiTuConsts.getInstance().masterAppellationId);
/*     */       }
/*     */     }
/*     */     
/*  56 */     for (Iterator i$ = xMasterInfo.getNow_apprentice_role_list().iterator(); i$.hasNext();) { long nowApprenticeRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  58 */       sSyncShiTuInfo.nowapprenticelist.add(ShiTuManager.setShiTuRoleInfoAndModelInfo(nowApprenticeRoleId, new ShiTuRoleInfoAndModelInfo()));
/*     */     }
/*     */     
/*  61 */     String roleName = mzm.gsp.role.main.RoleInterface.getName(roleId);
/*     */     
/*  63 */     SShiTuLineNotify notifyApprentice = new SShiTuLineNotify();
/*  64 */     notifyApprentice.onlinestatus = 1;
/*  65 */     notifyApprentice.profession = 0;
/*  66 */     notifyApprentice.professionname = roleName;
/*     */     
/*  68 */     OnlineManager.getInstance().sendMulti(notifyApprentice, xNowApprenticeMap.keySet());
/*     */     
/*  70 */     ApprenticeInfo xApprenticeInfo = xRole2ShiTuInfo.getApprenticeinfo();
/*  71 */     ShiTuTimeInfo xApprenticeTimeInfo = xApprenticeInfo.getTimeinfo();
/*     */     
/*  73 */     if ((xApprenticeTimeInfo.getStarttime() > 0L) && (xApprenticeTimeInfo.getEndtime() > 0L))
/*     */     {
/*  75 */       sSyncShiTuInfo.is_chu_shi_state = 1;
/*     */     }
/*     */     else
/*     */     {
/*  79 */       sSyncShiTuInfo.is_chu_shi_state = 0;
/*     */     }
/*  81 */     sSyncShiTuInfo.now_pay_respect_times = xApprenticeInfo.getNow_pay_respect_times();
/*     */     
/*  83 */     if (xApprenticeTimeInfo.getStarttime() > 0L)
/*     */     {
/*  85 */       long masterRoleId = xApprenticeInfo.getMasterroleid();
/*     */       
/*  87 */       if (masterRoleId == 0L)
/*     */       {
/*  89 */         GameServer.logger().error(String.format("[shitu]POnRoleLogin.processImp@master role id not exist|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(masterRoleId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  94 */         OnlineManager.getInstance().send(roleId, sSyncShiTuInfo);
/*  95 */         return true;
/*     */       }
/*  97 */       ShiTuManager.setShiTuRoleInfoAndModelInfo(masterRoleId, sSyncShiTuInfo.masterinfo);
/*     */       
/*     */ 
/* 100 */       int appellationCfgId = sSyncShiTuInfo.is_chu_shi_state == 1 ? ShiTuConsts.getInstance().chuShiAppellationId : ShiTuConsts.getInstance().apprenticeAppellationId;
/*     */       
/* 102 */       List<String> appellationArgs = TitleInterface.getAppArgs(roleId, appellationCfgId, false);
/* 103 */       if ((appellationArgs != null) && (!appellationArgs.isEmpty()))
/*     */       {
/* 105 */         String masterRoleName = sSyncShiTuInfo.masterinfo.rolename;
/* 106 */         String xMasterRoleName = (String)appellationArgs.get(0);
/* 107 */         if (!xMasterRoleName.equals(masterRoleName))
/*     */         {
/* 109 */           appellationArgs.set(0, masterRoleName);
/* 110 */           TitleInterface.replaceAppellationArgsNoneRealTime(roleId, appellationCfgId, appellationArgs);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 115 */       SShiTuLineNotify notifyMaster = new SShiTuLineNotify();
/* 116 */       notifyMaster.onlinestatus = 1;
/* 117 */       notifyMaster.profession = 1;
/* 118 */       notifyMaster.professionname = roleName;
/*     */       
/* 120 */       OnlineManager.getInstance().send(masterRoleId, notifyMaster);
/*     */     }
/*     */     
/*     */ 
/* 124 */     OnlineManager.getInstance().send(roleId, sSyncShiTuInfo);
/*     */     
/*     */ 
/* 127 */     Set<Long> roleIdSet = new HashSet(xNowApprenticeMap.keySet());
/*     */     
/* 129 */     if (ShiTuManager.getMasterId(xRole2ShiTuInfo) > 0L)
/*     */     {
/* 131 */       roleIdSet.add(Long.valueOf(roleId));
/*     */     }
/* 133 */     if (roleIdSet.size() > 0)
/*     */     {
/* 135 */       new PSynAllShiTuTaskInfos(roleId, roleIdSet).execute();
/* 136 */       new PSynAllShiTuActiveInfos(roleId, roleIdSet).execute();
/*     */     }
/* 138 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */