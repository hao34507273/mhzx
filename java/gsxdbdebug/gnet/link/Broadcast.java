/*    */ package gnet.link;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Broadcast
/*    */   extends __Broadcast__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 1048582;
/*    */   public int ptype;
/*    */   public Octets pdata;
/*    */   public int time;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 1048582;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Broadcast()
/*    */   {
/* 33 */     this.pdata = new Octets();
/*    */   }
/*    */   
/*    */   public Broadcast(int _ptype_, Octets _pdata_, int _time_) {
/* 37 */     this.ptype = _ptype_;
/* 38 */     this.pdata = _pdata_;
/* 39 */     this.time = _time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.ptype);
/* 48 */     _os_.marshal(this.pdata);
/* 49 */     _os_.marshal(this.time);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.ptype = _os_.unmarshal_int();
/* 55 */     this.pdata = _os_.unmarshal_Octets();
/* 56 */     this.time = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof Broadcast)) {
/* 66 */       Broadcast _o_ = (Broadcast)_o1_;
/* 67 */       if (this.ptype != _o_.ptype) return false;
/* 68 */       if (!this.pdata.equals(_o_.pdata)) return false;
/* 69 */       if (this.time != _o_.time) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.ptype;
/* 78 */     _h_ += this.pdata.hashCode();
/* 79 */     _h_ += this.time;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.ptype).append(",");
/* 87 */     _sb_.append("B").append(this.pdata.size()).append(",");
/* 88 */     _sb_.append(this.time).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Broadcast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */