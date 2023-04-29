/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGangCombineBrd
/*     */   extends __SGangCombineBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589968;
/*     */   public static final int FROM_MAIN = 0;
/*     */   public static final int FROM_VICE = 1;
/*     */   public static final int RESULT_SUCCEED = 0;
/*     */   public static final int RESULT_FAIL = 1;
/*     */   public long main_id;
/*     */   public String main_name;
/*     */   public long vice_id;
/*     */   public String vice_name;
/*     */   public int come_from;
/*     */   public int result;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589968;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGangCombineBrd()
/*     */   {
/*  43 */     this.main_name = "";
/*  44 */     this.vice_name = "";
/*     */   }
/*     */   
/*     */   public SGangCombineBrd(long _main_id_, String _main_name_, long _vice_id_, String _vice_name_, int _come_from_, int _result_) {
/*  48 */     this.main_id = _main_id_;
/*  49 */     this.main_name = _main_name_;
/*  50 */     this.vice_id = _vice_id_;
/*  51 */     this.vice_name = _vice_name_;
/*  52 */     this.come_from = _come_from_;
/*  53 */     this.result = _result_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.main_id);
/*  62 */     _os_.marshal(this.main_name, "UTF-16LE");
/*  63 */     _os_.marshal(this.vice_id);
/*  64 */     _os_.marshal(this.vice_name, "UTF-16LE");
/*  65 */     _os_.marshal(this.come_from);
/*  66 */     _os_.marshal(this.result);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.main_id = _os_.unmarshal_long();
/*  72 */     this.main_name = _os_.unmarshal_String("UTF-16LE");
/*  73 */     this.vice_id = _os_.unmarshal_long();
/*  74 */     this.vice_name = _os_.unmarshal_String("UTF-16LE");
/*  75 */     this.come_from = _os_.unmarshal_int();
/*  76 */     this.result = _os_.unmarshal_int();
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SGangCombineBrd)) {
/*  86 */       SGangCombineBrd _o_ = (SGangCombineBrd)_o1_;
/*  87 */       if (this.main_id != _o_.main_id) return false;
/*  88 */       if (!this.main_name.equals(_o_.main_name)) return false;
/*  89 */       if (this.vice_id != _o_.vice_id) return false;
/*  90 */       if (!this.vice_name.equals(_o_.vice_name)) return false;
/*  91 */       if (this.come_from != _o_.come_from) return false;
/*  92 */       if (this.result != _o_.result) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += (int)this.main_id;
/* 101 */     _h_ += this.main_name.hashCode();
/* 102 */     _h_ += (int)this.vice_id;
/* 103 */     _h_ += this.vice_name.hashCode();
/* 104 */     _h_ += this.come_from;
/* 105 */     _h_ += this.result;
/* 106 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuilder _sb_ = new StringBuilder();
/* 111 */     _sb_.append("(");
/* 112 */     _sb_.append(this.main_id).append(",");
/* 113 */     _sb_.append("T").append(this.main_name.length()).append(",");
/* 114 */     _sb_.append(this.vice_id).append(",");
/* 115 */     _sb_.append("T").append(this.vice_name.length()).append(",");
/* 116 */     _sb_.append(this.come_from).append(",");
/* 117 */     _sb_.append(this.result).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SGangCombineBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */