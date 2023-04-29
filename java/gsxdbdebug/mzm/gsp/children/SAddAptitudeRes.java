/*     */ package mzm.gsp.children;
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
/*     */ public class SAddAptitudeRes
/*     */   extends __SAddAptitudeRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609369;
/*     */   public long childrenid;
/*     */   public int apttype;
/*     */   public int aptvalue;
/*     */   public int useitemcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609369;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAddAptitudeRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAddAptitudeRes(long _childrenid_, int _apttype_, int _aptvalue_, int _useitemcount_)
/*     */   {
/*  39 */     this.childrenid = _childrenid_;
/*  40 */     this.apttype = _apttype_;
/*  41 */     this.aptvalue = _aptvalue_;
/*  42 */     this.useitemcount = _useitemcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.childrenid);
/*  51 */     _os_.marshal(this.apttype);
/*  52 */     _os_.marshal(this.aptvalue);
/*  53 */     _os_.marshal(this.useitemcount);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.childrenid = _os_.unmarshal_long();
/*  59 */     this.apttype = _os_.unmarshal_int();
/*  60 */     this.aptvalue = _os_.unmarshal_int();
/*  61 */     this.useitemcount = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAddAptitudeRes)) {
/*  71 */       SAddAptitudeRes _o_ = (SAddAptitudeRes)_o1_;
/*  72 */       if (this.childrenid != _o_.childrenid) return false;
/*  73 */       if (this.apttype != _o_.apttype) return false;
/*  74 */       if (this.aptvalue != _o_.aptvalue) return false;
/*  75 */       if (this.useitemcount != _o_.useitemcount) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.childrenid;
/*  84 */     _h_ += this.apttype;
/*  85 */     _h_ += this.aptvalue;
/*  86 */     _h_ += this.useitemcount;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.childrenid).append(",");
/*  94 */     _sb_.append(this.apttype).append(",");
/*  95 */     _sb_.append(this.aptvalue).append(",");
/*  96 */     _sb_.append(this.useitemcount).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAddAptitudeRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.apttype - _o_.apttype;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.aptvalue - _o_.aptvalue;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.useitemcount - _o_.useitemcount;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SAddAptitudeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */