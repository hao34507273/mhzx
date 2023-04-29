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
/*     */ 
/*     */ public class SPetSoulInitPropRes
/*     */   extends __SPetSoulInitPropRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590673;
/*     */   public long petid;
/*     */   public int pos;
/*     */   public int propindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590673;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetSoulInitPropRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SPetSoulInitPropRes(long _petid_, int _pos_, int _propindex_)
/*     */   {
/*  38 */     this.petid = _petid_;
/*  39 */     this.pos = _pos_;
/*  40 */     this.propindex = _propindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.petid);
/*  49 */     _os_.marshal(this.pos);
/*  50 */     _os_.marshal(this.propindex);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.petid = _os_.unmarshal_long();
/*  56 */     this.pos = _os_.unmarshal_int();
/*  57 */     this.propindex = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SPetSoulInitPropRes)) {
/*  67 */       SPetSoulInitPropRes _o_ = (SPetSoulInitPropRes)_o1_;
/*  68 */       if (this.petid != _o_.petid) return false;
/*  69 */       if (this.pos != _o_.pos) return false;
/*  70 */       if (this.propindex != _o_.propindex) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.petid;
/*  79 */     _h_ += this.pos;
/*  80 */     _h_ += this.propindex;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.petid).append(",");
/*  88 */     _sb_.append(this.pos).append(",");
/*  89 */     _sb_.append(this.propindex).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPetSoulInitPropRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.petid - _o_.petid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.pos - _o_.pos;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.propindex - _o_.propindex;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SPetSoulInitPropRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */