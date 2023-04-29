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
/*     */ public class SUsrInfo
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public String RoleId = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  21 */   public String RoleName = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  26 */   public int CashNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  31 */   public int MoneyNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int SilverNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public int Exp = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int Level = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public String SchoolName = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public String GangName = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public int HisContribution = 0;
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
/*  76 */   public int GangContribution = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int CompetitivePoint = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public int Fight = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public String RegisterTime = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int TotalLoginTime = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public String LastLogoutTime = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public int IsOnline = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   public int RechargeCashNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   public int BoundCashNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   public String UserID = "";
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 125 */     _js_.marshal("RoleId", this.RoleId);
/* 126 */     _js_.marshal("RoleName", this.RoleName);
/* 127 */     _js_.marshal("CashNum", Integer.valueOf(this.CashNum));
/* 128 */     _js_.marshal("MoneyNum", Integer.valueOf(this.MoneyNum));
/* 129 */     _js_.marshal("SilverNum", Integer.valueOf(this.SilverNum));
/* 130 */     _js_.marshal("Exp", Integer.valueOf(this.Exp));
/* 131 */     _js_.marshal("Level", Integer.valueOf(this.Level));
/* 132 */     _js_.marshal("SchoolName", this.SchoolName);
/* 133 */     _js_.marshal("GangName", this.GangName);
/* 134 */     _js_.marshal("HisContribution", Integer.valueOf(this.HisContribution));
/* 135 */     _js_.marshal("Chivalrous", Integer.valueOf(this.Chivalrous));
/* 136 */     _js_.marshal("Reputation", Integer.valueOf(this.Reputation));
/* 137 */     _js_.marshal("GangContribution", Integer.valueOf(this.GangContribution));
/* 138 */     _js_.marshal("CompetitivePoint", Integer.valueOf(this.CompetitivePoint));
/* 139 */     _js_.marshal("Fight", Integer.valueOf(this.Fight));
/* 140 */     _js_.marshal("RegisterTime", this.RegisterTime);
/* 141 */     _js_.marshal("TotalLoginTime", Integer.valueOf(this.TotalLoginTime));
/* 142 */     _js_.marshal("LastLogoutTime", this.LastLogoutTime);
/* 143 */     _js_.marshal("IsOnline", Integer.valueOf(this.IsOnline));
/* 144 */     _js_.marshal("RechargeCashNum", Integer.valueOf(this.RechargeCashNum));
/* 145 */     _js_.marshal("BoundCashNum", Integer.valueOf(this.BoundCashNum));
/* 146 */     _js_.marshal("UserID", this.UserID);
/* 147 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 152 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 153 */     this.RoleName = _js_.unmarshal_string("RoleName");
/* 154 */     this.CashNum = _js_.unmarshal_int("CashNum");
/* 155 */     this.MoneyNum = _js_.unmarshal_int("MoneyNum");
/* 156 */     this.SilverNum = _js_.unmarshal_int("SilverNum");
/* 157 */     this.Exp = _js_.unmarshal_int("Exp");
/* 158 */     this.Level = _js_.unmarshal_int("Level");
/* 159 */     this.SchoolName = _js_.unmarshal_string("SchoolName");
/* 160 */     this.GangName = _js_.unmarshal_string("GangName");
/* 161 */     this.HisContribution = _js_.unmarshal_int("HisContribution");
/* 162 */     this.Chivalrous = _js_.unmarshal_int("Chivalrous");
/* 163 */     this.Reputation = _js_.unmarshal_int("Reputation");
/* 164 */     this.GangContribution = _js_.unmarshal_int("GangContribution");
/* 165 */     this.CompetitivePoint = _js_.unmarshal_int("CompetitivePoint");
/* 166 */     this.Fight = _js_.unmarshal_int("Fight");
/* 167 */     this.RegisterTime = _js_.unmarshal_string("RegisterTime");
/* 168 */     this.TotalLoginTime = _js_.unmarshal_int("TotalLoginTime");
/* 169 */     this.LastLogoutTime = _js_.unmarshal_string("LastLogoutTime");
/* 170 */     this.IsOnline = _js_.unmarshal_int("IsOnline");
/* 171 */     this.RechargeCashNum = _js_.unmarshal_int("RechargeCashNum");
/* 172 */     this.BoundCashNum = _js_.unmarshal_int("BoundCashNum");
/* 173 */     this.UserID = _js_.unmarshal_string("UserID");
/* 174 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\SUsrInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */