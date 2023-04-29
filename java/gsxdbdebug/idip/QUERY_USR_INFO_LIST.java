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
/*     */ public class QUERY_USR_INFO_LIST
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public String RoleName = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public int Level = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public int GangId = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public int Exp = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int StoreExp = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int Cash = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int Money = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public int Silver = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public int Fight = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public int CompetitivePoint = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public int Chivalrous = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public int Reputation = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public int Vitality = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int GangContribute = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/*  85 */     _js_.marshal("RoleName", this.RoleName);
/*  86 */     _js_.marshal("Level", Integer.valueOf(this.Level));
/*  87 */     _js_.marshal("GangId", Integer.valueOf(this.GangId));
/*  88 */     _js_.marshal("Exp", Integer.valueOf(this.Exp));
/*  89 */     _js_.marshal("StoreExp", Integer.valueOf(this.StoreExp));
/*  90 */     _js_.marshal("Cash", Integer.valueOf(this.Cash));
/*  91 */     _js_.marshal("Money", Integer.valueOf(this.Money));
/*  92 */     _js_.marshal("Silver", Integer.valueOf(this.Silver));
/*  93 */     _js_.marshal("Fight", Integer.valueOf(this.Fight));
/*  94 */     _js_.marshal("CompetitivePoint", Integer.valueOf(this.CompetitivePoint));
/*  95 */     _js_.marshal("Chivalrous", Integer.valueOf(this.Chivalrous));
/*  96 */     _js_.marshal("Reputation", Integer.valueOf(this.Reputation));
/*  97 */     _js_.marshal("Vitality", Integer.valueOf(this.Vitality));
/*  98 */     _js_.marshal("GangContribute", Integer.valueOf(this.GangContribute));
/*  99 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 104 */     this.RoleName = _js_.unmarshal_string("RoleName");
/* 105 */     this.Level = _js_.unmarshal_int("Level");
/* 106 */     this.GangId = _js_.unmarshal_int("GangId");
/* 107 */     this.Exp = _js_.unmarshal_int("Exp");
/* 108 */     this.StoreExp = _js_.unmarshal_int("StoreExp");
/* 109 */     this.Cash = _js_.unmarshal_int("Cash");
/* 110 */     this.Money = _js_.unmarshal_int("Money");
/* 111 */     this.Silver = _js_.unmarshal_int("Silver");
/* 112 */     this.Fight = _js_.unmarshal_int("Fight");
/* 113 */     this.CompetitivePoint = _js_.unmarshal_int("CompetitivePoint");
/* 114 */     this.Chivalrous = _js_.unmarshal_int("Chivalrous");
/* 115 */     this.Reputation = _js_.unmarshal_int("Reputation");
/* 116 */     this.Vitality = _js_.unmarshal_int("Vitality");
/* 117 */     this.GangContribute = _js_.unmarshal_int("GangContribute");
/* 118 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QUERY_USR_INFO_LIST.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */