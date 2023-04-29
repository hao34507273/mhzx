/*     */ package mzm.gsp.instance;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SInstanceNormalResult
/*     */   extends __SInstanceNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12591373;
/*     */   public static final int PERSON_COUNT_NOT_ENOUGH = 1;
/*     */   public static final int LEVEL_NOT_ENOUGH = 2;
/*     */   public static final int MEMBER_STATUS_WRONG = 3;
/*     */   public static final int TEAM_LEADER_NOT_HAVE_ITEM = 5;
/*     */   public static final int MEMBER_STATUS_OFFLINE = 6;
/*     */   public static final int WAIT_MEMBER_OPERATION = 7;
/*     */   public static final int SAO_DANG_CHENG_GONG = 10;
/*     */   public static final int LEAVE_INSTANCE_NOT_AWARD = 11;
/*     */   public static final int SINGLE_INSTANCE_FAIL_TIMES_NOT_ENOUGH = 20;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12591373;
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
/*     */   public SInstanceNormalResult()
/*     */   {
/*  44 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SInstanceNormalResult(int _result_, ArrayList<String> _args_) {
/*  48 */     this.result = _result_;
/*  49 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.result);
/*  58 */     _os_.compact_uint32(this.args.size());
/*  59 */     for (String _v_ : this.args) {
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
/*  70 */       this.args.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SInstanceNormalResult)) {
/*  81 */       SInstanceNormalResult _o_ = (SInstanceNormalResult)_o1_;
/*  82 */       if (this.result != _o_.result) return false;
/*  83 */       if (!this.args.equals(_o_.args)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.result;
/*  92 */     _h_ += this.args.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.result).append(",");
/* 100 */     _sb_.append(this.args).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SInstanceNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */