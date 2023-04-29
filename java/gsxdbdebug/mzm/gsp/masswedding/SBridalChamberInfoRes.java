/*     */ package mzm.gsp.masswedding;
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
/*     */ public class SBridalChamberInfoRes
/*     */   extends __SBridalChamberInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604944;
/*     */   public long roleid;
/*     */   public int groom;
/*     */   public int bride;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604944;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SBridalChamberInfoRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBridalChamberInfoRes(long _roleid_, int _groom_, int _bride_)
/*     */   {
/*  38 */     this.roleid = _roleid_;
/*  39 */     this.groom = _groom_;
/*  40 */     this.bride = _bride_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.roleid);
/*  49 */     _os_.marshal(this.groom);
/*  50 */     _os_.marshal(this.bride);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.roleid = _os_.unmarshal_long();
/*  56 */     this.groom = _os_.unmarshal_int();
/*  57 */     this.bride = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SBridalChamberInfoRes)) {
/*  67 */       SBridalChamberInfoRes _o_ = (SBridalChamberInfoRes)_o1_;
/*  68 */       if (this.roleid != _o_.roleid) return false;
/*  69 */       if (this.groom != _o_.groom) return false;
/*  70 */       if (this.bride != _o_.bride) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.roleid;
/*  79 */     _h_ += this.groom;
/*  80 */     _h_ += this.bride;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.roleid).append(",");
/*  88 */     _sb_.append(this.groom).append(",");
/*  89 */     _sb_.append(this.bride).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBridalChamberInfoRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.groom - _o_.groom;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.bride - _o_.bride;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SBridalChamberInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */