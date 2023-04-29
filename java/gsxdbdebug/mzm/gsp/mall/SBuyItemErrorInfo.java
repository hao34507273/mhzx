/*    */ package mzm.gsp.mall;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBuyItemErrorInfo
/*    */   extends __SBuyItemErrorInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585474;
/*    */   public static final int YUANBAO_NOT_ENOUGH = 1;
/*    */   public static final int SHIMEN_NOT_ENOUGH = 2;
/*    */   public static final int ITEM_NOT_EXIST = 3;
/*    */   public static final int ITEM_BUY_NUM_ERROR = 4;
/*    */   public int errorcode;
/*    */   public ArrayList<String> params;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12585474;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBuyItemErrorInfo()
/*    */   {
/* 37 */     this.params = new ArrayList();
/*    */   }
/*    */   
/*    */   public SBuyItemErrorInfo(int _errorcode_, ArrayList<String> _params_) {
/* 41 */     this.errorcode = _errorcode_;
/* 42 */     this.params = _params_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.errorcode);
/* 51 */     _os_.compact_uint32(this.params.size());
/* 52 */     for (String _v_ : this.params) {
/* 53 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.errorcode = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 62 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 63 */       this.params.add(_v_);
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SBuyItemErrorInfo)) {
/* 74 */       SBuyItemErrorInfo _o_ = (SBuyItemErrorInfo)_o1_;
/* 75 */       if (this.errorcode != _o_.errorcode) return false;
/* 76 */       if (!this.params.equals(_o_.params)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.errorcode;
/* 85 */     _h_ += this.params.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.errorcode).append(",");
/* 93 */     _sb_.append(this.params).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\SBuyItemErrorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */