/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoTurnInfo;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleAllLottoActivityInfo;
/*     */ import xbean.RoleAllLottoInfo;
/*     */ import xbean.RoleAllLottoTurnInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_all_lotto_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   
/*     */   public PSendAward(long roleid, int activityCfgid, int turn)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.activityCfgid = activityCfgid;
/*  38 */     this.turn = turn;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     SAllLottoCfg cfg = SAllLottoCfg.get(this.activityCfgid);
/*  45 */     if (cfg == null)
/*     */     {
/*     */ 
/*  48 */       onFail(-3, null);
/*  49 */       return false;
/*     */     }
/*  51 */     SAllLottoTurnInfo turnInfo = (SAllLottoTurnInfo)cfg.turn_infos.get(Integer.valueOf(this.turn));
/*  52 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  55 */       onFail(-3, null);
/*  56 */       return false;
/*     */     }
/*  58 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  60 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  62 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  63 */     RoleAllLottoInfo xRoleAllLottoInfo = Role_all_lotto_infos.get(Long.valueOf(this.roleid));
/*  64 */     if (xRoleAllLottoInfo == null)
/*     */     {
/*     */ 
/*  67 */       onFail(-5, null);
/*  68 */       return false;
/*     */     }
/*  70 */     RoleAllLottoActivityInfo xRoleAllLottoActivityInfo = (RoleAllLottoActivityInfo)xRoleAllLottoInfo.getActivity_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/*  72 */     if (xRoleAllLottoActivityInfo == null)
/*     */     {
/*     */ 
/*  75 */       onFail(-5, null);
/*  76 */       return false;
/*     */     }
/*  78 */     RoleAllLottoTurnInfo xRoleAllLottoTurnInfo = (RoleAllLottoTurnInfo)xRoleAllLottoActivityInfo.getTurn_infos().get(Integer.valueOf(this.turn));
/*  79 */     if (xRoleAllLottoTurnInfo == null)
/*     */     {
/*     */ 
/*  82 */       onFail(-5, null);
/*  83 */       return false;
/*     */     }
/*  85 */     if (xRoleAllLottoTurnInfo.getAward_state() != 1)
/*     */     {
/*     */ 
/*  88 */       Map<String, Object> extraInfo = new HashMap();
/*  89 */       extraInfo.put("award_state", Integer.valueOf(xRoleAllLottoTurnInfo.getAward_state()));
/*  90 */       onFail(-10, extraInfo);
/*  91 */       return false;
/*     */     }
/*  93 */     xRoleAllLottoTurnInfo.setAward_state(2);
/*     */     
/*  95 */     int fixAwardid = turnInfo.fix_award_id;
/*  96 */     if (!AllLottoManager.isAllLottoSwitchOpenForRole(this.roleid))
/*     */     {
/*  98 */       fixAwardid = -1;
/*     */     }
/*     */     else
/*     */     {
/* 102 */       mzm.gsp.award.main.AwardModel awardModel = null;
/* 103 */       if (fixAwardid > 0)
/*     */       {
/* 105 */         awardModel = AwardInterface.getRoleFixAwardModel(fixAwardid, this.roleid, new AwardReason(LogReason.ALL_LOTTO_AWARD, this.activityCfgid));
/*     */       }
/*     */       
/* 108 */       MailAttachment mailAttachment = null;
/* 109 */       if (awardModel != null)
/*     */       {
/* 111 */         mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*     */       }
/*     */       else
/*     */       {
/* 115 */         mailAttachment = new MailAttachment();
/*     */       }
/* 117 */       String formatTurnBeginTimestamp = DateTimeUtils.formatTimestamp(turnInfo.timestamp * 1000L);
/* 118 */       if (!MailInterface.synBuildAndSendMail(this.roleid, cfg.award_mail_cfg_id, new ArrayList(), Arrays.asList(new String[] { formatTurnBeginTimestamp.substring(0, 4), formatTurnBeginTimestamp.substring(4, 6), formatTurnBeginTimestamp.substring(6, 8), formatTurnBeginTimestamp.substring(8, 10), formatTurnBeginTimestamp.substring(10, 12), String.valueOf(AllLottoManager.getFixAwardItemCfgid(this.roleid, fixAwardid)), String.valueOf(0) }), mailAttachment, new TLogArg(LogReason.ALL_LOTTO_AWARD, this.activityCfgid)).isOK())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 129 */         onFail(4, null);
/* 130 */         return false;
/*     */       }
/*     */     }
/* 133 */     GameServer.logger().info(String.format("[alllotto]PSendAward.processImp@send award success|roleid=%d|activity_cfg_id=%d|turn=%d|fix_award_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(fixAwardid) }));
/*     */     
/*     */ 
/*     */ 
/* 137 */     AllLottoTLogManager.addAwardTLog(this.roleid, this.activityCfgid, this.turn, fixAwardid);
/* 138 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 143 */     StringBuilder sb = new StringBuilder();
/* 144 */     sb.append(String.format("[alllotto]PSendAward.processImp@send award fail|roleid=%d|activity_cfg_id=%d|turn=%d|fix_award_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 147 */     if (extraInfo != null)
/*     */     {
/* 149 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 151 */         sb.append("|").append((String)entry.getKey());
/* 152 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 155 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\PSendAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */