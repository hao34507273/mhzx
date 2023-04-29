/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GenRoamTokenReq implements Marshal
/*    */ {
/*    */   public Octets userid;
/*    */   public long roleid;
/*    */   public Octets token;
/*    */   
/*    */   public GenRoamTokenReq()
/*    */   {
/* 16 */     this.userid = new Octets();
/* 17 */     this.roleid = 0L;
/* 18 */     this.token = new Octets();
/*    */   }
/*    */   
/*    */   public GenRoamTokenReq(Octets _userid_, long _roleid_, Octets _token_) {
/* 22 */     this.userid = _userid_;
/* 23 */     this.roleid = _roleid_;
/* 24 */     this.token = _token_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.userid);
/* 33 */     _os_.marshal(this.roleid);
/* 34 */     _os_.marshal(this.token);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.userid = _os_.unmarshal_Octets();
/* 40 */     this.roleid = _os_.unmarshal_long();
/* 41 */     this.token = _os_.unmarshal_Octets();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof GenRoamTokenReq)) {
/* 48 */       GenRoamTokenReq _o_ = (GenRoamTokenReq)_o1_;
/* 49 */       if (!this.userid.equals(_o_.userid)) return false;
/* 50 */       if (this.roleid != _o_.roleid) return false;
/* 51 */       if (!this.token.equals(_o_.token)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.userid.hashCode();
/* 60 */     _h_ += (int)this.roleid;
/* 61 */     _h_ += this.token.hashCode();
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 69 */     _sb_.append(this.roleid).append(",");
/* 70 */     _sb_.append("B").append(this.token.size()).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\GenRoamTokenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */