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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRandomLuckyBlesserErrorRes
/*    */   extends __SRandomLuckyBlesserErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604957;
/*    */   public static final int NOT_HAS_BLESSED_ROLE = 1;
/*    */   public static final int ALREADY_BLESSED = 2;
/*    */   public int result;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12604957;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRandomLuckyBlesserErrorRes()
/*    */   {
/* 37 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRandomLuckyBlesserErrorRes(int _result_, ArrayList<String> _args_) {
/* 41 */     this.result = _result_;
/* 42 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.result);
/* 51 */     _os_.compact_uint32(this.args.size());
/* 52 */     for (String _v_ : this.args) {
/* 53 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.result = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 62 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 63 */       this.args.add(_v_);
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SRandomLuckyBlesserErrorRes)) {
/* 74 */       SRandomLuckyBlesserErrorRes _o_ = (SRandomLuckyBlesserErrorRes)_o1_;
/* 75 */       if (this.result != _o_.result) return false;
/* 76 */       if (!this.args.equals(_o_.args)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.result;
/* 85 */     _h_ += this.args.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.result).append(",");
/* 93 */     _sb_.append(this.args).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SRandomLuckyBlesserErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */