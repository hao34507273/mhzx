/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.homeland.SCommonResultRes;
/*     */ import mzm.gsp.homeland.SCourtYardLevelUpRes;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PCCourtYardLevelUpReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCCourtYardLevelUpReq(long roleId)
/*     */   {
/*  32 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!CourtYardManager.isCourtLevelUpSwitchOpenForRole(this.roleId))
/*     */     {
/*  45 */       onCourtYardLevelUpReqFail(24);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1151, true))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userid = RoleInterface.getUserId(this.roleId);
/*  55 */     if (userid == null)
/*     */     {
/*  57 */       onCourtYardLevelUpReqFail(25);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  62 */     if (homeInfoWrapper == null)
/*     */     {
/*  64 */       onCourtYardLevelUpReqFail(23);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  69 */     this.partnerRoleId = (isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId());
/*     */     
/*  71 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  72 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  73 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  75 */       onCourtYardLevelUpReqFail(26);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1151, true, true))
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/*  86 */     SHomelandCfg currentHomelandCfg = SHomelandCfg.get(homeLevel);
/*  87 */     if (currentHomelandCfg == null)
/*     */     {
/*  89 */       Map<Object, String> extraMap = new HashMap();
/*  90 */       extraMap.put("home_level", String.valueOf(homeLevel));
/*     */       
/*  92 */       onCourtYardLevelUpReqFail(27, extraMap);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     int xCurrentCourtYardLevel = xHomeInfo.getCourtyardlevel();
/*  97 */     SCourtyardCfg sCurrentCourtyardCfg = SCourtyardCfg.get(xCurrentCourtYardLevel);
/*  98 */     if (sCurrentCourtyardCfg == null)
/*     */     {
/* 100 */       Map<Object, String> extraMap = new HashMap();
/* 101 */       extraMap.put("court_level", String.valueOf(xCurrentCourtYardLevel));
/*     */       
/* 103 */       onCourtYardLevelUpReqFail(28, extraMap);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     SCourtyardCfg sNextLevelCourtyardCfg = SCourtyardCfg.get(xCurrentCourtYardLevel + 1);
/* 108 */     if (sNextLevelCourtyardCfg == null)
/*     */     {
/* 110 */       Map<Object, String> extraMap = new HashMap();
/* 111 */       extraMap.put("court_level", String.valueOf(xCurrentCourtYardLevel));
/* 112 */       extraMap.put("next_court_level", String.valueOf(xCurrentCourtYardLevel + 1));
/*     */       
/* 114 */       onCourtYardLevelUpReqFail(29, extraMap);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     boolean result = HomelandManager.cutMoney(userid, this.roleId, LogReason.COURT_YARD_LEVEl_UP, 0, sNextLevelCourtyardCfg.moneyType, sNextLevelCourtyardCfg.moneyNum, CostType.COST_BIND_FIRST_COURT_YARD_LEVEL_UP);
/*     */     
/* 121 */     if (!result)
/*     */     {
/* 123 */       onCourtYardLevelUpReqFail(30);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     HomeOperate xOwnerHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/* 128 */     HomeOperate xPartnerHomeOperate = null;
/*     */     
/*     */ 
/* 131 */     CourtYardManager.moveCourtYardAllFurnitureFromHome2Bag(xHomeInfo, isOwner, xOwnerHomeOperate, false);
/* 132 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 134 */       xPartnerHomeOperate = HomelandManager.getXHomeOperate(this.partnerRoleId);
/*     */       
/* 136 */       CourtYardManager.moveCourtYardAllFurnitureFromHome2Bag(xHomeInfo, !isOwner, xPartnerHomeOperate, false);
/*     */     }
/*     */     
/* 139 */     int newLevel = xCurrentCourtYardLevel + 1;
/* 140 */     xHomeInfo.setCourtyardlevel(newLevel);
/*     */     
/* 142 */     HomelandManager.sendSSynOwnFurnitureRes(this.roleId, xOwnerHomeOperate);
/* 143 */     if ((homeInfoWrapper.getPartnerRoleId() != -1L) && (xPartnerHomeOperate != null))
/*     */     {
/* 145 */       HomelandManager.sendSSynOwnFurnitureRes(this.partnerRoleId, xPartnerHomeOperate);
/*     */     }
/*     */     
/* 148 */     HomelandManager.sendSSynHomelandRes(this.roleId, true, xHomeInfo, xOwnerHomeOperate);
/* 149 */     if ((homeInfoWrapper.getPartnerRoleId() != -1L) && (xPartnerHomeOperate != null))
/*     */     {
/* 151 */       HomelandManager.sendSSynHomelandRes(this.partnerRoleId, false, xHomeInfo, xPartnerHomeOperate);
/*     */     }
/*     */     
/* 154 */     long ownerRoleId = homeInfoWrapper.getOwnerRoleId();
/*     */     
/* 156 */     CourtYardManager.changeCourtYardBeautifulIntoWorld(xHomeInfo, ownerRoleId);
/* 157 */     CourtYardManager.changeCourtYardLevelIntoWorld(xHomeInfo, ownerRoleId);
/*     */     
/*     */ 
/* 160 */     java.util.List<Long> roleList = MapInterface.getRoleList(homeWorleId, sCurrentCourtyardCfg.mapId);
/*     */     
/* 162 */     HomelandManager.goHome(roleList, homeWorleId, currentHomelandCfg.mapId, -1, -1, currentHomelandCfg.maidX, currentHomelandCfg.maidY, homeInfoWrapper);
/*     */     
/*     */ 
/* 165 */     MapInterface.destroyScene(homeWorleId, sCurrentCourtyardCfg.mapId, null);
/*     */     
/* 167 */     SCourtYardLevelUpRes sCourtYardUpRes = new SCourtYardLevelUpRes();
/* 168 */     sCourtYardUpRes.court_yard_level = newLevel;
/* 169 */     OnlineManager.getInstance().send(this.roleId, sCourtYardUpRes);
/*     */     
/* 171 */     int newBeautiful = CourtYardManager.computeFurnitureBeautiful(xHomeInfo);
/* 172 */     CourtYardManager.sendSSynBeautifulRes(this.roleId, newBeautiful);
/* 173 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 175 */       OnlineManager.getInstance().send(this.partnerRoleId, sCourtYardUpRes);
/* 176 */       CourtYardManager.sendSSynBeautifulRes(this.partnerRoleId, newBeautiful);
/*     */     }
/*     */     
/* 179 */     ChildrenInterface.onHomeLevelUp(this.roleId, this.partnerRoleId);
/*     */     
/* 181 */     tlogCourtYardLevelUp(userid, newLevel, isOwner);
/*     */     
/* 183 */     StringBuilder sb = new StringBuilder();
/* 184 */     sb.append("[home]PCCourtYardLevelUpReq.processImp@court yard level up success");
/* 185 */     sb.append("|role_id=").append(this.roleId);
/* 186 */     sb.append("|now_level=").append(newLevel);
/*     */     
/* 188 */     GameServer.logger().info(sb.toString());
/* 189 */     return true;
/*     */   }
/*     */   
/*     */   private void tlogCourtYardLevelUp(String userId, int newLevel, boolean isOwner)
/*     */   {
/* 194 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 196 */     StringBuilder sbLog = new StringBuilder();
/* 197 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 198 */     sbLog.append(userId).append('|');
/* 199 */     sbLog.append(this.roleId).append('|');
/* 200 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 202 */     sbLog.append(newLevel).append('|');
/* 203 */     sbLog.append(isOwner).append('|');
/* 204 */     sbLog.append(this.partnerRoleId);
/*     */     
/* 206 */     TLogManager.getInstance().addLog(this.roleId, "CourtYardLevelup", sbLog.toString());
/*     */   }
/*     */   
/*     */   private void onCourtYardLevelUpReqFail(int ret)
/*     */   {
/* 211 */     onCourtYardLevelUpReqFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCourtYardLevelUpReqFail(int ret, Map<Object, String> extraMap)
/*     */   {
/* 216 */     StringBuilder sb = new StringBuilder();
/* 217 */     sb.append("[home]PCCourtYardLevelUpReq.processImp@court yard level up fail");
/* 218 */     sb.append("|role_id=").append(this.roleId);
/* 219 */     sb.append("|ret=").append(ret);
/*     */     
/* 221 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 223 */       for (Map.Entry<Object, String> entry : extraMap.entrySet())
/*     */       {
/* 225 */         sb.append("|").append(entry.getKey()).append("=").append((String)entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 229 */     GameServer.logger().error(sb.toString());
/*     */     
/* 231 */     SCommonResultRes sCommonResultRes = new SCommonResultRes();
/* 232 */     sCommonResultRes.res = ret;
/*     */     
/* 234 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PCCourtYardLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */