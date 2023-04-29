/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.SAdvertsFailed;
/*     */ import mzm.gsp.personal.SAdvertsSuccess;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PersonalInfo;
/*     */ import xtable.Advert;
/*     */ 
/*     */ public class PCAdverts extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCAdverts(long roleId)
/*     */   {
/*  24 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!SNSManager.isFunOpen(this.roleId))
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  36 */     if (!SNSManager.checkRoleStatus(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(this.roleId));
/*  43 */     if (xPersonalInfo == null)
/*     */     {
/*  45 */       SAdvertsFailed resp = new SAdvertsFailed();
/*  46 */       resp.retcode = 6;
/*  47 */       OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */       
/*  49 */       GameServer.logger().error(String.format("[personal]PCAdverts.processImp@query adverts failed|roleid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(6) }));
/*     */       
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     int avatar = AvatarInterface.getCurrentAvatar(this.roleId, true);
/*  56 */     int avatarFrameid = mzm.gsp.avatar.frame.AvatarFrameInterface.getCurrentAvatarFrameId(this.roleId, true);
/*     */     
/*     */ 
/*  59 */     ArrayList<mzm.gsp.personal.AdvertInfo> result = new ArrayList();
/*  60 */     Map<Integer, Long> xAdverts = xPersonalInfo.getAdverts();
/*  61 */     for (Map.Entry<Integer, Long> entry : xAdverts.entrySet())
/*     */     {
/*     */ 
/*  64 */       result.add(fillAdvertInfo(this.roleId, ((Long)entry.getValue()).longValue(), xPersonalInfo, avatar, avatarFrameid));
/*     */     }
/*     */     
/*  67 */     SAdvertsSuccess resp = new SAdvertsSuccess();
/*  68 */     resp.adverts = result;
/*  69 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/*  71 */     GameServer.logger().info(String.format("[personal]PCAdverts.processImp@query adverts success|roleid=%d|size=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(result.size()) }));
/*     */     
/*     */ 
/*  74 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private mzm.gsp.personal.AdvertInfo fillAdvertInfo(long roleId, long advertId, PersonalInfo xPersonalInfo, int avatar, int avatarFrameid)
/*     */   {
/*  80 */     mzm.gsp.personal.AdvertInfo advertInfo = new mzm.gsp.personal.AdvertInfo();
/*  81 */     advertInfo.roleid = roleId;
/*  82 */     advertInfo.advertid = advertId;
/*  83 */     advertInfo.realgender = xPersonalInfo.getGender();
/*     */     
/*  85 */     xbean.AdvertInfo xAdvertInfo = Advert.select(Long.valueOf(advertId));
/*  86 */     advertInfo.adverttype = xAdvertInfo.getAdverttype();
/*     */     try
/*     */     {
/*  89 */       advertInfo.name.setString(RoleInterface.getName(roleId), "UTF-8");
/*  90 */       advertInfo.content.setString(xAdvertInfo.getContent(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*  96 */     advertInfo.gender = RoleInterface.getGender(roleId);
/*  97 */     advertInfo.occupationid = RoleInterface.getOccupationId(roleId);
/*  98 */     advertInfo.level = RoleInterface.getLevel(roleId);
/*     */     
/* 100 */     advertInfo.headimage = avatar;
/* 101 */     advertInfo.avatar_frameid = avatarFrameid;
/* 102 */     return advertInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PCAdverts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */