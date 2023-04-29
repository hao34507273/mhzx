/*     */ package idip;
/*     */ 
/*     */ import jsonio.JsonMarshal;
/*     */ import jsonio.JsonMarshalException;
/*     */ import jsonio.JsonStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Participation
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public int DriveMonsterNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public int ArenaNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public int MonsterCompleteNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public int RewardCompleteNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int SchoolClearNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int BattleClearNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int MansionClearNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public long DayMasterMissionFinish = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public long DayQiyuanAnswer = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public long DayConvoyMissionFinish = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public long DayRewardMissionFinish = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public long DaySchoolAnswer = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public long WeekFactionMissionFinish = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public long DayWatchMoon = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public long DayActivityLiveness = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public long OnlineTime = 0L;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/*  95 */     _js_.marshal("DriveMonsterNum", Integer.valueOf(this.DriveMonsterNum));
/*  96 */     _js_.marshal("ArenaNum", Integer.valueOf(this.ArenaNum));
/*  97 */     _js_.marshal("MonsterCompleteNum", Integer.valueOf(this.MonsterCompleteNum));
/*  98 */     _js_.marshal("RewardCompleteNum", Integer.valueOf(this.RewardCompleteNum));
/*  99 */     _js_.marshal("SchoolClearNum", Integer.valueOf(this.SchoolClearNum));
/* 100 */     _js_.marshal("BattleClearNum", Integer.valueOf(this.BattleClearNum));
/* 101 */     _js_.marshal("MansionClearNum", Integer.valueOf(this.MansionClearNum));
/* 102 */     _js_.marshal("DayMasterMissionFinish", Long.valueOf(this.DayMasterMissionFinish));
/* 103 */     _js_.marshal("DayQiyuanAnswer", Long.valueOf(this.DayQiyuanAnswer));
/* 104 */     _js_.marshal("DayConvoyMissionFinish", Long.valueOf(this.DayConvoyMissionFinish));
/* 105 */     _js_.marshal("DayRewardMissionFinish", Long.valueOf(this.DayRewardMissionFinish));
/* 106 */     _js_.marshal("DaySchoolAnswer", Long.valueOf(this.DaySchoolAnswer));
/* 107 */     _js_.marshal("WeekFactionMissionFinish", Long.valueOf(this.WeekFactionMissionFinish));
/* 108 */     _js_.marshal("DayWatchMoon", Long.valueOf(this.DayWatchMoon));
/* 109 */     _js_.marshal("DayActivityLiveness", Long.valueOf(this.DayActivityLiveness));
/* 110 */     _js_.marshal("OnlineTime", Long.valueOf(this.OnlineTime));
/* 111 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 116 */     this.DriveMonsterNum = _js_.unmarshal_int("DriveMonsterNum");
/* 117 */     this.ArenaNum = _js_.unmarshal_int("ArenaNum");
/* 118 */     this.MonsterCompleteNum = _js_.unmarshal_int("MonsterCompleteNum");
/* 119 */     this.RewardCompleteNum = _js_.unmarshal_int("RewardCompleteNum");
/* 120 */     this.SchoolClearNum = _js_.unmarshal_int("SchoolClearNum");
/* 121 */     this.BattleClearNum = _js_.unmarshal_int("BattleClearNum");
/* 122 */     this.MansionClearNum = _js_.unmarshal_int("MansionClearNum");
/* 123 */     this.DayMasterMissionFinish = _js_.unmarshal_long("DayMasterMissionFinish");
/* 124 */     this.DayQiyuanAnswer = _js_.unmarshal_long("DayQiyuanAnswer");
/* 125 */     this.DayConvoyMissionFinish = _js_.unmarshal_long("DayConvoyMissionFinish");
/* 126 */     this.DayRewardMissionFinish = _js_.unmarshal_long("DayRewardMissionFinish");
/* 127 */     this.DaySchoolAnswer = _js_.unmarshal_long("DaySchoolAnswer");
/* 128 */     this.WeekFactionMissionFinish = _js_.unmarshal_long("WeekFactionMissionFinish");
/* 129 */     this.DayWatchMoon = _js_.unmarshal_long("DayWatchMoon");
/* 130 */     this.DayActivityLiveness = _js_.unmarshal_long("DayActivityLiveness");
/* 131 */     this.OnlineTime = _js_.unmarshal_long("OnlineTime");
/* 132 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\Participation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */