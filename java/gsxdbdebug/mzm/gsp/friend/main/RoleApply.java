/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ApplyInfoMap;
/*    */ import xtable.Role2apply;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleApply
/*    */ {
/*    */   private final long roleId;
/*    */   private ApplyInfoMap xApplyInfoMap;
/*    */   
/*    */   RoleApply(long roleId, boolean isRetainLock)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     if (isRetainLock) {
/* 20 */       this.xApplyInfoMap = Role2apply.get(Long.valueOf(roleId));
/*    */     } else {
/* 22 */       this.xApplyInfoMap = Role2apply.select(Long.valueOf(roleId));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean containsRole(long applyId) {
/* 27 */     if (this.xApplyInfoMap == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     return this.xApplyInfoMap.getApplymap().containsKey(Long.valueOf(applyId));
/*    */   }
/*    */   
/*    */   public int applySize()
/*    */   {
/* 35 */     if (this.xApplyInfoMap == null) {
/* 36 */       return 0;
/*    */     }
/* 38 */     return this.xApplyInfoMap.getApplymap().size();
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 43 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public ApplyInfoMap getApplyInfoMap() {
/* 47 */     return this.xApplyInfoMap;
/*    */   }
/*    */   
/*    */   public void setApplyInfoMap(ApplyInfoMap applyInfoMap) {
/* 51 */     this.xApplyInfoMap = applyInfoMap;
/*    */   }
/*    */   
/*    */   int getApplyOthersCountToday() {
/* 55 */     if (this.xApplyInfoMap == null) {
/* 56 */       return 0;
/*    */     }
/* 58 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 59 */     if (DateTimeUtils.isInSameDay(curTime, this.xApplyInfoMap.getCleardatatime())) {
/* 60 */       return this.xApplyInfoMap.getApplyaddcount();
/*    */     }
/* 62 */     return 0;
/*    */   }
/*    */   
/*    */   int getApplyOtherRefuseCountToday()
/*    */   {
/* 67 */     if (this.xApplyInfoMap == null) {
/* 68 */       return 0;
/*    */     }
/* 70 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 71 */     if (DateTimeUtils.isInSameDay(curTime, this.xApplyInfoMap.getCleardatatime())) {
/* 72 */       return this.xApplyInfoMap.getApplyaddrefusecount();
/*    */     }
/* 74 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\RoleApply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */