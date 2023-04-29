/*     */ package mzm.gsp.cake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SCakeNormalNotice extends __SCakeNormalNotice__ {
/*     */   public static final int PROTOCOL_TYPE = 12627723;
/*     */   public static final int CLIENT_SERVER_TURN_DIFF = 1;
/*     */   public static final int MAKE_CAKE_ERR__NOT_IN_SAME_FACTION = 2;
/*     */   public static final int COLLECTION_ERR__NOT_IN_OWN_FACTION = 3;
/*     */   public static final int EAT_SELF_TO_MAX = 20;
/*     */   public static final int EAT_OTHER_TO_MAX = 21;
/*     */   public static final int COLLECTION_START = 40;
/*     */   public static final int ADD_CAKE_ERR_STAGE = 41;
/*     */   public static final int ADD_CAKE_ERR_REPEAT = 42;
/*     */   public static final int MAKE_CAKE_ERR_REPEAT = 43;
/*     */   public static final int MAKE_CAKE_ERR_STAGE = 44;
/*     */   public static final int COLLECTION_ERR_MAX = 45;
/*     */   public static final int COOK_PERFECT = 60;
/*     */   public static final int COOK_TERRIBLE = 61;
/*     */   public static final int EAT_CAKE_DOUBLE = 80;
/*     */   public int result;
/*     */   public java.util.ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12627723;
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
/*     */ 
/*     */ 
/*     */   public SCakeNormalNotice()
/*     */   {
/*  49 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SCakeNormalNotice(int _result_, java.util.ArrayList<String> _args_) {
/*  53 */     this.result = _result_;
/*  54 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.result);
/*  63 */     _os_.compact_uint32(this.args.size());
/*  64 */     for (String _v_ : this.args) {
/*  65 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  71 */     this.result = _os_.unmarshal_int();
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  74 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  75 */       this.args.add(_v_);
/*     */     }
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SCakeNormalNotice)) {
/*  86 */       SCakeNormalNotice _o_ = (SCakeNormalNotice)_o1_;
/*  87 */       if (this.result != _o_.result) return false;
/*  88 */       if (!this.args.equals(_o_.args)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.result;
/*  97 */     _h_ += this.args.hashCode();
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.result).append(",");
/* 105 */     _sb_.append(this.args).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\SCakeNormalNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */