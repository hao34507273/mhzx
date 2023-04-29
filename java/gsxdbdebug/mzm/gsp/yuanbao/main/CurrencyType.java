/*    */ package mzm.gsp.yuanbao.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CurrencyType
/*    */ {
/* 10 */   CURRENCY_SILVE(1), 
/* 11 */   CURRENCY_GOLD(2), 
/* 12 */   CURRENCY_BUYYUANBAO(3), 
/* 13 */   CURRENCY_AWARDYUANBAO(4), 
/* 14 */   CURRENCY_GANG(5), 
/*    */   
/* 16 */   CURRENCY_SHIMEN(6), 
/* 17 */   CURRENCY_JINJI(7), 
/* 18 */   CURRENCY_XIAYI(8), 
/* 19 */   CURRENCY_SHENGWANG(9), 
/* 20 */   CURRENCY_VIGOR(10), 
/* 21 */   CURRENCY_YUANBAO(11), 
/* 22 */   CURRENCY_GOLD_INGOT(12), 
/* 23 */   CURRENCY_LADDER_JIFEN(13), 
/* 24 */   CURRENCY_FROZEN_POOL_NUM(14), 
/* 25 */   CURRENCY_GETTING_POOL_NUM(15), 
/* 26 */   CURRENCY_SINGLE_CROSS_FIELD_SCORE(16), 
/* 27 */   CURRENCY_MORAL_VALUE(17), 
/* 28 */   CURRENCY_XIAO_HUI_KUAI_PAO_POINT(18), 
/* 29 */   CURRENCY_CARD_ESSENCE(19), 
/* 30 */   CURRENCY_CARD_SCORE(20), 
/* 31 */   CURRENCY_BACK_GAME_ACTIVITY_POINT(21), 
/* 32 */   CURRENCY_XIAO_HUI_KUAI_PAO_COMPENSATE_POINT(22), 
/* 33 */   CURRENCY_BANDSTAND_SCORE(23), 
/* 34 */   CURRENCY_PET_FIGHT_SCORE(24), 
/* 35 */   CURRENCY_PET_MARK_SCORE1(25), 
/* 36 */   CURRENCY_PET_MARK_SCORE2(26), 
/* 37 */   CURRENCY_DRAW_CARNIVAL_POINT(27);
/*    */   
/*    */   public final int value;
/*    */   
/* 41 */   public static void checkCurrencyType() { Set<Integer> values = new HashSet();
/* 42 */     for (CurrencyType type : values())
/*    */     {
/* 44 */       if (!values.add(Integer.valueOf(type.value))) {
/* 45 */         throw new RuntimeException(String.format("CurrencyType中定义的常量重复,name=%s,value=%d", new Object[] { type.name(), Integer.valueOf(type.value) }));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private CurrencyType(int value)
/*    */   {
/* 52 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\main\CurrencyType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */