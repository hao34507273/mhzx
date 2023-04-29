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
/*     */ public class SSynChildrenCharacterRes
/*     */   extends __SSynChildrenCharacterRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609409;
/*     */   public static final int TIP_TYPE_NORMAL = 0;
/*     */   public static final int TIP_TYPE_FIGHT = 1;
/*     */   public long childrenid;
/*     */   public int character;
/*     */   public int tiptype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609409;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynChildrenCharacterRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynChildrenCharacterRes(long _childrenid_, int _character_, int _tiptype_)
/*     */   {
/*  41 */     this.childrenid = _childrenid_;
/*  42 */     this.character = _character_;
/*  43 */     this.tiptype = _tiptype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.childrenid);
/*  52 */     _os_.marshal(this.character);
/*  53 */     _os_.marshal(this.tiptype);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.childrenid = _os_.unmarshal_long();
/*  59 */     this.character = _os_.unmarshal_int();
/*  60 */     this.tiptype = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof SSynChildrenCharacterRes)) {
/*  70 */       SSynChildrenCharacterRes _o_ = (SSynChildrenCharacterRes)_o1_;
/*  71 */       if (this.childrenid != _o_.childrenid) return false;
/*  72 */       if (this.character != _o_.character) return false;
/*  73 */       if (this.tiptype != _o_.tiptype) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.childrenid;
/*  82 */     _h_ += this.character;
/*  83 */     _h_ += this.tiptype;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.childrenid).append(",");
/*  91 */     _sb_.append(this.character).append(",");
/*  92 */     _sb_.append(this.tiptype).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynChildrenCharacterRes _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.character - _o_.character;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.tiptype - _o_.tiptype;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SSynChildrenCharacterRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */