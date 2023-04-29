/*    */ package mzm.gsp.mail;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SNormalResult
/*    */   extends __SNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592899;
/*    */   public static final int BAG_FULL = 0;
/*    */   public static final int MONEY_FULL = 1;
/*    */   public static final int TOKEN_FULL = 2;
/*    */   public static final int VIGOR_FULL = 3;
/*    */   public static final int MAIL_NOT_AVAILABLE = 10;
/*    */   public static final int UNKNOW = 100;
/*    */   public int ret;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12592899;
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
/*    */ 
/*    */   public SNormalResult()
/*    */   {
/* 41 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SNormalResult(int _ret_, ArrayList<String> _args_) {
/* 45 */     this.ret = _ret_;
/* 46 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.ret);
/* 55 */     _os_.compact_uint32(this.args.size());
/* 56 */     for (String _v_ : this.args) {
/* 57 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     this.ret = _os_.unmarshal_int();
/* 64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 66 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 67 */       this.args.add(_v_);
/*    */     }
/* 69 */     if (!_validator_()) {
/* 70 */       throw new VerifyError("validator failed");
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 76 */     if (_o1_ == this) return true;
/* 77 */     if ((_o1_ instanceof SNormalResult)) {
/* 78 */       SNormalResult _o_ = (SNormalResult)_o1_;
/* 79 */       if (this.ret != _o_.ret) return false;
/* 80 */       if (!this.args.equals(_o_.args)) return false;
/* 81 */       return true;
/*    */     }
/* 83 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 87 */     int _h_ = 0;
/* 88 */     _h_ += this.ret;
/* 89 */     _h_ += this.args.hashCode();
/* 90 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 94 */     StringBuilder _sb_ = new StringBuilder();
/* 95 */     _sb_.append("(");
/* 96 */     _sb_.append(this.ret).append(",");
/* 97 */     _sb_.append(this.args).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\SNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */