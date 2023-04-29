/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleWordQuestionInfo;
/*     */ import xbean.WordQuestionInfo;
/*     */ import xtable.Role2wordquestion;
/*     */ import xtable.Wordquestion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WordQuestionItemSession
/*     */   extends Session
/*     */ {
/*     */   private int curIdx;
/*     */   private int endTime;
/*     */   
/*     */   public WordQuestionItemSession(long interval, long roleId, int curIdx)
/*     */   {
/*  28 */     super(interval, roleId);
/*  29 */     this.curIdx = curIdx;
/*  30 */     this.endTime = ((int)(TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()) + interval));
/*     */   }
/*     */   
/*     */   public int getEndTime()
/*     */   {
/*  35 */     return this.endTime;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  41 */     NoneRealTimeTaskManager.getInstance().addTask(new WordQuestionItemSessionTimeOutPro(getOwerId(), this.curIdx));
/*     */   }
/*     */   
/*     */   private static class WordQuestionItemSessionTimeOutPro extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int curIdx;
/*     */     
/*     */     public WordQuestionItemSessionTimeOutPro(long roleid, int curIdx)
/*     */     {
/*  51 */       this.roleid = roleid;
/*  52 */       this.curIdx = curIdx;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  58 */       Long wordQId = Role2wordquestion.get(Long.valueOf(this.roleid));
/*  59 */       if (wordQId == null)
/*     */       {
/*  61 */         String logStr = String.format("[wordquestion]WordQuestionItemSessionTimeOutPro.processImp@wordQId is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */         
/*  63 */         WordQuestionManager.logger.error(logStr);
/*  64 */         return false;
/*     */       }
/*  66 */       WordQuestionInfo xWordQuestionInfo = Wordquestion.get(wordQId);
/*  67 */       if (xWordQuestionInfo == null)
/*     */       {
/*  69 */         String logStr = String.format("[wordquestion]WordQuestionItemSessionTimeOutPro.processImp@xWordQuestionInfo is null|roleid=%d|wordQId=%d", new Object[] { Long.valueOf(this.roleid), wordQId });
/*     */         
/*     */ 
/*  72 */         WordQuestionManager.logger.error(logStr);
/*     */         
/*  74 */         return false;
/*     */       }
/*  76 */       RoleWordQuestionInfo xRoleInfo = (RoleWordQuestionInfo)xWordQuestionInfo.getRolequestionmap().get(Long.valueOf(this.roleid));
/*  77 */       if (xRoleInfo == null)
/*     */       {
/*  79 */         String logStr = String.format("[wordquestion]WordQuestionItemSessionTimeOutPro.processImp@xRoleInfo is null|roleid=%d|wordQId=%d", new Object[] { Long.valueOf(this.roleid), wordQId });
/*     */         
/*     */ 
/*  82 */         WordQuestionManager.logger.error(logStr);
/*     */         
/*  84 */         return false;
/*     */       }
/*  86 */       if (xRoleInfo.getCuridx() != this.curIdx)
/*     */       {
/*  88 */         String logStr = String.format("[wordquestion]WordQuestionItemSessionTimeOutPro.processImp@curIdx error|roleid=%d|wordQId=%d|curIdx=%d|xCurIdx=%d", new Object[] { Long.valueOf(this.roleid), wordQId, Integer.valueOf(this.curIdx), Integer.valueOf(xRoleInfo.getCuridx()) });
/*     */         
/*     */ 
/*  91 */         WordQuestionManager.logger.error(logStr);
/*  92 */         return false;
/*     */       }
/*  94 */       xRoleInfo.setCuridx(xRoleInfo.getCuridx() + 1);
/*  95 */       WordQuestionManager.getInstance().syncAnswerInfo(this.roleid, xWordQuestionInfo, -1);
/*  96 */       if (xRoleInfo.getCuridx() >= xRoleInfo.getQuestionidlist().size())
/*     */       {
/*  98 */         WordQuestionManager.getInstance().detectedIsEnd(wordQId.longValue(), xWordQuestionInfo);
/*     */       }
/*     */       
/* 101 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\WordQuestionItemSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */