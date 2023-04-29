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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryUserPrivilege3
/*    */   extends __QueryUserPrivilege3__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 543;
/*    */   public Octets userid;
/*    */   public int zoneid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 543;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public QueryUserPrivilege3()
/*    */   {
/* 34 */     this.userid = new Octets();
/*    */   }
/*    */   
/*    */   public QueryUserPrivilege3(Octets _userid_, int _zoneid_) {
/* 38 */     this.userid = _userid_;
/* 39 */     this.zoneid = _zoneid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.userid);
/* 48 */     _os_.marshal(this.zoneid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.userid = _os_.unmarshal_Octets();
/* 54 */     this.zoneid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof QueryUserPrivilege3)) {
/* 64 */       QueryUserPrivilege3 _o_ = (QueryUserPrivilege3)_o1_;
/* 65 */       if (!this.userid.equals(_o_.userid)) return false;
/* 66 */       if (this.zoneid != _o_.zoneid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.userid.hashCode();
/* 75 */     _h_ += this.zoneid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 83 */     _sb_.append(this.zoneid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\QueryUserPrivilege3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */