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
/*     */ public class CWingModelDye
/*     */   extends __CWingModelDye__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596510;
/*     */   public int modelid;
/*     */   public int itemid;
/*     */   public int isuseyuanbao;
/*     */   public long clientyuanbaonum;
/*     */   public int clientneedyuanbaonum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596510;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CWingModelDye() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CWingModelDye(int _modelid_, int _itemid_, int _isuseyuanbao_, long _clientyuanbaonum_, int _clientneedyuanbaonum_)
/*     */   {
/*  42 */     this.modelid = _modelid_;
/*  43 */     this.itemid = _itemid_;
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
/*  54 */     _os_.marshal(this.modelid);
/*  55 */     _os_.marshal(this.itemid);
/*  56 */     _os_.marshal(this.isuseyuanbao);
/*  57 */     _os_.marshal(this.clientyuanbaonum);
/*  58 */     _os_.marshal(this.clientneedyuanbaonum);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.modelid = _os_.unmarshal_int();
/*  64 */     this.itemid = _os_.unmarshal_int();
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
/*  76 */     if ((_o1_ instanceof CWingModelDye)) {
/*  77 */       CWingModelDye _o_ = (CWingModelDye)_o1_;
/*  78 */       if (this.modelid != _o_.modelid) return false;
/*  79 */       if (this.itemid != _o_.itemid) return false;
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
/*  90 */     _h_ += this.modelid;
/*  91 */     _h_ += this.itemid;
/*  92 */     _h_ += this.isuseyuanbao;
/*  93 */     _h_ += (int)this.clientyuanbaonum;
/*  94 */     _h_ += this.clientneedyuanbaonum;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.modelid).append(",");
/* 102 */     _sb_.append(this.itemid).append(",");
/* 103 */     _sb_.append(this.isuseyuanbao).append(",");
/* 104 */     _sb_.append(this.clientyuanbaonum).append(",");
/* 105 */     _sb_.append(this.clientneedyuanbaonum).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CWingModelDye _o_) {
/* 111 */     if (_o_ == this) return 0;
/* 112 */     int _c_ = 0;
/* 113 */     _c_ = this.modelid - _o_.modelid;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.itemid - _o_.itemid;
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CWingModelDye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */