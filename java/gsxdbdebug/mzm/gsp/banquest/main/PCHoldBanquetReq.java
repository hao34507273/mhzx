/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.banquest.SHoldBanquetRep;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BanquestInfo;
/*     */ import xbean.BanquestSessionInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2banquestinfo;
/*     */ import xtable.Role2banqustsession;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCHoldBanquetReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private long masterId;
/*     */   private long startTime;
/*     */   private int alreadyHoldCount;
/*  38 */   private Map<Long, String> roleidToUserid = new HashMap();
/*     */   
/*  40 */   private List<Long> lockRoleIds = new ArrayList();
/*     */   
/*     */   public PCHoldBanquetReq(long roleId)
/*     */   {
/*  44 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!BanquestManager.isBanquestOpen(this.roleId, true))
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     GameServer.logger().info(String.format("[banquest]PCHoldBanquetReq.processImp@ hold banquest process begin!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */     
/*     */ 
/*  57 */     if (!initDataBeforeGetLock())
/*     */     {
/*  59 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.processImp@ initDataBeforeGetLock error!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     Lockeys.lock(User.getTable(), this.roleidToUserid.values());
/*     */     
/*  66 */     Lockeys.lock(Basic.getTable(), this.lockRoleIds);
/*     */     
/*  68 */     if (!checkAfterGetLock(this.roleidToUserid, this.lockRoleIds))
/*     */     {
/*  70 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.processImp@ checkAfterGetLock error!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(this.masterId));
/*  77 */     if (xBanquestInfo == null)
/*     */     {
/*  79 */       xBanquestInfo = Pod.newBanquestInfo();
/*  80 */       Role2banquestinfo.insert(Long.valueOf(this.masterId), xBanquestInfo);
/*     */     }
/*  82 */     BanquestSessionInfo xBanquestSessionInfo = Role2banqustsession.get(Long.valueOf(this.masterId));
/*  83 */     if (xBanquestSessionInfo == null)
/*     */     {
/*  85 */       xBanquestSessionInfo = Pod.newBanquestSessionInfo();
/*  86 */       Role2banqustsession.insert(Long.valueOf(this.masterId), xBanquestSessionInfo);
/*     */     }
/*     */     
/*  89 */     if (xBanquestInfo.getHoldbanqueststate())
/*     */     {
/*  91 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.processImp@ banquesting!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  92 */       BanquestManager.sendBanquestNotice(this.roleId, false, 6, new String[0]);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     this.alreadyHoldCount = getAlreadyHoldCount(xBanquestInfo, this.startTime);
/*  97 */     if (this.alreadyHoldCount >= BanquestManager.getHoldMaxCount())
/*     */     {
/*  99 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.processImp@ hold count to max!|roleId=%d|alreadyHoldCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.alreadyHoldCount) }));
/*     */       
/*     */ 
/* 102 */       BanquestManager.sendBanquestNotice(this.roleId, false, 4, new String[0]);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     Collection<Long> guestIds = BanquestManager.getBanquestGuyIds(this.roleId);
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
/*     */ 
/*     */ 
/* 122 */     if (!BanquestManager.setHoldBanquestRoleState(this.lockRoleIds))
/*     */     {
/* 124 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.processImp@ setHoldBanquestRoleState err!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     holdBanquestInDB(xBanquestInfo, xBanquestSessionInfo);
/*     */     
/* 131 */     OnlineManager.getInstance().send(this.roleId, new SHoldBanquetRep());
/*     */     
/* 133 */     BanquestManager.synBanquestInfo(this.roleId, guestIds, guestIds.size(), this.startTime);
/*     */     
/* 135 */     BanquestTlogManager.tlogHoldBanquest(this.roleId, xBanquestInfo.getHoldcount(), this.startTime, (String)this.roleidToUserid.get(Long.valueOf(this.masterId)), this.masterId);
/*     */     
/*     */ 
/* 138 */     GameServer.logger().info(String.format("[banquest]PCHoldBanquetReq.processImp@ hold banquest process suc!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */     
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   private boolean initDataBeforeGetLock()
/*     */   {
/* 145 */     this.startTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 147 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId);
/* 148 */     if (marriedRoleId > 0L)
/*     */     {
/* 150 */       String marriedUserId = RoleInterface.getUserId(this.roleId);
/* 151 */       this.roleidToUserid.put(Long.valueOf(marriedRoleId), marriedUserId);
/* 152 */       this.lockRoleIds.add(Long.valueOf(marriedRoleId));
/*     */     }
/* 154 */     String userId = RoleInterface.getUserId(this.roleId);
/* 155 */     this.roleidToUserid.put(Long.valueOf(this.roleId), userId);
/* 156 */     this.lockRoleIds.add(Long.valueOf(this.roleId));
/*     */     
/*     */ 
/* 159 */     this.masterId = BanquestManager.getMasterId(this.roleId, marriedRoleId);
/* 160 */     if (this.masterId <= 0L)
/*     */     {
/* 162 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.processImp@ get master err!|roleId=%d|marriedRoleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */       
/*     */ 
/* 165 */       return false;
/*     */     }
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkAfterGetLock(Map<Long, String> roleidToUserid, List<Long> lockRoleIds)
/*     */   {
/* 172 */     if (lockRoleIds == null)
/*     */     {
/* 174 */       return false;
/*     */     }
/* 176 */     switch (lockRoleIds.size())
/*     */     {
/*     */     case 1: 
/*     */       break;
/*     */     
/*     */     case 2: 
/* 182 */       if (!MarriageInterface.isMarriageRelation(((Long)lockRoleIds.get(0)).longValue(), ((Long)lockRoleIds.get(1)).longValue()))
/*     */       {
/* 184 */         GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.checkAfterGetLock@ not marriage relation!|roleId=%d|lockRoleIds=%s", new Object[] { Long.valueOf(this.roleId), lockRoleIds }));
/*     */         
/*     */ 
/*     */ 
/* 188 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 193 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.checkAfterGetLock@ lock roles' num illegal!|roleId=%d|lockRoleIds=%s", new Object[] { Long.valueOf(this.roleId), lockRoleIds }));
/*     */       
/*     */ 
/*     */ 
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     if (!HomelandInterface.isCurrentHomeCreator(this.masterId))
/*     */     {
/* 202 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.checkAfterGetLock@ not current home creator!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 204 */       BanquestManager.sendBanquestNotice(this.roleId, false, 5, new String[0]);
/* 205 */       return false;
/*     */     }
/*     */     
/* 208 */     if (!HomelandInterface.isAtHome(this.roleId, false))
/*     */     {
/* 210 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.checkAfterGetLock@ not at home!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 212 */       BanquestManager.sendBanquestNotice(this.roleId, false, 5, new String[0]);
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     int roleLv = RoleInterface.getLevel(this.roleId);
/* 217 */     if (roleLv < BanquestManager.getHoldMinRoleLv())
/*     */     {
/* 219 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.checkAfterGetLock@ role lv not enough!|roleId=%d|roleLv=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLv) }));
/*     */       
/*     */ 
/* 222 */       return false;
/*     */     }
/*     */     
/* 225 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData((String)roleidToUserid.get(Long.valueOf(this.masterId)), this.masterId, BanquestManager.getActivityId());
/*     */     
/* 227 */     if (!res.isCanJoin())
/*     */     {
/* 229 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.checkAfterGetLock@ can not hold banquest today!|masterId=%d|roleId=%d|resCode=%d", new Object[] { Long.valueOf(this.masterId), Long.valueOf(this.roleId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 233 */       return false;
/*     */     }
/* 235 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void holdBanquestInDB(BanquestInfo xBanquestInfo, BanquestSessionInfo xBanquestSessionInfo)
/*     */   {
/* 241 */     xBanquestInfo.setLastbanqueststarttime(this.startTime);
/* 242 */     xBanquestInfo.setHoldbanqueststate(true);
/* 243 */     xBanquestInfo.setHoldcount(this.alreadyHoldCount + 1);
/* 244 */     BanquestManager.checkAndInitJoinBanqustData(xBanquestInfo, this.startTime);
/*     */     
/* 246 */     if (xBanquestInfo.getDishescount() < BanquestManager.getDishesMax())
/*     */     {
/* 248 */       PBanquestSession pBanquestSession = new PBanquestSession(BanquestManager.getDishesInterval(), this.masterId, this.startTime);
/* 249 */       xBanquestSessionInfo.setBanquestsessionid(pBanquestSession.getSessionId());
/*     */     }
/*     */     
/* 252 */     PBanquestEndSession endSession = new PBanquestEndSession(BanquestManager.getAllBanquestInterval() / 1000L, this.masterId, this.startTime);
/*     */     
/* 254 */     xBanquestSessionInfo.setBanquestendsessionid(endSession.getSessionId());
/*     */   }
/*     */   
/*     */   private int getAlreadyHoldCount(BanquestInfo xBanquestInfo, long startTime)
/*     */   {
/* 259 */     long lastHoldTime = xBanquestInfo.getLastbanqueststarttime();
/* 260 */     if (!DateTimeUtils.isInSameDay(lastHoldTime, startTime))
/*     */     {
/* 262 */       return 0;
/*     */     }
/* 264 */     return xBanquestInfo.getHoldcount();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PCHoldBanquetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */