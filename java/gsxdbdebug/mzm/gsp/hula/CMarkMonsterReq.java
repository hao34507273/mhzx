/*    */ package mzm.gsp.hula;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.hula.main.PMarkMonsterReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMarkMonsterReq
/*    */   extends __CMarkMonsterReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608776;
/*    */   public int seq;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PMarkMonsterReq(roleId, this.seq, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12608776;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CMarkMonsterReq()
/*    */   {
/* 36 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CMarkMonsterReq(int _seq_, Octets _content_) {
/* 40 */     this.seq = _seq_;
/* 41 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.seq);
/* 50 */     _os_.marshal(this.content);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.seq = _os_.unmarshal_int();
/* 56 */     this.content = _os_.unmarshal_Octets();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CMarkMonsterReq)) {
/* 66 */       CMarkMonsterReq _o_ = (CMarkMonsterReq)_o1_;
/* 67 */       if (this.seq != _o_.seq) return false;
/* 68 */       if (!this.content.equals(_o_.content)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.seq;
/* 77 */     _h_ += this.content.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.seq).append(",");
/* 85 */     _sb_.append("B").append(this.content.size()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\CMarkMonsterReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */