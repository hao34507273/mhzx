/*    */ package mzm.gsp.christmasstocking;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class HangStockingHistory implements Marshal
/*    */ {
/*    */   public long role_id;
/*    */   public Octets role_name;
/*    */   public long time;
/*    */   
/*    */   public HangStockingHistory()
/*    */   {
/* 16 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public HangStockingHistory(long _role_id_, Octets _role_name_, long _time_) {
/* 20 */     this.role_id = _role_id_;
/* 21 */     this.role_name = _role_name_;
/* 22 */     this.time = _time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.role_id);
/* 31 */     _os_.marshal(this.role_name);
/* 32 */     _os_.marshal(this.time);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.role_id = _os_.unmarshal_long();
/* 38 */     this.role_name = _os_.unmarshal_Octets();
/* 39 */     this.time = _os_.unmarshal_long();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof HangStockingHistory)) {
/* 46 */       HangStockingHistory _o_ = (HangStockingHistory)_o1_;
/* 47 */       if (this.role_id != _o_.role_id) return false;
/* 48 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 49 */       if (this.time != _o_.time) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += (int)this.role_id;
/* 58 */     _h_ += this.role_name.hashCode();
/* 59 */     _h_ += (int)this.time;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.role_id).append(",");
/* 67 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 68 */     _sb_.append(this.time).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\HangStockingHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */