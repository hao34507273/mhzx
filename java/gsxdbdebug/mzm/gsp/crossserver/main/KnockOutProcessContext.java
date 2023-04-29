/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ public class KnockOutProcessContext
/*    */ {
/* 10 */   private final long startTime = DateTimeUtils.getCurrTimeInMillis();
/*    */   
/*    */   public long getStartTime()
/*    */   {
/* 14 */     return this.startTime;
/*    */   }
/*    */   
/* 17 */   private Map<Long, Integer> roleid2ProcessMap = new HashMap();
/*    */   
/*    */   public Integer getRoleProcess(long roleid)
/*    */   {
/* 21 */     return (Integer)this.roleid2ProcessMap.get(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */   public void putRoleProcess(long roleid, int process)
/*    */   {
/* 26 */     this.roleid2ProcessMap.put(Long.valueOf(roleid), Integer.valueOf(process));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\KnockOutProcessContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */