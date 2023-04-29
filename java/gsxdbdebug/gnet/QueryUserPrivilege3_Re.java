/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class QueryUserPrivilege3_Re
/*    */   extends __QueryUserPrivilege3_Re__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 544;
/*    */   public Octets userid;
/*    */   public ArrayList<Integer> auth;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     GdeliveryHelper.GMLoginIn(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 25 */     return 544;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public QueryUserPrivilege3_Re()
/*    */   {
/* 32 */     this.userid = new Octets();
/* 33 */     this.auth = new ArrayList();
/*    */   }
/*    */   
/*    */   public QueryUserPrivilege3_Re(Octets _userid_, ArrayList<Integer> _auth_) {
/* 37 */     this.userid = _userid_;
/* 38 */     this.auth = _auth_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.userid);
/* 47 */     _os_.compact_uint32(this.auth.size());
/* 48 */     for (Integer _v_ : this.auth) {
/* 49 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.userid = _os_.unmarshal_Octets();
/* 56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.auth.add(Integer.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof QueryUserPrivilege3_Re)) {
/* 70 */       QueryUserPrivilege3_Re _o_ = (QueryUserPrivilege3_Re)_o1_;
/* 71 */       if (!this.userid.equals(_o_.userid)) return false;
/* 72 */       if (!this.auth.equals(_o_.auth)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.userid.hashCode();
/* 81 */     _h_ += this.auth.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 89 */     _sb_.append(this.auth).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\QueryUserPrivilege3_Re.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */