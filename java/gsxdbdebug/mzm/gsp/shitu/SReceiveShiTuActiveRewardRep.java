/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SReceiveShiTuActiveRewardRep extends __SReceiveShiTuActiveRewardRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601658;
/*     */   public static final int RESULT_SUCCESS = 1;
/*     */   public static final int RESULT_ERROR_BAG_FULL = 2;
/*     */   public static final int RESULT_ERROR_INDEX_ALEARDY_AWARD = 3;
/*     */   public static final int RESULT_ERROR_VALUE_NOT_ENOUGH = 4;
/*     */   public static final int RESULT_ERROR_AWARD_FAILED = 5;
/*     */   public static final int RESULT_ERROR_LEVEL_NOT_FOUND = 6;
/*     */   public static final int RESULT_ERROR_INDEX_NOT_EXIST = 7;
/*     */   public static final int RESULT_ERROR_NOT_MASTER = 8;
/*     */   public static final int RESULT_ERROR_ROLE_INFO = 9;
/*     */   public static final int RESULT_ERROR_NO_MASTER = 10;
/*     */   public static final int RESULT_ERROR_RELATION_START_DAY = 11;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601658;
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
/*     */   public SReceiveShiTuActiveRewardRep()
/*     */   {
/*  46 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SReceiveShiTuActiveRewardRep(int _result_, ArrayList<String> _args_) {
/*  50 */     this.result = _result_;
/*  51 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.result);
/*  60 */     _os_.compact_uint32(this.args.size());
/*  61 */     for (String _v_ : this.args) {
/*  62 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  68 */     this.result = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  72 */       this.args.add(_v_);
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SReceiveShiTuActiveRewardRep)) {
/*  83 */       SReceiveShiTuActiveRewardRep _o_ = (SReceiveShiTuActiveRewardRep)_o1_;
/*  84 */       if (this.result != _o_.result) return false;
/*  85 */       if (!this.args.equals(_o_.args)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.result;
/*  94 */     _h_ += this.args.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.result).append(",");
/* 102 */     _sb_.append(this.args).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SReceiveShiTuActiveRewardRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */