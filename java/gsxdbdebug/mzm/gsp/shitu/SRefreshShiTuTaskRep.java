/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SRefreshShiTuTaskRep
/*     */   extends __SRefreshShiTuTaskRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601640;
/*     */   public static final int RESULT_SUCCESS = 1;
/*     */   public static final int RESULT_ERROR_NOT_MASTER = 2;
/*     */   public static final int RESULT_ERROR_NO_TIMES = 3;
/*     */   public static final int RESULT_ERROR_ROLE_INFO = 4;
/*     */   public static final int RESULT_ERROR_APPRENTICE_TASK_INIT = 5;
/*     */   public static final int RESULT_ERROR_REFRESH_FAIL = 6;
/*     */   public static final int RESULT_ERROR_APPRENTICE_STATE = 7;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601640;
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
/*     */   public SRefreshShiTuTaskRep()
/*     */   {
/*  42 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SRefreshShiTuTaskRep(int _result_, ArrayList<String> _args_) {
/*  46 */     this.result = _result_;
/*  47 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.result);
/*  56 */     _os_.compact_uint32(this.args.size());
/*  57 */     for (String _v_ : this.args) {
/*  58 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.result = _os_.unmarshal_int();
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  68 */       this.args.add(_v_);
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SRefreshShiTuTaskRep)) {
/*  79 */       SRefreshShiTuTaskRep _o_ = (SRefreshShiTuTaskRep)_o1_;
/*  80 */       if (this.result != _o_.result) return false;
/*  81 */       if (!this.args.equals(_o_.args)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.result;
/*  90 */     _h_ += this.args.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.result).append(",");
/*  98 */     _sb_.append(this.args).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SRefreshShiTuTaskRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */