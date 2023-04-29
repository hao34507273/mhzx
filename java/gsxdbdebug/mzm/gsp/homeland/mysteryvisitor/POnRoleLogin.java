/*     */ package mzm.gsp.homeland.mysteryvisitor;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorAppear;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorAppearArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Marriage;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     long roleid = ((Long)this.arg).longValue();
/*  38 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpenForRole(roleid))
/*     */     {
/*     */ 
/*  45 */       MysteryVisitorTaskOneByOne.getInstance().add(new PClearMysteryVisitor(roleid));
/*  46 */       onFail(roleid, -1, null);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userid = RoleInterface.getUserId(roleid);
/*  51 */     long partnerid = MarriageInterface.getMarriedRoleid(roleid, false);
/*  52 */     if (partnerid < 0L)
/*     */     {
/*     */ 
/*  55 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  57 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*  58 */       if (MarriageInterface.getMarriedRoleid(roleid, true) >= 0L)
/*     */       {
/*     */ 
/*  61 */         onFail(roleid, 5, null);
/*  62 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  67 */       long marriageid = MarriageInterface.getMarriedId(roleid, false);
/*  68 */       if (marriageid < 0L)
/*     */       {
/*     */ 
/*  71 */         onFail(roleid, 5, null);
/*  72 */         return false;
/*     */       }
/*  74 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */       
/*  76 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */       
/*  78 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(partnerid) }));
/*     */       
/*  80 */       lock(Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/*  81 */       if ((MarriageInterface.getMarriedRoleid(roleid, true) != partnerid) || (MarriageInterface.getMarriedId(roleid, true) != marriageid))
/*     */       {
/*     */ 
/*     */ 
/*  85 */         onFail(roleid, 5, null);
/*  86 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  90 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  92 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  95 */       MysteryVisitorTaskOneByOne.getInstance().add(new PClearMysteryVisitor(roleid));
/*  96 */       Map<String, Object> extraInfo = new HashMap();
/*  97 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  98 */       onFail(roleid, 1, extraInfo);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int courdyardAestheticsDegree = HomelandInterface.getCourtYardBeautiful(roleid);
/* 103 */     if (courdyardAestheticsDegree < 0)
/*     */     {
/*     */ 
/* 106 */       MysteryVisitorTaskOneByOne.getInstance().add(new PClearMysteryVisitor(roleid));
/* 107 */       onFail(roleid, 4, null);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(roleid));
/* 112 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/* 115 */       return false;
/*     */     }
/* 117 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() > 0)
/*     */     {
/*     */ 
/* 120 */       onFail(roleid, 6, null);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     int mysteryVisitorCfgid = MysteryVisitorManager.getMysteryVisitorCfgid(courdyardAestheticsDegree);
/* 125 */     SMysteryVisitorCfg cfg = SMysteryVisitorCfg.get(mysteryVisitorCfgid);
/* 126 */     if (cfg == null)
/*     */     {
/*     */ 
/* 129 */       onFail(roleid, -4, null);
/* 130 */       return false;
/*     */     }
/* 132 */     switch (cfg.type)
/*     */     {
/*     */ 
/*     */     case 1: 
/* 136 */       if (!(cfg instanceof STaskMysteryVisitorCfg))
/*     */       {
/*     */ 
/* 139 */         onFail(roleid, -4, null);
/* 140 */         return false;
/*     */       }
/* 142 */       STaskMysteryVisitorCfg serverCfg = (STaskMysteryVisitorCfg)cfg;
/* 143 */       if (!TaskInterface.isHaveGraphId(roleid, serverCfg.task_graph_id))
/*     */       {
/* 145 */         TaskInterface.activeGraph(Long.valueOf(roleid), serverCfg.task_graph_id);
/*     */       }
/*     */       
/* 148 */       break;
/*     */     
/*     */     case 2: 
/* 151 */       TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorAppear(), new MysteryVisitorAppearArg(roleid));
/*     */       
/*     */ 
/* 154 */       break;
/*     */     
/*     */     case 3: 
/* 157 */       TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorAppear(), new MysteryVisitorAppearArg(roleid));
/*     */       
/*     */ 
/* 160 */       break;
/*     */     
/*     */ 
/*     */     default: 
/* 164 */       onFail(roleid, -4, null);
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(mysteryVisitorCfgid);
/*     */     
/* 170 */     TLogArg tLogArg = new TLogArg(LogReason.MYSTERY_VISITOR_REMIND_MAIL, mysteryVisitorCfgid);
/* 171 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, MysteryVisitorConsts.getInstance().REMIND_MAIL_CFG_ID, null, null, tLogArg);
/*     */     
/* 173 */     if (!sendMailRet.isOK())
/*     */     {
/*     */ 
/* 176 */       onFail(roleid, 7, null);
/* 177 */       return false;
/*     */     }
/*     */     
/* 180 */     StringBuilder sb = new StringBuilder();
/* 181 */     sb.append(String.format("[mysteryvisitor]POnRoleLogin.processImp@login process success|roleid=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(mysteryVisitorCfgid) }));
/*     */     
/*     */ 
/* 184 */     MysteryVisitorManager.logger.info(sb.toString());
/* 185 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(long roleid, int res, Map<String, Object> extraInfo)
/*     */   {
/* 190 */     StringBuilder sb = new StringBuilder();
/* 191 */     sb.append(String.format("[mysteryvisitor]POnRoleLogin.processImp@login process fail|roleid=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(res) }));
/* 192 */     if (extraInfo != null)
/*     */     {
/* 194 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 196 */         sb.append("|").append((String)entry.getKey());
/* 197 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 200 */     MysteryVisitorManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */