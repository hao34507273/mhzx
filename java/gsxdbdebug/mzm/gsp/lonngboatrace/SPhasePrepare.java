/*     */ package mzm.gsp.lonngboatrace;
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
/*     */ public class SPhasePrepare
/*     */   extends __SPhasePrepare__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619266;
/*     */   public int phaseid;
/*     */   public long endtimestamp;
/*     */   public long currtimestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619266;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SPhasePrepare() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPhasePrepare(int _phaseid_, long _endtimestamp_, long _currtimestamp_)
/*     */   {
/*  38 */     this.phaseid = _phaseid_;
/*  39 */     this.endtimestamp = _endtimestamp_;
/*  40 */     this.currtimestamp = _currtimestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.phaseid);
/*  49 */     _os_.marshal(this.endtimestamp);
/*  50 */     _os_.marshal(this.currtimestamp);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.phaseid = _os_.unmarshal_int();
/*  56 */     this.endtimestamp = _os_.unmarshal_long();
/*  57 */     this.currtimestamp = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SPhasePrepare)) {
/*  67 */       SPhasePrepare _o_ = (SPhasePrepare)_o1_;
/*  68 */       if (this.phaseid != _o_.phaseid) return false;
/*  69 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/*  70 */       if (this.currtimestamp != _o_.currtimestamp) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.phaseid;
/*  79 */     _h_ += (int)this.endtimestamp;
/*  80 */     _h_ += (int)this.currtimestamp;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.phaseid).append(",");
/*  88 */     _sb_.append(this.endtimestamp).append(",");
/*  89 */     _sb_.append(this.currtimestamp).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPhasePrepare _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.phaseid - _o_.phaseid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.endtimestamp - _o_.endtimestamp);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.currtimestamp - _o_.currtimestamp);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\SPhasePrepare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */