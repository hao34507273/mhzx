/*     */ package mzm.gsp.gm;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SGMMessageTipRes extends __SGMMessageTipRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585735;
/*     */   public static final int ACTIVITY_ALREADY_IN_STAGE_0 = 1;
/*     */   public static final int ACTIVITY_NOT_FINISH = 2;
/*     */   public static final int ACTIVITY_STAGE_NOT_ALLOW = 3;
/*     */   public static final int ACTIVITY_STAGE_NOW = 4;
/*     */   public static final int ACTIVITY_ID_ERROR = 5;
/*     */   public static final int CMD_MULTI_AWARD_ITEM_PARAM_WRONG = 11;
/*     */   public static final int CMD_UNSTATUS_FAIL = 20;
/*     */   public static final int ONLINE_NUM = 30;
/*     */   public static final int CMD_GET_ACTIVITY_STATE = 40;
/*     */   public static final int CMD_COMMON_TIPS = Integer.MAX_VALUE;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585735;
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
/*     */   public SGMMessageTipRes()
/*     */   {
/*  45 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGMMessageTipRes(int _result_, ArrayList<String> _args_) {
/*  49 */     this.result = _result_;
/*  50 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.result);
/*  59 */     _os_.compact_uint32(this.args.size());
/*  60 */     for (String _v_ : this.args) {
/*  61 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.result = _os_.unmarshal_int();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  70 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  71 */       this.args.add(_v_);
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SGMMessageTipRes)) {
/*  82 */       SGMMessageTipRes _o_ = (SGMMessageTipRes)_o1_;
/*  83 */       if (this.result != _o_.result) return false;
/*  84 */       if (!this.args.equals(_o_.args)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.result;
/*  93 */     _h_ += this.args.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.result).append(",");
/* 101 */     _sb_.append(this.args).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\SGMMessageTipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */