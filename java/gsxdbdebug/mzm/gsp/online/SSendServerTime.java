/*     */ package mzm.gsp.online;
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
/*     */ public class SSendServerTime
/*     */   extends __SSendServerTime__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12582913;
/*     */   public long servertime;
/*     */   public int raw_offset;
/*     */   public long serveropentime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12582913;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSendServerTime() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSendServerTime(long _servertime_, int _raw_offset_, long _serveropentime_)
/*     */   {
/*  38 */     this.servertime = _servertime_;
/*  39 */     this.raw_offset = _raw_offset_;
/*  40 */     this.serveropentime = _serveropentime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.servertime);
/*  49 */     _os_.marshal(this.raw_offset);
/*  50 */     _os_.marshal(this.serveropentime);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.servertime = _os_.unmarshal_long();
/*  56 */     this.raw_offset = _os_.unmarshal_int();
/*  57 */     this.serveropentime = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSendServerTime)) {
/*  67 */       SSendServerTime _o_ = (SSendServerTime)_o1_;
/*  68 */       if (this.servertime != _o_.servertime) return false;
/*  69 */       if (this.raw_offset != _o_.raw_offset) return false;
/*  70 */       if (this.serveropentime != _o_.serveropentime) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.servertime;
/*  79 */     _h_ += this.raw_offset;
/*  80 */     _h_ += (int)this.serveropentime;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.servertime).append(",");
/*  88 */     _sb_.append(this.raw_offset).append(",");
/*  89 */     _sb_.append(this.serveropentime).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSendServerTime _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.servertime - _o_.servertime);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.raw_offset - _o_.raw_offset;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.serveropentime - _o_.serveropentime);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\SSendServerTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */