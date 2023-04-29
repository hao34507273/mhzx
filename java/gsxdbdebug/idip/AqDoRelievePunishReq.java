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
/*     */ public class AqDoRelievePunishReq
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
/*  31 */   public String OpenId = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public String RoleId = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public byte RelieveBanPlay = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int RelievePlayType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public byte RelieveBanJoinRank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public int RelieveRankType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public byte RelieveBan = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public byte RelieveMaskchat = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public byte RelieveLockUsrInfo = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public byte RelieveZeroProfit = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int Source = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public String Serial = "";
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/*  90 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/*  91 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/*  92 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/*  93 */     _js_.marshal("OpenId", this.OpenId);
/*  94 */     _js_.marshal("RoleId", this.RoleId);
/*  95 */     _js_.marshal("RelieveBanPlay", Byte.valueOf(this.RelieveBanPlay));
/*  96 */     _js_.marshal("RelievePlayType", Integer.valueOf(this.RelievePlayType));
/*  97 */     _js_.marshal("RelieveBanJoinRank", Byte.valueOf(this.RelieveBanJoinRank));
/*  98 */     _js_.marshal("RelieveRankType", Integer.valueOf(this.RelieveRankType));
/*  99 */     _js_.marshal("RelieveBan", Byte.valueOf(this.RelieveBan));
/* 100 */     _js_.marshal("RelieveMaskchat", Byte.valueOf(this.RelieveMaskchat));
/* 101 */     _js_.marshal("RelieveLockUsrInfo", Byte.valueOf(this.RelieveLockUsrInfo));
/* 102 */     _js_.marshal("RelieveZeroProfit", Byte.valueOf(this.RelieveZeroProfit));
/* 103 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 104 */     _js_.marshal("Serial", this.Serial);
/* 105 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 110 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 111 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 112 */     this.Partition = _js_.unmarshal_int("Partition");
/* 113 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 114 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 115 */     this.RelieveBanPlay = _js_.unmarshal_byte("RelieveBanPlay");
/* 116 */     this.RelievePlayType = _js_.unmarshal_int("RelievePlayType");
/* 117 */     this.RelieveBanJoinRank = _js_.unmarshal_byte("RelieveBanJoinRank");
/* 118 */     this.RelieveRankType = _js_.unmarshal_int("RelieveRankType");
/* 119 */     this.RelieveBan = _js_.unmarshal_byte("RelieveBan");
/* 120 */     this.RelieveMaskchat = _js_.unmarshal_byte("RelieveMaskchat");
/* 121 */     this.RelieveLockUsrInfo = _js_.unmarshal_byte("RelieveLockUsrInfo");
/* 122 */     this.RelieveZeroProfit = _js_.unmarshal_byte("RelieveZeroProfit");
/* 123 */     this.Source = _js_.unmarshal_int("Source");
/* 124 */     this.Serial = _js_.unmarshal_string("Serial");
/* 125 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\AqDoRelievePunishReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */