/*     */ package mzm.gsp.qiuqian.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qiuqian.SQiuQianFail;
/*     */ import mzm.gsp.qiuqian.SQiuQianSuccess;
/*     */ import mzm.gsp.qiuqian.confbean.SQianWenInfo;
/*     */ import mzm.gsp.qiuqian.confbean.SQiuQianCfg;
/*     */ import mzm.gsp.qiuqian.event.QiuQianSuccess;
/*     */ import mzm.gsp.qiuqian.event.QiuQianSuccessArg;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class PCQiuQian
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int qiuqianid;
/*     */   private final long sessionid;
/*     */   
/*     */   public PCQiuQian(long roleid, int qiuqianid, long sessionid)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.qiuqianid = qiuqianid;
/*  32 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     SQiuQianCfg cfg = SQiuQianCfg.get(this.qiuqianid);
/*  39 */     if (cfg == null)
/*     */     {
/*  41 */       onFail(-3, null);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!QiuQianManager.isQiuQianSwitchOpenForRole(this.roleid, this.qiuqianid))
/*     */     {
/*     */ 
/*  48 */       onFail(-1, null);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!QiuQianManager.checkRoleStatus(this.roleid, 726))
/*     */     {
/*     */ 
/*  54 */       onFail(-2, null);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     Session session = Session.getSession(this.sessionid);
/*  59 */     if (session == null)
/*     */     {
/*     */ 
/*  62 */       onFail(1, null);
/*  63 */       return false;
/*     */     }
/*  65 */     QiuQianVaildSession qiuQianVaildSession = null;
/*  66 */     if ((session instanceof QiuQianVaildSession))
/*     */     {
/*  68 */       qiuQianVaildSession = (QiuQianVaildSession)session;
/*     */     }
/*  70 */     if ((qiuQianVaildSession == null) || (qiuQianVaildSession.getOwerId() != this.roleid) || (qiuQianVaildSession.getQiuQianid() != this.qiuqianid))
/*     */     {
/*     */ 
/*     */ 
/*  74 */       onFail(2, null);
/*  75 */       return false;
/*     */     }
/*  77 */     Session.removeSession(this.sessionid, this.roleid);
/*     */     
/*     */ 
/*  80 */     SQianWenInfo qianWenInfo = (SQianWenInfo)cfg.qianwen_infos.ceilingEntry(Integer.valueOf(1 + Xdb.random().nextInt(10000))).getValue();
/*     */     
/*     */ 
/*  83 */     TriggerEventsManger.getInstance().triggerEvent(new QiuQianSuccess(), new QiuQianSuccessArg(this.roleid, this.qiuqianid, qianWenInfo.point), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/*  87 */     SQiuQianSuccess protocol = new SQiuQianSuccess();
/*  88 */     protocol.qiuqian_id = this.qiuqianid;
/*  89 */     protocol.sort_id = qianWenInfo.sort_id;
/*  90 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  92 */     StringBuilder sb = new StringBuilder();
/*  93 */     sb.append(String.format("[qiuqian]PCQiuQian.processImp@qiu qian success|roleid=%d|qiuqianid=%d|sessionid=%d|sortid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.qiuqianid), Long.valueOf(this.sessionid), Integer.valueOf(qianWenInfo.sort_id) }));
/*     */     
/*  95 */     QiuQianManager.logger.info(sb.toString());
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 101 */     StringBuilder sb = new StringBuilder();
/* 102 */     sb.append(String.format("[qiuqian]PCQiuQian.processImp@qiu qian fail|roleid=%d|qiuqianid=%d|sessionid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.qiuqianid), Long.valueOf(this.sessionid), Integer.valueOf(res) }));
/*     */     
/* 104 */     if (extraInfo != null)
/*     */     {
/* 106 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 108 */         sb.append("|").append((String)entry.getKey());
/* 109 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 112 */     QiuQianManager.logger.info(sb.toString());
/* 113 */     if (res > 0)
/*     */     {
/* 115 */       SQiuQianFail protocol = new SQiuQianFail();
/* 116 */       protocol.res = res;
/* 117 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\main\PCQiuQian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */