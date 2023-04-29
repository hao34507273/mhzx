/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.indiana.SNotifyRoleGetIndianaAward;
/*     */ import mzm.gsp.indiana.SRoleGetIndianaAwardBrd;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaConsts;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.indiana.event.RoleGetIndianaAward;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaAwardRoleInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Indiana_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendAwardAndBulletin extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   private final int sortid;
/*     */   private final int number;
/*     */   
/*     */   public PSendAwardAndBulletin(long roleid, int activityCfgid, int turn, int sortid, int number)
/*     */   {
/*  47 */     this.roleid = roleid;
/*  48 */     this.activityCfgid = activityCfgid;
/*  49 */     this.turn = turn;
/*  50 */     this.sortid = sortid;
/*  51 */     this.number = number;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  57 */     SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  58 */     if (cfg == null)
/*     */     {
/*     */ 
/*  61 */       onFail(-3, null);
/*  62 */       return false;
/*     */     }
/*  64 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(this.turn));
/*  65 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  68 */       onFail(-3, null);
/*  69 */       return false;
/*     */     }
/*  71 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(this.sortid));
/*  72 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  75 */       onFail(-3, null);
/*  76 */       return false;
/*     */     }
/*  78 */     long turnBeginTimestamp = IndianaManager.getTurnBeginTimestamp(this.activityCfgid, this.turn);
/*  79 */     long turnEndTimestamp = IndianaManager.getTurnEndTimestamp(this.activityCfgid, this.turn);
/*  80 */     if ((turnBeginTimestamp < 0L) || (turnEndTimestamp < 0L))
/*     */     {
/*     */ 
/*  83 */       onFail(-3, null);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  89 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  91 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  93 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  94 */     lock(Indiana_infos.getTable(), Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*     */     
/*  96 */     IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  97 */     if (xIndianaInfo == null)
/*     */     {
/*     */ 
/* 100 */       onFail(-5, null);
/* 101 */       return false;
/*     */     }
/* 103 */     IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(this.turn));
/* 104 */     if (xIndianaTurnInfo == null)
/*     */     {
/*     */ 
/* 107 */       onFail(-5, null);
/* 108 */       return false;
/*     */     }
/* 110 */     IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(this.sortid));
/* 111 */     if (xIndianaAwardInfo == null)
/*     */     {
/*     */ 
/* 114 */       onFail(-5, null);
/* 115 */       return false;
/*     */     }
/* 117 */     IndianaAwardRoleInfo xIndianaAwardRoleInfo = (IndianaAwardRoleInfo)xIndianaAwardInfo.getAward_number_infos().get(Integer.valueOf(this.number));
/* 118 */     if (xIndianaAwardRoleInfo == null)
/*     */     {
/*     */ 
/* 121 */       onFail(-5, null);
/* 122 */       return false;
/*     */     }
/* 124 */     if (xIndianaAwardRoleInfo.getAward_state() != 0)
/*     */     {
/*     */ 
/* 127 */       Map<String, Object> extraInfo = new HashMap();
/* 128 */       extraInfo.put("award_state", Integer.valueOf(xIndianaAwardRoleInfo.getAward_state()));
/* 129 */       onFail(-7, extraInfo);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     String formatTurnBeginTimestamp = DateTimeUtils.formatTimestamp(turnBeginTimestamp);
/*     */     
/* 135 */     int fix_award_id = awardInfo.fix_award_id;
/* 136 */     if (!IndianaManager.isIndianaSwitchOpenForRole(this.roleid))
/*     */     {
/* 138 */       fix_award_id = -1;
/*     */     }
/*     */     else
/*     */     {
/* 142 */       mzm.gsp.award.main.AwardModel awardModel = null;
/* 143 */       if (fix_award_id > 0)
/*     */       {
/* 145 */         awardModel = AwardInterface.getRoleFixAwardModel(fix_award_id, this.roleid, new AwardReason(LogReason.INDIANA_AWARD, this.activityCfgid));
/*     */       }
/*     */       
/* 148 */       MailAttachment mailAttachment = null;
/* 149 */       if (awardModel != null)
/*     */       {
/* 151 */         mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*     */       }
/*     */       else
/*     */       {
/* 155 */         mailAttachment = new MailAttachment();
/*     */       }
/* 157 */       if (!mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.roleid, SIndianaConsts.getInstance().AWARD_MAIL_CFG_ID, new ArrayList(), Arrays.asList(new String[] { formatTurnBeginTimestamp.substring(0, 4), formatTurnBeginTimestamp.substring(4, 6), formatTurnBeginTimestamp.substring(6, 8), String.valueOf(turnInfo.diaplay_turn), String.valueOf(IndianaManager.getFixAwardItemCfgid(this.roleid, fix_award_id)), String.valueOf(0) }), mailAttachment, new TLogArg(LogReason.INDIANA_AWARD, this.activityCfgid)).isOK())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 167 */         onFail(9, null);
/* 168 */         return false;
/*     */       }
/*     */       
/* 171 */       SNotifyRoleGetIndianaAward protocol = new SNotifyRoleGetIndianaAward();
/* 172 */       protocol.activity_cfg_id = this.activityCfgid;
/* 173 */       protocol.turn = this.turn;
/* 174 */       protocol.sortid = this.sortid;
/* 175 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     }
/* 177 */     xIndianaAwardRoleInfo.setAward_state(1);
/*     */     
/*     */ 
/* 180 */     if ((xIndianaAwardRoleInfo.getRole_name() == null) || (xIndianaAwardRoleInfo.getRole_name().isEmpty()))
/*     */     {
/* 182 */       String roleName = RoleInterface.getName(this.roleid);
/* 183 */       xIndianaAwardRoleInfo.setRole_name(roleName);
/* 184 */       if ((IndianaManager.isIndianaSwitchOpen()) && (awardInfo.need_bulletin))
/*     */       {
/* 186 */         SRoleGetIndianaAwardBrd protocol = new SRoleGetIndianaAwardBrd();
/* 187 */         protocol.activity_cfg_id = this.activityCfgid;
/* 188 */         protocol.turn = this.turn;
/* 189 */         protocol.sortid = this.sortid;
/* 190 */         protocol.roleid = this.roleid;
/* 191 */         protocol.role_name.setString(roleName, "UTF-8");
/* 192 */         OnlineManager.getInstance().sendAll(protocol);
/*     */       }
/*     */     }
/* 195 */     xIndianaAwardInfo.getNeed_broadcast_numbers().add(Integer.valueOf(this.number));
/*     */     
/* 197 */     GameServer.logger().info(String.format("[indiana]PSendAwardAndBulletin.processImp@send award and bulletin success|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d|fix_award_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid), Integer.valueOf(this.number), Integer.valueOf(fix_award_id) }));
/*     */     
/*     */ 
/*     */ 
/* 201 */     IndianaTLogManager.addAwardTLog(this.roleid, this.activityCfgid, this.turn, this.sortid, this.number, fix_award_id);
/* 202 */     TriggerEventsManger.getInstance().triggerEvent(new RoleGetIndianaAward(), new mzm.gsp.indiana.event.RoleGetIndianaAwardArg(this.roleid, this.activityCfgid, this.turn, this.sortid, fix_award_id));
/*     */     
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 209 */     StringBuilder sb = new StringBuilder();
/* 210 */     sb.append(String.format("[indiana]PSendAwardAndBulletin.processImp@send award and bulletin fail|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid), Integer.valueOf(this.number), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 213 */     if (extraInfo != null)
/*     */     {
/* 215 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 217 */         sb.append("|").append((String)entry.getKey());
/* 218 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 221 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\PSendAwardAndBulletin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */