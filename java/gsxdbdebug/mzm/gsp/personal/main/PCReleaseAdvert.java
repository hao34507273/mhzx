/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.SReleaseAdvertFailed;
/*     */ import mzm.gsp.personal.SReleaseAdvertSuccess;
/*     */ import mzm.gsp.personal.SimpleAdvertInfo;
/*     */ import mzm.gsp.personal.confbean.SNSConsts;
/*     */ import mzm.gsp.personal.confbean.SNSSubTypeCfg;
/*     */ import mzm.gsp.personal.event.ReleaseAdvert;
/*     */ import mzm.gsp.personal.event.ReleaseAdvertArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdvertInfo;
/*     */ import xbean.AdvertObserver;
/*     */ import xbean.PersonalInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Advert;
/*     */ import xtable.Advertobservers;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ public class PCReleaseAdvert extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final SimpleAdvertInfo simpleAdvertInfo;
/*     */   
/*     */   public PCReleaseAdvert(long roleId, SimpleAdvertInfo simpleAdvertInfo)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.simpleAdvertInfo = simpleAdvertInfo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!SNSManager.isFunOpen(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (!SNSManager.checkRoleStatus(this.roleId))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     int advertType = this.simpleAdvertInfo.adverttype;
/*  60 */     if (advertType == SNSConsts.getInstance().ALL_SUB_TYPE_ID)
/*     */     {
/*     */ 
/*  63 */       onFailed(0);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     SNSSubTypeCfg snsSubTypeCfg = SNSSubTypeCfg.get(advertType);
/*  68 */     if (snsSubTypeCfg == null)
/*     */     {
/*     */ 
/*  71 */       onFailed(0);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     String content = this.simpleAdvertInfo.content.getString("UTF-8");
/*  76 */     if (content.length() < SNSConsts.getInstance().CONTENT_MIN_LEN)
/*     */     {
/*     */ 
/*  79 */       onFailed(1);
/*  80 */       return false;
/*     */     }
/*  82 */     if (content.length() > SNSConsts.getInstance().CONTENT_MAX_LEN)
/*     */     {
/*     */ 
/*  85 */       onFailed(2);
/*  86 */       return false;
/*     */     }
/*  88 */     if (SensitiveInterface.isContentSensitive(content))
/*     */     {
/*     */ 
/*  91 */       onFailed(3);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (RoleInterface.getLevel(this.roleId) < SNSConsts.getInstance().OPEN_LEVEL)
/*     */     {
/*     */ 
/*  98 */       onFailed(13);
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(this.roleId));
/* 104 */     if (xPersonalInfo == null)
/*     */     {
/*     */ 
/* 107 */       xPersonalInfo = Pod.newPersonalInfo();
/* 108 */       PersonalManager.initXPersonalInfo(this.roleId, xPersonalInfo);
/* 109 */       Role2personal.insert(Long.valueOf(this.roleId), xPersonalInfo);
/*     */     }
/*     */     
/*     */ 
/* 113 */     if (xPersonalInfo.getAdverts().get(Integer.valueOf(advertType)) != null)
/*     */     {
/*     */ 
/* 116 */       onFailed(4);
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 122 */     Long deleteTimestamp = (Long)xPersonalInfo.getDeletetimestamps().get(Integer.valueOf(advertType));
/* 123 */     if (deleteTimestamp != null)
/*     */     {
/* 125 */       if (now - deleteTimestamp.longValue() < TimeUnit.MINUTES.toMillis(SNSConsts.getInstance().RELEASE_INTERVAL))
/*     */       {
/*     */ 
/* 128 */         onFailed(5);
/* 129 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 134 */     AdvertInfo xAdvertInfo = Pod.newAdvertInfo();
/* 135 */     xAdvertInfo.setAdverttype(advertType);
/* 136 */     xAdvertInfo.setContent(content);
/* 137 */     xAdvertInfo.setRelease_timestamp(now);
/*     */     
/*     */ 
/* 140 */     long advertId = Advert.insert(xAdvertInfo).longValue();
/* 141 */     xPersonalInfo.getAdverts().put(Integer.valueOf(advertType), Long.valueOf(advertId));
/* 142 */     xPersonalInfo.getDeletetimestamps().remove(Integer.valueOf(advertType));
/*     */     
/*     */ 
/* 145 */     addDeleteObserver(advertType, this.roleId, advertId);
/*     */     
/*     */ 
/* 148 */     triggerReleaseAdvert(this.roleId, advertId, xPersonalInfo, xAdvertInfo);
/*     */     
/*     */ 
/* 151 */     tlog(this.roleId, advertId, xAdvertInfo);
/*     */     
/*     */ 
/* 154 */     Octets title = new Octets();
/* 155 */     title.setString(snsSubTypeCfg.typeName, "UTF-8");
/* 156 */     mzm.gsp.idip.main.IdipManager.chatTLog(this.roleId, 0L, 0L, 0L, 103, title, this.simpleAdvertInfo.content);
/*     */     
/*     */ 
/* 159 */     SReleaseAdvertSuccess resp = new SReleaseAdvertSuccess();
/* 160 */     resp.adverttype = this.simpleAdvertInfo.adverttype;
/* 161 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/* 163 */     GameServer.logger().info(String.format("[personal]PCReleaseAdvert.processImp@release advert success|roleid=%d|advert_type=%d|content=%s|advertid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(advertType), content, Long.valueOf(advertId) }));
/*     */     
/*     */ 
/*     */ 
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retCode)
/*     */   {
/* 172 */     SReleaseAdvertFailed resp = new SReleaseAdvertFailed();
/* 173 */     resp.retcode = retCode;
/* 174 */     OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */     
/* 176 */     GameServer.logger().error(String.format("[personal]PCReleaseAdvert.onFailed@release advert failed|roleid=%d|advert_type=%d|content=%s|ret=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.simpleAdvertInfo.adverttype), this.simpleAdvertInfo.content.getString("UTF-8"), Integer.valueOf(retCode) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addDeleteObserver(int advertType, long roleId, long advertId)
/*     */   {
/* 185 */     AdvertObserver advertObserver = Advertobservers.get(Long.valueOf(advertId));
/* 186 */     if (advertObserver == null)
/*     */     {
/* 188 */       advertObserver = Pod.newAdvertObserver();
/* 189 */       Advertobservers.insert(Long.valueOf(advertId), advertObserver);
/*     */     }
/* 191 */     if (advertObserver.getObserver() != null)
/*     */     {
/* 193 */       advertObserver.getObserver().stopTimer();
/*     */     }
/*     */     
/* 196 */     advertObserver.setObserver(new DeleteAdvertObserver(advertType, roleId, advertId, TimeUnit.MINUTES.toSeconds(SNSConsts.getInstance().VALID_MAX_TIME)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void triggerReleaseAdvert(long roleId, long advertId, PersonalInfo xPersonalInfo, AdvertInfo xAdvertInfo)
/*     */   {
/* 203 */     int advertType = xAdvertInfo.getAdverttype();
/* 204 */     int integrity = PersonalManager.calculateIntegrity(xPersonalInfo);
/* 205 */     long releaseTimestamp = xAdvertInfo.getRelease_timestamp();
/* 206 */     AdvertChart advertChart = new AdvertChart(roleId, advertId, integrity, releaseTimestamp);
/*     */     
/* 208 */     int realGender = xPersonalInfo.getGender();
/* 209 */     int level = RoleInterface.getLevel(this.roleId);
/* 210 */     int province = PersonalManager.getProvince(xPersonalInfo.getLocation());
/* 211 */     FilterInfo filterInfo = new FilterInfo(advertType, level, realGender, province);
/*     */     
/* 213 */     AdvertData advertData = new AdvertData(advertId, advertType, xAdvertInfo.getContent(), xAdvertInfo.getRelease_timestamp());
/*     */     
/* 215 */     RoleData roleData = null;
/* 216 */     if (xPersonalInfo.getAdverts().size() == 1)
/*     */     {
/* 218 */       String name = RoleInterface.getName(roleId);
/* 219 */       int gender = RoleInterface.getGender(roleId);
/* 220 */       int occupationId = RoleInterface.getOccupationId(roleId);
/* 221 */       int headImage = AvatarInterface.getCurrentAvatar(roleId, true);
/* 222 */       int avatarFrameId = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, true);
/* 223 */       roleData = new RoleData(roleId, headImage, realGender, level, name, gender, occupationId, avatarFrameId);
/*     */     }
/*     */     
/* 226 */     ReleaseAdvertArg arg = new ReleaseAdvertArg(roleId, advertId, advertData, roleData, advertChart, filterInfo);
/* 227 */     ReleaseAdvert releaseAdvertEvent = new ReleaseAdvert();
/* 228 */     releaseAdvertEvent.setSequential(true);
/* 229 */     TriggerEventsManger.getInstance().triggerEvent(releaseAdvertEvent, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlog(long roleId, long advertId, AdvertInfo xAdvertInfo)
/*     */   {
/* 235 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 236 */     String userId = RoleInterface.getUserId(roleId);
/* 237 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 239 */     TLogManager.getInstance().addLog(userId, "ReleaseAdvert", new Object[] { vGameIp, userId, Long.valueOf(roleId), Integer.valueOf(roleLevel), Long.valueOf(advertId), Integer.valueOf(xAdvertInfo.getAdverttype()), xAdvertInfo.getContent(), Long.valueOf(xAdvertInfo.getRelease_timestamp()) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PCReleaseAdvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */