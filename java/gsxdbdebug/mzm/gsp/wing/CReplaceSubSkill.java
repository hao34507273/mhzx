/*     */ package mzm.gsp.wing;
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
/*     */ 
/*     */ public class CReplaceSubSkill
/*     */   extends __CReplaceSubSkill__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596518;
/*     */   public int index;
/*     */   public int skillindex;
/*     */   public int subskillindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596518;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CReplaceSubSkill() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CReplaceSubSkill(int _index_, int _skillindex_, int _subskillindex_)
/*     */   {
/*  40 */     this.index = _index_;
/*  41 */     this.skillindex = _skillindex_;
/*  42 */     this.subskillindex = _subskillindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.index);
/*  51 */     _os_.marshal(this.skillindex);
/*  52 */     _os_.marshal(this.subskillindex);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.index = _os_.unmarshal_int();
/*  58 */     this.skillindex = _os_.unmarshal_int();
/*  59 */     this.subskillindex = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CReplaceSubSkill)) {
/*  69 */       CReplaceSubSkill _o_ = (CReplaceSubSkill)_o1_;
/*  70 */       if (this.index != _o_.index) return false;
/*  71 */       if (this.skillindex != _o_.skillindex) return false;
/*  72 */       if (this.subskillindex != _o_.subskillindex) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.index;
/*  81 */     _h_ += this.skillindex;
/*  82 */     _h_ += this.subskillindex;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.index).append(",");
/*  90 */     _sb_.append(this.skillindex).append(",");
/*  91 */     _sb_.append(this.subskillindex).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReplaceSubSkill _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.index - _o_.index;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.skillindex - _o_.skillindex;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.subskillindex - _o_.subskillindex;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CReplaceSubSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */