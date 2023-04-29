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
/*     */ public class SReportQQVipPayInfoResp
/*     */   extends __SReportQQVipPayInfoResp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600343;
/*     */   public int retcode;
/*     */   public int vip_flag;
/*     */   public byte is_new;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600343;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReportQQVipPayInfoResp()
/*     */   {
/*  35 */     this.vip_flag = 1;
/*     */   }
/*     */   
/*     */   public SReportQQVipPayInfoResp(int _retcode_, int _vip_flag_, byte _is_new_) {
/*  39 */     this.retcode = _retcode_;
/*  40 */     this.vip_flag = _vip_flag_;
/*  41 */     this.is_new = _is_new_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.retcode);
/*  50 */     _os_.marshal(this.vip_flag);
/*  51 */     _os_.marshal(this.is_new);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.retcode = _os_.unmarshal_int();
/*  57 */     this.vip_flag = _os_.unmarshal_int();
/*  58 */     this.is_new = _os_.unmarshal_byte();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof SReportQQVipPayInfoResp)) {
/*  68 */       SReportQQVipPayInfoResp _o_ = (SReportQQVipPayInfoResp)_o1_;
/*  69 */       if (this.retcode != _o_.retcode) return false;
/*  70 */       if (this.vip_flag != _o_.vip_flag) return false;
/*  71 */       if (this.is_new != _o_.is_new) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.retcode;
/*  80 */     _h_ += this.vip_flag;
/*  81 */     _h_ += this.is_new;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.retcode).append(",");
/*  89 */     _sb_.append(this.vip_flag).append(",");
/*  90 */     _sb_.append(this.is_new).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SReportQQVipPayInfoResp _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.retcode - _o_.retcode;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.vip_flag - _o_.vip_flag;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.is_new - _o_.is_new;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SReportQQVipPayInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */