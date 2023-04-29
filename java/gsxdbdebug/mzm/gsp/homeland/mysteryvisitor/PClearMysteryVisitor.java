/*     */ package mzm.gsp.homeland.mysteryvisitor;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappear;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappearArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PClearMysteryVisitor
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PClearMysteryVisitor(long roleid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  35 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  37 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  39 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(this.roleid));
/*  40 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/*  43 */       onFail(3, null);
/*  44 */       return false;
/*     */     }
/*  46 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() <= 0)
/*     */     {
/*     */ 
/*  49 */       onFail(3, null);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     int mysteryVisitorCfgid = xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id();
/*  54 */     SMysteryVisitorCfg cfg = SMysteryVisitorCfg.get(mysteryVisitorCfgid);
/*  55 */     if (cfg == null)
/*     */     {
/*     */ 
/*  58 */       onFail(-4, null);
/*  59 */       return false;
/*     */     }
/*  61 */     switch (cfg.type)
/*     */     {
/*     */ 
/*     */     case 1: 
/*  65 */       if (!(cfg instanceof STaskMysteryVisitorCfg))
/*     */       {
/*     */ 
/*  68 */         onFail(-4, null);
/*  69 */         return false;
/*     */       }
/*  71 */       STaskMysteryVisitorCfg serverCfg = (STaskMysteryVisitorCfg)cfg;
/*  72 */       if (TaskInterface.isHaveGraphId(this.roleid, serverCfg.task_graph_id))
/*     */       {
/*  74 */         TaskInterface.closeActivityGraphWithoutEvent(this.roleid, serverCfg.task_graph_id);
/*     */       }
/*     */       
/*     */ 
/*     */       break;
/*     */     case 2: 
/*     */     case 3: 
/*  81 */       TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorDisappear(), new MysteryVisitorDisappearArg(this.roleid));
/*     */       
/*  83 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     default: 
/*  88 */       onFail(-4, null);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(-1);
/*     */     
/*  94 */     StringBuilder sb = new StringBuilder();
/*  95 */     sb.append(String.format("[mysteryvisitor]PClearMysteryVisitor.processImp@clear mystery visitor success|roleid=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(mysteryVisitorCfgid) }));
/*     */     
/*     */ 
/*  98 */     MysteryVisitorManager.logger.info(sb.toString());
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 104 */     StringBuilder sb = new StringBuilder();
/* 105 */     sb.append(String.format("[mysteryvisitor]PClearMysteryVisitor.processImp@clear mystery visitor fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/* 107 */     if (extraInfo != null)
/*     */     {
/* 109 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 111 */         sb.append("|").append((String)entry.getKey());
/* 112 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 115 */     MysteryVisitorManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\PClearMysteryVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */