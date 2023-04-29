/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Dispatch;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.CGetRoleList;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.RoleInfo;
/*     */ import mzm.gsp.SGetRoleList;
/*     */ import mzm.gsp.SUserForbid;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DeleteState;
/*     */ import xbean.ForbidInfo;
/*     */ import xtable.Userforbid;
/*     */ 
/*     */ public class PGetRoleList extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final CGetRoleList protocolCRoleList;
/*     */   
/*     */   public PGetRoleList(CGetRoleList proCRoleList)
/*     */   {
/*  33 */     this.protocolCRoleList = proCRoleList;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  38 */     long currTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  40 */     Dispatch ctx = (Dispatch)this.protocolCRoleList.getContext();
/*  41 */     String userId = ctx.userid.getString("UTF-8");
/*  42 */     xbean.User xUser = xtable.User.get(userId);
/*     */     
/*  44 */     if (mzm.gsp.GameServerInfoManager.isRoamServer()) {
/*  45 */       Octets octets = LoginManager.getRoamToken(userId);
/*  46 */       if (octets == null) {
/*  47 */         GameServer.logger().error(String.format("[Login]PGetRoleList.processImp@login roam server,but do not have token|userid=%s", new Object[] { userId }));
/*     */         
/*     */ 
/*     */ 
/*  51 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  55 */     xbean.OnlineUserInfo xOnlineUserInfo = Onlines.getInstance().findUserInfo(userId);
/*  56 */     if (xOnlineUserInfo == null) {
/*  57 */       GameServer.logger().info(String.format("[online]PGetRoleList.processImp@user login arg is null|user_id=%s", new Object[] { userId }));
/*     */       
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     String netType = Onlines.getInstance().findEnumFromLoginArg(3, xOnlineUserInfo);
/*  63 */     String resultion = Onlines.getInstance().findEnumFromLoginArg(4, xOnlineUserInfo) + "*" + Onlines.getInstance().findEnumFromLoginArg(5, xOnlineUserInfo);
/*     */     
/*  65 */     String plat = String.valueOf(Onlines.getInstance().findPlatid(userId));
/*  66 */     String channel = Onlines.getInstance().findMSDKChannel(userId);
/*  67 */     String mac = Onlines.getInstance().findMac(userId);
/*  68 */     String systemSoftWare = Onlines.getInstance().findEnumFromLoginArg(1, xOnlineUserInfo);
/*     */     
/*  70 */     String hardWare = Onlines.getInstance().findEnumFromLoginArg(2, xOnlineUserInfo);
/*  71 */     String deviceid = Onlines.getInstance().findEnumFromLoginArg(11, xOnlineUserInfo);
/*     */     
/*  73 */     String log = buildLog(new Object[] { plat, channel, Integer.valueOf(0), mac, userId, systemSoftWare, hardWare, netType, resultion, deviceid });
/*  74 */     mzm.gsp.util.LogManager.getInstance().addLog("deviceinfo", log);
/*     */     
/*  76 */     if ((null == xUser) || (xUser.getRoleids().isEmpty()))
/*     */     {
/*  78 */       if ((mzm.gsp.csprovider.main.CSProviderInterface.getRequireActivateUser()) && ((xUser == null) || (!xUser.getActivated()))) {
/*  79 */         mzm.gsp.csprovider.SRequireUseActivateCard rep = new mzm.gsp.csprovider.SRequireUseActivateCard();
/*     */         
/*  81 */         GameServer.logger().info(String.format("[online]PGetRoleList.processImp@need to activate user|user_id=%s", new Object[] { userId }));
/*     */         
/*     */ 
/*  84 */         return Onlines.getInstance().sendResponse(this.protocolCRoleList, rep);
/*     */       }
/*     */       
/*  87 */       OpenInterface.getModuleFunSwitches(this.protocolCRoleList);
/*     */       
/*  89 */       return Onlines.getInstance().sendResponse(this.protocolCRoleList, new SGetRoleList());
/*     */     }
/*     */     
/*  92 */     ForbidInfo forbid = Userforbid.get(userId);
/*  93 */     if ((forbid != null) && (forbid.getExpiretime() <= currTimeMillis)) {
/*  94 */       Userforbid.remove(userId);
/*  95 */       forbid = null;
/*     */     }
/*     */     
/*  98 */     if (forbid != null) {
/*  99 */       SUserForbid rlf = new SUserForbid();
/* 100 */       rlf.expire_time = TimeUnit.MILLISECONDS.toSeconds(forbid.getExpiretime());
/* 101 */       rlf.reason = forbid.getReason();
/* 102 */       return Onlines.getInstance().sendResponse(this.protocolCRoleList, rlf);
/*     */     }
/*     */     
/*     */ 
/* 106 */     LoginManager.getInstance().checkInCrossServer(userId, this);
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   void innerGetRoleList(String userid, xbean.User xUser, List<Long> roleids) {
/* 111 */     SGetRoleList proSRoleList = new SGetRoleList();
/* 112 */     Map<Long, xbean.Basic> deleteRolesMap = new HashMap();
/*     */     
/* 114 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 115 */       xbean.Basic basic = xtable.Basic.get(Long.valueOf(roleid));
/* 116 */       if (basic != null) {
/* 117 */         DeleteState xDeleteState = xtable.Role2delete.get(Long.valueOf(roleid));
/* 118 */         RoleInfo roleInfo = new RoleInfo();
/*     */         
/* 120 */         if (xDeleteState != null)
/*     */         {
/* 122 */           int deleteState = xDeleteState.getDeletestate();
/* 123 */           if (deleteState == 2) {
/* 124 */             deleteRolesMap.put(Long.valueOf(roleid), basic);
/* 125 */             continue;
/*     */           }
/* 127 */           if (deleteState == 0) {
/* 128 */             long interval = xDeleteState.getDeleteendtime() - DateTimeUtils.getCurrTimeInMillis();
/*     */             
/* 130 */             if (interval <= 0L) {
/* 131 */               xDeleteState.setDeletestate(2);
/* 132 */               deleteRolesMap.put(Long.valueOf(roleid), basic);
/*     */               
/* 134 */               RoleDeleteLogManager.tlogRoleDel(roleid, 2);
/*     */               
/* 136 */               TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.online.event.PlayerRealDelete(), Long.valueOf(roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */               
/* 138 */               continue;
/*     */             }
/* 140 */             roleInfo.delendtime = ((int)(interval / 1000L));
/*     */           }
/*     */         }
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
/*     */ 
/* 156 */         roleInfo.roleid = roleid;
/*     */         
/* 158 */         roleInfo.basic.name = basic.getName();
/* 159 */         roleInfo.basic.gender = basic.getGender();
/* 160 */         roleInfo.basic.occupation = basic.getOccupationid();
/* 161 */         roleInfo.basic.level = RoleInterface.getLevel(roleid);
/* 162 */         roleInfo.expiretime = TimeUnit.MILLISECONDS.toSeconds(ForbidInfoManager.getRoleForbideTime(roleid));
/* 163 */         proSRoleList.roles.add(roleInfo);
/* 164 */         ModelInfo modelInfo = new ModelInfo();
/* 165 */         RoleInterface.fillModelInfo(roleid, modelInfo);
/* 166 */         proSRoleList.rolemodels.put(Long.valueOf(roleid), modelInfo);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 171 */     OpenInterface.getModuleFunSwitches(this.protocolCRoleList);
/*     */     
/*     */ 
/* 174 */     Onlines.getInstance().sendResponse(this.protocolCRoleList, proSRoleList);
/*     */   }
/*     */   
/*     */   CGetRoleList getCGetRoleList() {
/* 178 */     return this.protocolCRoleList;
/*     */   }
/*     */   
/*     */   private String buildLog(Object... arg) {
/* 182 */     StringBuilder stringBuilder = new StringBuilder();
/* 183 */     for (Object a : arg) {
/* 184 */       stringBuilder.append(a).append("|");
/*     */     }
/* 186 */     stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/* 187 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGetRoleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */