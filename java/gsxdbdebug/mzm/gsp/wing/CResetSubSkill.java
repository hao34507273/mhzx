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
/*     */ public class CResetSubSkill
/*     */   extends __CResetSubSkill__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596512;
/*     */   public int index;
/*     */   public int skillindex;
/*     */   public int subskillindex;
/*     */   public int isuseyuanbao;
/*     */   public long clientyuanbaonum;
/*     */   public int clientneedyuanbaonum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596512;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetSubSkill() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetSubSkill(int _index_, int _skillindex_, int _subskillindex_, int _isuseyuanbao_, long _clientyuanbaonum_, int _clientneedyuanbaonum_)
/*     */   {
/*  43 */     this.index = _index_;
/*  44 */     this.skillindex = _skillindex_;
/*  45 */     this.subskillindex = _subskillindex_;
/*  46 */     this.isuseyuanbao = _isuseyuanbao_;
/*  47 */     this.clientyuanbaonum = _clientyuanbaonum_;
/*  48 */     this.clientneedyuanbaonum = _clientneedyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.index);
/*  57 */     _os_.marshal(this.skillindex);
/*  58 */     _os_.marshal(this.subskillindex);
/*  59 */     _os_.marshal(this.isuseyuanbao);
/*  60 */     _os_.marshal(this.clientyuanbaonum);
/*  61 */     _os_.marshal(this.clientneedyuanbaonum);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.index = _os_.unmarshal_int();
/*  67 */     this.skillindex = _os_.unmarshal_int();
/*  68 */     this.subskillindex = _os_.unmarshal_int();
/*  69 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  70 */     this.clientyuanbaonum = _os_.unmarshal_long();
/*  71 */     this.clientneedyuanbaonum = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CResetSubSkill)) {
/*  81 */       CResetSubSkill _o_ = (CResetSubSkill)_o1_;
/*  82 */       if (this.index != _o_.index) return false;
/*  83 */       if (this.skillindex != _o_.skillindex) return false;
/*  84 */       if (this.subskillindex != _o_.subskillindex) return false;
/*  85 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  86 */       if (this.clientyuanbaonum != _o_.clientyuanbaonum) return false;
/*  87 */       if (this.clientneedyuanbaonum != _o_.clientneedyuanbaonum) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.index;
/*  96 */     _h_ += this.skillindex;
/*  97 */     _h_ += this.subskillindex;
/*  98 */     _h_ += this.isuseyuanbao;
/*  99 */     _h_ += (int)this.clientyuanbaonum;
/* 100 */     _h_ += this.clientneedyuanbaonum;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.index).append(",");
/* 108 */     _sb_.append(this.skillindex).append(",");
/* 109 */     _sb_.append(this.subskillindex).append(",");
/* 110 */     _sb_.append(this.isuseyuanbao).append(",");
/* 111 */     _sb_.append(this.clientyuanbaonum).append(",");
/* 112 */     _sb_.append(this.clientneedyuanbaonum).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CResetSubSkill _o_) {
/* 118 */     if (_o_ == this) return 0;
/* 119 */     int _c_ = 0;
/* 120 */     _c_ = this.index - _o_.index;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.skillindex - _o_.skillindex;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.subskillindex - _o_.subskillindex;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = Long.signum(this.clientyuanbaonum - _o_.clientyuanbaonum);
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = this.clientneedyuanbaonum - _o_.clientneedyuanbaonum;
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CResetSubSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */