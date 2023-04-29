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
/*     */ public class DoSendItemBySystemMailReq
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
/*  41 */   public long ItemId = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public int ItemLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public int Num = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public String MailTitle = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public String MailContent = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public int Source = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public String Serial = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public int MoneyType1 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public int MoneyNum1 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public int MoneyType2 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public int MoneyNum2 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int MoneyType3 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public int MoneyNum3 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public int TagId = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 110 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 111 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 112 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 113 */     _js_.marshal("OpenId", this.OpenId);
/* 114 */     _js_.marshal("RoleId", this.RoleId);
/* 115 */     _js_.marshal("ItemId", Long.valueOf(this.ItemId));
/* 116 */     _js_.marshal("ItemLevel", Integer.valueOf(this.ItemLevel));
/* 117 */     _js_.marshal("Num", Integer.valueOf(this.Num));
/* 118 */     _js_.marshal("MailTitle", this.MailTitle);
/* 119 */     _js_.marshal("MailContent", this.MailContent);
/* 120 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 121 */     _js_.marshal("Serial", this.Serial);
/* 122 */     _js_.marshal("MoneyType1", Integer.valueOf(this.MoneyType1));
/* 123 */     _js_.marshal("MoneyNum1", Integer.valueOf(this.MoneyNum1));
/* 124 */     _js_.marshal("MoneyType2", Integer.valueOf(this.MoneyType2));
/* 125 */     _js_.marshal("MoneyNum2", Integer.valueOf(this.MoneyNum2));
/* 126 */     _js_.marshal("MoneyType3", Integer.valueOf(this.MoneyType3));
/* 127 */     _js_.marshal("MoneyNum3", Integer.valueOf(this.MoneyNum3));
/* 128 */     _js_.marshal("TagId", Integer.valueOf(this.TagId));
/* 129 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 134 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 135 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 136 */     this.Partition = _js_.unmarshal_int("Partition");
/* 137 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 138 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 139 */     this.ItemId = _js_.unmarshal_long("ItemId");
/* 140 */     this.ItemLevel = _js_.unmarshal_int("ItemLevel");
/* 141 */     this.Num = _js_.unmarshal_int("Num");
/* 142 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 143 */     this.MailContent = _js_.unmarshal_string("MailContent");
/* 144 */     this.Source = _js_.unmarshal_int("Source");
/* 145 */     this.Serial = _js_.unmarshal_string("Serial");
/* 146 */     this.MoneyType1 = _js_.unmarshal_int("MoneyType1");
/* 147 */     this.MoneyNum1 = _js_.unmarshal_int("MoneyNum1");
/* 148 */     this.MoneyType2 = _js_.unmarshal_int("MoneyType2");
/* 149 */     this.MoneyNum2 = _js_.unmarshal_int("MoneyNum2");
/* 150 */     this.MoneyType3 = _js_.unmarshal_int("MoneyType3");
/* 151 */     this.MoneyNum3 = _js_.unmarshal_int("MoneyNum3");
/* 152 */     this.TagId = _js_.unmarshal_int("TagId");
/* 153 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoSendItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */