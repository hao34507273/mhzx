/*     */ package mzm.gsp.massexp.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.massexp.STaskEndFailed;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MassExpInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class ReturnCostObserver extends Observer
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public ReturnCostObserver(long intervalSeconds, long roleid, int activityCfgid)
/*     */   {
/*  24 */     super(intervalSeconds);
/*     */     
/*  26 */     this.roleid = roleid;
/*  27 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  33 */     new POnTaskEnd(this.roleid, this.activityCfgid).execute();
/*  34 */     return false;
/*     */   }
/*     */   
/*     */   private static class POnTaskEnd extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int activityCfgid;
/*     */     
/*     */     public POnTaskEnd(long roleid, int activityCfgid)
/*     */     {
/*  44 */       this.roleid = roleid;
/*  45 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  51 */       if (!MassExpManager.isFunOpen(this.roleid, false))
/*     */       {
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       if (!MassExpManager.canDoAction(this.roleid, 241))
/*     */       {
/*  58 */         return false;
/*     */       }
/*     */       
/*  61 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/*     */ 
/*  64 */       lock(Lockeys.get(User.getTable(), userid));
/*  65 */       MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(this.roleid, this.activityCfgid);
/*  66 */       if (xMassExpInfo == null)
/*     */       {
/*  68 */         onFailed(1);
/*  69 */         return false;
/*     */       }
/*     */       
/*  72 */       if (xMassExpInfo.getStatus() != 1)
/*     */       {
/*  74 */         Map<String, Object> extras = new HashMap();
/*  75 */         extras.put("status", Integer.valueOf(xMassExpInfo.getStatus()));
/*  76 */         extras.put("index", Integer.valueOf(xMassExpInfo.getCur_index()));
/*  77 */         extras.put("start_time", Long.valueOf(xMassExpInfo.getStart_time()));
/*     */         
/*  79 */         onFailed(2, extras);
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       MassExpManager.taskEnd(userid, this.roleid, this.activityCfgid, xMassExpInfo, MassExpInitReason.CLIENT_NOTIFY);
/*     */       
/*  85 */       MassExpManager.stopObserver(this.roleid, this.activityCfgid);
/*     */       
/*  87 */       GameServer.logger().info(String.format("[msssexp]POnTaskEnd.processImp@task end success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  89 */       return true;
/*     */     }
/*     */     
/*     */     private void onFailed(int retcode)
/*     */     {
/*  94 */       onFailed(retcode, null);
/*     */     }
/*     */     
/*     */     private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */     {
/*  99 */       if (retcode < 0)
/*     */       {
/* 101 */         STaskEndFailed resp = new STaskEndFailed();
/* 102 */         resp.retcode = retcode;
/* 103 */         OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */       }
/*     */       
/* 106 */       StringBuffer logBuilder = new StringBuffer();
/* 107 */       logBuilder.append("[massexp]POnTaskEnd.onFailed@task end failed");
/* 108 */       logBuilder.append('|').append("roleid=").append(this.roleid);
/* 109 */       logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 110 */       logBuilder.append('|').append("retcode=").append(retcode);
/*     */       
/* 112 */       if (extraParams != null)
/*     */       {
/* 114 */         for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */         {
/* 116 */           logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */         }
/*     */       }
/*     */       
/* 120 */       GameServer.logger().error(logBuilder.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\ReturnCostObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */