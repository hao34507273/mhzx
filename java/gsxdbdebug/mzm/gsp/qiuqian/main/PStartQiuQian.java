/*    */ package mzm.gsp.qiuqian.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qiuqian.SStartQiuQian;
/*    */ import mzm.gsp.qiuqian.confbean.SQiuQianCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStartQiuQian
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int qiuqianid;
/*    */   
/*    */   public PStartQiuQian(long roleid, int qiuqianid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.qiuqianid = qiuqianid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     SQiuQianCfg cfg = SQiuQianCfg.get(this.qiuqianid);
/* 30 */     if (cfg == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!QiuQianManager.isQiuQianSwitchOpenForRole(this.roleid, this.qiuqianid))
/*    */     {
/*    */ 
/* 38 */       onFail(-1, null);
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     SStartQiuQian protocol = new SStartQiuQian();
/* 43 */     protocol.qiuqian_id = this.qiuqianid;
/* 44 */     protocol.sessionid = new QiuQianVaildSession(QiuQianManager.QIU_QIAN_VAILD_INTERVAL, this.roleid, this.qiuqianid).getSessionId();
/* 45 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/* 47 */     StringBuilder sb = new StringBuilder();
/* 48 */     sb.append(String.format("[qiuqian]PStartQiuQian.processImp@start qiu qian success|roleid=%d|qiuqianid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.qiuqianid) }));
/*    */     
/* 50 */     QiuQianManager.logger.info(sb.toString());
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 56 */     StringBuilder sb = new StringBuilder();
/* 57 */     sb.append(String.format("[qiuqian]PStartQiuQian.processImp@start qiu qian fail|roleid=%d|qiuqianid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.qiuqianid), Integer.valueOf(res) }));
/*    */     
/* 59 */     if (extraInfo != null)
/*    */     {
/* 61 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 63 */         sb.append("|").append((String)entry.getKey());
/* 64 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 67 */     QiuQianManager.logger.info(sb.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\main\PStartQiuQian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */