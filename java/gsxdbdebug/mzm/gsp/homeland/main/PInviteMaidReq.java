/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SInviteMaidRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SMaidCfg;
/*     */ import mzm.gsp.homeland.confbean.SMaidRoomCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.UuidUtils;
/*     */ import mzm.gsp.util.UuidUtils.UuidType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PInviteMaidReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int maidCfgId;
/*     */   
/*     */   public PInviteMaidReq(long roleId, int maidCfgId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.maidCfgId = maidCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  42 */       String logStr = String.format("[home]PInviteMaidReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  43 */       HomelandManager.logger.info(logStr);
/*  44 */       return false;
/*     */     }
/*  46 */     String userid = RoleInterface.getUserId(this.roleId);
/*  47 */     if (userid == null)
/*     */     {
/*  49 */       String logString = String.format("[home]PInviteMaidReq.processImp@userid is null|roleId=%d|maidCfgId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.maidCfgId) });
/*     */       
/*     */ 
/*  52 */       HomelandManager.logger.error(logString);
/*  53 */       return false;
/*     */     }
/*  55 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  57 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  58 */     if (homeInfoWrapper == null)
/*     */     {
/*  60 */       String logString = String.format("[home]PInviteMaidReq.processImp@xHomeInfo is null|roleId=%d|maidCfgId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.maidCfgId) });
/*     */       
/*     */ 
/*  63 */       HomelandManager.logger.warn(logString);
/*     */       
/*  65 */       return false;
/*     */     }
/*  67 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  68 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*  69 */     if (!isOwner)
/*     */     {
/*  71 */       String logString = String.format("[home]PInviteMaidReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*     */ 
/*  75 */       HomelandManager.logger.warn(logString);
/*  76 */       HomelandManager.sendSCommonResultRes(this.roleId, 8);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  81 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  82 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  84 */       String logString = String.format("[home]PInviteMaidReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  88 */       HomelandManager.logger.info(logString);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     SMaidRoomCfg sMaidRoomCfg = SMaidRoomCfg.get(xHomeInfo.getMaidroomlevel());
/*  93 */     if (sMaidRoomCfg == null)
/*     */     {
/*  95 */       String logString = String.format("[home]PInviteMaidReq.processImp@SMaidRoomCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(xHomeInfo.getMaidroomlevel()) });
/*     */       
/*     */ 
/*     */ 
/*  99 */       HomelandManager.logger.error(logString);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (!sMaidRoomCfg.maidIds.contains(Integer.valueOf(this.maidCfgId)))
/*     */     {
/* 105 */       String logString = String.format("[home]PInviteMaidReq.processImp@SMaidRoomCfg is has no this maidId|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|maidCfgId=%d|maids=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(this.maidCfgId), sMaidRoomCfg.maidIds.toString() });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 110 */       HomelandManager.logger.error(logString);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     SMaidCfg sMaidCfg = SMaidCfg.get(this.maidCfgId);
/* 115 */     if (sMaidCfg == null)
/*     */     {
/* 117 */       String logString = String.format("[home]PInviteMaidReq.processImp@SMaidCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|maidCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(this.maidCfgId) });
/*     */       
/*     */ 
/* 120 */       HomelandManager.logger.error(logString);
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 125 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, mzm.gsp.tlog.LogReason.INVITE_MAID, this.maidCfgId, sMaidCfg.moneyType, sMaidCfg.moneyNum, CostType.COST_BIND_FIRST_INVITE_MAID);
/*     */     
/* 127 */     if (!ret)
/*     */     {
/* 129 */       String logString = String.format("[home]PInviteMaidReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|moneyType=%d|moneyNum=%d|maidCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(sMaidCfg.moneyType), Integer.valueOf(sMaidCfg.moneyNum), Integer.valueOf(this.maidCfgId) });
/*     */       
/*     */ 
/*     */ 
/* 133 */       HomelandManager.logger.error(logString);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     Set<Integer> hasMaidCfgIds = HomelandManager.getHasMaidCfgIds(xHomeInfo);
/*     */     
/* 139 */     if (hasMaidCfgIds.contains(Integer.valueOf(this.maidCfgId)))
/*     */     {
/* 141 */       String logString = String.format("[home]PInviteMaidReq.processImp@maid is already exists|roleId=%d|partnerRoleid=%d|maidCfgId=%d|hasMaidCfgIds=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.maidCfgId), hasMaidCfgIds.toString() });
/*     */       
/*     */ 
/*     */ 
/* 145 */       HomelandManager.logger.error(logString);
/* 146 */       return false;
/*     */     }
/* 148 */     String maidName = sMaidCfg.maidName;
/* 149 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(xHomeInfo.getHomelevel());
/* 150 */     xbean.MaidInfo xMaidInfo = HomelandManager.createMaidInfo(sMaidCfg, sHomelandCfg.maidX, sHomelandCfg.maidY);
/* 151 */     long maidUuid = UuidUtils.generateUuid(UuidUtils.UuidType.HOME_MAID);
/* 152 */     xHomeInfo.getUuid2maidinfo().put(Long.valueOf(maidUuid), xMaidInfo);
/*     */     
/* 154 */     String logString = String.format("[home]PInviteMaidReq.processImp@invite maid success|roleId=%d|partnerRoleid=%d|maidCfgId=%d|name=%s|maiduuid=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(sMaidCfg.id), maidName, Long.valueOf(maidUuid) });
/*     */     
/*     */ 
/*     */ 
/* 158 */     HomelandManager.logger.info(logString);
/*     */     
/* 160 */     SInviteMaidRes res = new SInviteMaidRes();
/* 161 */     res.maiduuid = maidUuid;
/* 162 */     res.maidinfo.maidid = sMaidCfg.id;
/* 163 */     res.maidinfo.name.setString(maidName, "UTF-8");
/* 164 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 166 */     if (partnerRoleId != -1L)
/*     */     {
/* 168 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/*     */     
/*     */ 
/* 172 */     tlogInvitemaid(userid, roleLevel, this.maidCfgId, xHomeInfo, sMaidCfg, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 175 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogInvitemaid(String userid, int roleLevel, int maidCfgId, HomeInfo xHomeInfo, SMaidCfg sMaidCfg, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 181 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 183 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(maidCfgId), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(sMaidCfg.moneyType), Integer.valueOf(sMaidCfg.moneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), HomelandManager.getHasMaidCfgIds(xHomeInfo), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/*     */ 
/* 187 */     TLogManager.getInstance().addLog(userid, this.roleId, "Invitemaid", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PInviteMaidReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */