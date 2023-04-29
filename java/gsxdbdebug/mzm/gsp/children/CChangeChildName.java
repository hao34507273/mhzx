/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.main.PCChangeChildName;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeChildName
/*    */   extends __CChangeChildName__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609333;
/*    */   public long child_id;
/*    */   public Octets child_new_name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCChangeChildName(roleId, this.child_id, this.child_new_name));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12609333;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeChildName()
/*    */   {
/* 40 */     this.child_new_name = new Octets();
/*    */   }
/*    */   
/*    */   public CChangeChildName(long _child_id_, Octets _child_new_name_) {
/* 44 */     this.child_id = _child_id_;
/* 45 */     this.child_new_name = _child_new_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.child_id);
/* 54 */     _os_.marshal(this.child_new_name);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.child_id = _os_.unmarshal_long();
/* 60 */     this.child_new_name = _os_.unmarshal_Octets();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CChangeChildName)) {
/* 70 */       CChangeChildName _o_ = (CChangeChildName)_o1_;
/* 71 */       if (this.child_id != _o_.child_id) return false;
/* 72 */       if (!this.child_new_name.equals(_o_.child_new_name)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.child_id;
/* 81 */     _h_ += this.child_new_name.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.child_id).append(",");
/* 89 */     _sb_.append("B").append(this.child_new_name.size()).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChangeChildName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */