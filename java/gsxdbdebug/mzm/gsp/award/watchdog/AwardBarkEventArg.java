/*    */ package mzm.gsp.award.watchdog;
/*    */ 
/*    */ public class AwardBarkEventArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final int orgRoleLv;
/*    */   private final long curValueSum;
/*    */   private final AwardWatchType type;
/*    */   
/*    */   public AwardBarkEventArg(long roleId, int orgRoleLv, long curValueSum, AwardWatchType type)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.orgRoleLv = orgRoleLv;
/* 14 */     this.curValueSum = curValueSum;
/* 15 */     this.type = type;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 20 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getOrgRoleLv()
/*    */   {
/* 25 */     return this.orgRoleLv;
/*    */   }
/*    */   
/*    */   public long getCurValueSum()
/*    */   {
/* 30 */     return this.curValueSum;
/*    */   }
/*    */   
/*    */   public AwardWatchType getType()
/*    */   {
/* 35 */     return this.type;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 41 */     StringBuilder sb = new StringBuilder();
/*    */     
/* 43 */     sb.append("[roleId=").append(this.roleId).append(",");
/* 44 */     sb.append("orgRoleLv=").append(this.orgRoleLv).append(",");
/* 45 */     sb.append("curValueSum=").append(this.curValueSum).append(",");
/* 46 */     sb.append("type=").append(this.type.getTypeValue()).append("]");
/*    */     
/* 48 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\AwardBarkEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */