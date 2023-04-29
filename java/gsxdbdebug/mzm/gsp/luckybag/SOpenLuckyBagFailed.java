/*     */ package mzm.gsp.luckybag;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class SOpenLuckyBagFailed
/*     */   extends __SOpenLuckyBagFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607490;
/*     */   public static final int ERROR_CURRENCY_NOT_ENOUGH = -1;
/*     */   public static final int ERROR_YUAN_BAO_NOT_ENOUGH = -2;
/*     */   public static final int ERROR_LUCKY_BAG_NOT_EXIST = -3;
/*     */   public static final int ERROR_ACTIVITY_NOT_OPEN = -4;
/*     */   public static final int ERROR_BAG_FULL = -5;
/*     */   public static final int ERROR_YUAN_BAO_NOT_IDENTICAL = -6;
/*     */   public int retcode;
/*     */   public int instanceid;
/*     */   public byte use_yuanbao;
/*     */   public long client_yuanbao;
/*     */   public long need_yuanbao;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607490;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SOpenLuckyBagFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SOpenLuckyBagFailed(int _retcode_, int _instanceid_, byte _use_yuanbao_, long _client_yuanbao_, long _need_yuanbao_)
/*     */   {
/*  47 */     this.retcode = _retcode_;
/*  48 */     this.instanceid = _instanceid_;
/*  49 */     this.use_yuanbao = _use_yuanbao_;
/*  50 */     this.client_yuanbao = _client_yuanbao_;
/*  51 */     this.need_yuanbao = _need_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.retcode);
/*  60 */     _os_.marshal(this.instanceid);
/*  61 */     _os_.marshal(this.use_yuanbao);
/*  62 */     _os_.marshal(this.client_yuanbao);
/*  63 */     _os_.marshal(this.need_yuanbao);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.retcode = _os_.unmarshal_int();
/*  69 */     this.instanceid = _os_.unmarshal_int();
/*  70 */     this.use_yuanbao = _os_.unmarshal_byte();
/*  71 */     this.client_yuanbao = _os_.unmarshal_long();
/*  72 */     this.need_yuanbao = _os_.unmarshal_long();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SOpenLuckyBagFailed)) {
/*  82 */       SOpenLuckyBagFailed _o_ = (SOpenLuckyBagFailed)_o1_;
/*  83 */       if (this.retcode != _o_.retcode) return false;
/*  84 */       if (this.instanceid != _o_.instanceid) return false;
/*  85 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/*  86 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  87 */       if (this.need_yuanbao != _o_.need_yuanbao) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.retcode;
/*  96 */     _h_ += this.instanceid;
/*  97 */     _h_ += this.use_yuanbao;
/*  98 */     _h_ += (int)this.client_yuanbao;
/*  99 */     _h_ += (int)this.need_yuanbao;
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.retcode).append(",");
/* 107 */     _sb_.append(this.instanceid).append(",");
/* 108 */     _sb_.append(this.use_yuanbao).append(",");
/* 109 */     _sb_.append(this.client_yuanbao).append(",");
/* 110 */     _sb_.append(this.need_yuanbao).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SOpenLuckyBagFailed _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.retcode - _o_.retcode;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.instanceid - _o_.instanceid;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.use_yuanbao - _o_.use_yuanbao;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = Long.signum(this.need_yuanbao - _o_.need_yuanbao);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\SOpenLuckyBagFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */