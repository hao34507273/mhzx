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
/*     */ public class CRestWingProperty
/*     */   extends __CRestWingProperty__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596485;
/*     */   public int index;
/*     */   public int isuseyuanbao;
/*     */   public long clientyuanbaonum;
/*     */   public int clientneedyuanbaonum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596485;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CRestWingProperty() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CRestWingProperty(int _index_, int _isuseyuanbao_, long _clientyuanbaonum_, int _clientneedyuanbaonum_)
/*     */   {
/*  39 */     this.index = _index_;
/*  40 */     this.isuseyuanbao = _isuseyuanbao_;
/*  41 */     this.clientyuanbaonum = _clientyuanbaonum_;
/*  42 */     this.clientneedyuanbaonum = _clientneedyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.index);
/*  51 */     _os_.marshal(this.isuseyuanbao);
/*  52 */     _os_.marshal(this.clientyuanbaonum);
/*  53 */     _os_.marshal(this.clientneedyuanbaonum);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.index = _os_.unmarshal_int();
/*  59 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  60 */     this.clientyuanbaonum = _os_.unmarshal_long();
/*  61 */     this.clientneedyuanbaonum = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CRestWingProperty)) {
/*  71 */       CRestWingProperty _o_ = (CRestWingProperty)_o1_;
/*  72 */       if (this.index != _o_.index) return false;
/*  73 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  74 */       if (this.clientyuanbaonum != _o_.clientyuanbaonum) return false;
/*  75 */       if (this.clientneedyuanbaonum != _o_.clientneedyuanbaonum) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.index;
/*  84 */     _h_ += this.isuseyuanbao;
/*  85 */     _h_ += (int)this.clientyuanbaonum;
/*  86 */     _h_ += this.clientneedyuanbaonum;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.index).append(",");
/*  94 */     _sb_.append(this.isuseyuanbao).append(",");
/*  95 */     _sb_.append(this.clientyuanbaonum).append(",");
/*  96 */     _sb_.append(this.clientneedyuanbaonum).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CRestWingProperty _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.index - _o_.index;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.isuseyuanbao - _o_.isuseyuanbao;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.clientyuanbaonum - _o_.clientyuanbaonum);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.clientneedyuanbaonum - _o_.clientneedyuanbaonum;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CRestWingProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */