/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.corps.main.PCCreateCorpsReq;
/*    */ 
/*    */ public class CCreateCorpsReq
/*    */   extends __CCreateCorpsReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617480;
/*    */   public Octets name;
/*    */   public Octets declaration;
/*    */   public int corpsbadgeid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCCreateCorpsReq(roleId, this.name, this.declaration, this.corpsbadgeid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12617480;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CCreateCorpsReq()
/*    */   {
/* 39 */     this.name = new Octets();
/* 40 */     this.declaration = new Octets();
/*    */   }
/*    */   
/*    */   public CCreateCorpsReq(Octets _name_, Octets _declaration_, int _corpsbadgeid_) {
/* 44 */     this.name = _name_;
/* 45 */     this.declaration = _declaration_;
/* 46 */     this.corpsbadgeid = _corpsbadgeid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.name);
/* 55 */     _os_.marshal(this.declaration);
/* 56 */     _os_.marshal(this.corpsbadgeid);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.name = _os_.unmarshal_Octets();
/* 62 */     this.declaration = _os_.unmarshal_Octets();
/* 63 */     this.corpsbadgeid = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CCreateCorpsReq)) {
/* 73 */       CCreateCorpsReq _o_ = (CCreateCorpsReq)_o1_;
/* 74 */       if (!this.name.equals(_o_.name)) return false;
/* 75 */       if (!this.declaration.equals(_o_.declaration)) return false;
/* 76 */       if (this.corpsbadgeid != _o_.corpsbadgeid) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.name.hashCode();
/* 85 */     _h_ += this.declaration.hashCode();
/* 86 */     _h_ += this.corpsbadgeid;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append("B").append(this.name.size()).append(",");
/* 94 */     _sb_.append("B").append(this.declaration.size()).append(",");
/* 95 */     _sb_.append(this.corpsbadgeid).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CCreateCorpsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */