/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.CCreateRole;
/*     */ import mzm.gsp.CreateRoleArg;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.SCreateRole;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.csprovider.main.CSProviderInterface;
/*     */ import mzm.gsp.online.event.PlayerCreate;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.DeleteState;
/*     */ import xbean.OnlineUserInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2delete;
/*     */ 
/*     */ public class PCreateRole extends LogicProcedure
/*     */ {
/*     */   private final String userId;
/*     */   private final CreateRoleArg roleinfo;
/*  32 */   private final SCreateRole res = new SCreateRole();
/*     */   private final CCreateRole cCreateRole;
/*     */   
/*     */   protected boolean processImp() throws Exception {
/*  36 */     int inviteCodeSize = this.roleinfo.invite_code.size();
/*  37 */     if ((inviteCodeSize > 0) && (inviteCodeSize != 12)) {
/*  38 */       this.res.result = 7;
/*  39 */       return false;
/*     */     }
/*  41 */     this.res.roleinfo.roleid = -1L;
/*  42 */     this.res.result = 7;
/*  43 */     String channel = Onlines.getInstance().findMSDKChannel(this.userId);
/*  44 */     if ((channel != null) && (!channel.isEmpty()) && (!ForbidInfoManager.containsForbiddenChannel(channel))) {
/*  45 */       if (GameServerInfoManager.isRoamServer()) {
/*  46 */         this.res.result = 7;
/*  47 */         return false; }
/*  48 */       if (!LoginManager.getInstance().checkAccountNum(this.userId, false)) {
/*  49 */         LoginManager.getInstance().onAccountNumMax(this.cCreateRole);
/*  50 */         this.res.result = 12;
/*  51 */         return false; }
/*  52 */       if (ForbidInfoManager.isUserForbid(this.userId)) {
/*  53 */         this.res.result = 5;
/*  54 */         return false; }
/*  55 */       if (!RoleInterface.isOccupationOpen(this.roleinfo.occupation, this.roleinfo.gender)) {
/*  56 */         this.res.result = 14;
/*  57 */         return false;
/*     */       }
/*  59 */       boolean isRegister = false;
/*  60 */       xbean.User xUser = xtable.User.get(this.userId);
/*  61 */       int maxRoleNum = OnlineManager.getInstance().getUserMaxRoleNum();
/*  62 */       if (xUser == null) {
/*  63 */         xUser = Pod.newUser();
/*  64 */         xtable.User.insert(this.userId, xUser);
/*  65 */         isRegister = true;
/*  66 */       } else if (xUser.getRoleids().isEmpty()) {
/*  67 */         isRegister = true;
/*  68 */       } else if (xUser.getRoleids().size() >= maxRoleNum) {
/*  69 */         lock(Basic.getTable(), xUser.getRoleids());
/*  70 */         int normalRole = 0;
/*  71 */         int protectedRole = 0;
/*  72 */         Iterator i$ = xUser.getRoleids().iterator();
/*     */         
/*  74 */         while (i$.hasNext()) {
/*  75 */           long roleId = ((Long)i$.next()).longValue();
/*  76 */           DeleteState xDeleteState = Role2delete.get(Long.valueOf(roleId));
/*  77 */           if (xDeleteState == null) {
/*  78 */             normalRole++;
/*  79 */           } else if (xDeleteState.getDeletestate() < 2) {
/*  80 */             protectedRole++;
/*     */           }
/*     */         }
/*     */         
/*  84 */         if (normalRole >= maxRoleNum) {
/*  85 */           this.res.result = 1;
/*  86 */           return false;
/*     */         }
/*     */         
/*  89 */         if (normalRole + protectedRole >= maxRoleNum) {
/*  90 */           this.res.result = 11;
/*  91 */           return false;
/*     */         }
/*     */       }
/*     */       
/*  95 */       if ((CSProviderInterface.getRequireActivateUser()) && (!xUser.getActivated())) {
/*  96 */         this.res.result = 10;
/*  97 */         return false;
/*     */       }
/*  99 */       long roleId = RoleManager.getInstance().createRole(this.userId, this.roleinfo.name, this.roleinfo.occupation, this.roleinfo.gender, this.res);
/* 100 */       if (roleId < 0L) {
/* 101 */         return false;
/*     */       }
/* 103 */       xUser.getRoleids().add(Long.valueOf(roleId));
/* 104 */       if (xUser.getRegister_time() <= 0L) {
/* 105 */         xUser.setRegister_time(DateTimeUtils.getCurrTimeInMillis());
/* 106 */         if (inviteCodeSize > 0) {
/* 107 */           xUser.setInvitee_code(this.roleinfo.invite_code.getString("UTF-8"));
/*     */         }
/*     */       }
/*     */       
/* 111 */       this.res.result = 0;
/* 112 */       this.res.roleinfo.roleid = roleId;
/* 113 */       this.res.roleinfo.basic = this.roleinfo;
/* 114 */       TriggerEventsManger.getInstance().triggerEvent(new PlayerCreate(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/* 115 */       String createRoleLog = String.format("%d|%s|%s|%s|%s|%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(OnlineManager.getInstance().getPlatform(this.userId)), RoleInterface.getChannel(this.userId), OnlineManager.getInstance().getMac(this.userId), this.userId, roleId + "", Integer.valueOf(this.roleinfo.gender), Integer.valueOf(this.roleinfo.occupation), this.roleinfo.name, "0", "0" });
/* 116 */       LogManager.getInstance().addLog("rolecreate", createRoleLog);
/* 117 */       String roleCreate = String.format("%s|%d|%d|%d|%s", new Object[] { this.userId, Long.valueOf(roleId), Integer.valueOf(this.roleinfo.gender), Integer.valueOf(this.roleinfo.occupation), this.roleinfo.name });
/* 118 */       TLogManager.getInstance().addLog(roleId, "RoleCreate", roleCreate);
/* 119 */       if (isRegister) {
/* 120 */         boolean ret = LoginManager.getInstance().insertAccount(this.userId);
/* 121 */         if (!ret) {
/* 122 */           LoginManager.getInstance().onAccountNumMax(this.cCreateRole);
/* 123 */           this.res.result = 12;
/* 124 */           return false;
/*     */         }
/*     */         
/* 127 */         String createUserLog = String.format("%d|%s|%s|%s", new Object[] { Integer.valueOf(OnlineManager.getInstance().getPlatform(this.userId)), RoleInterface.getChannel(this.userId), OnlineManager.getInstance().getMac(this.userId), this.userId });
/* 128 */         LogManager.getInstance().addLog("usercreate", createUserLog);
/* 129 */         registerTLog(roleId);
/*     */       }
/* 131 */       if (this.roleinfo.gender == 1) {
/* 132 */         BulletinInterface.sendNotice("欢迎新人帅哥【" + this.roleinfo.name + "】来到了梦幻诛仙世界，大家快去跟他打个招呼吧！");
/*     */       } else {
/* 134 */         BulletinInterface.sendNotice("欢迎新人美女【" + this.roleinfo.name + "】来到了梦幻诛仙世界，大家快去跟她打个招呼吧！");
/*     */       }
/* 136 */       GameServerInfoManager.onRoleCreate();
/* 137 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 142 */     this.res.result = 13;
/* 143 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private void registerTLog(long roleid)
/*     */   {
/* 149 */     OnlineUserInfo onlineUserInfo = Onlines.getInstance().findUserInfo(this.userId);
/* 150 */     if (onlineUserInfo != null) {
/* 151 */       String clientVersion = Onlines.getInstance().findEnumFromLoginArg(0, onlineUserInfo);
/* 152 */       String systemSoftWard = Onlines.getInstance().findEnumFromLoginArg(1, onlineUserInfo);
/* 153 */       String systemHardware = Onlines.getInstance().findEnumFromLoginArg(7, onlineUserInfo);
/* 154 */       int telecomOper = 1;
/* 155 */       if (onlineUserInfo != null) {
/* 156 */         telecomOper = onlineUserInfo.getTelecomoper();
/*     */       }
/*     */       
/* 159 */       String netWork = Onlines.getInstance().findEnumFromLoginArg(3, onlineUserInfo);
/* 160 */       String screenWidth = Onlines.getInstance().findEnumFromLoginArg(4, onlineUserInfo);
/* 161 */       int width = 0;
/* 162 */       if ((screenWidth != null) && (!screenWidth.isEmpty())) {
/*     */         try {
/* 164 */           width = Integer.valueOf(screenWidth).intValue();
/*     */         }
/*     */         catch (Exception var27) {}
/*     */       }
/*     */       
/*     */ 
/* 170 */       String screenHight = Onlines.getInstance().findEnumFromLoginArg(5, onlineUserInfo);
/* 171 */       int hight = 0;
/* 172 */       if ((screenHight != null) && (!screenHight.isEmpty())) {
/*     */         try {
/* 174 */           hight = Integer.valueOf(screenHight).intValue();
/*     */         }
/*     */         catch (Exception var26) {}
/*     */       }
/*     */       
/*     */ 
/* 180 */       String densityStr = Onlines.getInstance().findEnumFromLoginArg(6, onlineUserInfo);
/* 181 */       float density = 0.0F;
/* 182 */       if ((densityStr != null) && (!densityStr.isEmpty())) {
/*     */         try {
/* 184 */           density = Float.valueOf(densityStr).floatValue();
/*     */         }
/*     */         catch (Exception var25) {}
/*     */       }
/*     */       
/*     */ 
/* 190 */       String channel = Onlines.getInstance().findMSDKRegisterChannel(this.userId);
/* 191 */       String cpuHardward = Onlines.getInstance().findEnumFromLoginArg(7, onlineUserInfo);
/* 192 */       int memory = 0;
/* 193 */       String memeoryStr = Onlines.getInstance().findEnumFromLoginArg(8, onlineUserInfo);
/* 194 */       if ((densityStr != null) && (!densityStr.isEmpty())) {
/*     */         try {
/* 196 */           memory = Integer.valueOf(memeoryStr).intValue();
/*     */         }
/*     */         catch (Exception var24) {}
/*     */       }
/*     */       
/*     */ 
/* 202 */       String glRender = Onlines.getInstance().findEnumFromLoginArg(9, onlineUserInfo);
/* 203 */       String glVersion = Onlines.getInstance().findEnumFromLoginArg(10, onlineUserInfo);
/* 204 */       String deviceid = Onlines.getInstance().findEnumFromLoginArg(11, onlineUserInfo);
/* 205 */       boolean fakePlat = Onlines.getInstance().findFakePlat(this.userId);
/* 206 */       String playerRegister = String.format("%s|%s|%s|%d|%s|%d|%d|%f|%s|%s|%d|%s|%s|%s|%d", new Object[] { clientVersion, systemSoftWard, systemHardware, Integer.valueOf(telecomOper), netWork, Integer.valueOf(width), Integer.valueOf(hight), Float.valueOf(density), channel, cpuHardward, Integer.valueOf(memory), glRender, glVersion, deviceid, Integer.valueOf(fakePlat ? 1 : 0) });
/* 207 */       TLogManager.getInstance().addLog(roleid, "PlayerRegister", playerRegister);
/*     */     }
/*     */   }
/*     */   
/*     */   public SCreateRole getRes()
/*     */   {
/* 213 */     return this.res;
/*     */   }
/*     */   
/*     */   public PCreateRole(String userid, CreateRoleArg roleinfo, CCreateRole createRole) {
/* 217 */     this.userId = userid;
/* 218 */     this.roleinfo = roleinfo;
/* 219 */     this.cCreateRole = createRole;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PCreateRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */