/*    */ package mzm.gsp.apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.apollo.main.PCSTTReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSTTReq
/*    */   extends __CSTTReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602637;
/*    */   public Octets file_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid == -1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCSTTReq(roleid, this.file_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12602637;
/*    */   }
/*    */   
/*    */ 
/*    */   public CSTTReq()
/*    */   {
/* 38 */     this.file_id = new Octets();
/*    */   }
/*    */   
/*    */   public CSTTReq(Octets _file_id_) {
/* 42 */     this.file_id = _file_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.file_id);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.file_id = _os_.unmarshal_Octets();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CSTTReq)) {
/* 65 */       CSTTReq _o_ = (CSTTReq)_o1_;
/* 66 */       if (!this.file_id.equals(_o_.file_id)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.file_id.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append("B").append(this.file_id.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\CSTTReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */