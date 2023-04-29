/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncSelfInfo
/*     */   extends __SSyncSelfInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589979;
/*     */   public long read_announcement_timestamp;
/*     */   public int redeembanggong;
/*     */   public long get_fuli_timestamp;
/*     */   public long have_mifang_timestamp;
/*     */   public long sign_timestamp;
/*     */   public String signstr;
/*     */   public int yuan_bao_redeem_bang_gong;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12589979;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncSelfInfo()
/*     */   {
/*  37 */     this.read_announcement_timestamp = 0L;
/*  38 */     this.get_fuli_timestamp = 0L;
/*  39 */     this.have_mifang_timestamp = 0L;
/*  40 */     this.sign_timestamp = 0L;
/*  41 */     this.signstr = "";
/*     */   }
/*     */   
/*     */   public SSyncSelfInfo(long _read_announcement_timestamp_, int _redeembanggong_, long _get_fuli_timestamp_, long _have_mifang_timestamp_, long _sign_timestamp_, String _signstr_, int _yuan_bao_redeem_bang_gong_) {
/*  45 */     this.read_announcement_timestamp = _read_announcement_timestamp_;
/*  46 */     this.redeembanggong = _redeembanggong_;
/*  47 */     this.get_fuli_timestamp = _get_fuli_timestamp_;
/*  48 */     this.have_mifang_timestamp = _have_mifang_timestamp_;
/*  49 */     this.sign_timestamp = _sign_timestamp_;
/*  50 */     this.signstr = _signstr_;
/*  51 */     this.yuan_bao_redeem_bang_gong = _yuan_bao_redeem_bang_gong_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.read_announcement_timestamp);
/*  60 */     _os_.marshal(this.redeembanggong);
/*  61 */     _os_.marshal(this.get_fuli_timestamp);
/*  62 */     _os_.marshal(this.have_mifang_timestamp);
/*  63 */     _os_.marshal(this.sign_timestamp);
/*  64 */     _os_.marshal(this.signstr, "UTF-16LE");
/*  65 */     _os_.marshal(this.yuan_bao_redeem_bang_gong);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.read_announcement_timestamp = _os_.unmarshal_long();
/*  71 */     this.redeembanggong = _os_.unmarshal_int();
/*  72 */     this.get_fuli_timestamp = _os_.unmarshal_long();
/*  73 */     this.have_mifang_timestamp = _os_.unmarshal_long();
/*  74 */     this.sign_timestamp = _os_.unmarshal_long();
/*  75 */     this.signstr = _os_.unmarshal_String("UTF-16LE");
/*  76 */     this.yuan_bao_redeem_bang_gong = _os_.unmarshal_int();
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SSyncSelfInfo)) {
/*  86 */       SSyncSelfInfo _o_ = (SSyncSelfInfo)_o1_;
/*  87 */       if (this.read_announcement_timestamp != _o_.read_announcement_timestamp) return false;
/*  88 */       if (this.redeembanggong != _o_.redeembanggong) return false;
/*  89 */       if (this.get_fuli_timestamp != _o_.get_fuli_timestamp) return false;
/*  90 */       if (this.have_mifang_timestamp != _o_.have_mifang_timestamp) return false;
/*  91 */       if (this.sign_timestamp != _o_.sign_timestamp) return false;
/*  92 */       if (!this.signstr.equals(_o_.signstr)) return false;
/*  93 */       if (this.yuan_bao_redeem_bang_gong != _o_.yuan_bao_redeem_bang_gong) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += (int)this.read_announcement_timestamp;
/* 102 */     _h_ += this.redeembanggong;
/* 103 */     _h_ += (int)this.get_fuli_timestamp;
/* 104 */     _h_ += (int)this.have_mifang_timestamp;
/* 105 */     _h_ += (int)this.sign_timestamp;
/* 106 */     _h_ += this.signstr.hashCode();
/* 107 */     _h_ += this.yuan_bao_redeem_bang_gong;
/* 108 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     StringBuilder _sb_ = new StringBuilder();
/* 113 */     _sb_.append("(");
/* 114 */     _sb_.append(this.read_announcement_timestamp).append(",");
/* 115 */     _sb_.append(this.redeembanggong).append(",");
/* 116 */     _sb_.append(this.get_fuli_timestamp).append(",");
/* 117 */     _sb_.append(this.have_mifang_timestamp).append(",");
/* 118 */     _sb_.append(this.sign_timestamp).append(",");
/* 119 */     _sb_.append("T").append(this.signstr.length()).append(",");
/* 120 */     _sb_.append(this.yuan_bao_redeem_bang_gong).append(",");
/* 121 */     _sb_.append(")");
/* 122 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncSelfInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */