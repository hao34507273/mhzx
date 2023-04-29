/*     */ package mzm.gsp.roledye;
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
/*     */ public class SAddClothesColorRes
/*     */   extends __SAddClothesColorRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597249;
/*     */   public int colorid;
/*     */   public int hairid;
/*     */   public int clothid;
/*     */   public int fashiondresscfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597249;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAddClothesColorRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SAddClothesColorRes(int _colorid_, int _hairid_, int _clothid_, int _fashiondresscfgid_)
/*     */   {
/*  39 */     this.colorid = _colorid_;
/*  40 */     this.hairid = _hairid_;
/*  41 */     this.clothid = _clothid_;
/*  42 */     this.fashiondresscfgid = _fashiondresscfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.colorid);
/*  51 */     _os_.marshal(this.hairid);
/*  52 */     _os_.marshal(this.clothid);
/*  53 */     _os_.marshal(this.fashiondresscfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.colorid = _os_.unmarshal_int();
/*  59 */     this.hairid = _os_.unmarshal_int();
/*  60 */     this.clothid = _os_.unmarshal_int();
/*  61 */     this.fashiondresscfgid = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAddClothesColorRes)) {
/*  71 */       SAddClothesColorRes _o_ = (SAddClothesColorRes)_o1_;
/*  72 */       if (this.colorid != _o_.colorid) return false;
/*  73 */       if (this.hairid != _o_.hairid) return false;
/*  74 */       if (this.clothid != _o_.clothid) return false;
/*  75 */       if (this.fashiondresscfgid != _o_.fashiondresscfgid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.colorid;
/*  84 */     _h_ += this.hairid;
/*  85 */     _h_ += this.clothid;
/*  86 */     _h_ += this.fashiondresscfgid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.colorid).append(",");
/*  94 */     _sb_.append(this.hairid).append(",");
/*  95 */     _sb_.append(this.clothid).append(",");
/*  96 */     _sb_.append(this.fashiondresscfgid).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAddClothesColorRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.colorid - _o_.colorid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.hairid - _o_.hairid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.clothid - _o_.clothid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.fashiondresscfgid - _o_.fashiondresscfgid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\SAddClothesColorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */