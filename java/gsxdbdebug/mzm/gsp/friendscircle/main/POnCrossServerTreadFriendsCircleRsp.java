/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*     */ import mzm.gsp.friendscircle.STreadFriendsCircleSuccess;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleTread;
/*     */ import mzm.gsp.friendscircle.event.FriendsCircleTreadArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleTread;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnCrossServerTreadFriendsCircleRsp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final int result;
/*     */   private final boolean isTriggerBox;
/*     */   private final int addPopularityValue;
/*     */   private final int currentWeekPopularityValue;
/*     */   private final int currentTotalPopularityValue;
/*     */   private final long activeRoleId;
/*     */   private final int beTrodRoleZoneId;
/*     */   private final long beTrodRoleId;
/*     */   private final long serialId;
/*     */   private final int beTreadOwnTreasureBoxNum;
/*     */   private final byte isAutoTread;
/*     */   
/*     */   public POnCrossServerTreadFriendsCircleRsp(byte result, byte isTriggerBox, int addPopularityValue, int currentWeekPopularityValue, int currentTotalPopularityValue, long activeRoleId, int beTrodRoleZoneId, long beTrodRoleId, long serialId, int beTreadOwnTreasureBoxNum, byte isAutoTread)
/*     */   {
/*  50 */     this.result = result;
/*  51 */     this.isTriggerBox = (isTriggerBox == 1);
/*  52 */     this.addPopularityValue = addPopularityValue;
/*  53 */     this.currentWeekPopularityValue = currentWeekPopularityValue;
/*  54 */     this.currentTotalPopularityValue = currentTotalPopularityValue;
/*  55 */     this.activeRoleId = activeRoleId;
/*  56 */     this.beTrodRoleZoneId = beTrodRoleZoneId;
/*  57 */     this.beTrodRoleId = beTrodRoleId;
/*  58 */     this.serialId = serialId;
/*  59 */     this.beTreadOwnTreasureBoxNum = beTreadOwnTreasureBoxNum;
/*  60 */     this.isAutoTread = isAutoTread;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  66 */     String activeUserId = RoleInterface.getUserId(this.activeRoleId);
/*  67 */     if (activeUserId == null)
/*     */     {
/*  69 */       onCrossServerTreadFriendsCircleRspFail(6);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (this.result == 1)
/*     */     {
/*  75 */       onCrossServerTreadFriendsCircleRspFail(19);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if ((this.result != 0) && (this.result != 3))
/*     */     {
/*  81 */       onCrossServerTreadFriendsCircleRspFail(31);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     lock(Lockeys.get(User.getTable(), activeUserId));
/*  86 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.activeRoleId);
/*     */     
/*  88 */     CrossServerFriendsCircleTread xFriendsCircleTread = (CrossServerFriendsCircleTread)xRole2FriendsCircleInfo.getCross_server_tread().get(Long.valueOf(this.serialId));
/*     */     
/*  90 */     if (xFriendsCircleTread == null)
/*     */     {
/*  92 */       onCrossServerTreadFriendsCircleRspFail(32);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if ((xFriendsCircleTread.getBe_trod_role_id() != this.beTrodRoleId) || (xFriendsCircleTread.getBe_trod_role_zone_id() != this.beTrodRoleZoneId))
/*     */     {
/*     */ 
/*  99 */       onCrossServerTreadFriendsCircleRspFail(33);
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (xFriendsCircleTread.getIs_server_replied())
/*     */     {
/* 105 */       onCrossServerTreadFriendsCircleRspFail(34);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if (this.isTriggerBox)
/*     */     {
/* 111 */       AwardModel awardModel = AwardInterface.awardFixAward(SFriendsCircleConsts.getInstance().treasure_box_award_fix_id, activeUserId, this.activeRoleId, false, false, new AwardReason(LogReason.FRIENDS_CIRCLE_TRIGGER_TREASURE_BOX_AWARD));
/*     */       
/*     */ 
/* 114 */       if (awardModel == null)
/*     */       {
/* 116 */         onCrossServerTreadFriendsCircleRspFail(21);
/* 117 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 121 */       FriendsCircleManager.addTodayGetTreasureBoxNum(xRole2FriendsCircleInfo, 1);
/*     */     }
/*     */     
/* 124 */     boolean isCanGetMoreTriggerBox = FriendsCircleManager.getTodayGetTreasureBoxNum(xRole2FriendsCircleInfo) < SFriendsCircleConsts.getInstance().max_treasure_box_num_get_every_day;
/*     */     
/* 126 */     TriggerEventsManger.getInstance().triggerEvent(new FriendsCircleTread(), new FriendsCircleTreadArg(this.activeRoleId, this.beTrodRoleId, this.isTriggerBox, this.beTreadOwnTreasureBoxNum > 0, isCanGetMoreTriggerBox), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.activeRoleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */     RoleStatusInterface.unsetStatus(this.activeRoleId, 1827);
/*     */     
/* 134 */     STreadFriendsCircleSuccess sTreadFriendsCircleSuccess = new STreadFriendsCircleSuccess();
/* 135 */     sTreadFriendsCircleSuccess.is_trigger_box = (this.isTriggerBox ? 1 : 0);
/* 136 */     sTreadFriendsCircleSuccess.be_trod_role_id = this.beTrodRoleId;
/* 137 */     sTreadFriendsCircleSuccess.add_popularity_total_value = this.addPopularityValue;
/* 138 */     sTreadFriendsCircleSuccess.popularity_week_value = this.currentWeekPopularityValue;
/* 139 */     sTreadFriendsCircleSuccess.popularity_total_value = this.currentTotalPopularityValue;
/* 140 */     sTreadFriendsCircleSuccess.is_auto_tread = this.isAutoTread;
/*     */     
/* 142 */     OnlineManager.getInstance().send(this.activeRoleId, sTreadFriendsCircleSuccess);
/*     */     
/* 144 */     xFriendsCircleTread.setIs_server_replied(true);
/*     */     
/* 146 */     StringBuilder sbLog = new StringBuilder();
/* 147 */     sbLog.append("[friendscircle]POnCrossServerTreadFriendsCircleRsp.processImp@tread friends circle success");
/* 148 */     sbLog.append("|result=").append(this.result);
/* 149 */     sbLog.append("|is_trigger_box=").append(this.isTriggerBox);
/* 150 */     sbLog.append("|serial=").append(this.serialId);
/* 151 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/* 152 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 153 */     sbLog.append("|be_trod_role_zone_id=").append(this.beTrodRoleZoneId);
/*     */     
/* 155 */     GameServer.logger().info(sbLog.toString());
/*     */     
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   private void onCrossServerTreadFriendsCircleRspFail(int ret)
/*     */   {
/* 162 */     onCrossServerTreadFriendsCircleRspFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCrossServerTreadFriendsCircleRspFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 167 */     new PCTreadFriendsCircle.PUnSetCrossServerTread(this.activeRoleId).execute();
/*     */     
/* 169 */     StringBuilder sbLog = new StringBuilder();
/* 170 */     sbLog.append("[friendscircle]POnCrossServerTreadFriendsCircleRsp.processImp@tread friends circle failed");
/* 171 */     sbLog.append("|ret=").append(ret);
/* 172 */     sbLog.append("|result=").append(this.result);
/* 173 */     sbLog.append("|is_trigger_box=").append(this.isTriggerBox);
/* 174 */     sbLog.append("|serial=").append(this.serialId);
/* 175 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/* 176 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/* 177 */     sbLog.append("|be_trod_role_zone_id=").append(this.beTrodRoleZoneId);
/*     */     
/* 179 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 181 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 183 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 186 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 188 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 189 */     sFriendsCircleNormalRes.ret = ret;
/*     */     
/* 191 */     OnlineManager.getInstance().sendAtOnce(this.activeRoleId, sFriendsCircleNormalRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerTreadFriendsCircleRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */