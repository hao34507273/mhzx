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
/*     */ public class QueryGuildInfoRsp
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public String GuildId = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public int GuildId32 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public String GuildName = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public String LeaderName = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public String LeaderRoleId = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int Rank = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int Level = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public int EnableCnt = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public int CurMemberCnt = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public String Content = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public String GuildDecla = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public long Money = 0L;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/*  75 */     _js_.marshal("GuildId", this.GuildId);
/*  76 */     _js_.marshal("GuildId32", Integer.valueOf(this.GuildId32));
/*  77 */     _js_.marshal("GuildName", this.GuildName);
/*  78 */     _js_.marshal("LeaderName", this.LeaderName);
/*  79 */     _js_.marshal("LeaderRoleId", this.LeaderRoleId);
/*  80 */     _js_.marshal("Rank", Integer.valueOf(this.Rank));
/*  81 */     _js_.marshal("Level", Integer.valueOf(this.Level));
/*  82 */     _js_.marshal("EnableCnt", Integer.valueOf(this.EnableCnt));
/*  83 */     _js_.marshal("CurMemberCnt", Integer.valueOf(this.CurMemberCnt));
/*  84 */     _js_.marshal("Content", this.Content);
/*  85 */     _js_.marshal("GuildDecla", this.GuildDecla);
/*  86 */     _js_.marshal("Money", Long.valueOf(this.Money));
/*  87 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/*  92 */     this.GuildId = _js_.unmarshal_string("GuildId");
/*  93 */     this.GuildId32 = _js_.unmarshal_int("GuildId32");
/*  94 */     this.GuildName = _js_.unmarshal_string("GuildName");
/*  95 */     this.LeaderName = _js_.unmarshal_string("LeaderName");
/*  96 */     this.LeaderRoleId = _js_.unmarshal_string("LeaderRoleId");
/*  97 */     this.Rank = _js_.unmarshal_int("Rank");
/*  98 */     this.Level = _js_.unmarshal_int("Level");
/*  99 */     this.EnableCnt = _js_.unmarshal_int("EnableCnt");
/* 100 */     this.CurMemberCnt = _js_.unmarshal_int("CurMemberCnt");
/* 101 */     this.Content = _js_.unmarshal_string("Content");
/* 102 */     this.GuildDecla = _js_.unmarshal_string("GuildDecla");
/* 103 */     this.Money = _js_.unmarshal_long("Money");
/* 104 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryGuildInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */