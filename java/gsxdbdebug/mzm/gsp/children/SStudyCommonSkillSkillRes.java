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
/*     */ public class SStudyCommonSkillSkillRes
/*     */   extends __SStudyCommonSkillSkillRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609385;
/*     */   public long childrenid;
/*     */   public int itemkey;
/*     */   public int skilid;
/*     */   public int replaceskillid;
/*     */   public int pos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609385;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStudyCommonSkillSkillRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStudyCommonSkillSkillRes(long _childrenid_, int _itemkey_, int _skilid_, int _replaceskillid_, int _pos_)
/*     */   {
/*  40 */     this.childrenid = _childrenid_;
/*  41 */     this.itemkey = _itemkey_;
/*  42 */     this.skilid = _skilid_;
/*  43 */     this.replaceskillid = _replaceskillid_;
/*  44 */     this.pos = _pos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.childrenid);
/*  53 */     _os_.marshal(this.itemkey);
/*  54 */     _os_.marshal(this.skilid);
/*  55 */     _os_.marshal(this.replaceskillid);
/*  56 */     _os_.marshal(this.pos);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.childrenid = _os_.unmarshal_long();
/*  62 */     this.itemkey = _os_.unmarshal_int();
/*  63 */     this.skilid = _os_.unmarshal_int();
/*  64 */     this.replaceskillid = _os_.unmarshal_int();
/*  65 */     this.pos = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SStudyCommonSkillSkillRes)) {
/*  75 */       SStudyCommonSkillSkillRes _o_ = (SStudyCommonSkillSkillRes)_o1_;
/*  76 */       if (this.childrenid != _o_.childrenid) return false;
/*  77 */       if (this.itemkey != _o_.itemkey) return false;
/*  78 */       if (this.skilid != _o_.skilid) return false;
/*  79 */       if (this.replaceskillid != _o_.replaceskillid) return false;
/*  80 */       if (this.pos != _o_.pos) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.childrenid;
/*  89 */     _h_ += this.itemkey;
/*  90 */     _h_ += this.skilid;
/*  91 */     _h_ += this.replaceskillid;
/*  92 */     _h_ += this.pos;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.childrenid).append(",");
/* 100 */     _sb_.append(this.itemkey).append(",");
/* 101 */     _sb_.append(this.skilid).append(",");
/* 102 */     _sb_.append(this.replaceskillid).append(",");
/* 103 */     _sb_.append(this.pos).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStudyCommonSkillSkillRes _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.itemkey - _o_.itemkey;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.skilid - _o_.skilid;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.replaceskillid - _o_.replaceskillid;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.pos - _o_.pos;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SStudyCommonSkillSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */