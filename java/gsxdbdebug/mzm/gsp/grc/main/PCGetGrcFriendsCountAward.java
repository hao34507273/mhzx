/*     */ package mzm.gsp.grc.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grc.SGetGrcFriendsCountAwardFailed;
/*     */ import mzm.gsp.grc.SGetGrcFriendsCountAwardSuccess;
/*     */ import mzm.gsp.grc.confbean.SGrcFriendsCountAwardCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PCGetGrcFriendsCountAward extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int awardSerialNo;
/*     */   
/*     */   public PCGetGrcFriendsCountAward(long roleid, int awardSerialNo)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.awardSerialNo = awardSerialNo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     String userid = RoleInterface.getUserId(this.roleid);
/*  32 */     if (userid == null)
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (!GrcManager.canDoAction(this.roleid, 292))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     SGrcFriendsCountAwardCfg cfg = SGrcFriendsCountAwardCfg.get(this.awardSerialNo);
/*  43 */     if (cfg == null)
/*     */     {
/*  45 */       onFailed(-100, userid);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     xbean.User xUser = xtable.User.get(userid);
/*  50 */     if (xUser == null)
/*     */     {
/*  52 */       onFailed(-101, userid);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (this.awardSerialNo != xUser.getGrc_friends_count_award_serial_no() + 1)
/*     */     {
/*  58 */       onFailed(-1, userid);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (xUser.getGrc_friends_count() < cfg.need_count)
/*     */     {
/*  64 */       onFailed(-2, userid);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     AwardReason grcFriendsCountAwardReason = new AwardReason(LogReason.GRC_FRIENDS_COUNT_AWARD_ADD, PresentType.PRESENT_BIND_GRC_FRIENDS_COUNT_AWARD);
/*     */     
/*  70 */     AwardModel awardModel = AwardInterface.awardFixAward(cfg.award_cfg_id, userid, this.roleid, true, true, grcFriendsCountAwardReason);
/*     */     
/*  72 */     if (awardModel == null)
/*     */     {
/*  74 */       onFailed(-3, userid);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     xUser.setGrc_friends_count_award_serial_no(this.awardSerialNo);
/*     */     
/*  81 */     SGetGrcFriendsCountAwardSuccess resp = new SGetGrcFriendsCountAwardSuccess();
/*  82 */     resp.award_serial_no = this.awardSerialNo;
/*  83 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/*  85 */     GameServer.logger().info(String.format("[grc]PCGetGrcFriendsCountAward.onFailed@get grc friends count award success|roleid=%d|userid=%s|award_serial_no=%d|award_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), userid, Integer.valueOf(this.awardSerialNo), Integer.valueOf(cfg.award_cfg_id) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, String userid)
/*     */   {
/*  95 */     if (retcode < 0)
/*     */     {
/*  97 */       SGetGrcFriendsCountAwardFailed resp = new SGetGrcFriendsCountAwardFailed();
/*  98 */       resp.retcode = retcode;
/*  99 */       resp.award_serial_no = this.awardSerialNo;
/* 100 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 103 */     GameServer.logger().info(String.format("[grc]PCGetGrcFriendsCountAward.onFailed@get grc friends count award failed|roleid=%d|userid=%s|award_serial_no=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), userid, Integer.valueOf(this.awardSerialNo), Integer.valueOf(retcode) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetGrcFriendsCountAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */