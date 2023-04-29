/*    */ package mzm.gsp.masswedding;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.masswedding.main.PCBlessCoupleReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBlessCoupleReq
/*    */   extends __CBlessCoupleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604937;
/*    */   public long roleid;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCBlessCoupleReq(roleid, this.roleid, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12604937;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CBlessCoupleReq()
/*    */   {
/* 36 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CBlessCoupleReq(long _roleid_, Octets _content_) {
/* 40 */     this.roleid = _roleid_;
/* 41 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.roleid);
/* 50 */     _os_.marshal(this.content);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.roleid = _os_.unmarshal_long();
/* 56 */     this.content = _os_.unmarshal_Octets();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CBlessCoupleReq)) {
/* 66 */       CBlessCoupleReq _o_ = (CBlessCoupleReq)_o1_;
/* 67 */       if (this.roleid != _o_.roleid) return false;
/* 68 */       if (!this.content.equals(_o_.content)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.roleid;
/* 77 */     _h_ += this.content.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.roleid).append(",");
/* 85 */     _sb_.append("B").append(this.content.size()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\CBlessCoupleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */