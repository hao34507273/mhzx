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
/*     */ public class DoSendMoreItemBySystemMailReq
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
/*  41 */   public String MailTitle = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public String MailContent = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   public int Source = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  56 */   public String Serial = "";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public long ItemId1 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   public int ItemNum1 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  71 */   public long ItemId2 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   public int ItemNum2 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public long ItemId3 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  86 */   public int ItemNum3 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  91 */   public long ItemId4 = 0L;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public int ItemNum4 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 101 */   public int MoneyType1 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public int MoneyNum1 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 111 */   public int MoneyType2 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   public int MoneyNum2 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 121 */   public int MoneyType3 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 126 */   public int MoneyNum3 = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 131 */   public int TagId = 0;
/*     */   
/*     */   public JsonStream marshal(JsonStream _js_)
/*     */   {
/* 135 */     _js_.marshal("AreaId", Integer.valueOf(this.AreaId));
/* 136 */     _js_.marshal("PlatId", Byte.valueOf(this.PlatId));
/* 137 */     _js_.marshal("Partition", Integer.valueOf(this.Partition));
/* 138 */     _js_.marshal("OpenId", this.OpenId);
/* 139 */     _js_.marshal("RoleId", this.RoleId);
/* 140 */     _js_.marshal("MailTitle", this.MailTitle);
/* 141 */     _js_.marshal("MailContent", this.MailContent);
/* 142 */     _js_.marshal("Source", Integer.valueOf(this.Source));
/* 143 */     _js_.marshal("Serial", this.Serial);
/* 144 */     _js_.marshal("ItemId1", Long.valueOf(this.ItemId1));
/* 145 */     _js_.marshal("ItemNum1", Integer.valueOf(this.ItemNum1));
/* 146 */     _js_.marshal("ItemId2", Long.valueOf(this.ItemId2));
/* 147 */     _js_.marshal("ItemNum2", Integer.valueOf(this.ItemNum2));
/* 148 */     _js_.marshal("ItemId3", Long.valueOf(this.ItemId3));
/* 149 */     _js_.marshal("ItemNum3", Integer.valueOf(this.ItemNum3));
/* 150 */     _js_.marshal("ItemId4", Long.valueOf(this.ItemId4));
/* 151 */     _js_.marshal("ItemNum4", Integer.valueOf(this.ItemNum4));
/* 152 */     _js_.marshal("MoneyType1", Integer.valueOf(this.MoneyType1));
/* 153 */     _js_.marshal("MoneyNum1", Integer.valueOf(this.MoneyNum1));
/* 154 */     _js_.marshal("MoneyType2", Integer.valueOf(this.MoneyType2));
/* 155 */     _js_.marshal("MoneyNum2", Integer.valueOf(this.MoneyNum2));
/* 156 */     _js_.marshal("MoneyType3", Integer.valueOf(this.MoneyType3));
/* 157 */     _js_.marshal("MoneyNum3", Integer.valueOf(this.MoneyNum3));
/* 158 */     _js_.marshal("TagId", Integer.valueOf(this.TagId));
/* 159 */     return _js_;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream _js_) throws JsonMarshalException
/*     */   {
/* 164 */     this.AreaId = _js_.unmarshal_int("AreaId");
/* 165 */     this.PlatId = _js_.unmarshal_byte("PlatId");
/* 166 */     this.Partition = _js_.unmarshal_int("Partition");
/* 167 */     this.OpenId = _js_.unmarshal_string("OpenId");
/* 168 */     this.RoleId = _js_.unmarshal_string("RoleId");
/* 169 */     this.MailTitle = _js_.unmarshal_string("MailTitle");
/* 170 */     this.MailContent = _js_.unmarshal_string("MailContent");
/* 171 */     this.Source = _js_.unmarshal_int("Source");
/* 172 */     this.Serial = _js_.unmarshal_string("Serial");
/* 173 */     this.ItemId1 = _js_.unmarshal_long("ItemId1");
/* 174 */     this.ItemNum1 = _js_.unmarshal_int("ItemNum1");
/* 175 */     this.ItemId2 = _js_.unmarshal_long("ItemId2");
/* 176 */     this.ItemNum2 = _js_.unmarshal_int("ItemNum2");
/* 177 */     this.ItemId3 = _js_.unmarshal_long("ItemId3");
/* 178 */     this.ItemNum3 = _js_.unmarshal_int("ItemNum3");
/* 179 */     this.ItemId4 = _js_.unmarshal_long("ItemId4");
/* 180 */     this.ItemNum4 = _js_.unmarshal_int("ItemNum4");
/* 181 */     this.MoneyType1 = _js_.unmarshal_int("MoneyType1");
/* 182 */     this.MoneyNum1 = _js_.unmarshal_int("MoneyNum1");
/* 183 */     this.MoneyType2 = _js_.unmarshal_int("MoneyType2");
/* 184 */     this.MoneyNum2 = _js_.unmarshal_int("MoneyNum2");
/* 185 */     this.MoneyType3 = _js_.unmarshal_int("MoneyType3");
/* 186 */     this.MoneyNum3 = _js_.unmarshal_int("MoneyNum3");
/* 187 */     this.TagId = _js_.unmarshal_int("TagId");
/* 188 */     return _js_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\DoSendMoreItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */