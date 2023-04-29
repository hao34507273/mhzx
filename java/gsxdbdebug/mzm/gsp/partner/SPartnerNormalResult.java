/*    */ package mzm.gsp.partner;
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
/*    */ 
/*    */ 
/*    */ public class SPartnerNormalResult
/*    */   extends __SPartnerNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588038;
/*    */   public static final int ALREADY_HAVE_PARTNER = 0;
/*    */   public int result;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588038;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SPartnerNormalResult()
/*    */   {
/* 36 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SPartnerNormalResult(int _result_, ArrayList<String> _args_) {
/* 40 */     this.result = _result_;
/* 41 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.result);
/* 50 */     _os_.compact_uint32(this.args.size());
/* 51 */     for (String _v_ : this.args) {
/* 52 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.result = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 61 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 62 */       this.args.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SPartnerNormalResult)) {
/* 73 */       SPartnerNormalResult _o_ = (SPartnerNormalResult)_o1_;
/* 74 */       if (this.result != _o_.result) return false;
/* 75 */       if (!this.args.equals(_o_.args)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.result;
/* 84 */     _h_ += this.args.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.result).append(",");
/* 92 */     _sb_.append(this.args).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SPartnerNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */