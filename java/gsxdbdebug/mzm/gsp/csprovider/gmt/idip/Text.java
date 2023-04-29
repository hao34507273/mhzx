/*     */ package mzm.gsp.csprovider.gmt.idip;
/*     */ 
/*     */ import jsonio.JsonMarshal;
/*     */ import jsonio.JsonMarshalException;
/*     */ import jsonio.JsonStream;
/*     */ 
/*     */ public class Text
/*     */   implements JsonMarshal
/*     */ {
/*     */   public String opertype;
/*     */   public String oper_params1;
/*     */   public String oper_params2;
/*     */   public String oper_params3;
/*     */   public String oper_params4;
/*     */   public String oper_params5;
/*     */   public String oper_params6;
/*     */   public String oper_params7;
/*     */   public String oper_params8;
/*     */   public String oper_params9;
/*     */   public String oper_params10;
/*     */   public String oper_params11;
/*     */   public String oper_params12;
/*     */   public String oper_params13;
/*     */   public String oper_params14;
/*     */   public String oper_params15;
/*     */   public String oper_params16;
/*     */   public String oper_params17;
/*     */   public String oper_params18;
/*     */   public String oper_params19;
/*     */   public String oper_params20;
/*     */   public String oper_params21;
/*     */   public String oper_params22;
/*     */   public String oper_params23;
/*     */   public String oper_params24;
/*     */   public String oper_params25;
/*     */   
/*     */   public JsonStream marshal(JsonStream js)
/*     */   {
/*  39 */     js.marshal("opertype", this.opertype);
/*  40 */     js.marshal("oper_params1", this.oper_params1);
/*  41 */     js.marshal("oper_params2", this.oper_params2);
/*  42 */     js.marshal("oper_params3", this.oper_params3);
/*  43 */     js.marshal("oper_params4", this.oper_params4);
/*  44 */     js.marshal("oper_params5", this.oper_params5);
/*  45 */     js.marshal("oper_params6", this.oper_params6);
/*  46 */     js.marshal("oper_params7", this.oper_params7);
/*  47 */     js.marshal("oper_params8", this.oper_params8);
/*  48 */     js.marshal("oper_params9", this.oper_params9);
/*  49 */     js.marshal("oper_params10", this.oper_params10);
/*  50 */     js.marshal("oper_params11", this.oper_params11);
/*  51 */     js.marshal("oper_params12", this.oper_params12);
/*  52 */     js.marshal("oper_params13", this.oper_params13);
/*  53 */     js.marshal("oper_params14", this.oper_params14);
/*  54 */     js.marshal("oper_params15", this.oper_params15);
/*  55 */     js.marshal("oper_params16", this.oper_params16);
/*  56 */     js.marshal("oper_params17", this.oper_params17);
/*  57 */     js.marshal("oper_params18", this.oper_params18);
/*  58 */     js.marshal("oper_params19", this.oper_params19);
/*  59 */     js.marshal("oper_params20", this.oper_params20);
/*  60 */     js.marshal("oper_params21", this.oper_params21);
/*  61 */     js.marshal("oper_params22", this.oper_params22);
/*  62 */     js.marshal("oper_params23", this.oper_params23);
/*  63 */     js.marshal("oper_params24", this.oper_params24);
/*  64 */     js.marshal("oper_params25", this.oper_params25);
/*  65 */     return js;
/*     */   }
/*     */   
/*     */   public JsonStream unmarshal(JsonStream js)
/*     */     throws JsonMarshalException
/*     */   {
/*  71 */     this.opertype = js.unmarshal_string("opertype");
/*  72 */     this.oper_params1 = js.unmarshal_string("oper_params1");
/*  73 */     this.oper_params2 = js.unmarshal_string("oper_params2");
/*  74 */     this.oper_params3 = js.unmarshal_string("oper_params3");
/*  75 */     this.oper_params4 = js.unmarshal_string("oper_params4");
/*  76 */     this.oper_params5 = js.unmarshal_string("oper_params5");
/*  77 */     this.oper_params6 = js.unmarshal_string("oper_params6");
/*  78 */     this.oper_params7 = js.unmarshal_string("oper_params7");
/*  79 */     this.oper_params8 = js.unmarshal_string("oper_params8");
/*  80 */     this.oper_params9 = js.unmarshal_string("oper_params9");
/*  81 */     this.oper_params10 = js.unmarshal_string("oper_params10");
/*  82 */     this.oper_params11 = js.unmarshal_string("oper_params11");
/*  83 */     this.oper_params12 = js.unmarshal_string("oper_params12");
/*  84 */     this.oper_params13 = js.unmarshal_string("oper_params13");
/*  85 */     this.oper_params14 = js.unmarshal_string("oper_params14");
/*  86 */     this.oper_params15 = js.unmarshal_string("oper_params15");
/*  87 */     this.oper_params16 = js.unmarshal_string("oper_params16");
/*  88 */     this.oper_params17 = js.unmarshal_string("oper_params17");
/*  89 */     this.oper_params18 = js.unmarshal_string("oper_params18");
/*  90 */     this.oper_params19 = js.unmarshal_string("oper_params19");
/*  91 */     this.oper_params20 = js.unmarshal_string("oper_params20");
/*  92 */     this.oper_params21 = js.unmarshal_string("oper_params21");
/*  93 */     this.oper_params22 = js.unmarshal_string("oper_params22");
/*  94 */     this.oper_params23 = js.unmarshal_string("oper_params23");
/*  95 */     this.oper_params24 = js.unmarshal_string("oper_params24");
/*  96 */     this.oper_params25 = js.unmarshal_string("oper_params25");
/*  97 */     return js;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 103 */     JsonStream js = new JsonStream();
/* 104 */     marshal(js);
/* 105 */     return js.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */