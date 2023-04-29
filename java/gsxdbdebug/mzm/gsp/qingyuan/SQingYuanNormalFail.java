/*     */ package mzm.gsp.qingyuan;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SQingYuanNormalFail
/*     */   extends __SQingYuanNormalFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12602887;
/*     */   public static final int MEMBER_QING_YUAN_SIZE_MAX = 1;
/*     */   public static final int NOT_HAS_THE_QING_YUAN = 2;
/*     */   public static final int TEAM_MEMBER_SIZE_ERROR = 3;
/*     */   public static final int ROLE_LEVEL_NOT_MATCH = 4;
/*     */   public static final int FRIEND_VALUE_NOT_MATCH = 5;
/*     */   public static final int ALEARDY_QING_YUAN_RELATION = 6;
/*     */   public static final int CAN_NOT_BE_MARRIAGE_RELATION = 7;
/*     */   public static final int TEAM_MEMBER_STATUS_NOT_RIGHT = 8;
/*     */   public static final int TEAM_MEMBER_STATUS_CHANGES = 9;
/*     */   public int result;
/*     */   public ArrayList<String> params;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12602887;
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
/*     */   public SQingYuanNormalFail()
/*     */   {
/*  44 */     this.params = new ArrayList();
/*     */   }
/*     */   
/*     */   public SQingYuanNormalFail(int _result_, ArrayList<String> _params_) {
/*  48 */     this.result = _result_;
/*  49 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.result);
/*  58 */     _os_.compact_uint32(this.params.size());
/*  59 */     for (String _v_ : this.params) {
/*  60 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.result = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  69 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  70 */       this.params.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SQingYuanNormalFail)) {
/*  81 */       SQingYuanNormalFail _o_ = (SQingYuanNormalFail)_o1_;
/*  82 */       if (this.result != _o_.result) return false;
/*  83 */       if (!this.params.equals(_o_.params)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.result;
/*  92 */     _h_ += this.params.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.result).append(",");
/* 100 */     _sb_.append(this.params).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\SQingYuanNormalFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */