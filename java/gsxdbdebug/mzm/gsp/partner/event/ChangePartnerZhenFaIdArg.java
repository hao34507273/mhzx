/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ 
/*    */ public class ChangePartnerZhenFaIdArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int lineUpIndex;
/*    */   
/*    */   public final int zhenfaId;
/*    */   
/*    */   public final ChangeZhenFaIdType type;
/*    */   
/*    */ 
/*    */   public ChangePartnerZhenFaIdArg(long roleId, int lineUpIndex, int zhenFaId, ChangeZhenFaIdType type)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.lineUpIndex = lineUpIndex;
/* 19 */     this.zhenfaId = zhenFaId;
/* 20 */     this.type = type;
/*    */   }
/*    */   
/*    */   public static enum ChangeZhenFaIdType {
/* 24 */     TEAM, 
/* 25 */     PARTNER;
/*    */     
/*    */     private ChangeZhenFaIdType() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\ChangePartnerZhenFaIdArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */