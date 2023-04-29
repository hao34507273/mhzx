/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ModifyRoamServerDateReq implements Marshal
/*    */ {
/*    */   public Octets date_args;
/*    */   
/*    */   public ModifyRoamServerDateReq()
/*    */   {
/* 14 */     this.date_args = new Octets();
/*    */   }
/*    */   
/*    */   public ModifyRoamServerDateReq(Octets _date_args_) {
/* 18 */     this.date_args = _date_args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.date_args);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.date_args = _os_.unmarshal_Octets();
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 36 */     if (_o1_ == this) return true;
/* 37 */     if ((_o1_ instanceof ModifyRoamServerDateReq)) {
/* 38 */       ModifyRoamServerDateReq _o_ = (ModifyRoamServerDateReq)_o1_;
/* 39 */       if (!this.date_args.equals(_o_.date_args)) return false;
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 46 */     int _h_ = 0;
/* 47 */     _h_ += this.date_args.hashCode();
/* 48 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuilder _sb_ = new StringBuilder();
/* 53 */     _sb_.append("(");
/* 54 */     _sb_.append("B").append(this.date_args.size()).append(",");
/* 55 */     _sb_.append(")");
/* 56 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ModifyRoamServerDateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */