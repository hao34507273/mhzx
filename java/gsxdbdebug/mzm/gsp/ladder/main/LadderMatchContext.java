/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*    */ import mzm.gsp.crossserver.main.MatchActivityContextType;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ public class LadderMatchContext
/*    */   implements MatchActivityContext
/*    */ {
/*    */   private CancelMatchContext cancelMatchContext;
/* 14 */   private final long startTime = DateTimeUtils.getCurrTimeInMillis();
/*    */   
/*    */   public long getStartTime() {
/* 17 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public CancelMatchContext getCancelMatchContext() {
/* 21 */     return this.cancelMatchContext;
/*    */   }
/*    */   
/*    */   public void setCancelMatchContext(CancelMatchContext cancelMatchContext) {
/* 25 */     this.cancelMatchContext = cancelMatchContext;
/*    */   }
/*    */   
/* 28 */   private Map<Long, Integer> roleid2ProcessMap = new HashMap();
/*    */   
/*    */   public MatchActivityContextType getMatchActivityContextType()
/*    */   {
/* 32 */     return MatchActivityContextType.LADDER;
/*    */   }
/*    */   
/*    */   public Integer getRoleProcess(long roleid) {
/* 36 */     return (Integer)this.roleid2ProcessMap.get(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */   public void putRoleProcess(long roleid, int process) {
/* 40 */     this.roleid2ProcessMap.put(Long.valueOf(roleid), Integer.valueOf(process));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderMatchContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */