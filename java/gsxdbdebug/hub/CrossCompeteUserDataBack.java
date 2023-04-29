/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CrossCompeteUserDataBack implements Marshal
/*    */ {
/*    */   public String userid;
/*    */   public long roleid;
/*    */   public Octets user_token;
/*    */   
/*    */   public CrossCompeteUserDataBack()
/*    */   {
/* 16 */     this.userid = "";
/* 17 */     this.user_token = new Octets();
/*    */   }
/*    */   
/*    */   public CrossCompeteUserDataBack(String _userid_, long _roleid_, Octets _user_token_) {
/* 21 */     this.userid = _userid_;
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.user_token = _user_token_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.userid, "UTF-16LE");
/* 32 */     _os_.marshal(this.roleid);
/* 33 */     _os_.marshal(this.user_token);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.userid = _os_.unmarshal_String("UTF-16LE");
/* 39 */     this.roleid = _os_.unmarshal_long();
/* 40 */     this.user_token = _os_.unmarshal_Octets();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof CrossCompeteUserDataBack)) {
/* 47 */       CrossCompeteUserDataBack _o_ = (CrossCompeteUserDataBack)_o1_;
/* 48 */       if (!this.userid.equals(_o_.userid)) return false;
/* 49 */       if (this.roleid != _o_.roleid) return false;
/* 50 */       if (!this.user_token.equals(_o_.user_token)) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.userid.hashCode();
/* 59 */     _h_ += (int)this.roleid;
/* 60 */     _h_ += this.user_token.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append("T").append(this.userid.length()).append(",");
/* 68 */     _sb_.append(this.roleid).append(",");
/* 69 */     _sb_.append("B").append(this.user_token.size()).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\CrossCompeteUserDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */