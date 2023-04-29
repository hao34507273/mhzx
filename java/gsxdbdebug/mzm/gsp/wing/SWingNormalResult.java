/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public class SWingNormalResult
/*     */   extends __SWingNormalResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596533;
/*     */   public static final int NOT_OWN_THIS_WING = 1;
/*     */   public static final int NOT_ENOUGH_YUANBAO = 2;
/*     */   public static final int ALREADY_OWN_THIS_WING = 3;
/*     */   public static final int ADD_EXP__NOT_ENOUGH_ITEM = 4;
/*     */   public static final int ADD_RANK__NOT_ENOUGH_ITEM = 5;
/*     */   public static final int COLOR__NOT_ENOUGH_ITEM = 6;
/*     */   public static final int RESET__NOT_ENOUGH_ITEM = 7;
/*     */   public static final int ROLE_LV__NOT_ENOUGH = 8;
/*     */   public static final int WING_LV__NOT_ENOUGH = 9;
/*     */   public static final int WING_RANK__NOT_ENOUGH = 10;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596533;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int NOT_OPEN_WING = 11;
/*     */   
/*     */   public static final int REPEATED_SKILLS = 12;
/*     */   
/*     */   public static final int NO_MORE_SKILLS_TO_RAN = 13;
/*     */   
/*     */   public static final int TARGET_SKILL_INDEX_ILLEGAL = 14;
/*     */   
/*     */   public static final int TARGET_SKILL_ALREADY_OWN = 15;
/*     */   
/*     */   public static final int TARGET_SKILL_NOT_EXIST = 16;
/*     */   
/*     */   public static final int TARGET_SKILL_ALREADY_SET = 17;
/*     */   
/*     */   public static final int CHECK_ROLE_WING_INFO__DIFF_SERVER = 18;
/*     */   
/*     */   public static final int CHECK_ROLE_WING_INFO__NOT_EXIST = 19;
/*     */   
/*     */   public static final int CHANGE_WING_OCC_PLAN_ERR__NOT_OPEN_THIS_OCCUPATION = 20;
/*     */   
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   public SWingNormalResult()
/*     */   {
/*  55 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SWingNormalResult(int _result_, ArrayList<String> _args_) {
/*  59 */     this.result = _result_;
/*  60 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  68 */     _os_.marshal(this.result);
/*  69 */     _os_.compact_uint32(this.args.size());
/*  70 */     for (String _v_ : this.args) {
/*  71 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     this.result = _os_.unmarshal_int();
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  80 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  81 */       this.args.add(_v_);
/*     */     }
/*  83 */     if (!_validator_()) {
/*  84 */       throw new VerifyError("validator failed");
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  90 */     if (_o1_ == this) return true;
/*  91 */     if ((_o1_ instanceof SWingNormalResult)) {
/*  92 */       SWingNormalResult _o_ = (SWingNormalResult)_o1_;
/*  93 */       if (this.result != _o_.result) return false;
/*  94 */       if (!this.args.equals(_o_.args)) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += this.result;
/* 103 */     _h_ += this.args.hashCode();
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.result).append(",");
/* 111 */     _sb_.append(this.args).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SWingNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */