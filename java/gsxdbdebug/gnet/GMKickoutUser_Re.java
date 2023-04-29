/*    */ package gnet;
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
/*    */ public class GMKickoutUser_Re
/*    */   extends __GMKickoutUser_Re__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 355;
/*    */   public int retcode;
/*    */   public Octets gmuserid;
/*    */   public int localsid;
/*    */   public Octets kickuserid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 355;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public GMKickoutUser_Re()
/*    */   {
/* 34 */     this.gmuserid = new Octets();
/* 35 */     this.kickuserid = new Octets();
/*    */   }
/*    */   
/*    */   public GMKickoutUser_Re(int _retcode_, Octets _gmuserid_, int _localsid_, Octets _kickuserid_) {
/* 39 */     this.retcode = _retcode_;
/* 40 */     this.gmuserid = _gmuserid_;
/* 41 */     this.localsid = _localsid_;
/* 42 */     this.kickuserid = _kickuserid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.retcode);
/* 51 */     _os_.marshal(this.gmuserid);
/* 52 */     _os_.marshal(this.localsid);
/* 53 */     _os_.marshal(this.kickuserid);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.retcode = _os_.unmarshal_int();
/* 59 */     this.gmuserid = _os_.unmarshal_Octets();
/* 60 */     this.localsid = _os_.unmarshal_int();
/* 61 */     this.kickuserid = _os_.unmarshal_Octets();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof GMKickoutUser_Re)) {
/* 71 */       GMKickoutUser_Re _o_ = (GMKickoutUser_Re)_o1_;
/* 72 */       if (this.retcode != _o_.retcode) return false;
/* 73 */       if (!this.gmuserid.equals(_o_.gmuserid)) return false;
/* 74 */       if (this.localsid != _o_.localsid) return false;
/* 75 */       if (!this.kickuserid.equals(_o_.kickuserid)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.retcode;
/* 84 */     _h_ += this.gmuserid.hashCode();
/* 85 */     _h_ += this.localsid;
/* 86 */     _h_ += this.kickuserid.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.retcode).append(",");
/* 94 */     _sb_.append("B").append(this.gmuserid.size()).append(",");
/* 95 */     _sb_.append(this.localsid).append(",");
/* 96 */     _sb_.append("B").append(this.kickuserid.size()).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GMKickoutUser_Re.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */