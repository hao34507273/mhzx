/*     */ package mzm.gsp.marriage;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SParadeAttackErrorRes
/*     */   extends __SParadeAttackErrorRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12599851;
/*     */   public static final int MARRIAGE_PARADE_BRIDE_IN_FIGHT = 1;
/*     */   public static final int MARRIAGE_PARADE_BRIDE_ALREADY_CHALLENGED = 2;
/*     */   public static final int MARRIAGE_PARADE_GROOM_IN_FIGHT = 21;
/*     */   public static final int MARRIAGE_PARADE_GROOM_ALREADY_CHALLENGED = 22;
/*     */   public static final int MARRIAGE_ROB_PARADE_TO_MAX = 100;
/*     */   public static final int MARRIAGE_ATTACK_PROTECT_TO_MAX = 101;
/*     */   public static final int MARRIAGE_PARADE_END = 102;
/*     */   public static final int MARRIAGE_ROB_PARADE_TO_MAX_SELF = 103;
/*     */   public static final int MARRIAGE_ATTACK_PROTECT_TO_MAX_SELF = 104;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12599851;
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
/*     */   public SParadeAttackErrorRes()
/*     */   {
/*  44 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SParadeAttackErrorRes(int _result_, ArrayList<String> _args_) {
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
/*  80 */     if ((_o1_ instanceof SParadeAttackErrorRes)) {
/*  81 */       SParadeAttackErrorRes _o_ = (SParadeAttackErrorRes)_o1_;
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SParadeAttackErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */