/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum PresentType
/*     */ {
/*  11 */   PRESENT_TEST(false, 0, "test: present"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  16 */   PRESENT_BIND_TEST(true, 1, "test: prsent bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   PRESENT_GM(false, 98, "gm: present"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   PRESENT_BIND_GM(true, 99, "gm: present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   PRESENT_BIND_CSP(true, 100, "csp: present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   PRSENT_BIND_USE_MONEY_BAG_ITEM(true, 110, "item: use money bag item present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   PRSENT_BIND_ITEM_LOTTERY(true, 111, "item: lottery present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   PRSENT_BIND_MAIL_ADD(true, 140, "item: mail present bind"),  PRSENT_UN_BIND_MAIL_ADD(false, 141, "item: mail present unbind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   PRSENT_BIND_MARRIAGE_RECEIVE_GIFT(true, 150, "marriage: receive gift present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   PRESENT_BIND_IDIP(true, 160, "idip: present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   PRESENT_BIND_AQIDIP(true, 161, "aqidip: present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   PRESENT_AQIDIP(false, 162, "aqidip: present"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   PRESENT_BIND_GMT(true, 163, "gmt: present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   PRESENT_BIND_AQGMT(true, 164, "aqgmt: present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   PRESENT_AQGMT(false, 165, "aqgmt: present"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   PRESENT_BIND_FIRST_RECHAGRE(true, 200, "qingfu: get first recharge award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   PRESENT_BIND_SAVE_AMT_ACTIVITY(true, 201, "qingfu: get save amt activity award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   PRESENT_BIND_LEVEL_GROWTH_FUND_ACTIVITY(true, 202, "qingfu: get level growth fund activity award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   PRESENT_BIND_MONTH_CARD_ACTIVITY(true, 203, "qingfu: month card activity award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   PRESENT_BIND_MONTH_CARD_ACTIVITY_DAILY_AWARD(true, 204, "qingfu: get month card activity daily award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   PRESENT_BIND_ACCUM_TOTAL_COST_ACTIVITY(true, 205, "qingfu: get accum total cost activity award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   PRESENT_BIND_RMB_GIFT_BAG_ACTIVITY(true, 206, "qingfu: get rmb gift bag activity award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   PRESENT_BIND_GRC_FRIENDS_COUNT_AWARD(true, 250, "grc: get grc friends count award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 126 */   PRESENT_BIND_GRC_INVITEE_FRESHMAN_AWARD(true, 251, "grc: get grc invitee freshman award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 131 */   PRESENT_BIND_GRC_INVITER_REBATE_BIND_YUANBAO_AWARD(true, 252, "grc: get grc inviter rebate bind yuanbao award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 136 */   PRESENT_BIND_GRC_INVITER_GIFT_AWARD(true, 253, "grc: get grc inviter gift award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 141 */   PRSENT_BIND_ROLE_AWARD(true, 1000, "award: role award present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 146 */   PRSENT_BIND_HOME_SELL_FURNITURE(true, 1001, "sell: role sell furniture present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 151 */   PRSENT_BIND_RECEIVE_GIFT(true, 1100, "gift: receive gift present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 156 */   PRSENT_BIND_RECALL_REBATE(true, 1200, "recall: receive back rebate"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 161 */   PRESENT_BIND_BACK_GAME_ACTIVITY_USE_MANEKI_TOKEN(true, 1300, "back game activity: recharge present bind"), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 166 */   PRESENT_BIND_DRAW_CARNIVAL_ACTIVITY_DRAW(true, 1400, "draw carnival activity: draw bid award");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean bind;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int type;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String reason;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private PresentType(boolean bind, int type, String reason)
/*     */   {
/* 190 */     this.bind = bind;
/* 191 */     this.type = type;
/* 192 */     this.reason = reason;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PresentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */