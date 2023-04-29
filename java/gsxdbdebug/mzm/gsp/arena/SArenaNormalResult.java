/*     */ package mzm.gsp.arena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SArenaNormalResult extends __SArenaNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596737;
/*     */   public static final int ENTER_ARENA_MAP__SELF_NO_ACTION_POINT = 1;
/*     */   public static final int ENTER_ARENA_MAP__OTHER_NO_ACTION_POINT = 2;
/*     */   public static final int ENTER_ARENA_MAP__SELF_PARTICIPATED = 3;
/*     */   public static final int ENTER_ARENA_MAP__OTHER_PARTICIPATED = 4;
/*     */   public static final int ENTER_ARENA_MAP__DIFF_CAMP = 5;
/*     */   public static final int ENTER_ARENA_MAP__TEAM_STATUS = 6;
/*     */   public static final int ENTER_ARENA_MAP__NOT_ACTIVITY_TIME = 7;
/*     */   public static final int ENTER_ARENA_MAP__END = 8;
/*     */   public static final int LEAVE_ARENA_MAP__LACK_ACTION_POINT = 11;
/*     */   public static final int LEAVE_ARENA_MAP__IN_TEAM = 12;
/*     */   public int result;
/*     */   public java.util.ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12596737;
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
/*     */   public SArenaNormalResult()
/*     */   {
/*  43 */     this.args = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public SArenaNormalResult(int _result_, java.util.ArrayList<String> _args_) {
/*  47 */     this.result = _result_;
/*  48 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.result);
/*  57 */     _os_.compact_uint32(this.args.size());
/*  58 */     for (String _v_ : this.args) {
/*  59 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  65 */     this.result = _os_.unmarshal_int();
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
/*  79 */     if ((_o1_ instanceof SArenaNormalResult)) {
/*  80 */       SArenaNormalResult _o_ = (SArenaNormalResult)_o1_;
/*  81 */       if (this.result != _o_.result) return false;
/*  82 */       if (!this.args.equals(_o_.args)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.result;
/*  91 */     _h_ += this.args.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.result).append(",");
/*  99 */     _sb_.append(this.args).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\SArenaNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */