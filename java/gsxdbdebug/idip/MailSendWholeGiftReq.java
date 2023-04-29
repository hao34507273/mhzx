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
/*     */ public class MailSendWholeGiftReq
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
/*  31 */   public int MinLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public int MaxLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   public long MailStart = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public long MailEnd = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public String MailTitle = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public String MailContent = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public int OptionsID = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public int OptionsNum = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public int MoneyType1 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public int MoneyNum1 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int MoneyType2 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public int MoneyNum2 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public int MoneyType3 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int MoneyNum3 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public int Source = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public String Serial = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   public int Options2ID = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   public int Options2Num = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   public int Options3ID = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 126 */   public int Options3Num = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 131 */   public int FirstCreateTime = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 136 */   public int LastCreateTime = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 141 */   public int TagId = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 145 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 146 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 147 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 148 */     _js_.marshal("MinLevel", Integer.valueOf(this.MinLevel));
/* 149 */     _js_.marshal("MaxLevel", Integer.valueOf(this.MaxLevel));
/* 150 */     _js_.marshal("MailStart", Long.valueOf(this.MailStart));
/* 151 */     _js_.marshal("MailEnd", Long.valueOf(this.MailEnd));
/* 152 */     _js_.marshal("MailTitle", this.MailTitle);
/* 153 */     _js_.marshal("MailContent", this.MailContent);
/* 154 */     _js_.marshal("OptionsID", Integer.valueOf(this.OptionsID));
/* 155 */     _js_.marshal("OptionsNum", Integer.valueOf(this.OptionsNum));
/* 156 */     _js_.marshal("MoneyType1", Integer.valueOf(this.MoneyType1));
/* 157 */     _js_.marshal("MoneyNum1", Integer.valueOf(this.MoneyNum1));
/* 158 */     _js_.marshal("MoneyType2", Integer.valueOf(this.MoneyType2));
/* 159 */     _js_.marshal("MoneyNum2", Integer.valueOf(this.MoneyNum2));
/* 160 */     _js_.marshal("MoneyType3", Integer.valueOf(this.MoneyType3));
/* 161 */     _js_.marshal("MoneyNum3", Integer.valueOf(this.MoneyNum3));
/* 162 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 163 */     _js_.marshal("Serial", this.Serial);
/* 164 */     _js_.marshal("Options2ID", Integer.valueOf(this.Options2ID));
/* 165 */     _js_.marshal("Options2Num", Integer.valueOf(this.Options2Num));
/* 166 */     _js_.marshal("Options3ID", Integer.valueOf(this.Options3ID));
/* 167 */     _js_.marshal("Options3Num", Integer.valueOf(this.Options3Num));
/* 168 */     _js_.marshal("FirstCreateTime", Integer.valueOf(this.FirstCreateTime));
/* 169 */     _js_.marshal("LastCreateTime", Integer.valueOf(this.LastCreateTime));
/* 170 */     _js_.marshal("TagId", Integer.valueOf(this.TagId));
/* 171 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 176 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 177 */     this.Partition = _js_.unmarshal_int("Partition");
/* 178 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 179 */     this.MinLevel = _js_.unmarshal_int("MinLevel");
/* 180 */     this.MaxLevel = _js_.unmarshal_int("MaxLevel");
/* 181 */     this.MailStart = _js_.unmarshal_long("MailStart");
/* 182 */     this.MailEnd = _js_.unmarshal_long("MailEnd");
/* 183 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 184 */     this.MailContent = _js_.unmarshal_string("MailContent");
/* 185 */     this.OptionsID = _js_.unmarshal_int("OptionsID");
/* 186 */     this.OptionsNum = _js_.unmarshal_int("OptionsNum");
/* 187 */     this.MoneyType1 = _js_.unmarshal_int("MoneyType1");
/* 188 */     this.MoneyNum1 = _js_.unmarshal_int("MoneyNum1");
/* 189 */     this.MoneyType2 = _js_.unmarshal_int("MoneyType2");
/* 190 */     this.MoneyNum2 = _js_.unmarshal_int("MoneyNum2");
/* 191 */     this.MoneyType3 = _js_.unmarshal_int("MoneyType3");
/* 192 */     this.MoneyNum3 = _js_.unmarshal_int("MoneyNum3");
/* 193 */     this.Source = _js_.unmarshal_int("Source");
/* 194 */     this.Serial = _js_.unmarshal_string("Serial");
/* 195 */     this.Options2ID = _js_.unmarshal_int("Options2ID");
/* 196 */     this.Options2Num = _js_.unmarshal_int("Options2Num");
/* 197 */     this.Options3ID = _js_.unmarshal_int("Options3ID");
/* 198 */     this.Options3Num = _js_.unmarshal_int("Options3Num");
/* 199 */     this.FirstCreateTime = _js_.unmarshal_int("FirstCreateTime");
/* 200 */     this.LastCreateTime = _js_.unmarshal_int("LastCreateTime");
/* 201 */     this.TagId = _js_.unmarshal_int("TagId");
/* 202 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\MailSendWholeGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */