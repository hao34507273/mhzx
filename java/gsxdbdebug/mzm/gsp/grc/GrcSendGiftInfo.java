/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcSendGiftInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets to;
/*    */   
/*    */   public GrcSendGiftInfo()
/*    */   {
/* 12 */     this.to = new Octets();
/*    */   }
/*    */   
/*    */   public GrcSendGiftInfo(Octets _to_) {
/* 16 */     this.to = _to_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 24 */     _os_.marshal(this.to);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 29 */     this.to = _os_.unmarshal_Octets();
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 34 */     if (_o1_ == this) return true;
/* 35 */     if ((_o1_ instanceof GrcSendGiftInfo)) {
/* 36 */       GrcSendGiftInfo _o_ = (GrcSendGiftInfo)_o1_;
/* 37 */       if (!this.to.equals(_o_.to)) return false;
/* 38 */       return true;
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 44 */     int _h_ = 0;
/* 45 */     _h_ += this.to.hashCode();
/* 46 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 50 */     StringBuilder _sb_ = new StringBuilder();
/* 51 */     _sb_.append("(");
/* 52 */     _sb_.append("B").append(this.to.size()).append(",");
/* 53 */     _sb_.append(")");
/* 54 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\GrcSendGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */