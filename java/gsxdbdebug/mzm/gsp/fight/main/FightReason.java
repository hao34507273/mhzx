/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum FightReason
/*     */ {
/*  10 */   INSTANCE(1), 
/*     */   
/*     */ 
/*     */ 
/*  14 */   LEITAI(100), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  19 */   GUIDE_FIGHT_1(200), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  25 */   GM(2100000000), 
/*     */   
/*     */ 
/*  28 */   TASK_MAIN(300), 
/*  29 */   Task_CON_PVC_FIGHT(301), 
/*  30 */   Task_CON_PVE_FIGHT(302), 
/*     */   
/*     */ 
/*     */ 
/*  34 */   NORMAL_DARK_MONSTER_FIGHT(400), 
/*  35 */   TASK_DARK_MONSTER_FIGHT(401), 
/*  36 */   DOUBLE_POINT_DARK_MONSTER_FIGHT(402), 
/*     */   
/*     */ 
/*     */ 
/*  40 */   GANG_ROBBER_FIGHT(500), 
/*  41 */   LUANSHIYAOMO_FIGHT(501), 
/*  42 */   YAOSHOUTUXI_FIGHT(502), 
/*  43 */   SHENGXIAO_FIGHT(503), 
/*  44 */   MOJINGCHONGSHENG_FIGHT(504), 
/*  45 */   BAOTU_FIGHT(505), 
/*  46 */   MENPAI_PVP_FIGHT(506), 
/*  47 */   ARENA_FIGHT(507), 
/*  48 */   BIG_BOSS_ACTIVITY_FIGHT(508), 
/*  49 */   PARASELENE_ACTIVITY_FIGHT(509), 
/*  50 */   FACTION_COMPETITION_PVP(510), 
/*  51 */   WORLD_GOAL_PVE(511), 
/*  52 */   VISIBLE_MONSTER_PVE(512), 
/*  53 */   FACTION_COMPETITION_MERCENARY(513), 
/*  54 */   MENPAI_STAR_CAMPAIGN_PVE_FIGHT(514), 
/*  55 */   MENPAI_STAR_CAMPAIGN_ROLE_FIGHT(515), 
/*  56 */   MENPAI_STAR_VOTE_FIGHT(516), 
/*  57 */   ZHU_XIAN_JIAN_ZHEN_PVE(517), 
/*  58 */   FEI_SHENG_FIGHT_ACTIVITY_PVE(518), 
/*  59 */   FACTION_PVE(519), 
/*  60 */   CROSS_COMPETE_PVP(520), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  65 */   NPC_SREVICE_FIGHT(800), 
/*     */   
/*     */ 
/*     */ 
/*  69 */   JINGJI_ROLE_FIGHT(900), 
/*  70 */   JINGJI_ROBOT_FIGHT(901), 
/*     */   
/*     */ 
/*     */ 
/*  74 */   HU_SONG_FIGHT(1000), 
/*     */   
/*     */ 
/*     */ 
/*  78 */   MAP_MONSTER_FIGHT(1100), 
/*     */   
/*     */ 
/*     */ 
/*  82 */   QING_NORMAL_FIGHT(1200), 
/*  83 */   QING_ELITE_FIGHT(1201), 
/*     */   
/*     */ 
/*     */ 
/*  87 */   QMHW_MATCH_FIGHT(1300), 
/*     */   
/*     */ 
/*     */ 
/*  91 */   COUPLE_DAILY_FIGHT(1400), 
/*     */   
/*     */ 
/*     */ 
/*  95 */   ROB_MARRIAGE(1500), 
/*  96 */   ROB_MARRIAGE_PROTECT(1501), 
/*     */   
/*     */ 
/*     */ 
/* 100 */   LADDER_FIGHT_IN_CORSS(1600), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 105 */   HULA_FIGHT_KILL_MONSTER(1700), 
/*     */   
/*     */ 
/*     */ 
/* 109 */   CROSS_BATTLE_ROUND_ROBIN(1800), 
/* 110 */   CROSS_BATTLE_POINT(1801), 
/* 111 */   CROSS_BATTLE_SELECTION(1802), 
/* 112 */   CROSS_BATTLE_FINAL(1803), 
/*     */   
/*     */ 
/*     */ 
/* 116 */   FLOOR_FIGHT(1900), 
/*     */   
/*     */ 
/*     */ 
/* 120 */   SINGLE_BATTLE_FIGHT(2000), 
/*     */   
/*     */ 
/*     */ 
/* 124 */   PK_FIGHT(2101), 
/* 125 */   ARREST_FIGHT(2102), 
/*     */   
/*     */ 
/*     */ 
/* 129 */   WANTED_FIGHT_PVE(2200), 
/* 130 */   WANTED_FIGHT_PVP(2201), 
/*     */   
/*     */ 
/*     */ 
/* 134 */   JAIL_BREAK_FIGHT_PVE(2300), 
/* 135 */   JAIL_DELIVERY_FIGHT_PVE(2301), 
/*     */   
/*     */ 
/*     */ 
/* 139 */   PET_ARENA_CVC(2400), 
/*     */   
/*     */ 
/* 142 */   GATHER_MAP_ITEM_FIGHT_PVE(2550), 
/*     */   
/*     */ 
/*     */ 
/* 146 */   TREASURE_HUNT_PVE(2600);
/*     */   
/*     */ 
/*     */   public final int value;
/*     */   
/*     */   public static void checkReasonValue()
/*     */   {
/* 153 */     Set<Integer> values = new HashSet();
/* 154 */     for (FightReason type : values()) {
/* 155 */       if (values.contains(Integer.valueOf(type.value))) {
/* 156 */         throw new RuntimeException("FightReson中定义的常量重复!!! name=" + type.name() + "," + "value=" + type.value);
/*     */       }
/* 158 */       values.add(Integer.valueOf(type.value));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private FightReason(int value)
/*     */   {
/* 165 */     this.value = value;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */