/*     */ package mzm.gsp.csprovider.event;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UseActivateCardArg
/*     */ {
/*     */   public final String userId;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String cardNumber;
/*     */   
/*     */ 
/*     */ 
/*     */   public final int cardType;
/*     */   
/*     */ 
/*     */ 
/*     */   public final ErrorCode errorCode;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum ErrorCode
/*     */   {
/*  29 */     ERROR_SUCCESS(0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  34 */     ERROR_CARD_INVALID(1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  39 */     ERROR_NOT_IN_EFFECTIVE_TIME(2), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  44 */     ERROR_CARD_IS_OUT_OF_DATE(3), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  49 */     ERROR_CARD_USED_BY_THE_USER(4), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  54 */     ERROR_CARD_USED_BY_THE_USER_BUT_CARD_BATCH_INVALID(5), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  59 */     ERROR_CARD_USED_BY_THE_USER_IN_OTHER_SERVER(6), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  64 */     ERROR_CARD_ALREADY_USED_BY_OTHERS(7), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  69 */     ERROR_CARD_NOT_EXIST(8), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  74 */     ERROR_CSP_OTHER_ERROR(9), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  79 */     ERROR_NETWORK(10);
/*     */     
/*     */     public final int code;
/*     */     
/*     */     private ErrorCode(int code)
/*     */     {
/*  85 */       this.code = code;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public UseActivateCardArg(String userId, String cardNumber, int cardType, ErrorCode errorCode)
/*     */   {
/* 111 */     this.userId = userId;
/* 112 */     this.cardNumber = cardNumber;
/* 113 */     this.cardType = cardType;
/* 114 */     this.errorCode = errorCode;
/*     */   }
/*     */   
/*     */   public UseActivateCardArg(String userId, String cardNumber, ErrorCode errorCode)
/*     */   {
/* 119 */     this(userId, cardNumber, -1, errorCode);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\event\UseActivateCardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */