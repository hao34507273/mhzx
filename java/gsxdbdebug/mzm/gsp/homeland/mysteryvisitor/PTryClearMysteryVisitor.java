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
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappear;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappearArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Marriage;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PTryClearMysteryVisitor
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PTryClearMysteryVisitor(long roleid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  44 */       onFail(-1, null);
/*  45 */       return false;
/*     */     }
/*  47 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1141, true))
/*     */     {
/*     */ 
/*  50 */       onFail(-2, null);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  56 */     long partnerid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/*  57 */     if (partnerid < 0L)
/*     */     {
/*     */ 
/*  60 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  62 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  63 */       if (MarriageInterface.getMarriedRoleid(this.roleid, true) >= 0L)
/*     */       {
/*     */ 
/*  66 */         onFail(5, null);
/*  67 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  73 */       long marriageid = MarriageInterface.getMarriedId(this.roleid, false);
/*  74 */       if (marriageid < 0L)
/*     */       {
/*     */ 
/*  77 */         onFail(5, null);
/*  78 */         return false;
/*     */       }
/*  80 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */       
/*  82 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */       
/*  84 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(partnerid) }));
/*     */       
/*  86 */       lock(Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/*  87 */       if ((MarriageInterface.getMarriedRoleid(this.roleid, true) != partnerid) || (MarriageInterface.getMarriedId(this.roleid, true) != marriageid))
/*     */       {
/*     */ 
/*     */ 
/*  91 */         onFail(5, null);
/*  92 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  96 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  98 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 101 */       Map<String, Object> extraInfo = new HashMap();
/* 102 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 103 */       onFail(1, extraInfo);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(this.roleid));
/* 108 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/* 111 */       return false;
/*     */     }
/* 113 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() <= 0)
/*     */     {
/*     */ 
/* 116 */       onFail(3, null);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     int courdyardAestheticsDegree = HomelandInterface.getCourtYardBeautiful(this.roleid);
/* 121 */     if (courdyardAestheticsDegree >= 0)
/*     */     {
/*     */ 
/* 124 */       onFail(8, null);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     int mysteryVisitorCfgid = xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id();
/* 129 */     SMysteryVisitorCfg cfg = SMysteryVisitorCfg.get(mysteryVisitorCfgid);
/* 130 */     if (cfg == null)
/*     */     {
/*     */ 
/* 133 */       onFail(-4, null);
/* 134 */       return false;
/*     */     }
/* 136 */     switch (cfg.type)
/*     */     {
/*     */ 
/*     */     case 1: 
/* 140 */       if (!(cfg instanceof STaskMysteryVisitorCfg))
/*     */       {
/*     */ 
/* 143 */         onFail(-4, null);
/* 144 */         return false;
/*     */       }
/* 146 */       STaskMysteryVisitorCfg serverCfg = (STaskMysteryVisitorCfg)cfg;
/* 147 */       if (TaskInterface.isHaveGraphId(this.roleid, serverCfg.task_graph_id))
/*     */       {
/* 149 */         TaskInterface.closeActivityGraphWithoutEvent(this.roleid, serverCfg.task_graph_id);
/*     */       }
/*     */       
/*     */ 
/*     */       break;
/*     */     case 2: 
/*     */     case 3: 
/* 156 */       TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorDisappear(), new MysteryVisitorDisappearArg(this.roleid));
/*     */       
/* 158 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     default: 
/* 163 */       onFail(-4, null);
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(-1);
/*     */     
/* 169 */     StringBuilder sb = new StringBuilder();
/* 170 */     sb.append(String.format("[mysteryvisitor]PTryClearMysteryVisitor.processImp@try clear mystery visitor success|roleid=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(mysteryVisitorCfgid) }));
/*     */     
/*     */ 
/* 173 */     MysteryVisitorManager.logger.info(sb.toString());
/* 174 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 179 */     StringBuilder sb = new StringBuilder();
/* 180 */     sb.append(String.format("[mysteryvisitor]PTryClearMysteryVisitor.processImp@try clear mystery visitor fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 183 */     if (extraInfo != null)
/*     */     {
/* 185 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 187 */         sb.append("|").append((String)entry.getKey());
/* 188 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 191 */     MysteryVisitorManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\PTryClearMysteryVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */