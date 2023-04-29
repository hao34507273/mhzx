/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.genderconvert.main.GenderConvertInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.HeartbeatLogObserver;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.SSyncBaoShiDuInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BasicPropertiesSystem;
/*     */ import xbean.HeartBeatBean;
/*     */ import xbean.Pod;
/*     */ import xbean.Properties;
/*     */ import xtable.Role2heartbeat;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     RoleOutFightObj localRoleOutFightObj = RoleInterface.getRoleOutFightObject(((Long)this.arg).longValue());
/*  29 */     checkRoleAutoSign(((Long)this.arg).longValue(), localRoleOutFightObj);
/*  30 */     VigorDayUpdateObserver.loginRole(((Long)this.arg).longValue());
/*  31 */     localRoleOutFightObj.syncClientMoney();
/*  32 */     localRoleOutFightObj.syncClientRoleProperty();
/*  33 */     RoleVigorManager.getInstance().syncVigorList(((Long)this.arg).longValue());
/*  34 */     SSyncBaoShiDuInfo localSSyncBaoShiDuInfo = new SSyncBaoShiDuInfo();
/*  35 */     localSSyncBaoShiDuInfo.baoshudu = localRoleOutFightObj.getBaoShiDu();
/*  36 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), localSSyncBaoShiDuInfo);
/*     */     
/*  38 */     GenderConvertInterface.sendMultiOcpGender(((Long)this.arg).longValue(), false);
/*     */     
/*  40 */     HeartBeatBean localHeartBeatBean = Role2heartbeat.get((Long)this.arg);
/*  41 */     if (localHeartBeatBean == null)
/*     */     {
/*  43 */       localHeartBeatBean = Pod.newHeartBeatBean();
/*  44 */       localHeartBeatBean.setHeartbeatobserver(new HeartbeatLogObserver(((Long)this.arg).longValue()));
/*  45 */       Role2heartbeat.insert((Long)this.arg, localHeartBeatBean);
/*     */     }
/*  47 */     logPotential(((Long)this.arg).longValue());
/*     */     
/*  49 */     Properties localProperties = Role2properties.get((Long)this.arg);
/*  50 */     if (localProperties != null) {
/*  51 */       RoleManager.updatePropertiesSysOnLogin(localProperties, localProperties.getLevel());
/*     */     }
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   private void checkRoleAutoSign(long paramLong, RoleOutFightObj paramRoleOutFightObj)
/*     */   {
/*  58 */     Properties localProperties = Role2properties.get(Long.valueOf(paramLong));
/*  59 */     if (localProperties == null) {
/*  60 */       return;
/*     */     }
/*  62 */     for (BasicPropertiesSystem localBasicPropertiesSystem : localProperties.getPropertysysmap().values()) {
/*  63 */       if ((localBasicPropertiesSystem.getIsautospecialpoint()) && (localBasicPropertiesSystem.getPotentialpoint() > 0)) {
/*  64 */         paramRoleOutFightObj.autoSpecialPoint(localBasicPropertiesSystem);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void logPotential(long paramLong)
/*     */   {
/*  71 */     Role localRole = RoleInterface.getRole(paramLong, true);
/*  72 */     int i = RoleModuleManager.getLvTotalPotential(localRole.getLevel(), localRole.getOccupationId(), localRole.getGender());
/*  73 */     if (i < 0)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[role]POnRoleLogin.logPotential@ get standardPotential err!|roleId=%d|roleLv=%d|occupationId=%d|genderId=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localRole.getLevel()), Integer.valueOf(localRole.getOccupationId()), Integer.valueOf(localRole.getGender()) }));
/*     */       
/*  77 */       return;
/*     */     }
/*  79 */     Properties localProperties = Role2properties.get(Long.valueOf(paramLong));
/*  80 */     if (localProperties == null)
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[role]POnRoleLogin.logPotential@ get xProperties err!|roleId=%d|roleLv=%d|occupationId=%d|genderId=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localRole.getLevel()), Integer.valueOf(localRole.getOccupationId()), Integer.valueOf(localRole.getGender()) }));
/*     */       
/*  84 */       return;
/*     */     }
/*  86 */     Map localMap = localProperties.getPropertysysmap();
/*  87 */     if ((localMap == null) || (localMap.size() == 0)) {
/*  88 */       return;
/*     */     }
/*  90 */     Iterator localIterator = localMap.entrySet().iterator();
/*  91 */     while (localIterator.hasNext())
/*     */     {
/*  93 */       Map.Entry localEntry = (Map.Entry)localIterator.next();
/*  94 */       BasicPropertiesSystem localBasicPropertiesSystem = (BasicPropertiesSystem)localEntry.getValue();
/*  95 */       if (!checkValid(i, localBasicPropertiesSystem)) {
/*  96 */         GameServer.logger().error(String.format("[role]POnRoleLogin.logPotential@ BasicPropertiesSystem is err!|roleId=%d|roleLv=%d|occupationId=%d|genderId=%d|xBPS=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localRole.getLevel()), Integer.valueOf(localRole.getOccupationId()), Integer.valueOf(localRole.getGender()), BasicPropsToStr(localBasicPropertiesSystem) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean checkValid(int paramInt, BasicPropertiesSystem paramBasicPropertiesSystem)
/*     */   {
/* 103 */     if (paramBasicPropertiesSystem == null) {
/* 104 */       return false;
/*     */     }
/* 106 */     boolean bool = true;
/* 107 */     int i = 0;
/* 108 */     for (Iterator localIterator = paramBasicPropertiesSystem.getBasicpropertymap().values().iterator(); localIterator.hasNext();)
/*     */     {
/* 110 */       int j = ((Integer)localIterator.next()).intValue();
/* 111 */       if (j >= 0) {
/* 112 */         i += j;
/*     */       } else {
/* 114 */         bool = false;
/*     */       }
/*     */     }
/* 117 */     if (bool)
/*     */     {
/* 119 */       i += paramBasicPropertiesSystem.getPotentialpoint();
/* 120 */       if (i != paramInt) {
/* 121 */         bool = false;
/*     */       }
/*     */     }
/* 124 */     return bool;
/*     */   }
/*     */   
/*     */   private String BasicPropsToStr(BasicPropertiesSystem paramBasicPropertiesSystem)
/*     */   {
/* 129 */     if (paramBasicPropertiesSystem == null) {
/* 130 */       return "";
/*     */     }
/* 132 */     StringBuffer localStringBuffer = new StringBuffer();
/* 133 */     localStringBuffer.append("potentialpoint=");
/* 134 */     localStringBuffer.append(paramBasicPropertiesSystem.getPotentialpoint());
/* 135 */     localStringBuffer.append("|");
/* 136 */     localStringBuffer.append("basicpropertymap=");
/* 137 */     localStringBuffer.append(paramBasicPropertiesSystem.getBasicpropertymap());
/* 138 */     localStringBuffer.append("|");
/* 139 */     localStringBuffer.append("isautospecialpoint=");
/* 140 */     localStringBuffer.append(paramBasicPropertiesSystem.getIsautospecialpoint());
/* 141 */     localStringBuffer.append("|");
/* 142 */     localStringBuffer.append("autoassignpointpref=");
/* 143 */     localStringBuffer.append(paramBasicPropertiesSystem.getAutoassignpointpref());
/*     */     
/* 145 */     return localStringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */