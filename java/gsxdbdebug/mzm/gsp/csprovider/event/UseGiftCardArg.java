/*     */ package mzm.gsp.csprovider.event;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UseGiftCardArg
/*     */ {
/*     */   public final long roleId;
/*     */   
/*     */ 
/*     */   public final String userId;
/*     */   
/*     */ 
/*     */   public final String cardNumber;
/*     */   
/*     */ 
/*     */   public int parentType;
/*     */   
/*     */ 
/*     */   public final int cardType;
/*     */   
/*     */   public int awardId;
/*     */   
/*     */   public final ErrorCode errorCode;
/*     */   
/*     */ 
/*     */   public static enum ErrorCode
/*     */   {
/*  28 */     ERROR_SUCCESS(0), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  33 */     ERROR_CARD_INVALID(1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  38 */     ERROR_NOT_IN_EFFECTIVE_TIME(2), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  43 */     ERROR_CARD_IS_OUT_OF_DATE(3), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  48 */     ERROR_MAX_USE_TIMES_OF_THE_PARENT_TYPE_LIMIT(4), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  53 */     ERROR_CARD_USED_BY_THE_ROLE(5), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  58 */     ERROR_CARD_USED_BY_OTHERS(6), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  63 */     ERROR_CARD_NOT_EXIST(7), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  68 */     ERROR_CSP_OTHER_ERROR(8), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  73 */     ERROR_NETWORK(9);
/*     */     
/*     */     public final int code;
/*     */     
/*     */     private ErrorCode(int code)
/*     */     {
/*  79 */       this.code = code;
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
/*     */   public UseGiftCardArg(long roleId, String userId, String cardNumber, int parentType, int cardType, int awardId, ErrorCode errorCode)
/*     */   {
/* 120 */     this.roleId = roleId;
/* 121 */     this.userId = userId;
/* 122 */     this.cardNumber = cardNumber;
/* 123 */     this.parentType = parentType;
/* 124 */     this.cardType = cardType;
/* 125 */     this.awardId = awardId;
/* 126 */     this.errorCode = errorCode;
/*     */   }
/*     */   
/*     */   public UseGiftCardArg(long roleId, String userId, String cardNumber, ErrorCode errorCode)
/*     */   {
/* 131 */     this(roleId, userId, cardNumber, -1, -1, -1, errorCode);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\event\UseGiftCardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */