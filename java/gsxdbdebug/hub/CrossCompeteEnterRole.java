/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CrossCompeteEnterRole implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String userid;
/*    */   
/*    */   public CrossCompeteEnterRole()
/*    */   {
/* 13 */     this.userid = "";
/*    */   }
/*    */   
/*    */   public CrossCompeteEnterRole(long _roleid_, String _userid_) {
/* 17 */     this.roleid = _roleid_;
/* 18 */     this.userid = _userid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.roleid);
/* 27 */     _os_.marshal(this.userid, "UTF-16LE");
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     this.roleid = _os_.unmarshal_long();
/* 33 */     this.userid = _os_.unmarshal_String("UTF-16LE");
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof CrossCompeteEnterRole)) {
/* 40 */       CrossCompeteEnterRole _o_ = (CrossCompeteEnterRole)_o1_;
/* 41 */       if (this.roleid != _o_.roleid) return false;
/* 42 */       if (!this.userid.equals(_o_.userid)) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += (int)this.roleid;
/* 51 */     _h_ += this.userid.hashCode();
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(this.roleid).append(",");
/* 59 */     _sb_.append("T").append(this.userid.length()).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\CrossCompeteEnterRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */