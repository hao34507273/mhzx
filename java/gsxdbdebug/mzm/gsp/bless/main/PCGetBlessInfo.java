/*     */ package mzm.gsp.bless.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.bless.SGetBlessInfoSuccess;
/*     */ import mzm.gsp.bless.confbean.SBlessCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PCGetBlessInfo
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetBlessInfo(long roleid, int activityCfgid)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (this.activityCfgid <= 0)
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     SBlessCfg blessCfg = SBlessCfg.get(this.activityCfgid);
/*  36 */     if (blessCfg == null)
/*     */     {
/*  38 */       GameServer.logger().error(String.format("[bless]PCGetBlessInfo.processImp@cfg is null|roleid=%d|activity_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!BlessManager.canDoAction(this.roleid, 1101))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!BlessManager.isFunOpen(this.roleid))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!NpcInterface.checkNpcService(blessCfg.npcCfgid, blessCfg.npcServiceCfgid, this.roleid))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String userid = RoleInterface.getUserId(this.roleid);
/*  60 */     if (userid == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[bless]PCGetBlessInfo.processImp@userid is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  68 */     if (!result.isCanJoin())
/*     */     {
/*  70 */       if (result.isActivityNotOpen())
/*     */       {
/*  72 */         GameServer.logger().error(String.format("[bless]PCGetBlessInfo.processImp@can not join activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*  74 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  78 */     xbean.BlessInfo xBlessInfo = BlessManager.getBlessInfo(this.roleid, this.activityCfgid);
/*  79 */     if (xBlessInfo == null)
/*     */     {
/*  81 */       GameServer.logger().error(String.format("[bless]PCGetBlessInfo.processImp@xbean is null|roleid=%d|activity_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     BlessManager.checkBlessTime(xBlessInfo, DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*  90 */     mzm.gsp.bless.BlessInfo blessInfo = new mzm.gsp.bless.BlessInfo();
/*  91 */     BlessManager.fillBlessInfo(blessInfo, xBlessInfo);
/*     */     
/*  93 */     SGetBlessInfoSuccess rsp = new SGetBlessInfoSuccess();
/*  94 */     rsp.activity_cfgid = this.activityCfgid;
/*  95 */     rsp.bless_info = blessInfo;
/*     */     
/*  97 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/*  99 */     GameServer.logger().info(String.format("[bless]PCGetBlessInfo.processImp@get bless info success|roleid=%d|activity_cfgid=%d|num=%d|last_time=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(xBlessInfo.getNum()), Long.valueOf(xBlessInfo.getLast_time()) }));
/*     */     
/*     */ 
/*     */ 
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bless\main\PCGetBlessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */