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
/*     */ public class QueryRoleInfoRsp
/*     */   implements JsonMarshal
/*     */ {
/*  16 */   public String UserID = "";
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
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 120 */     _js_.marshal("UserID", this.UserID);
/* 121 */     _js_.marshal("RoleName", this.RoleName);
/* 122 */     _js_.marshal("CashNum", Integer.valueOf(this.CashNum));
/* 123 */     _js_.marshal("MoneyNum", Integer.valueOf(this.MoneyNum));
/* 124 */     _js_.marshal("SilverNum", Integer.valueOf(this.SilverNum));
/* 125 */     _js_.marshal("Exp", Integer.valueOf(this.Exp));
/* 126 */     _js_.marshal("Level", Integer.valueOf(this.Level));
/* 127 */     _js_.marshal("SchoolName", this.SchoolName);
/* 128 */     _js_.marshal("GangName", this.GangName);
/* 129 */     _js_.marshal("HisContribution", Integer.valueOf(this.HisContribution));
/* 130 */     _js_.marshal("Chivalrous", Integer.valueOf(this.Chivalrous));
/* 131 */     _js_.marshal("Reputation", Integer.valueOf(this.Reputation));
/* 132 */     _js_.marshal("GangContribution", Integer.valueOf(this.GangContribution));
/* 133 */     _js_.marshal("CompetitivePoint", Integer.valueOf(this.CompetitivePoint));
/* 134 */     _js_.marshal("Fight", Integer.valueOf(this.Fight));
/* 135 */     _js_.marshal("RegisterTime", this.RegisterTime);
/* 136 */     _js_.marshal("TotalLoginTime", Integer.valueOf(this.TotalLoginTime));
/* 137 */     _js_.marshal("LastLogoutTime", this.LastLogoutTime);
/* 138 */     _js_.marshal("IsOnline", Integer.valueOf(this.IsOnline));
/* 139 */     _js_.marshal("RechargeCashNum", Integer.valueOf(this.RechargeCashNum));
/* 140 */     _js_.marshal("BoundCashNum", Integer.valueOf(this.BoundCashNum));
/* 141 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 146 */     this.UserID = _js_.unmarshal_string("UserID");
/* 147 */     this.RoleName = _js_.unmarshal_string("RoleName");
/* 148 */     this.CashNum = _js_.unmarshal_int("CashNum");
/* 149 */     this.MoneyNum = _js_.unmarshal_int("MoneyNum");
/* 150 */     this.SilverNum = _js_.unmarshal_int("SilverNum");
/* 151 */     this.Exp = _js_.unmarshal_int("Exp");
/* 152 */     this.Level = _js_.unmarshal_int("Level");
/* 153 */     this.SchoolName = _js_.unmarshal_string("SchoolName");
/* 154 */     this.GangName = _js_.unmarshal_string("GangName");
/* 155 */     this.HisContribution = _js_.unmarshal_int("HisContribution");
/* 156 */     this.Chivalrous = _js_.unmarshal_int("Chivalrous");
/* 157 */     this.Reputation = _js_.unmarshal_int("Reputation");
/* 158 */     this.GangContribution = _js_.unmarshal_int("GangContribution");
/* 159 */     this.CompetitivePoint = _js_.unmarshal_int("CompetitivePoint");
/* 160 */     this.Fight = _js_.unmarshal_int("Fight");
/* 161 */     this.RegisterTime = _js_.unmarshal_string("RegisterTime");
/* 162 */     this.TotalLoginTime = _js_.unmarshal_int("TotalLoginTime");
/* 163 */     this.LastLogoutTime = _js_.unmarshal_string("LastLogoutTime");
/* 164 */     this.IsOnline = _js_.unmarshal_int("IsOnline");
/* 165 */     this.RechargeCashNum = _js_.unmarshal_int("RechargeCashNum");
/* 166 */     this.BoundCashNum = _js_.unmarshal_int("BoundCashNum");
/* 167 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\QueryRoleInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */