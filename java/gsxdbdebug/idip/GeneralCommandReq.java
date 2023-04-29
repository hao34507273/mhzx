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
/*     */ public class GeneralCommandReq
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public int AreaId = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public byte PlatId = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public int Partition = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public long CommandID = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public long parameter1 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public long parameter2 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public long parameter3 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public long parameter4 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public long parameter5 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public long parameter6 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public long parameter7 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public long parameter8 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public long parameter9 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public long parameter10 = 0L;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/*  85 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/*  86 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/*  87 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/*  88 */     _js_.marshal("CommandID", Long.valueOf(this.CommandID));
/*  89 */     _js_.marshal("parameter1", Long.valueOf(this.parameter1));
/*  90 */     _js_.marshal("parameter2", Long.valueOf(this.parameter2));
/*  91 */     _js_.marshal("parameter3", Long.valueOf(this.parameter3));
/*  92 */     _js_.marshal("parameter4", Long.valueOf(this.parameter4));
/*  93 */     _js_.marshal("parameter5", Long.valueOf(this.parameter5));
/*  94 */     _js_.marshal("parameter6", Long.valueOf(this.parameter6));
/*  95 */     _js_.marshal("parameter7", Long.valueOf(this.parameter7));
/*  96 */     _js_.marshal("parameter8", Long.valueOf(this.parameter8));
/*  97 */     _js_.marshal("parameter9", Long.valueOf(this.parameter9));
/*  98 */     _js_.marshal("parameter10", Long.valueOf(this.parameter10));
/*  99 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 104 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 105 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 106 */     this.Partition = _js_.unmarshal_int("Partition");
/* 107 */     this.CommandID = _js_.unmarshal_long("CommandID");
/* 108 */     this.parameter1 = _js_.unmarshal_long("parameter1");
/* 109 */     this.parameter2 = _js_.unmarshal_long("parameter2");
/* 110 */     this.parameter3 = _js_.unmarshal_long("parameter3");
/* 111 */     this.parameter4 = _js_.unmarshal_long("parameter4");
/* 112 */     this.parameter5 = _js_.unmarshal_long("parameter5");
/* 113 */     this.parameter6 = _js_.unmarshal_long("parameter6");
/* 114 */     this.parameter7 = _js_.unmarshal_long("parameter7");
/* 115 */     this.parameter8 = _js_.unmarshal_long("parameter8");
/* 116 */     this.parameter9 = _js_.unmarshal_long("parameter9");
/* 117 */     this.parameter10 = _js_.unmarshal_long("parameter10");
/* 118 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\GeneralCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */