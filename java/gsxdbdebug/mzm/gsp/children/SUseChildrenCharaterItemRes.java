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
/*     */ 
/*     */ public class SUseChildrenCharaterItemRes
/*     */   extends __SUseChildrenCharaterItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609410;
/*     */   public int character;
/*     */   public long childrenid;
/*     */   public int itemkey;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609410;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseChildrenCharaterItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseChildrenCharaterItemRes(int _character_, long _childrenid_, int _itemkey_)
/*     */   {
/*  38 */     this.character = _character_;
/*  39 */     this.childrenid = _childrenid_;
/*  40 */     this.itemkey = _itemkey_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.character);
/*  49 */     _os_.marshal(this.childrenid);
/*  50 */     _os_.marshal(this.itemkey);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.character = _os_.unmarshal_int();
/*  56 */     this.childrenid = _os_.unmarshal_long();
/*  57 */     this.itemkey = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SUseChildrenCharaterItemRes)) {
/*  67 */       SUseChildrenCharaterItemRes _o_ = (SUseChildrenCharaterItemRes)_o1_;
/*  68 */       if (this.character != _o_.character) return false;
/*  69 */       if (this.childrenid != _o_.childrenid) return false;
/*  70 */       if (this.itemkey != _o_.itemkey) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.character;
/*  79 */     _h_ += (int)this.childrenid;
/*  80 */     _h_ += this.itemkey;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.character).append(",");
/*  88 */     _sb_.append(this.childrenid).append(",");
/*  89 */     _sb_.append(this.itemkey).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseChildrenCharaterItemRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.character - _o_.character;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.itemkey - _o_.itemkey;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SUseChildrenCharaterItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */