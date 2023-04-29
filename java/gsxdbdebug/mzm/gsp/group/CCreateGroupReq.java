/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.group.main.PCreateGroupReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCreateGroupReq
/*    */   extends __CCreateGroupReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605192;
/*    */   public int group_type;
/*    */   public Octets group_name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCreateGroupReq(roleid, this.group_type, this.group_name));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12605192;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCreateGroupReq()
/*    */   {
/* 38 */     this.group_name = new Octets();
/*    */   }
/*    */   
/*    */   public CCreateGroupReq(int _group_type_, Octets _group_name_) {
/* 42 */     this.group_type = _group_type_;
/* 43 */     this.group_name = _group_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.group_type);
/* 52 */     _os_.marshal(this.group_name);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.group_type = _os_.unmarshal_int();
/* 58 */     this.group_name = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CCreateGroupReq)) {
/* 68 */       CCreateGroupReq _o_ = (CCreateGroupReq)_o1_;
/* 69 */       if (this.group_type != _o_.group_type) return false;
/* 70 */       if (!this.group_name.equals(_o_.group_name)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.group_type;
/* 79 */     _h_ += this.group_name.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.group_type).append(",");
/* 87 */     _sb_.append("B").append(this.group_name.size()).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\CCreateGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */