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
/*     */ public class PetInfoDet
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public int Type = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public String PetName = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public int PetModID = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public int PetExaID = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int Exp = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int Level = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int PhysicalDefense = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public int FaDefense = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public int blood = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public int Mana = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public int SkillNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public int Demon = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public double Growth = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int Life = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/*  85 */     _js_.marshal("Type", Integer.valueOf(this.Type));
/*  86 */     _js_.marshal("PetName", this.PetName);
/*  87 */     _js_.marshal("PetModID", Integer.valueOf(this.PetModID));
/*  88 */     _js_.marshal("PetExaID", Integer.valueOf(this.PetExaID));
/*  89 */     _js_.marshal("Exp", Integer.valueOf(this.Exp));
/*  90 */     _js_.marshal("Level", Integer.valueOf(this.Level));
/*  91 */     _js_.marshal("PhysicalDefense", Integer.valueOf(this.PhysicalDefense));
/*  92 */     _js_.marshal("FaDefense", Integer.valueOf(this.FaDefense));
/*  93 */     _js_.marshal("blood", Integer.valueOf(this.blood));
/*  94 */     _js_.marshal("Mana", Integer.valueOf(this.Mana));
/*  95 */     _js_.marshal("SkillNum", Integer.valueOf(this.SkillNum));
/*  96 */     _js_.marshal("Demon", Integer.valueOf(this.Demon));
/*  97 */     _js_.marshal("Growth", Double.valueOf(this.Growth));
/*  98 */     _js_.marshal("Life", Integer.valueOf(this.Life));
/*  99 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 104 */     this.Type = _js_.unmarshal_int("Type");
/* 105 */     this.PetName = _js_.unmarshal_string("PetName");
/* 106 */     this.PetModID = _js_.unmarshal_int("PetModID");
/* 107 */     this.PetExaID = _js_.unmarshal_int("PetExaID");
/* 108 */     this.Exp = _js_.unmarshal_int("Exp");
/* 109 */     this.Level = _js_.unmarshal_int("Level");
/* 110 */     this.PhysicalDefense = _js_.unmarshal_int("PhysicalDefense");
/* 111 */     this.FaDefense = _js_.unmarshal_int("FaDefense");
/* 112 */     this.blood = _js_.unmarshal_int("blood");
/* 113 */     this.Mana = _js_.unmarshal_int("Mana");
/* 114 */     this.SkillNum = _js_.unmarshal_int("SkillNum");
/* 115 */     this.Demon = _js_.unmarshal_int("Demon");
/* 116 */     this.Growth = _js_.unmarshal_float("Growth");
/* 117 */     this.Life = _js_.unmarshal_int("Life");
/* 118 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\PetInfoDet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */