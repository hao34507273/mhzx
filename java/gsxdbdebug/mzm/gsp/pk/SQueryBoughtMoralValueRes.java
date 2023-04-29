/*    */ package mzm.gsp.pk;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ public class SQueryBoughtMoralValueRes
/*    */   extends __SQueryBoughtMoralValueRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619804;
/*    */   public int bought_moral_value;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12619804;
/*    */   }
/*    */   
/*    */ 
/*    */   public SQueryBoughtMoralValueRes() {}
/*    */   
/*    */ 
/*    */   public SQueryBoughtMoralValueRes(int _bought_moral_value_)
/*    */   {
/* 34 */     this.bought_moral_value = _bought_moral_value_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     _os_.marshal(this.bought_moral_value);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     this.bought_moral_value = _os_.unmarshal_int();
/* 48 */     if (!_validator_()) {
/* 49 */       throw new VerifyError("validator failed");
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof SQueryBoughtMoralValueRes)) {
/* 57 */       SQueryBoughtMoralValueRes _o_ = (SQueryBoughtMoralValueRes)_o1_;
/* 58 */       if (this.bought_moral_value != _o_.bought_moral_value) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.bought_moral_value;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.bought_moral_value).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SQueryBoughtMoralValueRes _o_) {
/* 79 */     if (_o_ == this) return 0;
/* 80 */     int _c_ = 0;
/* 81 */     _c_ = this.bought_moral_value - _o_.bought_moral_value;
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\SQueryBoughtMoralValueRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */