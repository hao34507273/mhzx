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
/*     */ public class CResetMainSkill
/*     */   extends __CResetMainSkill__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596513;
/*     */   public int index;
/*     */   public int skillindex;
/*     */   public int isuseyuanbao;
/*     */   public long clientyuanbaonum;
/*     */   public int clientneedyuanbaonum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596513;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetMainSkill() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CResetMainSkill(int _index_, int _skillindex_, int _isuseyuanbao_, long _clientyuanbaonum_, int _clientneedyuanbaonum_)
/*     */   {
/*  42 */     this.index = _index_;
/*  43 */     this.skillindex = _skillindex_;
/*  44 */     this.isuseyuanbao = _isuseyuanbao_;
/*  45 */     this.clientyuanbaonum = _clientyuanbaonum_;
/*  46 */     this.clientneedyuanbaonum = _clientneedyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.index);
/*  55 */     _os_.marshal(this.skillindex);
/*  56 */     _os_.marshal(this.isuseyuanbao);
/*  57 */     _os_.marshal(this.clientyuanbaonum);
/*  58 */     _os_.marshal(this.clientneedyuanbaonum);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.index = _os_.unmarshal_int();
/*  64 */     this.skillindex = _os_.unmarshal_int();
/*  65 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  66 */     this.clientyuanbaonum = _os_.unmarshal_long();
/*  67 */     this.clientneedyuanbaonum = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CResetMainSkill)) {
/*  77 */       CResetMainSkill _o_ = (CResetMainSkill)_o1_;
/*  78 */       if (this.index != _o_.index) return false;
/*  79 */       if (this.skillindex != _o_.skillindex) return false;
/*  80 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  81 */       if (this.clientyuanbaonum != _o_.clientyuanbaonum) return false;
/*  82 */       if (this.clientneedyuanbaonum != _o_.clientneedyuanbaonum) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.index;
/*  91 */     _h_ += this.skillindex;
/*  92 */     _h_ += this.isuseyuanbao;
/*  93 */     _h_ += (int)this.clientyuanbaonum;
/*  94 */     _h_ += this.clientneedyuanbaonum;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.index).append(",");
/* 102 */     _sb_.append(this.skillindex).append(",");
/* 103 */     _sb_.append(this.isuseyuanbao).append(",");
/* 104 */     _sb_.append(this.clientyuanbaonum).append(",");
/* 105 */     _sb_.append(this.clientneedyuanbaonum).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CResetMainSkill _o_) {
/* 111 */     if (_o_ == this) return 0;
/* 112 */     int _c_ = 0;
/* 113 */     _c_ = this.index - _o_.index;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.skillindex - _o_.skillindex;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = Long.signum(this.clientyuanbaonum - _o_.clientyuanbaonum);
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.clientneedyuanbaonum - _o_.clientneedyuanbaonum;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CResetMainSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */