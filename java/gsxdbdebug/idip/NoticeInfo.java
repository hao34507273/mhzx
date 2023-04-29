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
/*     */ public class NoticeInfo
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public long NoticeId = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public int NoticeType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public int DisplayType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public int HrefType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public String HrefText = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public String HrefUrl = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int SendType = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public String NoticeTitle = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public String NoticeContent = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public String PictureUrl = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public long StartTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public long EndTime = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public int MinOpenServerDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int MaxOpenServerDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public int MaxCreatRoleDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public int MinCreatRoleDays = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int MaxRoleLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public int MinRoleLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public long HighRecharge = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   public long MinSaveAmt = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   public int NoticeTag = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   public int Badge = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 126 */   public int NoticeSortID = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 131 */   public int Partition = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 135 */     _js_.marshal("NoticeId", Long.valueOf(this.NoticeId));
/* 136 */     _js_.marshal("NoticeType", Integer.valueOf(this.NoticeType));
/* 137 */     _js_.marshal("DisplayType", Integer.valueOf(this.DisplayType));
/* 138 */     _js_.marshal("HrefType", Integer.valueOf(this.HrefType));
/* 139 */     _js_.marshal("HrefText", this.HrefText);
/* 140 */     _js_.marshal("HrefUrl", this.HrefUrl);
/* 141 */     _js_.marshal("SendType", Integer.valueOf(this.SendType));
/* 142 */     _js_.marshal("NoticeTitle", this.NoticeTitle);
/* 143 */     _js_.marshal("NoticeContent", this.NoticeContent);
/* 144 */     _js_.marshal("PictureUrl", this.PictureUrl);
/* 145 */     _js_.marshal("StartTime", Long.valueOf(this.StartTime));
/* 146 */     _js_.marshal("EndTime", Long.valueOf(this.EndTime));
/* 147 */     _js_.marshal("MinOpenServerDays", Integer.valueOf(this.MinOpenServerDays));
/* 148 */     _js_.marshal("MaxOpenServerDays", Integer.valueOf(this.MaxOpenServerDays));
/* 149 */     _js_.marshal("MaxCreatRoleDays", Integer.valueOf(this.MaxCreatRoleDays));
/* 150 */     _js_.marshal("MinCreatRoleDays", Integer.valueOf(this.MinCreatRoleDays));
/* 151 */     _js_.marshal("MaxRoleLevel", Integer.valueOf(this.MaxRoleLevel));
/* 152 */     _js_.marshal("MinRoleLevel", Integer.valueOf(this.MinRoleLevel));
/* 153 */     _js_.marshal("HighRecharge", Long.valueOf(this.HighRecharge));
/* 154 */     _js_.marshal("MinSaveAmt", Long.valueOf(this.MinSaveAmt));
/* 155 */     _js_.marshal("NoticeTag", Integer.valueOf(this.NoticeTag));
/* 156 */     _js_.marshal("Badge", Integer.valueOf(this.Badge));
/* 157 */     _js_.marshal("NoticeSortID", Integer.valueOf(this.NoticeSortID));
/* 158 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 159 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 164 */     this.NoticeId = _js_.unmarshal_long("NoticeId");
/* 165 */     this.NoticeType = _js_.unmarshal_int("NoticeType");
/* 166 */     this.DisplayType = _js_.unmarshal_int("DisplayType");
/* 167 */     this.HrefType = _js_.unmarshal_int("HrefType");
/* 168 */     this.HrefText = _js_.unmarshal_string("HrefText");
/* 169 */     this.HrefUrl = _js_.unmarshal_string("HrefUrl");
/* 170 */     this.SendType = _js_.unmarshal_int("SendType");
/* 171 */     this.NoticeTitle = _js_.unmarshal_string("NoticeTitle");
/* 172 */     this.NoticeContent = _js_.unmarshal_string("NoticeContent");
/* 173 */     this.PictureUrl = _js_.unmarshal_string("PictureUrl");
/* 174 */     this.StartTime = _js_.unmarshal_long("StartTime");
/* 175 */     this.EndTime = _js_.unmarshal_long("EndTime");
/* 176 */     this.MinOpenServerDays = _js_.unmarshal_int("MinOpenServerDays");
/* 177 */     this.MaxOpenServerDays = _js_.unmarshal_int("MaxOpenServerDays");
/* 178 */     this.MaxCreatRoleDays = _js_.unmarshal_int("MaxCreatRoleDays");
/* 179 */     this.MinCreatRoleDays = _js_.unmarshal_int("MinCreatRoleDays");
/* 180 */     this.MaxRoleLevel = _js_.unmarshal_int("MaxRoleLevel");
/* 181 */     this.MinRoleLevel = _js_.unmarshal_int("MinRoleLevel");
/* 182 */     this.HighRecharge = _js_.unmarshal_long("HighRecharge");
/* 183 */     this.MinSaveAmt = _js_.unmarshal_long("MinSaveAmt");
/* 184 */     this.NoticeTag = _js_.unmarshal_int("NoticeTag");
/* 185 */     this.Badge = _js_.unmarshal_int("Badge");
/* 186 */     this.NoticeSortID = _js_.unmarshal_int("NoticeSortID");
/* 187 */     this.Partition = _js_.unmarshal_int("Partition");
/* 188 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\NoticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */