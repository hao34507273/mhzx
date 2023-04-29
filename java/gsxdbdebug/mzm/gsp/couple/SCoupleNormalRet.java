/*     */ package mzm.gsp.couple;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public class SCoupleNormalRet
/*     */   extends __SCoupleNormalRet__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600585;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_TARGET_DO_NOT_WEAR_AIR_CRAFT = 0;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_TARGET_IN_ACTIVITY = 1;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_TARGET_IN_TEAM = 2;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_TARGET_IN_COUPLE_RIDE = 3;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_OUT_OF_DATE = 4;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_MAP_CAN_NOT_FLY = 5;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_OTHER_IN_MODEL_CHANGE = 6;
/*     */   public static final int REFUSE_OR_AGREE_RIDE_IN_MODEL_CHANGE = 7;
/*     */   public int ret;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600585;
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
/*     */   public SCoupleNormalRet()
/*     */   {
/*  43 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SCoupleNormalRet(int _ret_, ArrayList<String> _args_) {
/*  47 */     this.ret = _ret_;
/*  48 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.ret);
/*  57 */     _os_.compact_uint32(this.args.size());
/*  58 */     for (String _v_ : this.args) {
/*  59 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.ret = _os_.unmarshal_int();
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
/*  79 */     if ((_o1_ instanceof SCoupleNormalRet)) {
/*  80 */       SCoupleNormalRet _o_ = (SCoupleNormalRet)_o1_;
/*  81 */       if (this.ret != _o_.ret) return false;
/*  82 */       if (!this.args.equals(_o_.args)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.ret;
/*  91 */     _h_ += this.args.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.ret).append(",");
/*  99 */     _sb_.append(this.args).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\SCoupleNormalRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */