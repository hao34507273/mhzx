/*    */ package mzm.gsp.watchmoon;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ public class SWatchmoonInviteRes
/*    */   extends __SWatchmoonInviteRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600841;
/*    */   public String name1;
/*    */   public long roleid1;
/*    */   public long invitetime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600841;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SWatchmoonInviteRes()
/*    */   {
/* 35 */     this.name1 = "";
/*    */   }
/*    */   
/*    */   public SWatchmoonInviteRes(String _name1_, long _roleid1_, long _invitetime_) {
/* 39 */     this.name1 = _name1_;
/* 40 */     this.roleid1 = _roleid1_;
/* 41 */     this.invitetime = _invitetime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.name1, "UTF-16LE");
/* 50 */     _os_.marshal(this.roleid1);
/* 51 */     _os_.marshal(this.invitetime);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/* 57 */     this.roleid1 = _os_.unmarshal_long();
/* 58 */     this.invitetime = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SWatchmoonInviteRes)) {
/* 68 */       SWatchmoonInviteRes _o_ = (SWatchmoonInviteRes)_o1_;
/* 69 */       if (!this.name1.equals(_o_.name1)) return false;
/* 70 */       if (this.roleid1 != _o_.roleid1) return false;
/* 71 */       if (this.invitetime != _o_.invitetime) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.name1.hashCode();
/* 80 */     _h_ += (int)this.roleid1;
/* 81 */     _h_ += (int)this.invitetime;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 89 */     _sb_.append(this.roleid1).append(",");
/* 90 */     _sb_.append(this.invitetime).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\SWatchmoonInviteRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */