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
/*     */ public class SStudySpecialSkillRes
/*     */   extends __SStudySpecialSkillRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609396;
/*     */   public long childrenid;
/*     */   public int itemkey;
/*     */   public int skilid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609396;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SStudySpecialSkillRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SStudySpecialSkillRes(long _childrenid_, int _itemkey_, int _skilid_)
/*     */   {
/*  38 */     this.childrenid = _childrenid_;
/*  39 */     this.itemkey = _itemkey_;
/*  40 */     this.skilid = _skilid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.childrenid);
/*  49 */     _os_.marshal(this.itemkey);
/*  50 */     _os_.marshal(this.skilid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.childrenid = _os_.unmarshal_long();
/*  56 */     this.itemkey = _os_.unmarshal_int();
/*  57 */     this.skilid = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SStudySpecialSkillRes)) {
/*  67 */       SStudySpecialSkillRes _o_ = (SStudySpecialSkillRes)_o1_;
/*  68 */       if (this.childrenid != _o_.childrenid) return false;
/*  69 */       if (this.itemkey != _o_.itemkey) return false;
/*  70 */       if (this.skilid != _o_.skilid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.childrenid;
/*  79 */     _h_ += this.itemkey;
/*  80 */     _h_ += this.skilid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.childrenid).append(",");
/*  88 */     _sb_.append(this.itemkey).append(",");
/*  89 */     _sb_.append(this.skilid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStudySpecialSkillRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.itemkey - _o_.itemkey;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.skilid - _o_.skilid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SStudySpecialSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */