/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.SCheckWingsRep;
/*     */ import mzm.gsp.wing.WingCheckData;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WingContent;
/*     */ import xbean.WingPlan;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCCheckWingsReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long checkRoleId;
/*     */   private final int wingCfgId;
/*     */   
/*     */   public PCCheckWingsReq(long roleId, long checkRoleId, int wingCfgId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.checkRoleId = checkRoleId;
/*  31 */     this.wingCfgId = wingCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     int errCode = isRoleValid(this.checkRoleId);
/*  38 */     if (errCode > 0)
/*     */     {
/*  40 */       WingManager.sendWingNotice(this.roleId, errCode, new String[0]);
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.checkRoleId, false);
/*  46 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  47 */     if (xWingPlan == null)
/*     */     {
/*  49 */       GameServer.logger().error(String.format("[wing]PCGetOffWingReq.processImp@ wing plan not open!|checkRoleId=%d|plan=%d", new Object[] { Long.valueOf(this.checkRoleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  66 */     sendSCheckWingsRep(xWingPlan);
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   private int isRoleValid(long targetId)
/*     */   {
/*  72 */     boolean isRoleExist = RoleInterface.isRoleExist(targetId, false);
/*  73 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  75 */       if ((!isRoleExist) || (!OnlineManager.getInstance().isOnline(targetId)))
/*     */       {
/*  77 */         return 18;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*  82 */     else if (!isRoleExist)
/*     */     {
/*  84 */       return 19;
/*     */     }
/*     */     
/*  87 */     return -1;
/*     */   }
/*     */   
/*     */   void sendSCheckWingsRep(WingPlan xWingPlan)
/*     */   {
/*  92 */     SCheckWingsRep pro = new SCheckWingsRep();
/*  93 */     pro.roleid = this.checkRoleId;
/*  94 */     pro.checkwing = this.wingCfgId;
/*  95 */     pro.currank = xWingPlan.getCurrank();
/*  96 */     pro.curlv = xWingPlan.getCurlv();
/*  97 */     fillCheckInfo(xWingPlan.getWings(), pro.wings);
/*     */     
/*  99 */     OnlineManager.getInstance().send(this.roleId, pro);
/*     */   }
/*     */   
/*     */   private void fillCheckInfo(Map<Integer, WingContent> xWings, HashMap<Integer, WingCheckData> wings)
/*     */   {
/* 104 */     for (WingContent xWingContent : xWings.values())
/*     */     {
/* 106 */       WingCheckData pData = new WingCheckData();
/* 107 */       pData.cfgid = xWingContent.getCfgid();
/* 108 */       pData.colorid = xWingContent.getColorid();
/* 109 */       pData.skills.addAll(xWingContent.getSkills());
/* 110 */       pData.proids.addAll(xWingContent.getProids());
/* 111 */       wings.put(Integer.valueOf(pData.cfgid), pData);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCCheckWingsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */