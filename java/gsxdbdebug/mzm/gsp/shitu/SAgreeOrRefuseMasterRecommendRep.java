/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SAgreeOrRefuseMasterRecommendRep
/*     */   extends __SAgreeOrRefuseMasterRecommendRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601659;
/*     */   public static final int RESULT_SUCCESS = 1;
/*     */   public static final int RESULT_ERROR_TIME_OUT = 2;
/*     */   public static final int RESULT_ERROR_HAS_MASTER = 3;
/*     */   public static final int RESULT_ERROR_ROLE_INFO = 4;
/*     */   public int result;
/*     */   public int operator;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601659;
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
/*     */   public SAgreeOrRefuseMasterRecommendRep()
/*     */   {
/*  40 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAgreeOrRefuseMasterRecommendRep(int _result_, int _operator_, ArrayList<String> _args_) {
/*  44 */     this.result = _result_;
/*  45 */     this.operator = _operator_;
/*  46 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.result);
/*  55 */     _os_.marshal(this.operator);
/*  56 */     _os_.compact_uint32(this.args.size());
/*  57 */     for (String _v_ : this.args) {
/*  58 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.result = _os_.unmarshal_int();
/*  65 */     this.operator = _os_.unmarshal_int();
/*  66 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  68 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  69 */       this.args.add(_v_);
/*     */     }
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SAgreeOrRefuseMasterRecommendRep)) {
/*  80 */       SAgreeOrRefuseMasterRecommendRep _o_ = (SAgreeOrRefuseMasterRecommendRep)_o1_;
/*  81 */       if (this.result != _o_.result) return false;
/*  82 */       if (this.operator != _o_.operator) return false;
/*  83 */       if (!this.args.equals(_o_.args)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.result;
/*  92 */     _h_ += this.operator;
/*  93 */     _h_ += this.args.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.result).append(",");
/* 101 */     _sb_.append(this.operator).append(",");
/* 102 */     _sb_.append(this.args).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SAgreeOrRefuseMasterRecommendRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */