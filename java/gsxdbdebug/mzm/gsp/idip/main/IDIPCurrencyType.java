/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.mail.main.MailAttachment;
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
/*     */ public class IDIPCurrencyType
/*     */ {
/*     */   public static final int YUAN_BAO = 1;
/*     */   public static final int BIND_YUAN_BAO = 2;
/*     */   public static final int GOLD = 3;
/*     */   public static final int SILVER = 4;
/*     */   public static final int ROLE_EXP = 5;
/*     */   public static final int PET_EXP = 6;
/*     */   public static final int XIU_LIAN_EXP = 7;
/*     */   public static final int JING_JI_JI_FEN = 8;
/*     */   public static final int XIA_YI_VALUE = 9;
/*     */   public static final int SHI_MEN_VALUE = 10;
/*     */   public static final int REPUTATION_VALUE = 11;
/*     */   public static final int VIGOR = 12;
/*     */   public static final int STORE_EXP = 13;
/*     */   public static final int GOLD_INGOT = 14;
/*     */   public static final int MIN_CURRENCY_TYPE_ID = 1;
/*     */   public static final int MAX_CURRENCY_TYPE_ID = 14;
/*     */   
/*     */   public static void fillMailCurrencyAttachment(MailAttachment mailAttachment, Map<Integer, Integer> currencies)
/*     */   {
/*  93 */     for (Map.Entry<Integer, Integer> entry : currencies.entrySet())
/*     */     {
/*  95 */       fillMailCurrencyAttachment(mailAttachment, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void fillMailCurrencyAttachment(MailAttachment mailAttachment, int currencyType, int currencyNum)
/*     */   {
/* 102 */     switch (currencyType)
/*     */     {
/*     */     case 1: 
/* 105 */       mailAttachment.setYuanBao(currencyNum);
/* 106 */       break;
/*     */     
/*     */     case 2: 
/* 109 */       mailAttachment.setBindYuanBao(currencyNum);
/* 110 */       break;
/*     */     
/*     */     case 3: 
/* 113 */       mailAttachment.setGold(currencyNum);
/* 114 */       break;
/*     */     
/*     */     case 4: 
/* 117 */       mailAttachment.setSilver(currencyNum);
/* 118 */       break;
/*     */     
/*     */     case 5: 
/* 121 */       mailAttachment.setRoleExp(currencyNum);
/* 122 */       break;
/*     */     
/*     */     case 6: 
/* 125 */       mailAttachment.setPetExp(currencyNum);
/* 126 */       break;
/*     */     
/*     */     case 7: 
/* 129 */       mailAttachment.setXiuLianExp(currencyNum);
/* 130 */       break;
/*     */     
/*     */     case 8: 
/* 133 */       mailAttachment.addToken(2, currencyNum);
/* 134 */       break;
/*     */     
/*     */     case 9: 
/* 137 */       mailAttachment.addToken(1, currencyNum);
/* 138 */       break;
/*     */     
/*     */     case 10: 
/* 141 */       mailAttachment.addToken(3, currencyNum);
/* 142 */       break;
/*     */     
/*     */     case 11: 
/* 145 */       mailAttachment.addToken(4, currencyNum);
/* 146 */       break;
/*     */     
/*     */     case 12: 
/* 149 */       mailAttachment.setVigor(currencyNum);
/* 150 */       break;
/*     */     
/*     */     case 13: 
/* 153 */       mailAttachment.setStoreExp(currencyNum);
/* 154 */       break;
/*     */     
/*     */     case 14: 
/* 157 */       mailAttachment.setGoldIngot(currencyNum);
/* 158 */       break;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\IDIPCurrencyType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */