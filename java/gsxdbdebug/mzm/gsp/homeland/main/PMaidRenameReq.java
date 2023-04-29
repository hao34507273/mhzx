/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SMaidRenameRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.MaidInfo;
/*     */ 
/*     */ public class PMaidRenameReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long maidUuId;
/*     */   private final Octets name;
/*     */   
/*     */   public PMaidRenameReq(long roleId, long maidUuId, Octets name)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.maidUuId = maidUuId;
/*  27 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  40 */       String logStr = String.format("[home]PMaidRenameReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  41 */       HomelandManager.logger.info(logStr);
/*  42 */       return false;
/*     */     }
/*  44 */     String newName = this.name.getString("UTF-8");
/*  45 */     if (newName == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (("".equals(newName)) || (newName.length() > 30))
/*     */     {
/*  51 */       String logString = String.format("[home]PMaidRenameReq.processImp@maid rename error,newName error|roleId=%d|maidUuId=%d|newName=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.maidUuId), newName });
/*     */       
/*     */ 
/*     */ 
/*  55 */       HomelandManager.logger.info(logString);
/*  56 */       return false;
/*     */     }
/*  58 */     String userid = RoleInterface.getUserId(this.roleId);
/*  59 */     if (userid == null)
/*     */     {
/*  61 */       String logString = String.format("[home]PMaidRenameReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  63 */       HomelandManager.logger.error(logString);
/*  64 */       return false;
/*     */     }
/*  66 */     if (SensitiveInterface.isNameSensitive(newName))
/*     */     {
/*     */ 
/*  69 */       String logString = String.format("[home]PMaidRenameReq.processImp@name is sensitive|roleId=%d|maidUuId=%d|name=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.maidUuId), this.name.getString("UTF-8") });
/*     */       
/*  71 */       HomelandManager.logger.warn(logString);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  78 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  79 */     if (homeInfoWrapper == null)
/*     */     {
/*  81 */       String logString = String.format("[home]PMaidRenameReq.processImp@xHomeInfo is null|roleId=%d|maidUuId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.maidUuId) });
/*     */       
/*     */ 
/*  84 */       HomelandManager.logger.warn(logString);
/*     */       
/*  86 */       return false;
/*     */     }
/*  88 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().MAID_RENAME_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  92 */       String logString = String.format("[home]PMaidRenameReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  94 */       HomelandManager.logger.warn(logString);
/*  95 */       return false;
/*     */     }
/*  97 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  98 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/* 100 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 101 */     int homeLevel = xHomeInfo.getHomelevel();
/* 102 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 103 */     if (sHomelandCfg == null)
/*     */     {
/* 105 */       String logString = String.format("[home]PMaidRenameReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 109 */       HomelandManager.logger.error(logString);
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/* 115 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/* 117 */       String logString = String.format("[home]PMaidRenameReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/* 121 */       HomelandManager.logger.info(logString);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     MaidInfo xMaidInfo = (MaidInfo)xHomeInfo.getUuid2maidinfo().get(Long.valueOf(this.maidUuId));
/* 126 */     if (xMaidInfo == null)
/*     */     {
/* 128 */       String logString = String.format("[home]PMaidRenameReq.processImp@maid is not exists|roleId=%d|partnerRoleid=%d|maidUuId=%d|hasMaids=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.maidUuId), xHomeInfo.getUuid2maidinfo().keySet() });
/*     */       
/*     */ 
/*     */ 
/* 132 */       HomelandManager.logger.error(logString);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     String oldName = xMaidInfo.getName();
/*     */     
/* 138 */     xMaidInfo.setName(newName);
/* 139 */     String logString = String.format("[home]PMaidRenameReq.processImp@maid rename success|roleId=%d|partnerRoleid=%d|maidUuId=%d|maidCfgId=%d|newName=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.maidUuId), Integer.valueOf(xMaidInfo.getMaidcfgid()), newName });
/*     */     
/*     */ 
/*     */ 
/* 143 */     HomelandManager.logger.info(logString);
/*     */     
/* 145 */     SMaidRenameRes res = new SMaidRenameRes();
/* 146 */     res.maiduuid = this.maidUuId;
/* 147 */     res.name = this.name;
/* 148 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 150 */     if (partnerRoleId != -1L)
/*     */     {
/* 152 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/*     */     
/* 155 */     if (this.maidUuId == xHomeInfo.getCurrentmaiduuid())
/*     */     {
/* 157 */       HomelandManager.changeMaidNpcName(homeWorleId, sHomelandCfg.mapId, xMaidInfo.getMaidcfgid(), this.maidUuId, newName);
/*     */     }
/*     */     
/* 160 */     tlogMaidrename(userid, roleLevel, xMaidInfo.getMaidcfgid(), xHomeInfo, oldName, newName, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogMaidrename(String userid, int roleLevel, int maidId, HomeInfo xHomeInfo, String oldname, String newname, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 169 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 171 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(maidId), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), oldname, newname, Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 174 */     TLogManager.getInstance().addLog(userid, this.roleId, "Maidrename", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PMaidRenameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */