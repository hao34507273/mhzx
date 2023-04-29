/*     */ package mzm.gsp.marriage;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SMarriageNormalResult extends __SMarriageNormalResult__ {
/*     */   public static final int PROTOCOL_TYPE = 12599816;
/*     */   public static final int MARRY_REQ_NOT_SINGLE = 0;
/*     */   public static final int MARRY_REQ_SOMEONE_IN_CEREMONY = 1;
/*     */   public static final int AGREE_OR_CANCEL_MARRIAGE_ITEM_NOT_ENOUGH = 20;
/*     */   public static final int AGREE_OR_CANCEL_MARRIAGE_MONEY_NOT_ENOUGH = 21;
/*     */   public static final int AGREE_OR_CANCEL_MARRIAGE_SOMEONE_IN_CEREMONY = 22;
/*     */   public static final int DIVORCE_REQUST_SILVER_NOT_ENOUGH = 40;
/*     */   public static final int SEND_FRIEND_GIFT_FRIEND_NOT_MARRY = 60;
/*     */   public static final int SEND_FRIEND_GIFT_FRIEND_MARRY_TIME_TOO_LONG = 61;
/*     */   public static final int SEND_FRIEND_GIFT_FRIEND_ALREADY_SEND = 62;
/*     */   public static final int TRANSFOR_MARRIAGE_MARRY_TIME_TOO_LONG = 80;
/*     */   public static final int TRANSFOR_MARRIAGE_NOT_IN_BIG_WORLD = 81;
/*     */   public static final int FORCE_DIVORCE_SOMEONE_ALREADY_DO_THIS = 100;
/*     */   public static final int MARRIAGE_PARADE_NOT_NORMAL_STATE = 120;
/*     */   public static final int MARRIAGE_PARADE_SOMEONE_IN_PARADE = 121;
/*     */   public int result;
/*     */   public java.util.ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  27 */     return 12599816;
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
/*     */   public SMarriageNormalResult()
/*     */   {
/*  49 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SMarriageNormalResult(int _result_, java.util.ArrayList<String> _args_) {
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
/*  85 */     if ((_o1_ instanceof SMarriageNormalResult)) {
/*  86 */       SMarriageNormalResult _o_ = (SMarriageNormalResult)_o1_;
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SMarriageNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */