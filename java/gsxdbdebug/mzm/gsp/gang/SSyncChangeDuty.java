/*     */ package mzm.gsp.gang;
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
/*     */ 
/*     */ public class SSyncChangeDuty
/*     */   extends __SSyncChangeDuty__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589832;
/*     */   public long targetid;
/*     */   public int duty;
/*     */   public long managerid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  28 */     return 12589832;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncChangeDuty() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncChangeDuty(long _targetid_, int _duty_, long _managerid_)
/*     */   {
/*  39 */     this.targetid = _targetid_;
/*  40 */     this.duty = _duty_;
/*  41 */     this.managerid = _managerid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.targetid);
/*  50 */     _os_.marshal(this.duty);
/*  51 */     _os_.marshal(this.managerid);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.targetid = _os_.unmarshal_long();
/*  57 */     this.duty = _os_.unmarshal_int();
/*  58 */     this.managerid = _os_.unmarshal_long();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof SSyncChangeDuty)) {
/*  68 */       SSyncChangeDuty _o_ = (SSyncChangeDuty)_o1_;
/*  69 */       if (this.targetid != _o_.targetid) return false;
/*  70 */       if (this.duty != _o_.duty) return false;
/*  71 */       if (this.managerid != _o_.managerid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.targetid;
/*  80 */     _h_ += this.duty;
/*  81 */     _h_ += (int)this.managerid;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.targetid).append(",");
/*  89 */     _sb_.append(this.duty).append(",");
/*  90 */     _sb_.append(this.managerid).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncChangeDuty _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = Long.signum(this.targetid - _o_.targetid);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.duty - _o_.duty;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = Long.signum(this.managerid - _o_.managerid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncChangeDuty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */