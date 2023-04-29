/*     */ package mzm.gsp.banquest;
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
/*     */ public class SSyncBanquetInfo
/*     */   extends __SSyncBanquetInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605960;
/*     */   public long masterid;
/*     */   public int player_num;
/*     */   public long start_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605960;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncBanquetInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncBanquetInfo(long _masterid_, int _player_num_, long _start_time_)
/*     */   {
/*  38 */     this.masterid = _masterid_;
/*  39 */     this.player_num = _player_num_;
/*  40 */     this.start_time = _start_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.masterid);
/*  49 */     _os_.marshal(this.player_num);
/*  50 */     _os_.marshal(this.start_time);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.masterid = _os_.unmarshal_long();
/*  56 */     this.player_num = _os_.unmarshal_int();
/*  57 */     this.start_time = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSyncBanquetInfo)) {
/*  67 */       SSyncBanquetInfo _o_ = (SSyncBanquetInfo)_o1_;
/*  68 */       if (this.masterid != _o_.masterid) return false;
/*  69 */       if (this.player_num != _o_.player_num) return false;
/*  70 */       if (this.start_time != _o_.start_time) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.masterid;
/*  79 */     _h_ += this.player_num;
/*  80 */     _h_ += (int)this.start_time;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.masterid).append(",");
/*  88 */     _sb_.append(this.player_num).append(",");
/*  89 */     _sb_.append(this.start_time).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncBanquetInfo _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.masterid - _o_.masterid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.player_num - _o_.player_num;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.start_time - _o_.start_time);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\SSyncBanquetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */