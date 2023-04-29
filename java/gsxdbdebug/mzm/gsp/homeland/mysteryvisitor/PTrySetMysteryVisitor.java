/*     */ package mzm.gsp.homeland.mysteryvisitor;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
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
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Marriage;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PTrySetMysteryVisitor
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PTrySetMysteryVisitor(long roleid)
/*     */   {
/*  39 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  48 */       onFail(-1, null);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1141, true))
/*     */     {
/*     */ 
/*  54 */       onFail(-2, null);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  60 */     long partnerid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/*  61 */     if (partnerid < 0L)
/*     */     {
/*     */ 
/*  64 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  66 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  67 */       if (MarriageInterface.getMarriedRoleid(this.roleid, true) >= 0L)
/*     */       {
/*     */ 
/*  70 */         onFail(5, null);
/*  71 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  77 */       long marriageid = MarriageInterface.getMarriedId(this.roleid, false);
/*  78 */       if (marriageid < 0L)
/*     */       {
/*     */ 
/*  81 */         onFail(5, null);
/*  82 */         return false;
/*     */       }
/*  84 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */       
/*  86 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */       
/*  88 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(partnerid) }));
/*     */       
/*  90 */       lock(Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/*  91 */       if ((MarriageInterface.getMarriedRoleid(this.roleid, true) != partnerid) || (MarriageInterface.getMarriedId(this.roleid, true) != marriageid))
/*     */       {
/*     */ 
/*     */ 
/*  95 */         onFail(5, null);
/*  96 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 100 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/* 102 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 105 */       Map<String, Object> extraInfo = new HashMap();
/* 106 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 107 */       onFail(1, extraInfo);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     int courdyardAestheticsDegree = HomelandInterface.getCourtYardBeautiful(this.roleid);
/* 112 */     if (courdyardAestheticsDegree < 0)
/*     */     {
/*     */ 
/* 115 */       onFail(4, null);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(this.roleid));
/* 120 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/* 123 */       return false;
/*     */     }
/* 125 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() > 0)
/*     */     {
/*     */ 
/* 128 */       onFail(6, null);
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     int mysteryVisitorCfgid = MysteryVisitorManager.getMysteryVisitorCfgid(courdyardAestheticsDegree);
/* 133 */     SMysteryVisitorCfg cfg = SMysteryVisitorCfg.get(mysteryVisitorCfgid);
/* 134 */     if (cfg == null)
/*     */     {
/*     */ 
/* 137 */       onFail(-4, null);
/* 138 */       return false;
/*     */     }
/* 140 */     switch (cfg.type)
/*     */     {
/*     */ 
/*     */     case 1: 
/* 144 */       if (!(cfg instanceof STaskMysteryVisitorCfg))
/*     */       {
/*     */ 
/* 147 */         onFail(-4, null);
/* 148 */         return false;
/*     */       }
/* 150 */       STaskMysteryVisitorCfg serverCfg = (STaskMysteryVisitorCfg)cfg;
/* 151 */       if (!TaskInterface.isHaveGraphId(this.roleid, serverCfg.task_graph_id))
/*     */       {
/* 153 */         TaskInterface.activeGraph(Long.valueOf(this.roleid), serverCfg.task_graph_id);
/*     */       }
/*     */       
/* 156 */       break;
/*     */     
/*     */     case 2: 
/* 159 */       TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorAppear(), new MysteryVisitorAppearArg(this.roleid));
/*     */       
/*     */ 
/* 162 */       break;
/*     */     
/*     */     case 3: 
/* 165 */       TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorAppear(), new MysteryVisitorAppearArg(this.roleid));
/*     */       
/*     */ 
/* 168 */       break;
/*     */     
/*     */ 
/*     */     default: 
/* 172 */       onFail(-4, null);
/* 173 */       return false;
/*     */     }
/*     */     
/*     */     
/* 177 */     xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(mysteryVisitorCfgid);
/*     */     
/* 179 */     TLogArg tLogArg = new TLogArg(LogReason.MYSTERY_VISITOR_REMIND_MAIL, mysteryVisitorCfgid);
/* 180 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.roleid, MysteryVisitorConsts.getInstance().REMIND_MAIL_CFG_ID, null, null, tLogArg);
/*     */     
/* 182 */     if (!sendMailRet.isOK())
/*     */     {
/*     */ 
/* 185 */       onFail(7, null);
/* 186 */       return false;
/*     */     }
/*     */     
/* 189 */     StringBuilder sb = new StringBuilder();
/* 190 */     sb.append(String.format("[mysteryvisitor]PTrySetMysteryVisitor.processImp@try set mystery visitor success|roleid=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(mysteryVisitorCfgid) }));
/*     */     
/*     */ 
/* 193 */     MysteryVisitorManager.logger.info(sb.toString());
/* 194 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 199 */     StringBuilder sb = new StringBuilder();
/* 200 */     sb.append(String.format("[mysteryvisitor]PTrySetMysteryVisitor.processImp@try set mystery visitor fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 203 */     if (extraInfo != null)
/*     */     {
/* 205 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 207 */         sb.append("|").append((String)entry.getKey());
/* 208 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 211 */     MysteryVisitorManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\PTrySetMysteryVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */