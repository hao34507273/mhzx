/*     */ package mzm.gsp.pet;
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
/*     */ public class SPetSoulRandomPropRes
/*     */   extends __SPetSoulRandomPropRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590670;
/*     */   public long petid;
/*     */   public int pos;
/*     */   public int oldpropindex;
/*     */   public int newpropindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590670;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetSoulRandomPropRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetSoulRandomPropRes(long _petid_, int _pos_, int _oldpropindex_, int _newpropindex_)
/*     */   {
/*  39 */     this.petid = _petid_;
/*  40 */     this.pos = _pos_;
/*  41 */     this.oldpropindex = _oldpropindex_;
/*  42 */     this.newpropindex = _newpropindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.petid);
/*  51 */     _os_.marshal(this.pos);
/*  52 */     _os_.marshal(this.oldpropindex);
/*  53 */     _os_.marshal(this.newpropindex);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.petid = _os_.unmarshal_long();
/*  59 */     this.pos = _os_.unmarshal_int();
/*  60 */     this.oldpropindex = _os_.unmarshal_int();
/*  61 */     this.newpropindex = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SPetSoulRandomPropRes)) {
/*  71 */       SPetSoulRandomPropRes _o_ = (SPetSoulRandomPropRes)_o1_;
/*  72 */       if (this.petid != _o_.petid) return false;
/*  73 */       if (this.pos != _o_.pos) return false;
/*  74 */       if (this.oldpropindex != _o_.oldpropindex) return false;
/*  75 */       if (this.newpropindex != _o_.newpropindex) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.petid;
/*  84 */     _h_ += this.pos;
/*  85 */     _h_ += this.oldpropindex;
/*  86 */     _h_ += this.newpropindex;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.petid).append(",");
/*  94 */     _sb_.append(this.pos).append(",");
/*  95 */     _sb_.append(this.oldpropindex).append(",");
/*  96 */     _sb_.append(this.newpropindex).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetSoulRandomPropRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.pos - _o_.pos;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.oldpropindex - _o_.oldpropindex;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.newpropindex - _o_.newpropindex;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetSoulRandomPropRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */