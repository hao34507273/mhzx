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
/*     */ public class QueryRolelistInfoRsp
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public int FightRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public int FightScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public int LevelRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public int LevelScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int EvilRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int EvilScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int CompetitiveRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public int CompetitiveScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public int ExamRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public int ExamScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public int WushuRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public int WushuScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public int BossRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int BossScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public int BattleRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public int BattleScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int FlowerRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public int FlowerScore = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public int BloomRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   public int BloomScore = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 115 */     _js_.marshal("FightRank", Integer.valueOf(this.FightRank));
/* 116 */     _js_.marshal("FightScore", Integer.valueOf(this.FightScore));
/* 117 */     _js_.marshal("LevelRank", Integer.valueOf(this.LevelRank));
/* 118 */     _js_.marshal("LevelScore", Integer.valueOf(this.LevelScore));
/* 119 */     _js_.marshal("EvilRank", Integer.valueOf(this.EvilRank));
/* 120 */     _js_.marshal("EvilScore", Integer.valueOf(this.EvilScore));
/* 121 */     _js_.marshal("CompetitiveRank", Integer.valueOf(this.CompetitiveRank));
/* 122 */     _js_.marshal("CompetitiveScore", Integer.valueOf(this.CompetitiveScore));
/* 123 */     _js_.marshal("ExamRank", Integer.valueOf(this.ExamRank));
/* 124 */     _js_.marshal("ExamScore", Integer.valueOf(this.ExamScore));
/* 125 */     _js_.marshal("WushuRank", Integer.valueOf(this.WushuRank));
/* 126 */     _js_.marshal("WushuScore", Integer.valueOf(this.WushuScore));
/* 127 */     _js_.marshal("BossRank", Integer.valueOf(this.BossRank));
/* 128 */     _js_.marshal("BossScore", Integer.valueOf(this.BossScore));
/* 129 */     _js_.marshal("BattleRank", Integer.valueOf(this.BattleRank));
/* 130 */     _js_.marshal("BattleScore", Integer.valueOf(this.BattleScore));
/* 131 */     _js_.marshal("FlowerRank", Integer.valueOf(this.FlowerRank));
/* 132 */     _js_.marshal("FlowerScore", Integer.valueOf(this.FlowerScore));
/* 133 */     _js_.marshal("BloomRank", Integer.valueOf(this.BloomRank));
/* 134 */     _js_.marshal("BloomScore", Integer.valueOf(this.BloomScore));
/* 135 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 140 */     this.FightRank = _js_.unmarshal_int("FightRank");
/* 141 */     this.FightScore = _js_.unmarshal_int("FightScore");
/* 142 */     this.LevelRank = _js_.unmarshal_int("LevelRank");
/* 143 */     this.LevelScore = _js_.unmarshal_int("LevelScore");
/* 144 */     this.EvilRank = _js_.unmarshal_int("EvilRank");
/* 145 */     this.EvilScore = _js_.unmarshal_int("EvilScore");
/* 146 */     this.CompetitiveRank = _js_.unmarshal_int("CompetitiveRank");
/* 147 */     this.CompetitiveScore = _js_.unmarshal_int("CompetitiveScore");
/* 148 */     this.ExamRank = _js_.unmarshal_int("ExamRank");
/* 149 */     this.ExamScore = _js_.unmarshal_int("ExamScore");
/* 150 */     this.WushuRank = _js_.unmarshal_int("WushuRank");
/* 151 */     this.WushuScore = _js_.unmarshal_int("WushuScore");
/* 152 */     this.BossRank = _js_.unmarshal_int("BossRank");
/* 153 */     this.BossScore = _js_.unmarshal_int("BossScore");
/* 154 */     this.BattleRank = _js_.unmarshal_int("BattleRank");
/* 155 */     this.BattleScore = _js_.unmarshal_int("BattleScore");
/* 156 */     this.FlowerRank = _js_.unmarshal_int("FlowerRank");
/* 157 */     this.FlowerScore = _js_.unmarshal_int("FlowerScore");
/* 158 */     this.BloomRank = _js_.unmarshal_int("BloomRank");
/* 159 */     this.BloomScore = _js_.unmarshal_int("BloomScore");
/* 160 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryRolelistInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */