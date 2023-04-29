/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*  5 */ public enum RankType { ROLE_FIGHT_VALUE(0), 
/*  6 */   PET_YAOLI(1), 
/*  7 */   ROLE_LEVEL(2), 
/*  8 */   ROLE_JINGJI(3), 
/*  9 */   ROLE_KEJU(4), 
/* 10 */   GIVE_FLOWER(5), 
/* 11 */   RECEIVE_FLOWER(6), 
/* 12 */   ROLE_PVP3(7), 
/* 13 */   BIG_BOSS(8), 
/* 14 */   JIU_XIAO_FIGHT_WIN(9), 
/* 15 */   PARASELENE(10), 
/* 16 */   JINGJI_POINT(11), 
/* 17 */   ROLE_MULTI_FIGHT_VALUE(12), 
/* 18 */   EXPERIENCE_MASTER(13), 
/* 19 */   QMHW(14);
/*    */   
/*    */   private final int value;
/*    */   
/* 23 */   public static void checkRankType() { Set<Integer> values = new java.util.HashSet();
/* 24 */     for (RankType type : values())
/*    */     {
/* 26 */       if (!values.add(Integer.valueOf(type.value))) {
/* 27 */         throw new RuntimeException(String.format("RankType中定义的常量重复,name=%s,value=%d", new Object[] { type.name(), Integer.valueOf(type.value) }));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private RankType(int value)
/*    */   {
/* 35 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue()
/*    */   {
/* 40 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\RankType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */