/*    */ package mzm.gsp.marriage;
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
/*    */ public class SAgreeOrCancelMarriageErrorRes
/*    */   extends __SAgreeOrCancelMarriageErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599837;
/*    */   public static final int MONEY_NOT_ENOUGH = 1;
/*    */   public static final int ITEM_NOT_ENOUGH = 2;
/*    */   public static final int OTHER_IN_CEREMONY = 3;
/*    */   public int error;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599837;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAgreeOrCancelMarriageErrorRes()
/*    */   {
/* 38 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SAgreeOrCancelMarriageErrorRes(int _error_, ArrayList<String> _args_) {
/* 42 */     this.error = _error_;
/* 43 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.error);
/* 52 */     _os_.compact_uint32(this.args.size());
/* 53 */     for (String _v_ : this.args) {
/* 54 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.error = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 64 */       this.args.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SAgreeOrCancelMarriageErrorRes)) {
/* 75 */       SAgreeOrCancelMarriageErrorRes _o_ = (SAgreeOrCancelMarriageErrorRes)_o1_;
/* 76 */       if (this.error != _o_.error) return false;
/* 77 */       if (!this.args.equals(_o_.args)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.error;
/* 86 */     _h_ += this.args.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.error).append(",");
/* 94 */     _sb_.append(this.args).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SAgreeOrCancelMarriageErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */