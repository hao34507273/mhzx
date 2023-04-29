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
/*     */ public class DoUpdateNoticeReq
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public int AreaId = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public int Partition = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public byte PlatId = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public long NoticeId = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int NoticeType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int DisplayType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int HrefType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public String HrefText = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public String HrefUrl = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public int SendType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public String NoticeTitle = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public String NoticeContent = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public String PictureUrl = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public long StartTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public long EndTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public int MinOpenServerDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int MaxOpenServerDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public int MaxCreatRoleDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public int MinCreatRoleDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   public int MaxRoleLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   public int MinRoleLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   public long MaxSaveAmt = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 126 */   public long MinSaveAmt = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 131 */   public int NoticeTag = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 136 */   public int Badge = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 141 */   public int NoticeSortID = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 145 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 146 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 147 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 148 */     _js_.marshal("NoticeId", Long.valueOf(this.NoticeId));
/* 149 */     _js_.marshal("NoticeType", Integer.valueOf(this.NoticeType));
/* 150 */     _js_.marshal("DisplayType", Integer.valueOf(this.DisplayType));
/* 151 */     _js_.marshal("HrefType", Integer.valueOf(this.HrefType));
/* 152 */     _js_.marshal("HrefText", this.HrefText);
/* 153 */     _js_.marshal("HrefUrl", this.HrefUrl);
/* 154 */     _js_.marshal("SendType", Integer.valueOf(this.SendType));
/* 155 */     _js_.marshal("NoticeTitle", this.NoticeTitle);
/* 156 */     _js_.marshal("NoticeContent", this.NoticeContent);
/* 157 */     _js_.marshal("PictureUrl", this.PictureUrl);
/* 158 */     _js_.marshal("StartTime", Long.valueOf(this.StartTime));
/* 159 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
/* 160 */     _js_.marshal("MinOpenServerDays", Integer.valueOf(this.MinOpenServerDays));
/* 161 */     _js_.marshal("MaxOpenServerDays", Integer.valueOf(this.MaxOpenServerDays));
/* 162 */     _js_.marshal("MaxCreatRoleDays", Integer.valueOf(this.MaxCreatRoleDays));
/* 163 */     _js_.marshal("MinCreatRoleDays", Integer.valueOf(this.MinCreatRoleDays));
/* 164 */     _js_.marshal("MaxRoleLevel", Integer.valueOf(this.MaxRoleLevel));
/* 165 */     _js_.marshal("MinRoleLevel", Integer.valueOf(this.MinRoleLevel));
/* 166 */     _js_.marshal("MaxSaveAmt", Long.valueOf(this.MaxSaveAmt));
/* 167 */     _js_.marshal("MinSaveAmt", Long.valueOf(this.MinSaveAmt));
/* 168 */     _js_.marshal("NoticeTag", Integer.valueOf(this.NoticeTag));
/* 169 */     _js_.marshal("Badge", Integer.valueOf(this.Badge));
/* 170 */     _js_.marshal("NoticeSortID", Integer.valueOf(this.NoticeSortID));
/* 171 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 176 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 177 */     this.Partition = _js_.unmarshal_int("Partition");
/* 178 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 179 */     this.NoticeId = _js_.unmarshal_long("NoticeId");
/* 180 */     this.NoticeType = _js_.unmarshal_int("NoticeType");
/* 181 */     this.DisplayType = _js_.unmarshal_int("DisplayType");
/* 182 */     this.HrefType = _js_.unmarshal_int("HrefType");
/* 183 */     this.HrefText = _js_.unmarshal_string("HrefText");
/* 184 */     this.HrefUrl = _js_.unmarshal_string("HrefUrl");
/* 185 */     this.SendType = _js_.unmarshal_int("SendType");
/* 186 */     this.NoticeTitle = _js_.unmarshal_string("NoticeTitle");
/* 187 */     this.NoticeContent = _js_.unmarshal_string("NoticeContent");
/* 188 */     this.PictureUrl = _js_.unmarshal_string("PictureUrl");
/* 189 */     this.StartTime = _js_.unmarshal_long("StartTime");
/* 190 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 191 */     this.MinOpenServerDays = _js_.unmarshal_int("MinOpenServerDays");
/* 192 */     this.MaxOpenServerDays = _js_.unmarshal_int("MaxOpenServerDays");
/* 193 */     this.MaxCreatRoleDays = _js_.unmarshal_int("MaxCreatRoleDays");
/* 194 */     this.MinCreatRoleDays = _js_.unmarshal_int("MinCreatRoleDays");
/* 195 */     this.MaxRoleLevel = _js_.unmarshal_int("MaxRoleLevel");
/* 196 */     this.MinRoleLevel = _js_.unmarshal_int("MinRoleLevel");
/* 197 */     this.MaxSaveAmt = _js_.unmarshal_long("MaxSaveAmt");
/* 198 */     this.MinSaveAmt = _js_.unmarshal_long("MinSaveAmt");
/* 199 */     this.NoticeTag = _js_.unmarshal_int("NoticeTag");
/* 200 */     this.Badge = _js_.unmarshal_int("Badge");
/* 201 */     this.NoticeSortID = _js_.unmarshal_int("NoticeSortID");
/* 202 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoUpdateNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */