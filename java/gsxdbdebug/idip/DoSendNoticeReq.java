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
/*     */ public class DoSendNoticeReq
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
/*  31 */   public int NoticeType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int DisplayType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int HrefType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public String HrefText = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public String HrefUrl = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public int SendType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public String NoticeTitle = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public String NoticeContent = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public String PictureUrl = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public long StartTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public long EndTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public int MinOpenServerDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public int MaxOpenServerDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int MaxCreatRoleDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public int MinCreatRoleDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public int MaxRoleLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   public int MinRoleLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   public long MaxSaveAmt = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   public long MinSaveAmt = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 126 */   public int NoticeTag = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 131 */   public int Badge = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 136 */   public int NoticeSortID = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 141 */   public long NoticeId = 0L;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 145 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 146 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 147 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 148 */     _js_.marshal("NoticeType", Integer.valueOf(this.NoticeType));
/* 149 */     _js_.marshal("DisplayType", Integer.valueOf(this.DisplayType));
/* 150 */     _js_.marshal("HrefType", Integer.valueOf(this.HrefType));
/* 151 */     _js_.marshal("HrefText", this.HrefText);
/* 152 */     _js_.marshal("HrefUrl", this.HrefUrl);
/* 153 */     _js_.marshal("SendType", Integer.valueOf(this.SendType));
/* 154 */     _js_.marshal("NoticeTitle", this.NoticeTitle);
/* 155 */     _js_.marshal("NoticeContent", this.NoticeContent);
/* 156 */     _js_.marshal("PictureUrl", this.PictureUrl);
/* 157 */     _js_.marshal("StartTime", Long.valueOf(this.StartTime));
/* 158 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
/* 159 */     _js_.marshal("MinOpenServerDays", Integer.valueOf(this.MinOpenServerDays));
/* 160 */     _js_.marshal("MaxOpenServerDays", Integer.valueOf(this.MaxOpenServerDays));
/* 161 */     _js_.marshal("MaxCreatRoleDays", Integer.valueOf(this.MaxCreatRoleDays));
/* 162 */     _js_.marshal("MinCreatRoleDays", Integer.valueOf(this.MinCreatRoleDays));
/* 163 */     _js_.marshal("MaxRoleLevel", Integer.valueOf(this.MaxRoleLevel));
/* 164 */     _js_.marshal("MinRoleLevel", Integer.valueOf(this.MinRoleLevel));
/* 165 */     _js_.marshal("MaxSaveAmt", Long.valueOf(this.MaxSaveAmt));
/* 166 */     _js_.marshal("MinSaveAmt", Long.valueOf(this.MinSaveAmt));
/* 167 */     _js_.marshal("NoticeTag", Integer.valueOf(this.NoticeTag));
/* 168 */     _js_.marshal("Badge", Integer.valueOf(this.Badge));
/* 169 */     _js_.marshal("NoticeSortID", Integer.valueOf(this.NoticeSortID));
/* 170 */     _js_.marshal("NoticeId", Long.valueOf(this.NoticeId));
/* 171 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 176 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 177 */     this.Partition = _js_.unmarshal_int("Partition");
/* 178 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 179 */     this.NoticeType = _js_.unmarshal_int("NoticeType");
/* 180 */     this.DisplayType = _js_.unmarshal_int("DisplayType");
/* 181 */     this.HrefType = _js_.unmarshal_int("HrefType");
/* 182 */     this.HrefText = _js_.unmarshal_string("HrefText");
/* 183 */     this.HrefUrl = _js_.unmarshal_string("HrefUrl");
/* 184 */     this.SendType = _js_.unmarshal_int("SendType");
/* 185 */     this.NoticeTitle = _js_.unmarshal_string("NoticeTitle");
/* 186 */     this.NoticeContent = _js_.unmarshal_string("NoticeContent");
/* 187 */     this.PictureUrl = _js_.unmarshal_string("PictureUrl");
/* 188 */     this.StartTime = _js_.unmarshal_long("StartTime");
/* 189 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 190 */     this.MinOpenServerDays = _js_.unmarshal_int("MinOpenServerDays");
/* 191 */     this.MaxOpenServerDays = _js_.unmarshal_int("MaxOpenServerDays");
/* 192 */     this.MaxCreatRoleDays = _js_.unmarshal_int("MaxCreatRoleDays");
/* 193 */     this.MinCreatRoleDays = _js_.unmarshal_int("MinCreatRoleDays");
/* 194 */     this.MaxRoleLevel = _js_.unmarshal_int("MaxRoleLevel");
/* 195 */     this.MinRoleLevel = _js_.unmarshal_int("MinRoleLevel");
/* 196 */     this.MaxSaveAmt = _js_.unmarshal_long("MaxSaveAmt");
/* 197 */     this.MinSaveAmt = _js_.unmarshal_long("MinSaveAmt");
/* 198 */     this.NoticeTag = _js_.unmarshal_int("NoticeTag");
/* 199 */     this.Badge = _js_.unmarshal_int("Badge");
/* 200 */     this.NoticeSortID = _js_.unmarshal_int("NoticeSortID");
/* 201 */     this.NoticeId = _js_.unmarshal_long("NoticeId");
/* 202 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoSendNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */