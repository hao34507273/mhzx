/*     */ package mzm.gsp.breakegg.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.breakegg.SBreakEggFail;
/*     */ import mzm.gsp.nationalholiday.confbean.SBreakEggCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BreakEggGameInfo;
/*     */ import xbean.BreakEggInfo;
/*     */ import xtable.Breakegg_info;
/*     */ import xtable.Role2breakegg_info;
/*     */ import xtable.Role2drawandguess_info;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBreakEggReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final long inviterId;
/*     */   private final int index;
/*     */   
/*     */   public PCBreakEggReq(long roleId, int activityCfgId, long inviterId, int index)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.activityCfgId = activityCfgId;
/*  34 */     this.inviterId = inviterId;
/*  35 */     this.index = index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     SBreakEggCfg sBreakEggCfg = SBreakEggCfg.get(this.activityCfgId);
/*  44 */     if (sBreakEggCfg == null)
/*     */     {
/*  46 */       onFailed(4);
/*  47 */       return false;
/*     */     }
/*  49 */     if ((this.index < 0) || (this.index >= sBreakEggCfg.totalEggNum))
/*     */     {
/*  51 */       onFailed(4);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!BreakEggManager.isBreakEggSwitchOpen(this.roleId, sBreakEggCfg.openId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     Map<Long, String> roleidToUserid = new HashMap();
/*     */     
/*  61 */     String userId = RoleInterface.getUserId(this.roleId);
/*  62 */     if (userId == null)
/*     */     {
/*  64 */       onFailed(2);
/*  65 */       return false;
/*     */     }
/*  67 */     roleidToUserid.put(Long.valueOf(this.roleId), userId);
/*     */     
/*  69 */     String inviterUserId = RoleInterface.getUserId(this.inviterId);
/*  70 */     if (inviterUserId == null)
/*     */     {
/*  72 */       onFailed(2);
/*  73 */       return false;
/*     */     }
/*  75 */     roleidToUserid.put(Long.valueOf(this.inviterId), inviterUserId);
/*     */     
/*  77 */     lock(User.getTable(), roleidToUserid.values());
/*  78 */     xdb.Lockeys.lock(Role2drawandguess_info.getTable(), roleidToUserid.keySet());
/*     */     
/*     */ 
/*  81 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1865, true, true))
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     Long breakEggId = Role2breakegg_info.get(Long.valueOf(this.roleId));
/*  88 */     if (breakEggId == null)
/*     */     {
/*  90 */       onFailed(7);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     BreakEggGameInfo xBreakEggGameInfo = Breakegg_info.get(breakEggId);
/*     */     
/*  96 */     if (xBreakEggGameInfo == null)
/*     */     {
/*  98 */       onFailed(7);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if (xBreakEggGameInfo.getInviter_id() != this.inviterId)
/*     */     {
/* 104 */       onFailed(4);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if (xBreakEggGameInfo.getIndex2break_egg_info().get(Integer.valueOf(this.index)) != null)
/*     */     {
/* 110 */       onFailed(6);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     int maxBreakNum = BreakEggManager.getMaxBreakNum(this.roleId, xBreakEggGameInfo, sBreakEggCfg);
/* 115 */     int nowBreakNum = BreakEggManager.getNowBreakNum(this.roleId, xBreakEggGameInfo);
/* 116 */     if (nowBreakNum >= maxBreakNum)
/*     */     {
/* 118 */       onFailed(5);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     xBreakEggGameInfo.getRole_id2break_num().put(Long.valueOf(this.roleId), Integer.valueOf(nowBreakNum + 1));
/*     */     
/* 124 */     BreakEggInfo xBreakEggInfo = xbean.Pod.newBreakEggInfo();
/* 125 */     xBreakEggInfo.setRole_id(this.roleId);
/* 126 */     xBreakEggInfo.getItemid2num().putAll(BreakEggManager.getItemRewardInfo(this.inviterId, RoleInterface.getLevel(this.inviterId), ((Integer)xBreakEggGameInfo.getReward_info_id().get(this.index)).intValue()));
/*     */     
/*     */ 
/* 129 */     xBreakEggGameInfo.getIndex2break_egg_info().put(Integer.valueOf(this.index), xBreakEggInfo);
/*     */     
/* 131 */     BreakEggManager.sSynBreakEggRewardIndex(Arrays.asList(new Integer[] { Integer.valueOf(this.index) }), xBreakEggGameInfo);
/*     */     
/*     */ 
/* 134 */     if (BreakEggManager.getNowBreakNum(this.roleId, xBreakEggGameInfo) >= maxBreakNum)
/*     */     {
/* 136 */       checkFinished(xBreakEggGameInfo, sBreakEggCfg);
/*     */     }
/*     */     
/* 139 */     BreakEggManager.logger.info(String.format("[breakegg]PCBreakEggReq.processImp@ success|userId=%s|roleId=%d|activityCfgId=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId) }));
/*     */     
/*     */ 
/* 142 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkFinished(BreakEggGameInfo xBreakEggGameInfo, SBreakEggCfg sBreakEggCfg)
/*     */   {
/* 154 */     for (Iterator i$ = xBreakEggGameInfo.getRoleid_list().iterator(); i$.hasNext();) { long otherRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 156 */       if (otherRoleId != this.roleId)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 161 */         int maxBreakNum = BreakEggManager.getMaxBreakNum(otherRoleId, xBreakEggGameInfo, sBreakEggCfg);
/*     */         
/* 163 */         int nowBreakNum = BreakEggManager.getNowBreakNum(otherRoleId, xBreakEggGameInfo);
/* 164 */         if (maxBreakNum > nowBreakNum)
/*     */         {
/* 166 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 170 */     if (Session.removeSession(xBreakEggGameInfo.getSession_id()) != null)
/*     */     {
/* 172 */       new PGameFinished(xBreakEggGameInfo.getRoleid_list()).execute();
/*     */     }
/* 174 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int errorCode)
/*     */   {
/* 179 */     onFailed(errorCode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int errorCode, Map<String, Object> extraParams)
/*     */   {
/* 190 */     SBreakEggFail rsp = new SBreakEggFail();
/* 191 */     rsp.activity_id = this.activityCfgId;
/* 192 */     rsp.index = this.index;
/* 193 */     rsp.error_code = errorCode;
/* 194 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 196 */     StringBuffer logBuilder = new StringBuffer();
/* 197 */     logBuilder.append("[breakegg]PCBreakEggReq.onFailed@processImp() failed");
/* 198 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 199 */     logBuilder.append('|').append("activityCfgId=").append(this.activityCfgId);
/* 200 */     logBuilder.append('|').append("error_code=").append(errorCode);
/*     */     
/* 202 */     if (extraParams != null)
/*     */     {
/* 204 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 206 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 210 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\PCBreakEggReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */