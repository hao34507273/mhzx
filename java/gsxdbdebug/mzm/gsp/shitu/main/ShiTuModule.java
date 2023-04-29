/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.ChartCfgManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MasterRankInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMasterRankInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Masterrank;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class ShiTuModule implements mzm.event.Module, MergeModule, PostModuleInitListner
/*     */ {
/*     */   public void postInit()
/*     */   {
/*  26 */     ShiTuManager.check();
/*     */   }
/*     */   
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  32 */     ActivityInterface.registerActivityByLogicType(53, new PayRespectActivityHandler());
/*  33 */     MasterRankManager.init();
/*     */     try
/*     */     {
/*  36 */       ShiTuManager.init();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  40 */       throw new RuntimeException(e);
/*     */     }
/*  42 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  48 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/*  54 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/*  60 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  66 */     return Arrays.asList(new Table[] { Role2shitu.getTable(), Masterrank.getTable(), xtable.Role2shitutask.getTable(), xtable.Role2shituactive.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  73 */     PShiTuMerge pShiTuMerge = new PShiTuMerge(null);
/*     */     
/*  75 */     return pShiTuMerge.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class PShiTuMerge
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  87 */       long mainZoneId = MergeMain.getMainZoneid();
/*  88 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  90 */       lock(Masterrank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*     */       
/*  92 */       MasterRankInfo xMainMasterRankInfo = Masterrank.get(Long.valueOf(mainZoneId));
/*  93 */       MasterRankInfo xViceMasterRankInfo = Masterrank.get(Long.valueOf(viceZoneId));
/*  94 */       if (xMainMasterRankInfo == null)
/*     */       {
/*  96 */         xMainMasterRankInfo = Pod.newMasterRankInfo();
/*  97 */         Masterrank.add(Long.valueOf(mainZoneId), xMainMasterRankInfo);
/*     */       }
/*     */       
/* 100 */       if (xViceMasterRankInfo == null)
/*     */       {
/* 102 */         xViceMasterRankInfo = Pod.newMasterRankInfo();
/* 103 */         Masterrank.add(Long.valueOf(viceZoneId), xViceMasterRankInfo);
/*     */       }
/*     */       
/*     */ 
/* 107 */       List<RoleMasterRankInfo> xMainRoleMasterRankInfoList = xMainMasterRankInfo.getRolemasterrankdatas();
/*     */       
/* 109 */       List<RoleMasterRankInfo> xViceRoleMasterRankInfoList = xViceMasterRankInfo.getRolemasterrankdatas();
/*     */       
/*     */ 
/* 112 */       int mainMasterRankSize = xMainRoleMasterRankInfoList.size();
/*     */       
/* 114 */       int viceMasterRankSize = xViceRoleMasterRankInfoList.size();
/*     */       
/* 116 */       int masterIndex = 0;
/* 117 */       int viceIndex = 0;
/* 118 */       int index = 0;
/*     */       
/* 120 */       SChartSubTypeCfg sChatrSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(13);
/* 121 */       int masterRankCfgSize = sChatrSubTypeCfg.capacity + sChatrSubTypeCfg.extraSize;
/*     */       
/*     */ 
/* 124 */       List<Long> newRankRoleIdList = new ArrayList();
/* 125 */       for (; index < masterRankCfgSize; index++)
/*     */       {
/* 127 */         if ((viceIndex >= viceMasterRankSize) || (masterIndex >= mainMasterRankSize)) {
/*     */           break;
/*     */         }
/*     */         
/* 131 */         RoleMasterRankInfo xMainRoleMasterRankInfo = (RoleMasterRankInfo)xMainRoleMasterRankInfoList.get(masterIndex);
/* 132 */         RoleMasterRankInfo xViceRoleMasterRankInfo = (RoleMasterRankInfo)xViceRoleMasterRankInfoList.get(viceIndex);
/*     */         
/* 134 */         long mainRoleId = xMainRoleMasterRankInfo.getRoleid();
/* 135 */         long viceRoleId = xViceRoleMasterRankInfo.getRoleid();
/*     */         
/* 137 */         int mainRoleMasterRankData = ShiTuManager.selectApprenticeSize(mainRoleId);
/*     */         
/* 139 */         int viceRoleMasterRankData = ShiTuManager.selectApprenticeSize(viceRoleId);
/* 140 */         if (mainRoleMasterRankData >= viceRoleMasterRankData)
/*     */         {
/* 142 */           newRankRoleIdList.add(Long.valueOf(mainRoleId));
/* 143 */           masterIndex++;
/*     */         }
/*     */         else
/*     */         {
/* 147 */           newRankRoleIdList.add(Long.valueOf(viceRoleId));
/* 148 */           viceIndex++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 153 */       if (viceIndex >= viceMasterRankSize) {
/* 155 */         for (; 
/* 155 */             (index < masterRankCfgSize) && (masterIndex < mainMasterRankSize); masterIndex++)
/*     */         {
/* 157 */           RoleMasterRankInfo xMainRoleMasterRankInfo = (RoleMasterRankInfo)xMainRoleMasterRankInfoList.get(masterIndex);
/*     */           
/* 159 */           long mainRoleId = xMainRoleMasterRankInfo.getRoleid();
/*     */           
/* 161 */           newRankRoleIdList.add(Long.valueOf(mainRoleId));index++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */       if (masterIndex >= mainMasterRankSize) {
/* 168 */         for (; 
/* 168 */             (index < masterRankCfgSize) && (viceIndex < viceMasterRankSize); viceIndex++)
/*     */         {
/* 170 */           RoleMasterRankInfo xViceRoleMasterRankInfo = (RoleMasterRankInfo)xViceRoleMasterRankInfoList.get(viceIndex);
/*     */           
/* 172 */           long viceRoleId = xViceRoleMasterRankInfo.getRoleid();
/*     */           
/* 174 */           newRankRoleIdList.add(Long.valueOf(viceRoleId));index++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 179 */       xMainRoleMasterRankInfoList.clear();
/* 180 */       for (int i = 0; i < newRankRoleIdList.size(); i++)
/*     */       {
/* 182 */         RoleMasterRankInfo xRoleMasterRankInfo = Pod.newRoleMasterRankInfo();
/* 183 */         xRoleMasterRankInfo.setRoleid(((Long)newRankRoleIdList.get(i)).longValue());
/* 184 */         xMainRoleMasterRankInfoList.add(xRoleMasterRankInfo);
/*     */       }
/*     */       
/*     */ 
/* 188 */       Masterrank.remove(Long.valueOf(viceZoneId));
/*     */       
/* 190 */       GameServer.logger().info(String.format("[merge]ShiTuModule.PShiTuMerge.processImp@handle master rank merge success|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*     */       
/*     */ 
/*     */ 
/* 194 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\ShiTuModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */