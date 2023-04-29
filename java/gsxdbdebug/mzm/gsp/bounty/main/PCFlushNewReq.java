/*     */ package mzm.gsp.bounty.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.BountyConsts;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BountyInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2bounty;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCFlushNewReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final boolean useYuan;
/*     */   private final long clientCurYuan;
/*     */   private final long clientNeedYuan;
/*  36 */   private boolean isFrist = false;
/*     */   
/*     */   public PCFlushNewReq(long roleId, boolean useYuan, long clientCurYuan, long clientNeedYuan)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.useYuan = useYuan;
/*  42 */     this.clientCurYuan = clientCurYuan;
/*  43 */     this.clientNeedYuan = clientNeedYuan;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     GameServer.logger().info("hahaha");
/*  50 */     if (!BountyManager.isBountyOpen(this.roleId))
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 205, true))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String userid = RoleInterface.getUserId(this.roleId);
/*  60 */     lock(Lockeys.get(User.getTable(), userid));
/*  61 */     Map<Long, String> roleidToUserid = new HashMap();
/*     */     
/*  63 */     BountyInfo xBountyInfo = Role2bounty.get(Long.valueOf(this.roleId));
/*  64 */     if (xBountyInfo == null)
/*     */     {
/*  66 */       int level = RoleInterface.getLevel(this.roleId);
/*  67 */       SActivityCfg sg = ActivityInterface.getActivityCfg(BountyConsts.getInstance().ACTIVITYID);
/*  68 */       if (sg == null)
/*     */       {
/*  70 */         return false;
/*     */       }
/*  72 */       if (level < sg.levelMin)
/*     */       {
/*  74 */         return false;
/*     */       }
/*     */       
/*  77 */       xBountyInfo = BountyManager.createBountyXTable(this.roleId);
/*  78 */       this.isFrist = true;
/*     */     }
/*     */     
/*  81 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), BountyConsts.getInstance().ACTIVITYID);
/*     */     
/*  83 */     if (!res.isCanJoin())
/*     */     {
/*  85 */       GameServer.logger().error(String.format("[bounty]PCFlushNewReq.processImp@ refuse join activity!|roleId=%d|resCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     if (xBountyInfo.getBountycount() >= BountyConsts.getInstance().DAY_UPPER_LIMIT)
/*     */     {
/*  94 */       BountyManager.sendNormalResult(this.roleId, 11, new String[0]);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (BountyManager.isHaveBGraph(this.roleId))
/*     */     {
/* 100 */       BountyManager.sendNormalResult(this.roleId, 10, new String[0]);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     int needBirdNum = BountyManager.rmGoldBird(userid, this.roleId, xBountyInfo, this.isFrist, this.useYuan, this.clientCurYuan, this.clientNeedYuan);
/* 105 */     if (needBirdNum < 0)
/*     */     {
/* 107 */       GameServer.logger().error(String.format("[bounty]PCFlushNewReq.processImp@ rmGoldBird err!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 108 */       return false;
/*     */     }
/* 110 */     if (!BountyManager.refreshNewBountyTasks(this.roleId, xBountyInfo, needGetOneSpecialTask(needBirdNum, xBountyInfo)))
/*     */     {
/* 112 */       GameServer.logger().error(String.format("[bounty]PCFlushNewReq.processImp@ flushNewBountyTasks err!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 114 */       return false;
/*     */     }
/* 116 */     BountyManager.synBountyInfo(this.roleId, xBountyInfo);
/* 117 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean needGetOneSpecialTask(int needBirdNum, BountyInfo xBountyInfo)
/*     */   {
/* 130 */     if (!OpenInterface.getOpenStatus(308))
/*     */     {
/* 132 */       return false;
/*     */     }
/* 134 */     int useBirdNum = xBountyInfo.getUsedbirdnum();
/* 135 */     int freeCount = xBountyInfo.getFreerefreshcount();
/* 136 */     if (needBirdNum > 0)
/*     */     {
/* 138 */       useBirdNum += needBirdNum;
/*     */ 
/*     */ 
/*     */     }
/* 142 */     else if (needBirdNum == 0)
/*     */     {
/* 144 */       freeCount++;
/*     */     }
/*     */     else
/*     */     {
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     xBountyInfo.setFreerefreshcount(freeCount);
/* 152 */     xBountyInfo.setUsedbirdnum(useBirdNum);
/*     */     
/* 154 */     return BountyManager.needGetSpecialTask(xBountyInfo, useBirdNum, freeCount);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\PCFlushNewReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */