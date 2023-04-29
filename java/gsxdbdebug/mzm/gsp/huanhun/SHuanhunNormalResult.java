/*     */ package mzm.gsp.huanhun;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SHuanhunNormalResult extends __SHuanhunNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584458;
/*     */   public static final int SEEK_HELP_GANG__LEFT_NUM_NULL = 1;
/*     */   public static final int SEEK_HELP_GANG__REPEAT = 2;
/*     */   public static final int SEEK_HELP_GANG__NO_GANG = 3;
/*     */   public static final int SEEK_HELP_GANG__SUC = 4;
/*     */   public static final int ADD_ITEM__FULL = 5;
/*     */   public static final int ADD_ITEM__COUNT_ERROR = 6;
/*     */   public static final int ADD_ITEM__ID_ERROR = 7;
/*     */   public static final int SEEK_HELP_GANG__NO_ENOUGH_FULL_BOX = 8;
/*     */   public static final int CHECK_OTHER_HELP_ITEM__OUT_TIME = 10;
/*     */   public static final int HELP_OTHER_COUNT_NULL = 20;
/*     */   public static final int HELP_OTHER_FORBID_NON_LEVEL = 21;
/*     */   public static final int ADD_ITEM_ERROR__HUN_CLOSE = 22;
/*     */   public int result;
/*     */   public java.util.ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584458;
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
/*     */   public SHuanhunNormalResult()
/*     */   {
/*  47 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SHuanhunNormalResult(int _result_, java.util.ArrayList<String> _args_) {
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
/*  62 */     for (String _v_ : this.args) {
/*  63 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  69 */     this.result = _os_.unmarshal_int();
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  72 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
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
/*  83 */     if ((_o1_ instanceof SHuanhunNormalResult)) {
/*  84 */       SHuanhunNormalResult _o_ = (SHuanhunNormalResult)_o1_;
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SHuanhunNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */