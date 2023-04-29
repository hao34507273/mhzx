/*    */ package mzm.gsp.floplottery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFlopLotteryError
/*    */   extends __SFlopLotteryError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618503;
/*    */   public static final int BAG_CAPACITY_NOT_ENOUGH = 1;
/*    */   public static final int MONEY_NOT_ENOUGH = 2;
/*    */   public static final int HANDLE_ERROR = 3;
/*    */   public int code;
/*    */   public ArrayList<String> params;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618503;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFlopLotteryError()
/*    */   {
/* 38 */     this.params = new ArrayList();
/*    */   }
/*    */   
/*    */   public SFlopLotteryError(int _code_, ArrayList<String> _params_) {
/* 42 */     this.code = _code_;
/* 43 */     this.params = _params_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.code);
/* 52 */     _os_.compact_uint32(this.params.size());
/* 53 */     for (String _v_ : this.params) {
/* 54 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.code = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 64 */       this.params.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SFlopLotteryError)) {
/* 75 */       SFlopLotteryError _o_ = (SFlopLotteryError)_o1_;
/* 76 */       if (this.code != _o_.code) return false;
/* 77 */       if (!this.params.equals(_o_.params)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.code;
/* 86 */     _h_ += this.params.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.code).append(",");
/* 94 */     _sb_.append(this.params).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\SFlopLotteryError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */