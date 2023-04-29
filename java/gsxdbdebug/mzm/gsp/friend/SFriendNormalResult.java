/*     */ package mzm.gsp.friend;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SFriendNormalResult extends __SFriendNormalResult__ {
/*     */   public static final int PROTOCOL_TYPE = 12587012;
/*     */   public static final int FIND_PLAYER_NOT_FIND = 1;
/*     */   public static final int AGREE_APPLY_FRIEND_MAX = 11;
/*     */   public static final int DEL_FRIEND_SWORN_RELATION = 12;
/*     */   public static final int ROLE_IN_DELETE = 13;
/*     */   public static final int DEL_FRIEND_IN_MARRIAGE = 14;
/*     */   public static final int DEL_FRIEND_IN_SHITU = 15;
/*     */   public static final int DEL_FRIEND_IN_QING_YUAN = 16;
/*     */   public static final int VALIDATE_WORDS_MAX = 21;
/*     */   public static final int LEVEL_NOT_ENOUGH = 22;
/*     */   public static final int HAS_SENSITIVE_WORDS = 23;
/*     */   public static final int TARGET_NOT_FRIEND = 31;
/*     */   public static final int INVALID_REMARK_NAME_LENGTH = 32;
/*     */   public static final int SENSITIVE_WORD_IN_REMARK_NAME = 33;
/*     */   public static final int INVALID_CHARACTER_IN_REMARK_NAME = 34;
/*     */   public static final int CAN_NOT_DO_THIS_IN_CROSS = 200;
/*     */   public int result;
/*     */   public java.util.ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12587012; }
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
/*     */ 
/*     */ 
/*     */   public SFriendNormalResult()
/*     */   {
/*  50 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SFriendNormalResult(int _result_, java.util.ArrayList<String> _args_) {
/*  54 */     this.result = _result_;
/*  55 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.result);
/*  64 */     _os_.compact_uint32(this.args.size());
/*  65 */     for (String _v_ : this.args) {
/*  66 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  72 */     this.result = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  75 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  76 */       this.args.add(_v_);
/*     */     }
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SFriendNormalResult)) {
/*  87 */       SFriendNormalResult _o_ = (SFriendNormalResult)_o1_;
/*  88 */       if (this.result != _o_.result) return false;
/*  89 */       if (!this.args.equals(_o_.args)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.result;
/*  98 */     _h_ += this.args.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.result).append(",");
/* 106 */     _sb_.append(this.args).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SFriendNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */