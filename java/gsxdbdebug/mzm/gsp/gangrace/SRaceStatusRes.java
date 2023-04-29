/*     */ package mzm.gsp.gangrace;
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
/*     */ public class SRaceStatusRes
/*     */   extends __SRaceStatusRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602122;
/*     */   public int statuscode;
/*     */   public int begintime;
/*     */   public int curcount;
/*     */   public int maxcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602122;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRaceStatusRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SRaceStatusRes(int _statuscode_, int _begintime_, int _curcount_, int _maxcount_)
/*     */   {
/*  39 */     this.statuscode = _statuscode_;
/*  40 */     this.begintime = _begintime_;
/*  41 */     this.curcount = _curcount_;
/*  42 */     this.maxcount = _maxcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.statuscode);
/*  51 */     _os_.marshal(this.begintime);
/*  52 */     _os_.marshal(this.curcount);
/*  53 */     _os_.marshal(this.maxcount);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.statuscode = _os_.unmarshal_int();
/*  59 */     this.begintime = _os_.unmarshal_int();
/*  60 */     this.curcount = _os_.unmarshal_int();
/*  61 */     this.maxcount = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SRaceStatusRes)) {
/*  71 */       SRaceStatusRes _o_ = (SRaceStatusRes)_o1_;
/*  72 */       if (this.statuscode != _o_.statuscode) return false;
/*  73 */       if (this.begintime != _o_.begintime) return false;
/*  74 */       if (this.curcount != _o_.curcount) return false;
/*  75 */       if (this.maxcount != _o_.maxcount) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.statuscode;
/*  84 */     _h_ += this.begintime;
/*  85 */     _h_ += this.curcount;
/*  86 */     _h_ += this.maxcount;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.statuscode).append(",");
/*  94 */     _sb_.append(this.begintime).append(",");
/*  95 */     _sb_.append(this.curcount).append(",");
/*  96 */     _sb_.append(this.maxcount).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SRaceStatusRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.statuscode - _o_.statuscode;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.begintime - _o_.begintime;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.curcount - _o_.curcount;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.maxcount - _o_.maxcount;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\SRaceStatusRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */