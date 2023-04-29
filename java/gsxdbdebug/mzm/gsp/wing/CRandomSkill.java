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
/*     */ public class CRandomSkill
/*     */   extends __CRandomSkill__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596482;
/*     */   public int index;
/*     */   public int isuseyuanbao;
/*     */   public long clientyuanbaonum;
/*     */   public int clientneedyuanbaonum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596482;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CRandomSkill() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CRandomSkill(int _index_, int _isuseyuanbao_, long _clientyuanbaonum_, int _clientneedyuanbaonum_)
/*     */   {
/*  41 */     this.index = _index_;
/*  42 */     this.isuseyuanbao = _isuseyuanbao_;
/*  43 */     this.clientyuanbaonum = _clientyuanbaonum_;
/*  44 */     this.clientneedyuanbaonum = _clientneedyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.index);
/*  53 */     _os_.marshal(this.isuseyuanbao);
/*  54 */     _os_.marshal(this.clientyuanbaonum);
/*  55 */     _os_.marshal(this.clientneedyuanbaonum);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.index = _os_.unmarshal_int();
/*  61 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  62 */     this.clientyuanbaonum = _os_.unmarshal_long();
/*  63 */     this.clientneedyuanbaonum = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CRandomSkill)) {
/*  73 */       CRandomSkill _o_ = (CRandomSkill)_o1_;
/*  74 */       if (this.index != _o_.index) return false;
/*  75 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  76 */       if (this.clientyuanbaonum != _o_.clientyuanbaonum) return false;
/*  77 */       if (this.clientneedyuanbaonum != _o_.clientneedyuanbaonum) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.index;
/*  86 */     _h_ += this.isuseyuanbao;
/*  87 */     _h_ += (int)this.clientyuanbaonum;
/*  88 */     _h_ += this.clientneedyuanbaonum;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.index).append(",");
/*  96 */     _sb_.append(this.isuseyuanbao).append(",");
/*  97 */     _sb_.append(this.clientyuanbaonum).append(",");
/*  98 */     _sb_.append(this.clientneedyuanbaonum).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CRandomSkill _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.index - _o_.index;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.clientyuanbaonum - _o_.clientyuanbaonum);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.clientneedyuanbaonum - _o_.clientneedyuanbaonum;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CRandomSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */