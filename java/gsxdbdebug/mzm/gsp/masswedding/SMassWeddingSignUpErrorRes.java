/*    */ package mzm.gsp.masswedding;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMassWeddingSignUpErrorRes
/*    */   extends __SMassWeddingSignUpErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604932;
/*    */   public static final int IN_FROCE_DIVORCE = 1;
/*    */   public static final int NOT_COUPLE = 2;
/*    */   public static final int MONEY_NOT_ENOUGH = 3;
/*    */   public static final int ALREADY_SIGN_UP = 4;
/*    */   public static final int PRICE_NOT_ENOUGH = 5;
/*    */   public int result;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12604932;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMassWeddingSignUpErrorRes()
/*    */   {
/* 40 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SMassWeddingSignUpErrorRes(int _result_, ArrayList<String> _args_) {
/* 44 */     this.result = _result_;
/* 45 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.result);
/* 54 */     _os_.compact_uint32(this.args.size());
/* 55 */     for (String _v_ : this.args) {
/* 56 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     this.result = _os_.unmarshal_int();
/* 63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 65 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 66 */       this.args.add(_v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SMassWeddingSignUpErrorRes)) {
/* 77 */       SMassWeddingSignUpErrorRes _o_ = (SMassWeddingSignUpErrorRes)_o1_;
/* 78 */       if (this.result != _o_.result) return false;
/* 79 */       if (!this.args.equals(_o_.args)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.result;
/* 88 */     _h_ += this.args.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.result).append(",");
/* 96 */     _sb_.append(this.args).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SMassWeddingSignUpErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */