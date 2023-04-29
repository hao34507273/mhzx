/*     */ package mzm.gsp.corps;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCorpsNormalInfo extends __SCorpsNormalInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617485;
/*     */   public static final int CREATE_CORPS_ERR__NAME_ILLEGAL = 1;
/*     */   public static final int CREATE_CORPS_ERR__NAME_DUPLICATE = 2;
/*     */   public static final int CREATE_CORPS_ERR__DECLARATION_ILLEGAL = 3;
/*     */   public static final int INVITE_CORPS_ERR__IN_ANOTHER_CORPS = 20;
/*     */   public static final int INVITE_CORPS_ERR__ILLEGAL_LEVEL = 21;
/*     */   public static final int INVITE_CORPS_ERR__CORPS_FULL = 22;
/*     */   public static final int INVITE_CORPS_ERR__DUPLICATE_INVITE = 23;
/*     */   public static final int INVITE_CORPS_REP__TIMEOUT = 40;
/*     */   public static final int JOIN_CORPS__CORPS_FULL = 41;
/*     */   public static final int RENAME_CORPS_ERR__NAME_ILLEGAL = 60;
/*     */   public static final int RENAME_CORPS_ERR__NAME_DUPLICATE = 61;
/*     */   public static final int RP_DECLARATION_ERR__DECLARATION_ILLEGAL = 62;
/*     */   public int result;
/*     */   public java.util.ArrayList<com.goldhuman.Common.Octets> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617485;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCorpsNormalInfo()
/*     */   {
/*  47 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SCorpsNormalInfo(int _result_, java.util.ArrayList<com.goldhuman.Common.Octets> _args_) {
/*  51 */     this.result = _result_;
/*  52 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.result);
/*  61 */     _os_.compact_uint32(this.args.size());
/*  62 */     for (com.goldhuman.Common.Octets _v_ : this.args) {
/*  63 */       _os_.marshal(_v_);
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  69 */     this.result = _os_.unmarshal_int();
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  72 */       com.goldhuman.Common.Octets _v_ = _os_.unmarshal_Octets();
/*  73 */       this.args.add(_v_);
/*     */     }
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SCorpsNormalInfo)) {
/*  84 */       SCorpsNormalInfo _o_ = (SCorpsNormalInfo)_o1_;
/*  85 */       if (this.result != _o_.result) return false;
/*  86 */       if (!this.args.equals(_o_.args)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.result;
/*  95 */     _h_ += this.args.hashCode();
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.result).append(",");
/* 103 */     _sb_.append(this.args).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SCorpsNormalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */