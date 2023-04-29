/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friend.main.PCAppplyAddFriend;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAppplyAddFriend
/*    */   extends __CAppplyAddFriend__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587015;
/*    */   public long roleid;
/*    */   public String content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PCAppplyAddFriend(roleId, this.roleid, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12587015;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAppplyAddFriend()
/*    */   {
/* 35 */     this.content = "";
/*    */   }
/*    */   
/*    */   public CAppplyAddFriend(long _roleid_, String _content_) {
/* 39 */     this.roleid = _roleid_;
/* 40 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.roleid);
/* 49 */     _os_.marshal(this.content, "UTF-16LE");
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.roleid = _os_.unmarshal_long();
/* 55 */     this.content = _os_.unmarshal_String("UTF-16LE");
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CAppplyAddFriend)) {
/* 65 */       CAppplyAddFriend _o_ = (CAppplyAddFriend)_o1_;
/* 66 */       if (this.roleid != _o_.roleid) return false;
/* 67 */       if (!this.content.equals(_o_.content)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     _h_ += this.content.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append("T").append(this.content.length()).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\CAppplyAddFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */