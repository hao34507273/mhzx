/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friend.main.PCFindPlayer;
/*    */ 
/*    */ 
/*    */ public class CFindPlayer
/*    */   extends __CFindPlayer__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587009;
/*    */   public String content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleId = Role.getRoleId(this);
/* 18 */     Role.addRoleProcedure(roleId, new PCFindPlayer(roleId, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 26 */     return 12587009;
/*    */   }
/*    */   
/*    */ 
/*    */   public CFindPlayer()
/*    */   {
/* 32 */     this.content = "";
/*    */   }
/*    */   
/*    */   public CFindPlayer(String _content_) {
/* 36 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.content, "UTF-16LE");
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.content = _os_.unmarshal_String("UTF-16LE");
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof CFindPlayer)) {
/* 59 */       CFindPlayer _o_ = (CFindPlayer)_o1_;
/* 60 */       if (!this.content.equals(_o_.content)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.content.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append("T").append(this.content.length()).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\CFindPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */