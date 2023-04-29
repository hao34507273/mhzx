/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*     */ public class SGrcTurnOnOffResp
/*     */   extends __SGrcTurnOnOffResp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600325;
/*     */   public int retcode;
/*     */   public int gift_type;
/*     */   public byte onoff;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600325;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGrcTurnOnOffResp() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGrcTurnOnOffResp(int _retcode_, int _gift_type_, byte _onoff_)
/*     */   {
/*  38 */     this.retcode = _retcode_;
/*  39 */     this.gift_type = _gift_type_;
/*  40 */     this.onoff = _onoff_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.retcode);
/*  49 */     _os_.marshal(this.gift_type);
/*  50 */     _os_.marshal(this.onoff);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.retcode = _os_.unmarshal_int();
/*  56 */     this.gift_type = _os_.unmarshal_int();
/*  57 */     this.onoff = _os_.unmarshal_byte();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGrcTurnOnOffResp)) {
/*  67 */       SGrcTurnOnOffResp _o_ = (SGrcTurnOnOffResp)_o1_;
/*  68 */       if (this.retcode != _o_.retcode) return false;
/*  69 */       if (this.gift_type != _o_.gift_type) return false;
/*  70 */       if (this.onoff != _o_.onoff) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.retcode;
/*  79 */     _h_ += this.gift_type;
/*  80 */     _h_ += this.onoff;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.retcode).append(",");
/*  88 */     _sb_.append(this.gift_type).append(",");
/*  89 */     _sb_.append(this.onoff).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGrcTurnOnOffResp _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.retcode - _o_.retcode;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.gift_type - _o_.gift_type;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.onoff - _o_.onoff;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SGrcTurnOnOffResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */