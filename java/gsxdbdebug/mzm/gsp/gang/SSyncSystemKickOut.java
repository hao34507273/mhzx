/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncSystemKickOut
/*    */   extends __SSyncSystemKickOut__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589868;
/*    */   public ArrayList<Long> rolelist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589868;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncSystemKickOut()
/*    */   {
/* 34 */     this.rolelist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSyncSystemKickOut(ArrayList<Long> _rolelist_) {
/* 38 */     this.rolelist = _rolelist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.compact_uint32(this.rolelist.size());
/* 47 */     for (Long _v_ : this.rolelist) {
/* 48 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 56 */       long _v_ = _os_.unmarshal_long();
/* 57 */       this.rolelist.add(Long.valueOf(_v_));
/*    */     }
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SSyncSystemKickOut)) {
/* 68 */       SSyncSystemKickOut _o_ = (SSyncSystemKickOut)_o1_;
/* 69 */       if (!this.rolelist.equals(_o_.rolelist)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.rolelist.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.rolelist).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncSystemKickOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */