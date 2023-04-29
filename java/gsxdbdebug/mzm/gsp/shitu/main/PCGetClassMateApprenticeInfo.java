/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.shitu.SGetClassMateApprenticeInfo;
/*     */ import mzm.gsp.shitu.ShiTuRoleInfo;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class PCGetClassMateApprenticeInfo extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int startPos;
/*     */   
/*     */   public PCGetClassMateApprenticeInfo(long roleId, int startPos)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.startPos = startPos;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (this.startPos < 0)
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1718, true))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!ShiTuManager.isShiTuSwitchOpen(this.roleId, "PCGetClassMateApprenticeInfo.processImp"))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (this.startPos < 0)
/*     */     {
/*  48 */       GameServer.logger().error(String.format("[shitu]PCGetClassMateApprenticeInfo.processImp@page num <= 0|role_id=%d|start_pos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.startPos) }));
/*     */       
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     ApprenticeInfo xApprenticeInfo = Role2shitu.selectApprenticeinfo(Long.valueOf(this.roleId));
/*     */     
/*  56 */     if (xApprenticeInfo == null)
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[shitu]PCGetClassMateApprenticeInfo.processImp@shi tu info is null|role_id=%d|start_pos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.startPos) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*  63 */     long masterRoleId = xApprenticeInfo.getMasterroleid();
/*  64 */     if (masterRoleId <= 0L)
/*     */     {
/*  66 */       GameServer.logger().error(String.format("[shitu]PCGetClassMateApprenticeInfo.processImp@role not has master|role_id=%d|start_pos=%d|master_role_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.startPos), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     MasterInfo xMasterInfo = Role2shitu.selectMasterinfo(Long.valueOf(masterRoleId));
/*  74 */     if (xMasterInfo == null)
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[shitu]PCGetClassMateApprenticeInfo.processImp@master shi tu info is null|role_id=%d|start_pos=%d|master_role_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.startPos), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  80 */       return false;
/*     */     }
/*  82 */     SGetClassMateApprenticeInfo sGetClassMateApprenticeInfo = new SGetClassMateApprenticeInfo();
/*     */     
/*  84 */     List<Long> xNowApprenticeRoleList = xMasterInfo.getNow_apprentice_role_list();
/*  85 */     for (Iterator i$ = xNowApprenticeRoleList.iterator(); i$.hasNext();) { long nowApprenticeRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  87 */       if (nowApprenticeRoleId != this.roleId)
/*     */       {
/*     */ 
/*     */ 
/*  91 */         sGetClassMateApprenticeInfo.nowclassmatelistinfo.add(ShiTuManager.setShiTuRoleInfo(nowApprenticeRoleId, new ShiTuRoleInfo()));
/*     */       }
/*     */     }
/*     */     
/*  95 */     List<Long> graduateRoleIdList = xMasterInfo.getApprentice_role_list();
/*     */     
/*  97 */     int nowGraduateSize = graduateRoleIdList.size();
/*     */     
/*     */ 
/* 100 */     int endPos = this.startPos + ShiTuConsts.getInstance().graduateApprenticePageSize;
/*     */     
/* 102 */     List<ShiTuRoleInfo> apprenticeList = sGetClassMateApprenticeInfo.chushiclassmatelistinfo;
/*     */     
/*     */ 
/* 105 */     for (int index = this.startPos; (index <= endPos - 1) && (index < nowGraduateSize); index++)
/*     */     {
/*     */ 
/* 108 */       long graduatedClassMateRoleId = ((Long)graduateRoleIdList.get(index)).longValue();
/* 109 */       if (graduatedClassMateRoleId != this.roleId)
/*     */       {
/*     */ 
/*     */ 
/* 113 */         apprenticeList.add(ShiTuManager.setShiTuRoleInfo(graduatedClassMateRoleId, new ShiTuRoleInfo())); }
/*     */     }
/* 115 */     sGetClassMateApprenticeInfo.classmatesize = (xNowApprenticeRoleList.size() + nowGraduateSize - 1);
/* 116 */     OnlineManager.getInstance().send(this.roleId, sGetClassMateApprenticeInfo);
/*     */     
/* 118 */     GameServer.logger().info(String.format("[shitu]PCGetClassMateApprenticeInfo.processImp@handle get class mate role info success|role_id=%d|begin_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.startPos) }));
/*     */     
/*     */ 
/*     */ 
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCGetClassMateApprenticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */