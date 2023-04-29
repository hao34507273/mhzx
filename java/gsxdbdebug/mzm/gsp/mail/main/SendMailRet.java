/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ public final class SendMailRet {
/*    */   private final RetEnum retEnum;
/*    */   private final boolean limit;
/*    */   
/*    */   public static enum RetEnum {
/*  8 */     SEND_MAIL_OK(0, "ok"), 
/*  9 */     SEND_MAIL_ROLE_NOT_EXIST(64496, "send mail role not exist"), 
/* 10 */     SEND_MAIL_TLOG_NULL(64495, "send mail tLog is null"), 
/* 11 */     SEND_ITEM_NOT_EXIST(64494, "send item not exist"), 
/* 12 */     SEND_MAIL_CFG_NOT_EXIST(64493, "send mail cfg id not exist"), 
/* 13 */     SEND_MAIL_ROAM_SERVER(64487, "cross server can not send email");
/*    */     
/*    */ 
/*    */ 
/*    */     public final int ret;
/*    */     
/*    */ 
/*    */     public final String retMsg;
/*    */     
/*    */ 
/*    */ 
/*    */     private RetEnum(int ret, String retMsg)
/*    */     {
/* 26 */       this.ret = ret;
/* 27 */       this.retMsg = retMsg;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SendMailRet(RetEnum retEnum, boolean limit)
/*    */   {
/* 35 */     this.retEnum = retEnum;
/* 36 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public boolean isOK() {
/* 40 */     return this.retEnum == RetEnum.SEND_MAIL_OK;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isLimit()
/*    */   {
/* 49 */     return this.limit;
/*    */   }
/*    */   
/*    */   public boolean isRoleNotExist() {
/* 53 */     return this.retEnum == RetEnum.SEND_MAIL_ROLE_NOT_EXIST;
/*    */   }
/*    */   
/*    */   public boolean isMailTLogArgNull() {
/* 57 */     return this.retEnum == RetEnum.SEND_MAIL_TLOG_NULL;
/*    */   }
/*    */   
/*    */   public boolean isItemNotExist() {
/* 61 */     return this.retEnum == RetEnum.SEND_ITEM_NOT_EXIST;
/*    */   }
/*    */   
/*    */   public RetEnum getRetEnum() {
/* 65 */     return this.retEnum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\SendMailRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */