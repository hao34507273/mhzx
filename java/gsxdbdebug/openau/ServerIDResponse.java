/*    */ package openau;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ServerIDResponse
/*    */   extends __ServerIDResponse__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 8902;
/*    */   public int plattype;
/*    */   public Octets serverids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     GameServer.logger().info(String.format("OnServerIDResponse plattype=%d", new Object[] { Integer.valueOf(this.plattype) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 8902;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ServerIDResponse()
/*    */   {
/* 35 */     this.serverids = new Octets();
/*    */   }
/*    */   
/*    */   public ServerIDResponse(int _plattype_, Octets _serverids_) {
/* 39 */     this.plattype = _plattype_;
/* 40 */     this.serverids = _serverids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.plattype);
/* 49 */     _os_.marshal(this.serverids);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.plattype = _os_.unmarshal_int();
/* 55 */     this.serverids = _os_.unmarshal_Octets();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof ServerIDResponse)) {
/* 65 */       ServerIDResponse _o_ = (ServerIDResponse)_o1_;
/* 66 */       if (this.plattype != _o_.plattype) return false;
/* 67 */       if (!this.serverids.equals(_o_.serverids)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.plattype;
/* 76 */     _h_ += this.serverids.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.plattype).append(",");
/* 84 */     _sb_.append("B").append(this.serverids.size()).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\ServerIDResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */